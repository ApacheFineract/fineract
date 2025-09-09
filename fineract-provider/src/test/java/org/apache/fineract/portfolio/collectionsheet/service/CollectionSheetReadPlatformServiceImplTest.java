package org.apache.fineract.portfolio.collectionsheet.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;

import com.google.gson.JsonElement;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.apache.fineract.infrastructure.configuration.domain.ConfigurationDomainService;
import org.apache.fineract.infrastructure.core.api.JsonQuery;
import org.apache.fineract.infrastructure.core.serialization.FromJsonHelper;
import org.apache.fineract.infrastructure.security.service.PlatformSecurityContext;
import org.apache.fineract.organisation.monetary.data.CurrencyData;
import org.apache.fineract.organisation.office.domain.Office;
import org.apache.fineract.portfolio.calendar.domain.Calendar;
import org.apache.fineract.portfolio.calendar.domain.CalendarEntityType;
import org.apache.fineract.portfolio.calendar.domain.CalendarRepositoryWrapper;
import org.apache.fineract.portfolio.calendar.exception.NotValidRecurringDateException;
import org.apache.fineract.portfolio.calendar.service.CalendarReadPlatformService;
import org.apache.fineract.portfolio.collectionsheet.data.JLGClientData;
import org.apache.fineract.portfolio.collectionsheet.data.JLGCollectionSheetData;
import org.apache.fineract.portfolio.collectionsheet.data.JLGCollectionSheetFlatData;
import org.apache.fineract.portfolio.collectionsheet.data.JLGGroupData;
import org.apache.fineract.portfolio.collectionsheet.data.SavingsDueData;
import org.apache.fineract.portfolio.collectionsheet.repository.GroupAndCenterCollectionSheetDao;
import org.apache.fineract.portfolio.collectionsheet.serialization.CollectionSheetGenerateCommandFromApiJsonDeserializer;
import org.apache.fineract.portfolio.group.data.CenterData;
import org.apache.fineract.portfolio.group.data.GroupGeneralData;
import org.apache.fineract.portfolio.group.service.CenterReadPlatformService;
import org.apache.fineract.portfolio.group.service.GroupReadPlatformService;
import org.apache.fineract.portfolio.loanproduct.data.LoanProductData;
import org.apache.fineract.portfolio.meeting.attendance.service.AttendanceDropdownReadPlatformService;
import org.apache.fineract.portfolio.paymenttype.service.PaymentTypeReadPlatformService;
import org.apache.fineract.useradministration.domain.AppUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CollectionSheetReadPlatformServiceImplTest {

    private List<JLGCollectionSheetFlatData> jlgCollectionSheetFlatData;
    private JLGCollectionSheetFlatData mockJlgCollectionSheetFlatData;
    private List<JLGCollectionSheetFlatData> mockJlgCollectionSheetFlatDataList;
    private List<JLGGroupData> groupsWithSavingsData;
    private Calendar calendar;
    private GroupGeneralData groups;
    private CenterData centerData;
    private AppUser currentUser;
    private Office mockOffice;

    @InjectMocks
    private CollectionSheetReadPlatformServiceImpl underTest;

    @Mock
    private PaymentTypeReadPlatformService paymentTypeReadPlatformService;

    @Mock
    private AttendanceDropdownReadPlatformService attendanceDropdownReadPlatformService;

    @Mock
    private CollectionSheetGenerateCommandFromApiJsonDeserializer collectionSheetGenerateCommandFromApiJsonDeserializer;

    @Mock
    private CalendarRepositoryWrapper calendarRepositoryWrapper;

    @Mock
    private GroupReadPlatformService groupReadPlatformService;

    @Mock
    private ConfigurationDomainService configurationDomainService;

    @Mock
    private CalendarReadPlatformService calendarReadPlatformService;

    @Mock
    private PlatformSecurityContext context;

    @Mock
    private GroupAndCenterCollectionSheetDao groupAndCenterCollectionSheetDao;

    @Mock
    private CenterReadPlatformService centerReadPlatformService;

    @Mock
    private Calendar calendarMock;

    @BeforeEach
    void setUp() {
        jlgCollectionSheetFlatData = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            long randomGroupId = (long) (Math.random() * 10) + 1;
            long randomClientId = (long) (Math.random() * 10) + 1;
            long randomLoanId = (long) (Math.random() * 10) + 1;

            JLGCollectionSheetFlatData data = JLGCollectionSheetFlatData.builder().groupName("Group_" + randomGroupId)
                    .groupId(randomGroupId).clientName("ClientName_" + UUID.randomUUID().toString()).staffId(1L)
                    .staffName("StaffName_" + UUID.randomUUID().toString()).levelId(2L).levelName("Group").clientId(randomClientId)
                    .loanId(randomLoanId).accountId(String.format("%09d", randomLoanId)).accountStatusId(300).productShortName("LOAN")
                    .productId(1L).disbursementAmount(BigDecimal.ZERO).principalDue(BigDecimal.ZERO).principalPaid(BigDecimal.ZERO)
                    .interestDue(BigDecimal.ZERO).interestPaid(BigDecimal.ZERO).feeDue(BigDecimal.ZERO).feePaid(BigDecimal.ZERO).build();

            jlgCollectionSheetFlatData.add(data);
        }
        calendar = mock(Calendar.class);
        groups = mock(GroupGeneralData.class);
        currentUser = mock(AppUser.class);
        mockOffice = mock(Office.class);
        centerData = mock(CenterData.class);
        mockJlgCollectionSheetFlatData = mock(JLGCollectionSheetFlatData.class);
        mockJlgCollectionSheetFlatDataList = List.of(mockJlgCollectionSheetFlatData);
    }

    @Test
    void buildJLGCollectionSheet_happyPath() {

        Mockito.when(paymentTypeReadPlatformService.retrieveAllPaymentTypes()).thenReturn(new ArrayList<>());
        Mockito.when(attendanceDropdownReadPlatformService.retrieveAttendanceTypeOptions()).thenReturn(new ArrayList<>());

        Collections.shuffle(jlgCollectionSheetFlatData);

        // Expected Results Data
        Set<LoanProductData> loanProducts = new LinkedHashSet<>();
        for (JLGCollectionSheetFlatData row : jlgCollectionSheetFlatData) {
            // collect unique loan products
            if (row.getProductId() != null) {
                loanProducts.add(LoanProductData.lookupWithCurrency(row.getProductId(), row.getProductShortName(), row.getCurrency()));
            }
        }

        Map<Long, JLGGroupData> groupMap = new LinkedHashMap<>();
        for (JLGCollectionSheetFlatData element : jlgCollectionSheetFlatData) {
            Long groupId = element.getGroupId();

            // if group does not exist, create it
            JLGGroupData group = groupMap.computeIfAbsent(groupId,
                    id -> JLGGroupData.builder().groupId(element.getGroupId()).groupName(element.getGroupName())
                            .staffId(element.getStaffId()).staffName(element.getStaffName()).levelId(element.getLevelId())
                            .levelName(element.getLevelName()).clients(new ArrayList<>()).build());

            // add client to that group
            group.getClients().add(element.getClientData());
        }
        // finally get all groups as a list
        List<JLGGroupData> groupsDataList = new ArrayList<>(groupMap.values());

        JLGCollectionSheetData results = JLGCollectionSheetData.builder().dueDate(LocalDate.of(2025, 9, 1)).loanProducts(loanProducts)
                .groups(groupsDataList).attendanceTypeOptions(new ArrayList<>()).paymentTypeOptions(new ArrayList<>()).build();

        assertEquals(results, underTest.buildJLGCollectionSheet(LocalDate.of(2025, 9, 1), jlgCollectionSheetFlatData));
    }

    @Test
    void generateGroupCollectionSheet_happyPath() {
        final LocalDate date = LocalDate.of(2025, 9, 1);
        final String apiRequestBodyAsJson = "{\n" + "    \"transactionDate\":\"01 September 2025\",\n"
                + "    \"dateFormat\":\"dd MMMM yyyy\",\n" + "    \"locale\":\"en\",\n" + "    \"calendarId\":1\n" + "}";
        final FromJsonHelper fromJsonHelper = new FromJsonHelper();
        final JsonElement parsedQuery = fromJsonHelper.parse(apiRequestBodyAsJson);
        final JsonQuery query = JsonQuery.from(apiRequestBodyAsJson, parsedQuery, fromJsonHelper);
        List<JLGGroupData> dummyList = Arrays.asList(mock(JLGGroupData.class));

        // context returns currentUser
        Mockito.when(context.authenticatedUser()).thenReturn(currentUser);

        // user returns office
        Mockito.when(currentUser.getOffice()).thenReturn(mockOffice);

        // office returns hierarchy string
        Mockito.when(mockOffice.getHierarchy()).thenReturn("1.1.1");
        Mockito.when(paymentTypeReadPlatformService.retrieveAllPaymentTypes()).thenReturn(new ArrayList<>());
        Mockito.when(attendanceDropdownReadPlatformService.retrieveAttendanceTypeOptions()).thenReturn(new ArrayList<>());
        Mockito.doNothing().when(collectionSheetGenerateCommandFromApiJsonDeserializer).validateForGenerateCollectionSheet(anyString());
        Mockito.when(groupReadPlatformService.retrieveOne(1L)).thenReturn(groups);
        Mockito.when(configurationDomainService.isSkippingMeetingOnFirstDayOfMonthEnabled()).thenReturn(true);
        Mockito.when(configurationDomainService.retreivePeriodInNumberOfDaysForSkipMeetingDate()).thenReturn(30L);
        Mockito.when(calendarRepositoryWrapper.findOneWithNotFoundDetection(anyLong())).thenReturn(calendarMock);
        Mockito.when(calendarMock.isValidRecurringDate(any(LocalDate.class), anyBoolean(), anyInt())).thenReturn(true);
        Mockito.when(calendarReadPlatformService.isCalendarAssociatedWithEntity(anyLong(), isNull(), anyLong())).thenReturn(false);
        Mockito.when(context.authenticatedUser()).thenReturn(currentUser);
        Mockito.when(groupAndCenterCollectionSheetDao.getGroupCollectionSheetFlatDataList(eq(date), anyString(),
                any(GroupGeneralData.class), any(CalendarEntityType.class))).thenReturn(mockJlgCollectionSheetFlatDataList);

        Mockito.when(groupAndCenterCollectionSheetDao.getGroupsWithSavingsData(eq(date), anyString(), any(GroupGeneralData.class),
                any(CalendarEntityType.class))).thenReturn(dummyList);
        Collections.shuffle(jlgCollectionSheetFlatData);
        Assertions.assertNotNull(underTest.generateGroupCollectionSheet(1L, query));
    }

    @Test
    void generateCenterCollectionSheet_happyPath() {
        final LocalDate date = LocalDate.of(2025, 9, 1);
        final String apiRequestBodyAsJson = "{\n" + "    \"transactionDate\":\"01 September 2025\",\n"
                + "    \"dateFormat\":\"dd MMMM yyyy\",\n" + "    \"locale\":\"en\",\n" + "    \"calendarId\":1\n" + "}";
        final FromJsonHelper fromJsonHelper = new FromJsonHelper();
        final JsonElement parsedQuery = fromJsonHelper.parse(apiRequestBodyAsJson);
        final JsonQuery query = JsonQuery.from(apiRequestBodyAsJson, parsedQuery, fromJsonHelper);
        List<JLGGroupData> dummyList = Arrays.asList(mock(JLGGroupData.class));

        // context returns currentUser
        Mockito.when(context.authenticatedUser()).thenReturn(currentUser);

        // user returns office
        Mockito.when(currentUser.getOffice()).thenReturn(mockOffice);

        // office returns hierarchy string
        Mockito.when(mockOffice.getHierarchy()).thenReturn("1.1.1");
        Mockito.when(paymentTypeReadPlatformService.retrieveAllPaymentTypes()).thenReturn(new ArrayList<>());
        Mockito.when(attendanceDropdownReadPlatformService.retrieveAttendanceTypeOptions()).thenReturn(new ArrayList<>());
        Mockito.doNothing().when(collectionSheetGenerateCommandFromApiJsonDeserializer).validateForGenerateCollectionSheet(anyString());
        Mockito.when(centerReadPlatformService.retrieveOne(1L)).thenReturn(centerData);
        Mockito.when(context.authenticatedUser()).thenReturn(currentUser);
        Mockito.when(groupAndCenterCollectionSheetDao.getCenterCollectionSheetFlatDataList(eq(date), anyString(), any(CenterData.class)))
                .thenReturn(mockJlgCollectionSheetFlatDataList);
        Mockito.when(groupAndCenterCollectionSheetDao.getCenterWithSavingsData(eq(date), anyString(), any(CenterData.class)))
                .thenReturn(dummyList);
        Collections.shuffle(jlgCollectionSheetFlatData);
        Assertions.assertNotNull(underTest.generateCenterCollectionSheet(1L, query));
    }

    @Test
    void generateGroupCollectionSheet_Exception() {
        final String apiRequestBodyAsJson = "{\n" + "    \"transactionDate\":\"01 September 2025\",\n"
                + "    \"dateFormat\":\"dd MMMM yyyy\",\n" + "    \"locale\":\"en\",\n" + "    \"calendarId\":1\n" + "}";
        final FromJsonHelper fromJsonHelper = new FromJsonHelper();
        final JsonElement parsedQuery = fromJsonHelper.parse(apiRequestBodyAsJson);
        final JsonQuery query = JsonQuery.from(apiRequestBodyAsJson, parsedQuery, fromJsonHelper);

        Mockito.doNothing().when(collectionSheetGenerateCommandFromApiJsonDeserializer).validateForGenerateCollectionSheet(anyString());
        Mockito.when(groupReadPlatformService.retrieveOne(1L)).thenReturn(groups);
        Mockito.when(configurationDomainService.isSkippingMeetingOnFirstDayOfMonthEnabled()).thenReturn(false);
        Mockito.when(calendarRepositoryWrapper.findOneWithNotFoundDetection(anyLong())).thenReturn(calendarMock);
        Mockito.when(calendarMock.isValidRecurringDate(any(LocalDate.class), anyBoolean(), anyInt())).thenReturn(false);
        Assertions.assertThrows(NotValidRecurringDateException.class, () -> {
            // call the method under test that should throw
            underTest.generateGroupCollectionSheet(1L, query);
        });
    }

    @Test
    void generateCenterCollectionSheet_Exception() {
        final String apiRequestBodyAsJson = "{\n" + "    \"transactionDate\":\"01 September 2025\",\n"
                + "    \"dateFormat\":\"dd MMMM yyyy\",\n" + "    \"locale\":\"en\",\n" + "    \"calendarId\":1\n" + "}";
        final FromJsonHelper fromJsonHelper = new FromJsonHelper();
        final JsonElement parsedQuery = fromJsonHelper.parse(apiRequestBodyAsJson);
        final JsonQuery query = JsonQuery.from(apiRequestBodyAsJson, parsedQuery, fromJsonHelper);
        List<JLGGroupData> dummyList = Arrays.asList(mock(JLGGroupData.class));

        // office returns hierarchy string
        Mockito.doNothing().when(collectionSheetGenerateCommandFromApiJsonDeserializer).validateForGenerateCollectionSheet(anyString());
        Collections.shuffle(jlgCollectionSheetFlatData);
        Assertions.assertThrows(Exception.class, () -> {
            underTest.generateGroupCollectionSheet(1L, query);
        });
    }

    @Test
    void mergeCollectionSheetWithSavings_happyPath() {
        Collections.shuffle(jlgCollectionSheetFlatData);

        // Expected Results Data
        Set<LoanProductData> loanProducts = new LinkedHashSet<>();
        for (JLGCollectionSheetFlatData row : jlgCollectionSheetFlatData) {
            // collect unique loan products
            if (row.getProductId() != null) {
                loanProducts.add(LoanProductData.lookupWithCurrency(row.getProductId(), row.getProductShortName(), row.getCurrency()));
            }
        }

        Map<Long, JLGGroupData> groupMap = new LinkedHashMap<>();
        for (JLGCollectionSheetFlatData element : jlgCollectionSheetFlatData) {
            Long groupId = element.getGroupId();

            // if group does not exist, create it
            JLGGroupData group = groupMap.computeIfAbsent(groupId,
                    id -> JLGGroupData.builder().groupId(element.getGroupId()).groupName(element.getGroupName())
                            .staffId(element.getStaffId()).staffName(element.getStaffName()).levelId(element.getLevelId())
                            .levelName(element.getLevelName())
                            .clients(List.of(JLGClientData.builder().savings(List.of(SavingsDueData.builder().savingsId(1L)
                                    .accountId("000000001").accountStatusId(300).productName("SACC").productId(1L)
                                    .currency(CurrencyData.builder().code("USD").nameCode("US Dollar").decimalPlaces(2).inMultiplesOf(1)
                                            .displaySymbol("$").nameCode("currency.USD").displayLabel("US Dollar ($)").build())
                                    .dueAmount(BigDecimal.ZERO).depositAccountType("Saving Deposit").build())).build()))
                            .build());

            // add client to that group
            // group.getClients().add(element.getClientData());
        }
        // finally get all groups as a list
        List<JLGGroupData> groupsDataList = new ArrayList<>(groupMap.values());

        JLGCollectionSheetData jlgCollectionSheetData = JLGCollectionSheetData.builder().dueDate(LocalDate.of(2025, 9, 1))
                .loanProducts(loanProducts).groups(groupsDataList).attendanceTypeOptions(new ArrayList<>())
                .paymentTypeOptions(new ArrayList<>()).build();

        JLGCollectionSheetData mergedResults = JLGCollectionSheetData.builder().dueDate(LocalDate.of(2025, 9, 1)).loanProducts(loanProducts)
                .groups(groupsDataList).attendanceTypeOptions(new ArrayList<>()).paymentTypeOptions(new ArrayList<>()).build();

        Assertions.assertEquals(underTest.mergeCollectionSheetWithSavings(groupsDataList, jlgCollectionSheetData), mergedResults);
    }
}
