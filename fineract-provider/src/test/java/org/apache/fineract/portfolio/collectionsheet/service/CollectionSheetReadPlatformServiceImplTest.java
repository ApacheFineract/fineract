package org.apache.fineract.portfolio.collectionsheet.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.apache.fineract.portfolio.collectionsheet.data.JLGCollectionSheetData;
import org.apache.fineract.portfolio.collectionsheet.data.JLGCollectionSheetFlatData;
import org.apache.fineract.portfolio.collectionsheet.data.JLGGroupData;
import org.apache.fineract.portfolio.loanproduct.data.LoanProductData;
import org.apache.fineract.portfolio.meeting.attendance.service.AttendanceDropdownReadPlatformService;
import org.apache.fineract.portfolio.paymenttype.service.PaymentTypeReadPlatformService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CollectionSheetReadPlatformServiceImplTest {

  @InjectMocks
  private CollectionSheetReadPlatformServiceImpl underTest;

  @Mock
  private PaymentTypeReadPlatformService paymentTypeReadPlatformService;

  @Mock
  private AttendanceDropdownReadPlatformService attendanceDropdownReadPlatformService;

  @Test
  void buildJLGCollectionSheet_happyPath() {

    Mockito.when(paymentTypeReadPlatformService.retrieveAllPaymentTypes()).thenReturn(new ArrayList<>());
    Mockito.when(attendanceDropdownReadPlatformService.retrieveAttendanceTypeOptions()).thenReturn(new ArrayList<>());

    List<JLGCollectionSheetFlatData> jlgCollectionSheetFlatData = new ArrayList<>();

//    for(int i=0; i<50; i++) {
//      JLGCollectionSheetFlatData data = JLGCollectionSheetFlatData.builder()
//              .groupName("Group_" + UUID.randomUUID().toString())
//              .groupId(1L)
//              .clientName("ClientName_" + UUID.randomUUID().toString())
//              .staffId(1L)
//              .staffName("StaffName_" + UUID.randomUUID().toString())
//              .levelId(2L)
//              .levelName("Group")
//              .clientId(196L)
//              .loanId(4272L)
//              .accountId("000004272")
//              .accountStatusId(300)
//              .productShortName("LOAN")
//              .productId(1L)
//              .disbursementAmount(BigDecimal.ZERO)
//              .principalDue(BigDecimal.ZERO)
//              .principalPaid(BigDecimal.ZERO)
//              .interestDue(BigDecimal.ZERO)
//              .interestPaid(BigDecimal.ZERO)
//              .feeDue(BigDecimal.ZERO)
//              .feePaid(BigDecimal.ZERO)
//              .build();
//      jlgCollectionSheetFlatData.add(data);
//    }

//    for(int i=0; i<50; i++) {
//      JLGCollectionSheetFlatData data = JLGCollectionSheetFlatData.builder()
//              .groupName("Group_" + UUID.randomUUID().toString())
//              .groupId(2L)
//              .clientName("ClientName_" + UUID.randomUUID().toString())
//              .staffId(1L)
//              .staffName("StaffName_" + UUID.randomUUID().toString())
//              .levelId(2L)
//              .levelName("Group")
//              .clientId(195L)
//              .loanId(4271L)
//              .accountId("000004272")
//              .accountStatusId(300)
//              .productShortName("LOAN")
//              .productId(1L)
//              .disbursementAmount(BigDecimal.ZERO)
//              .principalDue(BigDecimal.ZERO)
//              .principalPaid(BigDecimal.ZERO)
//              .interestDue(BigDecimal.ZERO)
//              .interestPaid(BigDecimal.ZERO)
//              .feeDue(BigDecimal.ZERO)
//              .feePaid(BigDecimal.ZERO)
//              .build();
//      jlgCollectionSheetFlatData.add(data);
//    }

//    for(int i=0; i<5; i++) {
//      JLGCollectionSheetFlatData data = JLGCollectionSheetFlatData.builder()
//              .groupName("Group_" + UUID.randomUUID().toString())
//              .groupId(3L)
//              .clientName("ClientName_" + UUID.randomUUID().toString())
//              .staffId(1L)
//              .staffName("StaffName_" + UUID.randomUUID().toString())
//              .levelId(2L)
//              .levelName("Group")
//              .clientId(194L)
//              .loanId(4270L)
//              .accountId("000004270")
//              .accountStatusId(300)
//              .productShortName("LOAN")
//              .productId(1L)
//              .disbursementAmount(BigDecimal.ZERO)
//              .principalDue(BigDecimal.ZERO)
//              .principalPaid(BigDecimal.ZERO)
//              .interestDue(BigDecimal.ZERO)
//              .interestPaid(BigDecimal.ZERO)
//              .feeDue(BigDecimal.ZERO)
//              .feePaid(BigDecimal.ZERO)
//              .build();
//      jlgCollectionSheetFlatData.add(data);
//    }

    for (int i = 0; i < 500; i++) {
      long randomGroupId  = (long) (Math.random() * 10) + 1;  // 1–10
      long randomClientId = (long) (Math.random() * 10) + 1;  // 1–10
      long randomLoanId   = (long) (Math.random() * 10) + 1;  // 1–10

      JLGCollectionSheetFlatData data = JLGCollectionSheetFlatData.builder()
              .groupName("Group_" + randomGroupId)
              .groupId(randomGroupId)
              .clientName("ClientName_" + UUID.randomUUID().toString())
              .staffId(1L)
              .staffName("StaffName_" + UUID.randomUUID().toString())
              .levelId(2L)
              .levelName("Group")
              .clientId(randomClientId)
              .loanId(randomLoanId)
              .accountId(String.format("%09d", randomLoanId))
              .accountStatusId(300)
              .productShortName("LOAN")
              .productId(1L)
              .disbursementAmount(BigDecimal.ZERO)
              .principalDue(BigDecimal.ZERO)
              .principalPaid(BigDecimal.ZERO)
              .interestDue(BigDecimal.ZERO)
              .interestPaid(BigDecimal.ZERO)
              .feeDue(BigDecimal.ZERO)
              .feePaid(BigDecimal.ZERO)
              .build();

      jlgCollectionSheetFlatData.add(data);
    }

    Collections.shuffle(jlgCollectionSheetFlatData);
//    for(JLGCollectionSheetFlatData element : jlgCollectionSheetFlatData){
//      System.out.println(element);
//    }

    // Expected Results Data
    Set<LoanProductData> loanProducts = new LinkedHashSet<>();
    for (JLGCollectionSheetFlatData row : jlgCollectionSheetFlatData) {
      // collect unique loan products
      if (row.getProductId() != null) {
        loanProducts.add(LoanProductData.lookupWithCurrency(
                row.getProductId(), row.getProductShortName(), row.getCurrency()));
      }
//      System.out.println("LoanProductData: " + loanProducts);
    }

    Map<Long, JLGGroupData> groupMap = new LinkedHashMap<>();
    for (JLGCollectionSheetFlatData element : jlgCollectionSheetFlatData) {
      Long groupId = element.getGroupId();

      // if group does not exist, create it
      JLGGroupData group = groupMap.computeIfAbsent(groupId, id -> JLGGroupData.builder()
              .groupId(element.getGroupId())
              .groupName(element.getGroupName())
              .staffId(element.getStaffId())
              .staffName(element.getStaffName())
              .levelId(element.getLevelId())
              .levelName(element.getLevelName())
              .clients(new ArrayList<>())
              .build());

      // add client to that group
      group.getClients().add(element.getClientData());
    }
//    System.out.println("GroupMaps: " + groupMap);

    // finally get all groups as a list
    List<JLGGroupData> groups = new ArrayList<>(groupMap.values());

    JLGCollectionSheetData results = JLGCollectionSheetData.builder()
            .dueDate(LocalDate.of(2025, 9, 1))
            .loanProducts(loanProducts)
            .groups(groups)
            .attendanceTypeOptions(new ArrayList<>())
            .paymentTypeOptions(new ArrayList<>())
            .build();

    assertEquals(results,
            underTest.buildJLGCollectionSheet(LocalDate.of(2025, 9, 1), jlgCollectionSheetFlatData));
  }
}