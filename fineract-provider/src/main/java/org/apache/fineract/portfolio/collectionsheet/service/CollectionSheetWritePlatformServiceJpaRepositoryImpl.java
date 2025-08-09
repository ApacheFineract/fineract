/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.portfolio.collectionsheet.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.fineract.command.core.Command;
import org.apache.fineract.infrastructure.configuration.domain.ConfigurationDomainService;
import org.apache.fineract.infrastructure.core.api.JsonCommand;
import org.apache.fineract.infrastructure.core.data.CommandProcessingResult;
import org.apache.fineract.infrastructure.core.data.CommandProcessingResultBuilder;
import org.apache.fineract.infrastructure.core.domain.ExternalId;
import org.apache.fineract.infrastructure.core.service.DateUtils;
import org.apache.fineract.infrastructure.event.business.domain.loan.LoanDisbursalBusinessEvent;
import org.apache.fineract.infrastructure.event.business.domain.loan.transaction.LoanDisbursalTransactionBusinessEvent;
import org.apache.fineract.organisation.holiday.domain.Holiday;
import org.apache.fineract.organisation.holiday.domain.HolidayRepositoryWrapper;
import org.apache.fineract.organisation.monetary.domain.Money;
import org.apache.fineract.organisation.workingdays.domain.WorkingDays;
import org.apache.fineract.organisation.workingdays.domain.WorkingDaysRepositoryWrapper;
import org.apache.fineract.portfolio.account.PortfolioAccountType;
import org.apache.fineract.portfolio.account.data.AccountTransferDTO;
import org.apache.fineract.portfolio.account.data.PortfolioAccountData;
import org.apache.fineract.portfolio.account.domain.AccountTransferType;
import org.apache.fineract.portfolio.collectionsheet.command.CollectionSheetBulkDisbursalCommand;
import org.apache.fineract.portfolio.collectionsheet.command.CollectionSheetBulkRepaymentCommand;
import org.apache.fineract.portfolio.collectionsheet.command.SingleDisbursalCommand;
import org.apache.fineract.portfolio.collectionsheet.data.CollectionSheetRequest;
import org.apache.fineract.portfolio.collectionsheet.data.CollectionSheetResponse;
import org.apache.fineract.portfolio.collectionsheet.data.CollectionSheetTransactionDataValidator;
import org.apache.fineract.portfolio.collectionsheet.data.RepaymentTransactionRequest;
import org.apache.fineract.portfolio.collectionsheet.data.SavingDueTransactionRequest;
import org.apache.fineract.portfolio.collectionsheet.serialization.CollectionSheetBulkDisbursalCommandFromApiJsonDeserializer;
import org.apache.fineract.portfolio.collectionsheet.serialization.CollectionSheetBulkRepaymentCommandFromApiJsonDeserializer;
import org.apache.fineract.portfolio.loanaccount.api.LoanApiConstants;
import org.apache.fineract.portfolio.loanaccount.data.HolidayDetailDTO;
import org.apache.fineract.portfolio.loanaccount.data.ScheduleGeneratorDTO;
import org.apache.fineract.portfolio.loanaccount.domain.Loan;
import org.apache.fineract.portfolio.loanaccount.domain.LoanAccountDomainService;
import org.apache.fineract.portfolio.loanaccount.domain.LoanCharge;
import org.apache.fineract.portfolio.loanaccount.domain.LoanEvent;
import org.apache.fineract.portfolio.loanaccount.domain.LoanRepositoryWrapper;
import org.apache.fineract.portfolio.loanaccount.domain.LoanTransaction;
import org.apache.fineract.portfolio.loanaccount.domain.LoanTransactionType;
import org.apache.fineract.portfolio.loanaccount.serialization.LoanTransactionValidator;
import org.apache.fineract.portfolio.loanaccount.service.LoanAssembler;
import org.apache.fineract.portfolio.loanaccount.service.LoanWritePlatformService;
import org.apache.fineract.portfolio.loanproduct.domain.LoanProduct;
import org.apache.fineract.portfolio.meeting.service.MeetingWritePlatformService;
import org.apache.fineract.portfolio.paymentdetail.domain.PaymentDetail;
import org.apache.fineract.portfolio.paymentdetail.domain.PaymentDetailAssembler;
import org.apache.fineract.portfolio.paymentdetail.service.PaymentDetailWritePlatformService;
import org.apache.fineract.portfolio.paymenttype.domain.PaymentType;
import org.apache.fineract.portfolio.paymenttype.domain.PaymentTypeRepositoryWrapper;
import org.apache.fineract.portfolio.savings.data.SavingsAccountTransactionDTO;
import org.apache.fineract.portfolio.savings.domain.DepositAccountAssembler;
import org.apache.fineract.portfolio.savings.domain.SavingsAccount;
import org.apache.fineract.portfolio.savings.domain.SavingsAccountTransaction;
import org.apache.fineract.portfolio.savings.service.DepositAccountWritePlatformService;
import org.apache.fineract.useradministration.domain.AppUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CollectionSheetWritePlatformServiceJpaRepositoryImpl implements CollectionSheetWritePlatformService {

    private final LoanWritePlatformService loanWritePlatformService;
    private final CollectionSheetBulkRepaymentCommandFromApiJsonDeserializer bulkRepaymentCommandFromApiJsonDeserializer;
    private final CollectionSheetBulkDisbursalCommandFromApiJsonDeserializer bulkDisbursalCommandFromApiJsonDeserializer;
    private final CollectionSheetTransactionDataValidator transactionDataValidator;
    private final MeetingWritePlatformService meetingWritePlatformService;
    private final DepositAccountAssembler accountAssembler;
    private final DepositAccountWritePlatformService accountWritePlatformService;
    private final PaymentDetailAssembler paymentDetailAssembler;
    private final PaymentDetailWritePlatformService paymentDetailWritePlatformService;
    private final PaymentTypeRepositoryWrapper repositoryWrapper;
    private final ConfigurationDomainService configurationDomainService;
    private final LoanRepositoryWrapper loanRepositoryWrapper;
    private final HolidayRepositoryWrapper holidayRepository;
    private final WorkingDaysRepositoryWrapper workingDaysRepository;
    private final LoanTransactionValidator loanTransactionValidator;
    private final LoanAssembler loanAssembler;
    private final LoanAccountDomainService loanAccountDomainService;

    @Override
    public CommandProcessingResult updateCollectionSheet(final JsonCommand command) {

        this.transactionDataValidator.validateTransaction(command);

        final Map<String, Object> changes = new HashMap<>();
        changes.put("locale", command.locale());
        changes.put("dateFormat", command.dateFormat());

        final String noteText = command.stringValueOfParameterNamed("note");
        if (StringUtils.isNotBlank(noteText)) {
            changes.put("note", noteText);
        }

        final PaymentDetail paymentDetail = this.paymentDetailWritePlatformService.createAndPersistPaymentDetail(command, changes);
        changes.putAll(updateBulkRepayments(command, paymentDetail));

        changes.putAll(updateBulkDisbursals(command));

        changes.putAll(updateBulkMandatorySavingsDuePayments(command, paymentDetail));

        this.meetingWritePlatformService.updateCollectionSheetAttendance(command);

        return new CommandProcessingResultBuilder() //
                .withCommandId(command.commandId()) //
                .withEntityId(command.entityId()) //
                .withGroupId(command.entityId()) //
                .with(changes).with(changes).build();
    }

    @Override
    public CommandProcessingResult saveIndividualCollectionSheet(final JsonCommand command) {

        this.transactionDataValidator.validateIndividualCollectionSheet(command);

        final Map<String, Object> changes = new HashMap<>();
        changes.put("locale", command.locale());
        changes.put("dateFormat", command.dateFormat());

        final String noteText = command.stringValueOfParameterNamed("note");
        if (StringUtils.isNotBlank(noteText)) {
            changes.put("note", noteText);
        }

        final PaymentDetail paymentDetail = null;

        changes.putAll(updateBulkRepayments(command, paymentDetail));

        changes.putAll(updateBulkDisbursals(command));

        changes.putAll(updateBulkMandatorySavingsDuePayments(command, paymentDetail));

        final var result = new CommandProcessingResultBuilder().withCommandId(command.commandId()).withEntityId(command.entityId())
                .withGroupId(command.entityId()).with(changes).with(changes).build();

        return result;
    }

    @Transactional
    @Override
    public CollectionSheetResponse saveIndividualCollectionSheet(Command<CollectionSheetRequest> command) {
        // this.transactionDataValidator.validateIndividualCollectionSheet(command);

        final Map<String, Object> changes = new HashMap<>();
        changes.put("locale", command.getPayload().getLocale());
        changes.put("dateFormat", command.getPayload().getDateFormat());

        // final String noteText = command.stringValueOfParameterNamed("note");
        // if (StringUtils.isNotBlank(noteText)) {
        // changes.put("note", noteText);
        // }

        changes.putAll(updateBulkRepayments(command));

         changes.putAll(updateBulkDisbursals(command));
        // changes.putAll(updateBulkMandatorySavingsDuePayments(command, paymentDetail));

        // final var result = new CommandProcessingResultBuilder()
        // .withCommandId(command.commandId())
        // .withEntityId(command.entityId())
        // .withGroupId(command.entityId())
        // .with(changes).with(changes).build();

        return CollectionSheetResponse.builder().commandId(command.getId()).groupId(1L).entityId(1L).changes(changes).build();
    }

    @Deprecated
    private Map<String, Object> updateBulkRepayments(final JsonCommand command, final PaymentDetail paymentDetail) {
        final Map<String, Object> changes = new HashMap<>();
        final CollectionSheetBulkRepaymentCommand bulkRepaymentCommand = this.bulkRepaymentCommandFromApiJsonDeserializer
                .commandFromApiJson(command.json(), paymentDetail);
        changes.putAll(this.loanWritePlatformService.makeLoanBulkRepayment(bulkRepaymentCommand));
        return changes;
    }

    private Map<String, Object> updateBulkRepayments(final Command<CollectionSheetRequest> command) {
        final Map<String, Object> changes = new HashMap<>();
        List<RepaymentTransactionRequest> repaymentTransactionList = command.getPayload().getBulkDisbursementTransactions()
                .getBulkRepaymentTransactions();
        List<Long> transactionIds = new ArrayList<>();
        for (RepaymentTransactionRequest element : repaymentTransactionList) {
            final Long paymentTypeId = element.getPaymentTypeId();
            final PaymentType paymentType = this.repositoryWrapper.findOneWithNotFoundDetection(paymentTypeId);
            final String accountNumber = element.getAccountNumber();
            final String checkNumber = element.getCheckNumber();
            final String routingCode = element.getRoutingCode();
            final String receiptNumber = element.getReceiptNumber();
            final String bankNumber = element.getBankNumber();
            final PaymentDetail paymentDetail = PaymentDetail.instance(paymentType, accountNumber, checkNumber, routingCode, receiptNumber,
                    bankNumber);

            final boolean isRecoveryRepayment = false;


            boolean isAccountTransfer = false;
            HolidayDetailDTO holidayDetailDTO = null;
            boolean isHolidayValidationDone = false;
            final boolean allowTransactionsOnHoliday = this.configurationDomainService.allowTransactionsOnHolidayEnabled();
            // for (final SingleRepaymentCommand singleLoanRepaymentCommand : repaymentCommand) {
            // if (singleLoanRepaymentCommand != null) {

            LocalDate transactionDate = getTransactionDate(command);
            Loan loan = this.loanRepositoryWrapper.findOneWithNotFoundDetection(element.getLoanId());
            final List<Holiday> holidays = this.holidayRepository.findByOfficeIdAndGreaterThanDate(loan.getOfficeId(), transactionDate);
            final WorkingDays workingDays = this.workingDaysRepository.findOne();
            final boolean allowTransactionsOnNonWorkingDay = this.configurationDomainService.allowTransactionsOnNonWorkingDayEnabled();
            boolean isHolidayEnabled;
            isHolidayEnabled = this.configurationDomainService.isRescheduleRepaymentsOnHolidaysEnabled();
            holidayDetailDTO = new HolidayDetailDTO(isHolidayEnabled, holidays, workingDays, allowTransactionsOnHoliday,
                    allowTransactionsOnNonWorkingDay);
            loanTransactionValidator.validateRepaymentDateIsOnHoliday(transactionDate, holidayDetailDTO.isAllowTransactionsOnHoliday(),
                    holidayDetailDTO.getHolidays());
            loanTransactionValidator.validateRepaymentDateIsOnNonWorkingDay(transactionDate, holidayDetailDTO.getWorkingDays(),
                    holidayDetailDTO.isAllowTransactionsOnNonWorkingDay());
            isHolidayValidationDone = true;
            // break;
            // }
            // }
            // for (final SingleRepaymentCommand singleLoanRepaymentCommand : repaymentCommand) {
            // if (singleLoanRepaymentCommand != null) {
            final Loan loanAssembled = this.loanAssembler.assembleFrom(element.getLoanId());

             ExternalId externalId = null;
             if (configurationDomainService.isExternalIdAutoGenerationEnabled()) {
              externalId = ExternalId.generate();
             }
             if (paymentDetail != null && paymentDetail.getId() == null) {
              this.paymentDetailWritePlatformService.persistPaymentDetail(paymentDetail);
             }
             final String chargeRefundChargeType = null;
             LoanTransaction loanTransaction =
             this.loanAccountDomainService.makeRepayment(LoanTransactionType.REPAYMENT, loanAssembled,
             transactionDate, element.getTransactionAmount(),
             paymentDetail,
             null, externalId, isRecoveryRepayment, chargeRefundChargeType,
             isAccountTransfer,
             holidayDetailDTO, isHolidayValidationDone);
             transactionIds.add(loanTransaction.getId());
             }
            changes.put("loanTransactions", transactionIds);
            return changes;
        }

        // final CollectionSheetBulkRepaymentCommand bulkRepaymentCommand =
        // this.bulkRepaymentCommandFromApiJsonDeserializer
        // .commandFromApiJson(command.json(), paymentDetail);
        // changes.putAll(this.loanWritePlatformService.makeLoanBulkRepayment(bulkRepaymentCommand));
//        return Map.of("key1", "value1");
//    }

    private LocalDate getTransactionDate(Command<CollectionSheetRequest> command) {
        try {
            String dateFieldVal = command.getPayload().getTransactionDate();
            String format = command.getPayload().getDateFormat();
            String locale = command.getPayload().getLocale();

            DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern(format.replace("y", "u"))
                    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0).parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                    .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0).toFormatter(Locale.forLanguageTag(locale))
                    .withResolverStyle(ResolverStyle.STRICT);

            return LocalDate.parse(dateFieldVal, formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format or value in transaction", e);
        }
    }

    @Deprecated
    private Map<String, Object> updateBulkDisbursals(final JsonCommand command) {
        final Map<String, Object> changes = new HashMap<>();
        final CollectionSheetBulkDisbursalCommand bulkDisbursalCommand = this.bulkDisbursalCommandFromApiJsonDeserializer
                .commandFromApiJson(command.json());
        changes.putAll(this.loanWritePlatformService.bulkLoanDisbursal(command, bulkDisbursalCommand, false));
        return changes;
    }

  private Map<String, Object> updateBulkDisbursals(final Command<CollectionSheetRequest> command) {
    final Map<String, Object> changes = new HashMap<>();
//    List<SavingDueTransactionRequest> bulkSavingsDueTransactions =
//            command.getPayload().getBulkDisbursementTransactions().getBulkSavingsDueTransactions();
//    for (SavingDueTransactionRequest element : bulkSavingsDueTransactions) {
//
//      final AppUser currentUser = getAppUserIfPresent();
//
//      final SingleDisbursalCommand[] disbursalCommand = bulkDisbursalCommand.getDisburseTransactions();
//
//      final LocalDate nextPossibleRepaymentDate = null;
//      final LocalDate rescheduledRepaymentDate = null;
//
//      for (final SingleDisbursalCommand singleLoanDisbursalCommand : disbursalCommand) {
//        Loan loan = this.loanAssembler.assembleFrom(singleLoanDisbursalCommand.getLoanId());
//        final LocalDate actualDisbursementDate = command.localDateValueOfParameterNamed("actualDisbursementDate");
//
//        // validate ActualDisbursement Date Against Expected Disbursement
//        // Date
//        LoanProduct loanProduct = loan.loanProduct();
//        if (loanProduct.isSyncExpectedWithDisbursementDate()) {
//          syncExpectedDateWithActualDisbursementDate(loan, actualDisbursementDate);
//        }
//        checkClientOrGroupActive(loan);
//        businessEventNotifierService.notifyPreBusinessEvent(new LoanDisbursalBusinessEvent(loan));
//
//        final List<Long> existingTransactionIds = new ArrayList<>();
//        final List<Long> existingReversedTransactionIds = new ArrayList<>();
//
//        final PaymentDetail paymentDetail = this.paymentDetailWritePlatformService.createAndPersistPaymentDetail(command, changes);
//
//        // Bulk disbursement should happen on meeting date (mostly from
//        // collection sheet).
//        // FIXME: AA - this should be first meeting date based on
//        // disbursement date and next available meeting dates
//        // assuming repayment schedule won't regenerate because expected
//        // disbursement and actual disbursement happens on same date
//        loanDownPaymentTransactionValidator.validateAccountStatus(loan, LoanEvent.LOAN_DISBURSED);
//        updateLoanCounters(loan, actualDisbursementDate);
//        if (canDisburse(loan)) {
//          Money amountBeforeAdjust = loan.getPrincipal();
//          Money disburseAmount = loanDisbursementService.adjustDisburseAmount(loan, command, actualDisbursementDate);
//          boolean recalculateSchedule = amountBeforeAdjust.isNotEqualTo(loan.getPrincipal());
//          final ExternalId txnExternalId = externalIdFactory.createFromCommand(command, LoanApiConstants.externalIdParameterName);
//          if (isAccountTransfer) {
//            disburseLoanToSavings(loan, command, disburseAmount, paymentDetail);
//            existingTransactionIds.addAll(loanTransactionRepository.findTransactionIdsByLoan(loan));
//            existingReversedTransactionIds.addAll(loanTransactionRepository.findReversedTransactionIdsByLoan(loan));
//
//          } else {
//            existingTransactionIds.addAll(loanTransactionRepository.findTransactionIdsByLoan(loan));
//            existingReversedTransactionIds.addAll(loanTransactionRepository.findReversedTransactionIdsByLoan(loan));
//            LoanTransaction disbursementTransaction = LoanTransaction.disbursement(loan, disburseAmount, paymentDetail,
//                    actualDisbursementDate, txnExternalId, loan.getTotalOverpaidAsMoney());
//            disbursementTransaction.updateLoan(loan);
//            loan.addLoanTransaction(disbursementTransaction);
//            businessEventNotifierService
//                    .notifyPostBusinessEvent(new LoanDisbursalTransactionBusinessEvent(disbursementTransaction));
//          }
//          LocalDate recalculateFrom = null;
//          final ScheduleGeneratorDTO scheduleGeneratorDTO = this.loanUtilService.buildScheduleGeneratorDTO(loan, recalculateFrom);
//          regenerateScheduleOnDisbursement(command, loan, recalculateSchedule, scheduleGeneratorDTO, nextPossibleRepaymentDate,
//                  rescheduledRepaymentDate);
//          boolean downPaymentEnabled = loan.getLoanProductRelatedDetail().isEnableDownPayment();
//          if (loan.isInterestBearingAndInterestRecalculationEnabled() || downPaymentEnabled) {
//            createAndSaveLoanScheduleArchive(loan, scheduleGeneratorDTO);
//          }
//          disburseLoan(command, configurationDomainService.isPaymentTypeApplicableForDisbursementCharge(), paymentDetail, loan,
//                  currentUser, changes, scheduleGeneratorDTO);
//
//          loanAccrualsProcessingService.reprocessExistingAccruals(loan);
//
//          LocalDate firstInstallmentDueDate = loan.fetchRepaymentScheduleInstallment(1).getDueDate();
//          if (loan.isInterestBearingAndInterestRecalculationEnabled()
//                  && (DateUtils.isBeforeBusinessDate(firstInstallmentDueDate) || loan.isDisbursementMissed())) {
//            loanAccrualsProcessingService.processIncomePostingAndAccruals(loan);
//          }
//        }
//        if (!changes.isEmpty()) {
//          createNote(loan, command, changes);
//          loan = saveAndFlushLoanWithDataIntegrityViolationChecks(loan);
//          journalEntryPoster.postJournalEntries(loan, existingTransactionIds, existingReversedTransactionIds);
//          loanAccrualTransactionBusinessEventService.raiseBusinessEventForAccrualTransactions(loan, existingTransactionIds);
//        }
//        final Set<LoanCharge> loanCharges = loan.getActiveCharges();
//        final Map<Long, BigDecimal> disBuLoanCharges = new HashMap<>();
//        for (final LoanCharge loanCharge : loanCharges) {
//          if (loanCharge.isDueAtDisbursement() && loanCharge.getChargePaymentMode().isPaymentModeAccountTransfer()
//                  && loanCharge.isChargePending()) {
//            disBuLoanCharges.put(loanCharge.getId(), loanCharge.amountOutstanding());
//          }
//        }
//        final Locale locale = command.extractLocale();
//        final DateTimeFormatter fmt = DateTimeFormatter.ofPattern(command.dateFormat()).withLocale(locale);
//        for (final Map.Entry<Long, BigDecimal> entrySet : disBuLoanCharges.entrySet()) {
//          final PortfolioAccountData savingAccountData = this.accountAssociationsReadPlatformService
//                  .retriveLoanLinkedAssociation(loan.getId());
//          final SavingsAccount fromSavingsAccount = null;
//          final boolean isRegularTransaction = true;
//          final boolean isExceptionForBalanceCheck = false;
//          final AccountTransferDTO accountTransferDTO = new AccountTransferDTO(actualDisbursementDate, entrySet.getValue(),
//                  PortfolioAccountType.SAVINGS, PortfolioAccountType.LOAN, savingAccountData.getId(), loan.getId(),
//                  "Loan Charge Payment", locale, fmt, null, null, LoanTransactionType.REPAYMENT_AT_DISBURSEMENT.getValue(),
//                  entrySet.getKey(), null, AccountTransferType.CHARGE_PAYMENT.getValue(), null, null, ExternalId.empty(), null, null,
//                  fromSavingsAccount, isRegularTransaction, isExceptionForBalanceCheck);
//          this.accountTransfersWritePlatformService.transferFunds(accountTransferDTO);
//        }
//        updateRecurringCalendarDatesForInterestRecalculation(loan);
//        loanAccrualsProcessingService.processAccrualsOnInterestRecalculation(loan,
//                loan.isInterestBearingAndInterestRecalculationEnabled(), true);
//        loanAccountDomainService.setLoanDelinquencyTag(loan, DateUtils.getBusinessLocalDate());
//        businessEventNotifierService.notifyPostBusinessEvent(new LoanDisbursalBusinessEvent(loan));
//      }
      return changes;
    }




//    changes.putAll(this.loanWritePlatformService.bulkLoanDisbursal(command, bulkDisbursalCommand, false));
//    return changes;
//  }

    private Map<String, Object> updateBulkMandatorySavingsDuePayments(final JsonCommand command, final PaymentDetail paymentDetail) {
        final Map<String, Object> changes = new HashMap<>();
        final Collection<SavingsAccountTransactionDTO> savingsTransactions = this.accountAssembler
                .assembleBulkMandatorySavingsAccountTransactionDTOs(command, paymentDetail);
        List<Long> depositTransactionIds = new ArrayList<>();
        for (SavingsAccountTransactionDTO savingsAccountTransactionDTO : savingsTransactions) {
            try {
                SavingsAccountTransaction savingsAccountTransaction = this.accountWritePlatformService
                        .mandatorySavingsAccountDeposit(savingsAccountTransactionDTO);
                depositTransactionIds.add(savingsAccountTransaction.getId());
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        changes.put("SavingsTransactions", depositTransactionIds);
        return changes;
    }
}
