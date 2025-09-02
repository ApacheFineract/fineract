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
package org.apache.fineract.commands.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommandPermission {

    UPDATE_CREDIT_BUREAU(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU,
            "/creditBureauConfiguration/template"), UPDATE_CREDIT_BUREAU_LOANPRODUCT_MAPPING(Action.UPDATE,
                    Entity.CREDIT_BUREAU_LOANPRODUCT_MAPPING,
                    "/creditBureauConfiguration/template"), ADD_ORGANISATION_CREDIT_BUREAU(Action.CREATE, Entity.ORGANISATION_CREDIT_BUREAU,
                            "/creditBureauConfiguration/organizationCreditBureau/template"),

    GET_CREDIT_REPORT(Action.GET, Entity.CREDIT_REPORT, "/getCreditReport/template"),

    SAVE_CREDIT_REPORT(Action.SAVE, Entity.CREDIT_REPORT, "/saveCreditReport/"),

    DELETE_CREDIT_REPORT(Action.DELETE, Entity.CREDIT_REPORT, "/deleteCreditReport/"),

    CREATE_CREDIT_BUREAU_LOAN_PRODUCT_MAPPING(Action.CREATE, Entity.CREDIT_BUREAU_LOANPRODUCT_MAPPING,
            "/creditBureauConfiguration/template"),

    ADD_CREDIT_BUREAU_CONFIGURATION(Action.CREATE, Entity.CREDIT_BUREAU_CONFIGURATION, "/addCreditBureauConfigurationData/"),

    UPDATE_CREDIT_BUREAU_CONFIGURATION(Action.UPDATE, Entity.CREDIT_BUREAU_CONFIGURATION, "/updateCreditBureauConfigurationData/"),

    ADD_CLIENT_ADDRESS(Action.CREATE, Entity.ADDRESS, "/clients/"),

    UPDATE_CLIENT_ADDRESS(Action.UPDATE, Entity.ADDRESS, "/clients/"),

    ADD_FAMILY_MEMBERS(Action.CREATE, Entity.FAMILY_MEMBERS, "/clients/"),

    UPDATE_FAMILY_MEMBERS(Action.UPDATE, Entity.FAMILY_MEMBERS, "/clients/"),

    DELETE_FAMILY_MEMBERS(Action.DELETE, Entity.FAMILY_MEMBERS, "/clients/"),

    UPDATE_GLOBAL_CONFIGURATION(Action.UPDATE, Entity.CONFIGURATION, "/configurations/"),

    UPDATE_PERMISSIONS(Action.UPDATE, Entity.PERMISSION, "/permissions"),

    CREATE_ROLE(Action.CREATE, Entity.ROLE, "/roles/template"),

    UPDATE_ROLE(Action.UPDATE, Entity.ROLE, "/roles/"),

    UPDATE_ROLE_PERMISSIONS(Action.PERMISSIONS, Entity.ROLE, "/roles/"),

    CREATE_USER(Action.CREATE, Entity.USER, "/users/template"),

    CHANGE_USER_PASSWORD(Action.CHANGEPWD, Entity.USER, "/users/"),

    UPDATE_USER(Action.UPDATE, Entity.USER, "/users/"),

    DELETE_USER(Action.DELETE, Entity.USER, "/users/"),

    CREATE_OFFICE(Action.CREATE, Entity.OFFICE, "/offices/template"),

    UPDATE_OFFICE(Action.UPDATE, Entity.OFFICE, "/offices/"),

    CREATE_OFFICE_TRANSACTION(Action.CREATE, Entity.OFFICE_TRANSACTION, "/officetransactions/template"),

    DELETE_OFFICE_TRANSACTION(Action.DELETE, Entity.OFFICE_TRANSACTION, "/officetransactions/"),

    CREATE_STAFF(Action.CREATE, Entity.STAFF, "/staff/template"),

    UPDATE_STAFF(Action.UPDATE, Entity.STAFF, "/staff/"),

    CREATE_GUARANTOR(Action.CREATE, Entity.GUARANTOR, "/loans/"),

    RECOVER_FROM_GUARANTOR(Action.RECOVERGUARANTEES, Entity.LOAN, "/loans/"),

    UPDATE_GUARANTOR(Action.UPDATE, Entity.GUARANTOR, "/loans/"),

    DELETE_GUARANTOR(Action.DELETE, Entity.GUARANTOR, "/loans/"),

    CREATE_FUND(Action.CREATE, Entity.FUND, "/funds/template"),

    UPDATE_FUND(Action.UPDATE, Entity.FUND, "/funds/"),

    CREATE_REPORT(Action.CREATE, Entity.REPORT, "/reports/template"),

    UPDATE_REPORT(Action.UPDATE, Entity.REPORT, "/reports/"),

    DELETE_REPORT(Action.DELETE, Entity.REPORT, "/reports/"),

    UPDATE_CURRENCIES(Action.UPDATE, Entity.CURRENCY, "/currencies"),

    CREATE_SMS(Action.CREATE, Entity.SMS, "/sms/template"),

    UPDATE_SMS(Action.UPDATE, Entity.SMS, "/sms/"),

    DELETE_SMS(Action.DELETE, Entity.SMS, "/sms/"),

    CREATE_CODE(Action.CREATE, Entity.CODE, "/codes/template"),

    UPDATE_CODE(Action.UPDATE, Entity.CODE, "/codes/"),

    DELETE_CODE(Action.DELETE, Entity.CODE, "/codes/"),

    CREATE_HOOK(Action.CREATE, Entity.HOOK, "/hooks/template"),

    UPDATE_HOOK(Action.UPDATE, Entity.HOOK, "/hooks/"),

    DELETE_HOOK(Action.DELETE, Entity.HOOK, "/hooks/"),

    CREATE_CHARGE(Action.CREATE, Entity.CHARGE, "/charges/template"),

    CREATE_COLLATERAL(Action.CREATE, Entity.COLLATERAL_PRODUCT, "/collateral-product"),

    UPDATE_CHARGE(Action.UPDATE, Entity.CHARGE, "/charges/"),

    DELETE_CHARGE(Action.DELETE, Entity.CHARGE, "/charges/"),

    CREATE_LOAN_PRODUCT(Action.CREATE, Entity.LOAN_PRODUCT, "/loanproducts/template"),

    UPDATE_LOAN_PRODUCT(Action.UPDATE, Entity.LOAN_PRODUCT, "/loanproducts/"),

    CREATE_CLIENT_IDENTIFIER(Action.CREATE, Entity.CLIENT_IDENTIFIER, "/clients/"),

    UPDATE_CLIENT_IDENTIFIER(Action.UPDATE, Entity.CLIENT_IDENTIFIER, "/clients/"),

    DELETE_CLIENT_IDENTIFIER(Action.DELETE, Entity.CLIENT_IDENTIFIER, "/clients/"),

    CREATE_CLIENT(Action.CREATE, Entity.CLIENT, "/clients/template"),

    ACTIVATE_CLIENT(Action.ACTIVATE, Entity.CLIENT, "/clients/"),

    CLOSE_CLIENT(Action.CLOSE, Entity.CLIENT, "/clients/"),

    REJECT_CLIENT(Action.REJECT, Entity.CLIENT, "/clients/"),

    WITHDRAW_CLIENT(Action.WITHDRAW, Entity.CLIENT, "/clients/"),

    REACTIVATE_CLIENT(Action.REACTIVATE, Entity.CLIENT, "/clients/"),

    PROPOSE_CLIENT_TRANSFER(Action.PROPOSETRANSFER, Entity.CLIENT, "/clientId/"),

    PROPOSE_AND_ACCEPT_CLIENT_TRANSFER(Action.PROPOSEANDACCEPTTRANSFER, Entity.CLIENT, "/clientId/"),

    WITHDRAW_CLIENT_TRANSFER_REQUEST(Action.WITHDRAWTRANSFER, Entity.CLIENT, "/clientId/"),

    ACCEPT_CLIENT_TRANSFER(Action.ACCEPTTRANSFER, Entity.CLIENT, "/clientId/"),

    REJECT_CLIENT_TRANSFER(Action.REJECTTRANSFER, Entity.CLIENT, "/clientId/"),

    UPDATE_CLIENT(Action.UPDATE, Entity.CLIENT, "/clients/"),

    DELETE_CLIENT(Action.DELETE, Entity.CLIENT, "/clients/"),

    CREATED_BDATATABLE(Action.CREATE, Entity.DATATABLE, "/datatables/"),

    UPDATED_BDATATABLE(Action.UPDATE, Entity.DATATABLE, "/datatables/"),

    DELETED_BDATATABLE(Action.DELETE, Entity.DATATABLE, "/datatables/"),

    UNDO_REJECTION(Action.UNDOREJECT, Entity.CLIENT, "/clients/"),

    UNDO_WITHDRAWAL(Action.UNDOWITHDRAWAL, Entity.CLIENT, "/clients/"),

    CREATE_LOAN_CHARGE(Action.CREATE, Entity.LOANCHARGE, "/loans/"),

    UPDATE_LOAN_CHARGE(Action.UPDATE, Entity.LOANCHARGE, "/loans/"),

    WAIVE_LOAN_CHARGE(Action.WAIVE, Entity.LOANCHARGE, "/loans/"),

    PAY_LOAN_CHARGE(Action.PAY, Entity.LOANCHARGE, "/loans/"),

    ADJUSTMENT_FOR_LOAN_CHARGE(Action.ADJUSTMENT, Entity.LOANCHARGE, "/loans/"),

    DEACTIVATE_OVERDUE_LOAN_CHARGES(Action.DEACTIVATEOVERDUE, Entity.LOANCHARGE, "/loans/"),

    DELETE_LOAN_CHARGE(Action.DELETE, Entity.LOANCHARGE, "/loans/"),

    LOAN_REPAYMENT_TRANSACTION(Action.REPAYMENT, Entity.LOAN, "/loans/"),

    LOAN_MERCHANT_ISSUED_REFUND_TRANSACTION(Action.MERCHANTISSUEDREFUND, Entity.LOAN, "/loans/"),

    LOAN_PAYOUT_REFUND_TRANSACTION(Action.PAYOUTREFUND, Entity.LOAN, "/loans/"),

    LOAN_GOODWILL_CREDIT_TRANSACTION(Action.GOODWILLCREDIT, Entity.LOAN, "/loans/"),

    LOAN_INTEREST_PAYMENT_WAIVER_TRANSACTION(Action.INTERESTPAYMENTWAIVER, Entity.LOAN, "/loans/"),

    REFUND_LOAN_CHARGE(Action.CHARGEREFUND, Entity.LOAN, "/loans/"),

    LOAN_RECOVERY_PAYMENT_TRANSACTION(Action.RECOVERYPAYMENT, Entity.LOAN, "/loans/"),

    WAIVE_INTEREST_PORTION_TRANSACTION(Action.WAIVEINTERESTPORTION, Entity.LOAN, "/loans/"),

    WRITE_OFF_LOAN_TRANSACTION(Action.WRITEOFF, Entity.LOAN, "/loans/"),

    UNDO_WRITE_OFF_LOAN_TRANSACTION(Action.UNDOWRITEOFF, Entity.LOAN, "/loans/"),

    CLOSE_LOAN_AS_RESCHEDULED_TRANSACTION(Action.CLOSEASRESCHEDULED, Entity.LOAN, "/loans/"),

    CLOSE_LOAN_TRANSACTION(Action.CLOSE, Entity.LOAN, "/loans/"),

    ADJUST_TRANSACTION(Action.ADJUST, Entity.LOAN, "/loans/"),

    REFUND_LOAN_TRANSACTION_BY_CASH(Action.REFUNDBYCASH, Entity.LOAN, "/loans/"),

    CHARGE_BACK_TRANSACTION(Action.CHARGEBACK, Entity.LOAN, "/loans/"),

    LOAN_FORECLOSURE(Action.FORECLOSURE, Entity.LOAN, "/loans/"),

    CREDIT_BALANCE_REFUND(Action.CREDITBALANCEREFUND, Entity.LOAN, "/loans/"),

    UNDO_WAIVE_CHARGE_TRANSACTION(Action.UNDO, Entity.WAIVECHARGE, "/loans/"),

    CREATE_LOAN_APPLICATION(Action.CREATE, Entity.LOAN, "/loans"),

    UPDATE_POST_DATED_CHEQUE(Action.UPDATE, Entity.REPAYMENT_WITH_POSTDATEDCHECKS, "/loans/"),

    BOUNCED_CHEQUE(Action.BOUNCE, Entity.REPAYMENT_WITH_POSTDATEDCHECKS, "/loans/"),

    DELETE_POST_DATED_CHEQUE(Action.DELETE, Entity.REPAYMENT_WITH_POSTDATEDCHECKS, "/loans/"),

    UPDATE_LOAN_APPLICATION(Action.UPDATE, Entity.LOAN, "/loans/"),

    MARK_AS_FRAUD(Action.SETFRAUD, Entity.LOAN, "/loans/"),

    UPDATE_DISBUSEMENT_DATE(Action.UPDATE, Entity.DISBURSEMENT_DETAIL, "/loans/"),

    ADD_AND_DELETE_DISBURSEMENT_DETAILS(Action.UPDATE, Entity.DISBURSEMENT_DETAIL, "/loans/"),

    DELETE_LOAN_APPLICATION(Action.DELETE, Entity.LOAN, "/loans/"),

    REJECT_LOAN_APPLICATION(Action.REJECT, Entity.LOAN, "/loans/"),

    REJECT_GLIM_APPLICATION(Action.REJECT, Entity.GLIM_LOAN, "/loans/"),

    WITHDRAW_LOAN_APPLICATION(Action.WITHDRAW, Entity.LOAN, "/loans/"),

    APPROVE_LOAN_APPLICATION(Action.APPROVE, Entity.LOAN, "/loans/"),

    APPROVE_GLIM_LOAN_APPLICATION(Action.APPROVE, Entity.GLIM_LOAN, "/loans/"),

    DISBURSE_GLIM_LOAN_APPLICATION(Action.DISBURSE, Entity.GLIM_LOAN, "/loans/"),

    REPAYMENT_GLIM_LOAN_APPLICATION(Action.REPAYMENT, Entity.GLIM_LOAN, "/loans/"),

    UNDO_GLIM_LOAN_DISBURSAL(Action.UNDODISBURSAL, Entity.GLIM_LOAN, "/loans/"),

    UNDO_GLIM_LOAN_APPROVAL(Action.UNDOAPPROVAL, Entity.GLIM_LOAN, "/loans/"),

    DISBURSE_LOAN_APPLICATION(Action.DISBURSE, Entity.LOAN, "/loans/"),

    DISBURSE_LOAN_TO_SAVINGS_APPLICATION(Action.DISBURSETOSAVINGS, Entity.LOAN, "/loans/"),

    DISBURSE_WITHOUT_AUTO_DOWNPAYMENT(Action.DISBURSEWITHOUTAUTODOWNPAYMENT, Entity.LOAN, "/loans/"),

    UNDO_LOAN_APPLICATION_APPROVAL(Action.APPROVALUNDO, Entity.LOAN, "/loans/"),

    UNDO_LOAN_APPLICATION_DISBURSAL(Action.DISBURSALUNDO, Entity.LOAN, "/loans/"),

    UNDO_LAST_DISBURSAL_LOAN_APPLICATION(Action.DISBURSALLASTUNDO, Entity.LOAN, "/loans/"),

    ASSIGN_LOAN_OFFICER(Action.UPDATELOANOFFICER, Entity.LOAN, "/loans/"),

    UNASSIGN_LOAN_OFFICER(Action.REMOVELOANOFFICER, Entity.LOAN, "/loans/"),

    ASSIGN_LOAN_OFFICERS_IN_BULK(Action.BULKREASSIGN, Entity.LOAN, "/loans/loanreassignment"),

    ASSIGN_DELINQUENCY(Action.UPDATEDELINQUENCY, Entity.LOAN, "/loans/"),

    CREATE_CODE_VALUE(Action.CREATE, Entity.CODE_VALUE, "/codes/"),

    UPDATE_CODE_VALUE(Action.UPDATE, Entity.CODE_VALUE, "/codes/"),

    DELETE_CODE_VALUE(Action.DELETE, Entity.CODE_VALUE, "/codes/"),

    CREATE_GL_CLOSURE(Action.CREATE, Entity.GL_CLOSURE, "/glclosures/template"),

    UPDATE_GL_CLOSURE(Action.UPDATE, Entity.GL_CLOSURE, "/glclosures/"),

    DELETE_GL_CLOSURE(Action.DELETE, Entity.GL_CLOSURE, "/glclosures/"),

    EXCUTE_ACCRUAL_ACCOUNTING(Action.EXECUTE, Entity.PERIODIC_ACCRUAL_ACCOUNTING, "/accrualaccounting"),

    CREATE_GL_ACCOUNT(Action.CREATE, Entity.GL_ACCOUNT, "/glaccounts/template"),

    UPDATE_GL_ACCOUNT(Action.UPDATE, Entity.GL_ACCOUNT, "/glaccounts/"),

    DELETE_GL_ACCOUNT(Action.DELETE, Entity.GL_ACCOUNT, "/glaccounts/"),

    CREATE_JOURNAL_ENTRY(Action.CREATE, Entity.JOURNAL_ENTRY, "/journalentries/template"),

    REVERSE_JOURNAL_ENTRY(Action.REVERSE, Entity.JOURNAL_ENTRY, "/journalentries/"),

    UPDATE_RUNNING_BALANCE_FOR_JOURNAL_ENTRY(Action.UPDATERUNNINGBALANCE, Entity.JOURNAL_ENTRY, "/journalentries/update"),

    DEFINE_OPENING_BALANCE_FOR_JOURNAL_ENTRY(Action.DEFINEOPENINGBALANCE, Entity.JOURNAL_ENTRY, "/journalentries/update"),

    UPDATE_OPENING_BALANCE_FOR_JOURNAL_ENTRY(Action.UPDATEOPENINGBALANCE, Entity.JOURNAL_ENTRY, "/journalentries/update"),

    CREATE_SAVING_PRODUCT(Action.CREATE, Entity.SAVINGS_PRODUCT, "/savingsproducts/template"),

    UPDATE_SAVING_PRODUCT(Action.UPDATE, Entity.SAVINGS_PRODUCT, "/savingsproducts/"),

    DELETE_SAVING_PRODUCT(Action.DELETE, Entity.SAVINGS_PRODUCT, "/savingsproducts/"),

    CREATE_SAVINGS_ACCOUNT(Action.CREATE, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/template"),

    CREATE_GSIM_ACCOUNT(Action.CREATE, Entity.GSIM_ACCOUNT, "/gsimaccounts/template"),

    UPDATE_SAVINGS_ACCOUNT(Action.UPDATE, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    UPDATE_GSIM_ACCOUNT(Action.UPDATE, Entity.GSIM_ACCOUNT, "/gsimaccounts/"),

    DELETE_SAVINGS_ACCOUNT(Action.DELETE, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    REJECT_SAVINGS_ACCOUNT_APPLICATION(Action.REJECT, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    REJECT_GSIM_ACCOUNT_APPLICATION(Action.REJECT, Entity.GSIM_ACCOUNT, "/savingsaccounts/"),

    WITHDRAW_SAVINGS_ACCOUNT_APPLICATION(Action.WITHDRAW, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    APPROVE_SAVINGS_ACCOUNT_APPLICATION(Action.APPROVE, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    APPROVE_GSIM_ACCOUNT_APPLICATION(Action.APPROVE, Entity.GSIM_ACCOUNT, "/gsimsaccounts/"),

    UNDO_SAVINGS_ACCOUNT_APPLICATION(Action.APPROVALUNDO, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    UNDO_GSIM_APPLICATION_APPROVAL(Action.APPROVALUNDO, Entity.GSIM_ACCOUNT, "/savingsaccounts/"),

    SAVINGS_ACCOUNT_ACTIVATION(Action.ACTIVATE, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    GSIM_ACCOUNT_ACTIVATION(Action.ACTIVATE, Entity.GSIM_ACCOUNT, "/savingsaccounts/"),

    CLOSE_SAVINGS_ACCOUNT_APPLICATION(Action.CLOSE, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    CLOSE_GSIM_APPLICATION(Action.CLOSE, Entity.GSIM_ACCOUNT, "/savingsaccounts/"),

    CREATE_ACCOUNT_TRANSFER(Action.CREATE, Entity.ACCOUNT_TRANSFER, "/accounttransfers"),

    CREATE_STANDING_INSTRUCTION(Action.CREATE, Entity.STANDING_INSTRUCTION, "/standinginstructions"),

    UPDATE_STANDING_INSTRUCTION(Action.UPDATE, Entity.STANDING_INSTRUCTION, "/standinginstructions"),

    DELETE_STANDING_INSTRUCTION(Action.DELETE, Entity.STANDING_INSTRUCTION, "/standinginstructions"),

    SAVINGS_ACCOUNT_DEPOSIT(Action.DEPOSIT, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    GSIM_SAVINGS_ACCOUNT_DEPOSIT(Action.DEPOSIT, Entity.GSIM_ACCOUNT, "/savingsaccounts/"),

    SAVINGS_ACCOUNT_WITHDRAWAL(Action.WITHDRAWAL, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    UNDO_SAVINGS_ACCOUNT_TRANSACTION(Action.UNDOTRANSACTION, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    REVERSE_SAVINGS_ACCOUNT_TRANSACTION(Action.REVERSETRANSACTION, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    ADJUST_SAVINGS_ACCOUNT_TRANSACTION(Action.ADJUSTTRANSACTION, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    SAVINGS_ACCOUNT_INTEREST_CALCULATION(Action.CALCULATEINTEREST, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    SAVINGS_ACCOUNT_INTEREST_POSTING(Action.POSTINTEREST, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    SAVINGS_ACCOUNT_APPLY_ANNUAL_FEES(Action.APPLYANNUALFEE, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    CREATE_SAVINGS_ACCOUNT_CHARGE(Action.CREATE, Entity.SAVINGS_ACCOUNT_CHARGE, "/savingsaccounts/"),

    UPDATE_SAVINGS_ACCOUNT_CHARGE(Action.UPDATE, Entity.SAVINGS_ACCOUNT_CHARGE, "/savingsaccounts/"),

    WAIVE_SAVINGS_ACCOUNT_CHARGE(Action.WAIVE, Entity.SAVINGS_ACCOUNT_CHARGE, "/savingsaccounts/"),

    PAY_SAVINGS_ACCOUNT_CHARGE(Action.PAY, Entity.SAVINGS_ACCOUNT_CHARGE, "/savingsaccounts/"),

    INACTIVATE_SAVINGS_ACCOUNT_CHARGE(Action.INACTIVATE, Entity.SAVINGS_ACCOUNT_CHARGE, "/savingsaccounts/"),

    DELETE_SAVINGS_ACCOUNT_CHARGE(Action.DELETE, Entity.SAVINGS_ACCOUNT_CHARGE, "/savingsaccounts/"),

    CREATE_FIXED_DEPOSIT_PRODUCT(Action.CREATE, Entity.FIXED_DEPOSIT_PRODUCT, "/fixeddepositproducts/template"),

    UPDATE_FIXED_DEPOSIT_PRODUCT(Action.UPDATE, Entity.FIXED_DEPOSIT_PRODUCT, "/fixeddepositproducts/"),

    DELETE_FIXED_DEPOSIT_PRODUCT(Action.DELETE, Entity.FIXED_DEPOSIT_PRODUCT, "/fixeddepositproducts/"),

    CREATE_RECURRING_DEPOSIT_PRODUCT(Action.CREATE, Entity.RECURRING_DEPOSIT_PRODUCT, "/recurringdepositproducts/template"),

    UPDATE_RECURRING_DEPOSIT_PRODUCT(Action.UPDATE, Entity.RECURRING_DEPOSIT_PRODUCT, "/recurringdepositproducts/"),

    DELETE_RECURRING_DEPOSIT_PRODUCT(Action.DELETE, Entity.RECURRING_DEPOSIT_PRODUCT, "/recurringdepositproducts/"),

    CREATE_INTEREST_RATE_CHART(Action.CREATE, Entity.INTEREST_RATE_CHART, "/interestratechart/template"),

    UPDATE_INTEREST_RATE_CHART(Action.UPDATE, Entity.INTEREST_RATE_CHART, "/interestratechart/"),

    DELETE_INTEREST_RATE_CHART(Action.DELETE, Entity.INTEREST_RATE_CHART, "/interestratechart/"),

    CREATE_INTEREST_RATE_CHARTS_LAB(Action.CREATE, Entity.CHARTSLAB, "/interestratechart/"),

    UPDATE_INTEREST_RATE_CHARTS_LAB(Action.UPDATE, Entity.CHARTSLAB, "/interestratechart/"),

    DELETE_INTEREST_RATE_CHARTS_LAB(Action.DELETE, Entity.CHARTSLAB, "/interestratechart/"),

    CREATE_CALENDAR(Action.CREATE, Entity.CALENDAR, "/"),

    UPDATE_CALENDAR(Action.UPDATE, Entity.CALENDAR, "/"),

    DELETE_CALENDAR(Action.DELETE, Entity.CALENDAR, "/"),

    CREATE_NOTE(Action.CREATE, Entity.LOAN, "/"),

    UPDATE_NOTE(Action.UPDATE, Entity.LOAN, "/"),

    DELETE_NOTE(Action.DELETE, Entity.LOAN, "/"),

    CREATE_GROUP(Action.CREATE, Entity.GROUP, "/groups/template"),

    UPDATE_GROUP(Action.UPDATE, Entity.GROUP, "/groups/"),

    ACTIVATE_GROUP(Action.ACTIVATE, Entity.GROUP, "/groups/"),

    SAVE_GROUP_COLLECTION_SHEET(Action.SAVECOLLECTIONSHEET, Entity.GROUP, "/groups/"),

    SAVE_INDIVIDUAL_COLLECTION_SHEET(Action.SAVE, Entity.COLLECTIONSHEET, "/collectionsheet?command=saveCollectionSheet"),

    DELETE_GROUP(Action.DELETE, Entity.GROUP, "/groups/"),

    ASSOCIATE_CLIENTS_TO_GROUP(Action.ASSOCIATECLIENTS, Entity.GROUP, "/groups/"),

    DISASSOCIATE_CLIENTS_FROM_GROUP(Action.DISASSOCIATECLIENTS, Entity.GROUP, "/groups/"),

    TRANSFER_CLIENTS_BETWEEN_GROUPS(Action.TRANSFERCLIENTS, Entity.GROUP, "/groups/"),

    UNASSIGN_GROUP_STAFF(Action.UNASSIGNSTAFF, Entity.GROUP, "/groups/"),

    ASSIGN_GROUP_STAFF(Action.ASSIGNSTAFF, Entity.GROUP, "/groups/"),

    CLOSE_GROUP(Action.CLOSE, Entity.GROUP, "/groups/"),

    UPDATE_COLLATERAL(Action.UPDATE, Entity.COLLATERAL, "/loans/"),

    UPDATE_COLLATERAL_PRODUCT(Action.UPDATE, Entity.COLLATERAL_PRODUCT, "/collateral-management/"),

    UPDATE_CLIENT_COLLATERAL_PRODUCT(Action.UPDATE, Entity.CLIENT_COLLATERAL_PRODUCT, "/clients/"),

    DELETE_LOAN_COLLATERAL(Action.DELETE, Entity.LOAN_COLLATERAL_PRODUCT, "/loans/"),

    DELETE_COLLATERAL(Action.DELETE, Entity.COLLATERAL, "/loans/"),

    DELETE_COLLATERAL_PRODUCT(Action.DELETE, Entity.COLLATERAL_PRODUCT, "/collateral-management/"),

    DELETE_CLIENT_COLLATERAL_PRODUCT(Action.DELETE, Entity.CLIENT_COLLATERAL_PRODUCT, "/clients/"),

    ADD_CLIENT_COLLATERAL_PRODUCT(Action.CREATE, Entity.CLIENT_COLLATERAL_PRODUCT, "/clients/"),

    UPDATE_COLLECTIONSHEET(Action.UPDATE, Entity.COLLECTIONSHEET, "/groups/"),

    CREATE_CENTER(Action.CREATE, Entity.CENTER, "/centers/template"),

    UPDATE_CENTER(Action.UPDATE, Entity.CENTER, "/centers/"),

    DELETE_CENTER(Action.DELETE, Entity.CENTER, "/centers/"),

    ACTIVATE_CENTER(Action.ACTIVATE, Entity.CENTER, "/centers/"),

    SAVE_CENTER_COLLECTIONSHEET(Action.SAVECOLLECTIONSHEET, Entity.CENTER, "/centers/"),

    CLOSE_CENTER(Action.CLOSE, Entity.CENTER, "/centers/"),

    ASSOCIATE_GROUPS_TO_CENTER(Action.ASSOCIATEGROUPS, Entity.CENTER, "/groups/"),

    DISASSOCIATE_GROUPS_FROM_CENTER(Action.DISASSOCIATEGROUPS, Entity.CENTER, "/groups/"),

    CREATE_ACCOUNTING_RULE(Action.CREATE, Entity.ACCOUNTING_RULE, "/accountingrules/template"),

    UPDATE_ACCOUNTING_RULE(Action.UPDATE, Entity.ACCOUNTING_RULE, "/accountingrules/"),

    DELETE_ACCOUNTING_RULE(Action.DELETE, Entity.ACCOUNTING_RULE, "/accountingrules/"),

    UPDATE_TAXONOMY_MAPPING(Action.UPDATE, Entity.XBRLMAPPING, "/xbrlmapping"),

    CREATE_HOLIDAY(Action.CREATE, Entity.HOLIDAY, "/holidays/template"),

    ACTIVATE_HOLIDAY(Action.ACTIVATE, Entity.HOLIDAY, "/holidays/"),

    UPDATE_HOLIDAY(Action.UPDATE, Entity.HOLIDAY, "/holidays/"),

    DELETE_HOLIDAY(Action.DELETE, Entity.HOLIDAY, "/holidays/"),

    ASSIGN_ROLE(Action.ASSIGNROLE, Entity.GROUP, "/groups/"),

    UNASSIGN_ROLE(Action.UNASSIGNROLE, Entity.GROUP, "/groups/"),

    UNASSIGN_CLIENT_STAFF(Action.UNASSIGNSTAFF, Entity.CLIENT, "/clients/"),

    CREATE_TEMPLATE(Action.CREATE, Entity.TEMPLATE, "/templates"),

    UPDATE_TEMPLATE(Action.UPDATE, Entity.TEMPLATE, "/templates/"),

    DELETE_TEMPLATE(Action.DELETE, Entity.TEMPLATE, "/templates/"),

    ASSIGN_CLIENT_STAFF(Action.ASSIGNSTAFF, Entity.CLIENT, "/clients/"),

    UPDATE_CLIENT_SAVINGS_ACCOUNT(Action.UPDATESAVINGSACCOUNT, Entity.CLIENT, "/clients/"),

    CREATE_PRODUCTMIX(Action.CREATE, Entity.PRODUCTMIX, "/loanproducts/"),

    UPDATE_PRODUCT_MIX(Action.UPDATE, Entity.PRODUCTMIX, "/loanproducts/"),

    DELETE_PRODUCT_MIX(Action.DELETE, Entity.PRODUCTMIX, "/loanproducts/"),

    UPDATE_JOBDETAIL(Action.UPDATE, Entity.SCHEDULER, "/updateJobDetail/"),

    CREATE_MEETING(Action.CREATE, Entity.MEETING, "/"),

    UPDATE_MEETING(Action.UPDATE, Entity.MEETING, "/"),

    DELETE_MEETING(Action.DELETE, Entity.MEETING, "/"),

    SAVE_OR_UPDATE_ATTENDANCE(Action.SAVEORUPDATEATTENDANCE, Entity.MEETING, "/"),

    UPDATE_CACHE(Action.UPDATE, Entity.CACHE, "/cache"),

    CREATE_FIXED_DEPOSIT_ACCOUNT(Action.CREATE, Entity.FIXEDDEPOSIT_ACCOUNT, "/fixeddepositaccounts/template"),

    UPDATE_FIXED_DEPOSIT_ACCOUNT(Action.UPDATE, Entity.FIXEDDEPOSIT_ACCOUNT, "/fixeddepositaccounts/"),

    DELETE_FIXED_DEPOSIT_ACCOUNT(Action.DELETE, Entity.FIXEDDEPOSIT_ACCOUNT, "/fixeddepositaccounts/"),

    REJECT_FIXED_DEPOSIT_ACCOUNT_APPLICATION(Action.REJECT, Entity.FIXEDDEPOSIT_ACCOUNT, "/fixeddepositaccounts/"),

    WITHDRAW_FIXED_DEPOSIT_ACCOUNT_APPLICATION(Action.WITHDRAW, Entity.FIXEDDEPOSIT_ACCOUNT, "/fixeddepositaccounts/"),

    APPROVE_FIXED_DEPOSIT_ACCOUNT_APPLICATION(Action.APPROVE, Entity.FIXEDDEPOSIT_ACCOUNT, "/fixeddepositaccounts/"),

    UNDO_FIXED_DEPOSIT_ACCOUNT_APPLICATION(Action.APPROVALUNDO, Entity.FIXEDDEPOSIT_ACCOUNT, "/fixeddepositaccounts/"),

    FIXED_DEPOSIT_ACCOUNT_ACTIVATION(Action.ACTIVATE, Entity.FIXEDDEPOSIT_ACCOUNT, "/fixeddepositaccounts/"),

    CLOSE_FIXED_DEPOSIT_ACCOUNT(Action.CLOSE, Entity.FIXEDDEPOSIT_ACCOUNT, "/fixeddepositaccounts/"),

    PREMATURE_CLOSE_FIXED_DEPOSIT_ACCOUNT(Action.PREMATURECLOSE, Entity.FIXEDDEPOSIT_ACCOUNT, "/fixeddepositaccounts/"),

    FIXED_DEPOSIT_ACCOUNT_INTEREST_CALCULATION(Action.CALCULATEINTEREST, Entity.FIXEDDEPOSIT_ACCOUNT, "/fixeddepositaccounts/"),

    FIXED_DEPOSIT_ACCOUNT_INTEREST_POSTING(Action.POSTINTEREST, Entity.FIXEDDEPOSIT_ACCOUNT, "/fixeddepositaccounts/"),

    FIXED_DEPOSIT_ACCOUNT_DEPOSIT(Action.DEPOSIT, Entity.FIXEDDEPOSIT_ACCOUNT, "/fixeddepositaccounts/"),

    FIXED_DEPOSIT_ACCOUNT_WITHDRAWAL(Action.WITHDRAWAL, Entity.FIXEDDEPOSIT_ACCOUNT, "/fixeddepositaccounts/"),

    CREATE_RECURRING_DEPOSIT_ACCOUNT(Action.CREATE, Entity.RECURRINGDEPOSIT_ACCOUNT, "/recurringdepositaccounts/template"),

    UPDATE_RECURRING_DEPOSIT_ACCOUNT(Action.UPDATE, Entity.RECURRINGDEPOSIT_ACCOUNT, "/recurringdepositaccounts/"),

    RECURRING_ACCOUNT_DEPOSIT(Action.DEPOSIT, Entity.RECURRINGDEPOSIT_ACCOUNT, "/recurringdepositaccounts/"),

    RECURRING_ACCOUNT_WITHDRAWAL(Action.WITHDRAWAL, Entity.RECURRINGDEPOSIT_ACCOUNT, "/recurringdepositaccounts/"),

    ADJUST_RECURRING_ACCOUNT_TRANSACTION(Action.ADJUSTTRANSACTION, Entity.RECURRINGDEPOSIT_ACCOUNT, "/recurringdepositaccounts/"),

    UNDO_RECURRING_ACCOUNT_TRANSACTION(Action.UNDOTRANSACTION, Entity.RECURRINGDEPOSIT_ACCOUNT, "/recurringdepositaccounts/"),

    DELETE_RECURRING_DEPOSIT_ACCOUNT(Action.DELETE, Entity.RECURRINGDEPOSIT_ACCOUNT, "/recurringdepositaccounts/"),

    REJECT_RECURRING_DEPOSIT_ACCOUNT_APPLICATION(Action.REJECT, Entity.RECURRINGDEPOSIT_ACCOUNT, "/recurringdepositaccounts/"),

    WITHDRAW_RECURRING_DEPOSIT_ACCOUNT_APPLICATION(Action.WITHDRAW, Entity.RECURRINGDEPOSIT_ACCOUNT, "/recurringdepositaccounts/"),

    APPROVE_RECURRING_DEPOSIT_ACCOUNT_APPLICATION(Action.APPROVE, Entity.RECURRINGDEPOSIT_ACCOUNT, "/recurringdepositaccounts/"),

    UNDO_RECURRING_DEPOSIT_ACCOUNT_APPLICATION(Action.APPROVALUNDO, Entity.RECURRINGDEPOSIT_ACCOUNT, "/recurringdepositaccounts/"),

    RECURRING_DEPOSIT_ACCOUNT_ACTIVATION(Action.ACTIVATE, Entity.RECURRINGDEPOSIT_ACCOUNT, "/recurringdepositaccounts/"),

    CLOSE_RECURRING_DEPOSIT_ACCOUNT(Action.CLOSE, Entity.RECURRINGDEPOSIT_ACCOUNT, "/recurringdepositaccounts/"),

    UPDATE_DEPOSIT_AMOUNT_FOR_RECURRING_DEPOSIT_ACCOUNT(Action.CREATE, Entity.RECURRINGDEPOSIT_ACCOUNT, "/recurringdepositaccounts/"),

    PREMATURE_CLOSE_RECURRING_DEPOSIT_ACCOUNT(Action.PREMATURECLOSE, Entity.RECURRINGDEPOSIT_ACCOUNT, "/recurringdepositaccounts/"),

    RECURRING_DEPOSIT_ACCOUNT_INTEREST_CALCULATION(Action.CALCULATEINTEREST, Entity.RECURRINGDEPOSIT_ACCOUNT, "/recurringdepositaccounts/"),

    RECURRING_DEPOSIT_ACCOUNT_INTEREST_POSTING(Action.POSTINTEREST, Entity.RECURRINGDEPOSIT_ACCOUNT, "/recurringdepositaccounts/"),

    CREATE_OFFICE_TO_GL_ACCOUNT_MAPPING(Action.CREATE, Entity.FINANCIALACTIVITY_ACCOUNT, "/organizationglaccounts/template"),

    UPDATE_OFFICE_TO_GL_ACCOUNT_MAPPING(Action.UPDATE, Entity.FINANCIALACTIVITY_ACCOUNT, "/organizationglaccounts/"),

    DELETE_OFFICE_TO_GL_ACCOUNT_MAPPING(Action.DELETE, Entity.FINANCIALACTIVITY_ACCOUNT, "/organizationglaccounts/"),

    REGISTER_DB_DATATABLE(Action.REGISTER, Entity.DATATABLE, "/datatables/register/"),

    REGISTER_SURVEY(Action.REGISTER, Entity.SURVEY, "/survey/register/"),

    FULLFIL_SURVEY(Action.CREATE, Entity.SURVEY, "/survey/"),

    UPDATE_LIKELIHOOD(Action.UPDATE, Entity.LIKELIHOOD, "/likelihood/"),

    ASSIGN_SAVINGS_OFFICER(Action.UPDATESAVINGSOFFICER, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    UNASSIGN_SAVINGS_OFFICER(Action.REMOVESAVINGSOFFICER, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    SAVINGS_INTEREST_POSTING_AS_ON_DATE(Action.POSTINTERESTASONDATE, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    CREATE_LOAN_RESCHEDULE_REQUEST(Action.CREATE, Entity.LOAN, "/rescheduleloans"),

    APPROVE_LOAN_RESCHEDULE_REQUEST(Action.APPROVE, Entity.LOAN, "/rescheduleloans/"),

    REJECT_LOAN_RESCHEDULE_REQUEST(Action.REJECT, Entity.LOAN, "/rescheduleloans/"),

    UPDATE_ACCOUNT_NUMBER_FORMAT(Action.UPDATE, Entity.LOAN, "/"),

    DELETE_ACCOUNT_NUMBER_FORMAT(Action.DELETE, Entity.LOAN, "/"),

    REFUND_BY_TRANSFER(Action.REFUNDBYTRANSFER, Entity.ACCOUNT_TRANSFER, "/refundByTransfer"),

    CREATE_TELLER(Action.CREATE, Entity.TELLER, "/tellers/templates"),

    UPDATE_TELLER(Action.UPDATE, Entity.TELLER, "/tellers/"),

    DELETE_TELLER(Action.DELETE, Entity.TELLER, "/tellers/"),

    ALLOCATE_TELLER(Action.ALLOCATECASHIER, Entity.TELLER, "/tellers/"),

    UPDATE_ALLOCATION_TELLER(Action.UPDATECASHIERALLOCATION, Entity.TELLER, "/tellers/"),

    DELETE_ALLOCATION_TELLER(Action.DELETECASHIERALLOCATION, Entity.TELLER, "/tellers/"),

    ALLOCATE_CASH_TO_CASHIER(Action.ALLOCATECASHTOCASHIER, Entity.TELLER, "/tellers/"),

    SETTLE_CASH_FROM_CASHIER(Action.SETTLECASHFROMCASHIER, Entity.TELLER, "/tellers/"),

    DELETE_ROLE(Action.DELETE, Entity.ROLE, "/roles/"),

    DISABLE_ROLE(Action.DISABLE, Entity.ROLE, "/roles/"),

    ENABLE_ROLE(Action.ENABLE, Entity.ROLE, "/roles/"),

    CREATE_MAP(Action.CREATE, Entity.ENTITY_MAPPING, "/entitytoentitymapping/"),

    UPDATE_MAP(Action.UPDATE, Entity.ENTITY_MAPPING, "/entitytoentitymapping"),

    DELETE_MAP(Action.DELETE, Entity.ENTITY_MAPPING, "/entitytoentitymapping/"),

    UPDATE_WORKING_DAYS(Action.UPDATE, Entity.WORKINGDAYS, "/workingdays/"),

    UPDATE_PASSWORD_PREFERENCES(Action.UPDATE, Entity.WORKINGDAYS, "/"),

    CREATE_PAYMENT_TYPE(Action.CREATE, Entity.WORKINGDAYS, "/"),

    UPDATE_PAYMENT_TYPE(Action.UPDATE, Entity.WORKINGDAYS, "/"),

    DELETE_PAYMENT_TYPE(Action.DELETE, Entity.PAYMENT_TYPE, "/"),

    UPDATE_EXTERNAL_SERVICE_PROPERTIES(Action.UPDATE, Entity.EXTERNAL_SERVICES, "/externalservices/"),

    CREATE_CLIENT_CHARGE(Action.UPDATE, Entity.EXTERNAL_SERVICES, "/clients/"),

    DELETE_CLIENT_CHARGE(Action.UPDATE, Entity.EXTERNAL_SERVICES, "/clients/"),

    WAIVE_CLIENT_CHARGE(Action.UPDATE, Entity.EXTERNAL_SERVICES, "/clients/"),

    PAY_CLIENT_CHARGE(Action.UPDATE, Entity.EXTERNAL_SERVICES, "/clients/"),

    INACTIVATE_CLIENT_CHARGE(Action.INACTIVATE, Entity.EXTERNAL_SERVICES, "/clients/"),

    UNDO_CLIENT_TRANSACTION(Action.INACTIVATE, Entity.EXTERNAL_SERVICES, "/clients/"),

    CREATE_PROVISIONING_CATEGORY(Action.CREATE, Entity.PROVISION_CATEGORY, "/provisioningcategory"),

    UPDATE_PROVISIONING_CATEGORY(Action.UPDATE, Entity.PROVISION_CATEGORY, "/provisioningcategory/"),

    DELETE_PROVISIONING_CATEGORY(Action.DELETE, Entity.PROVISION_CATEGORY, "/provisioningcategory/"),

    CREATE_PROVISIONING_CRITERIA(Action.CREATE, Entity.PROVISION_CRITERIA, "/provisioningcriteria"),

    UPDATE_PROVISIONING_CRITERIA(Action.UPDATE, Entity.PROVISION_CRITERIA, "/provisioningcriteria/"),

    DELETE_PROVISIONING_CRITERIA(Action.DELETE, Entity.PROVISION_CRITERIA, "/provisioningcriteria/"),

    CREATE_PROVISIONING_ENTRIES(Action.CREATE, Entity.PROVISION_ENTRIES, "/provisioningentries"),

    CREATE_PROVISIONING_JOURNAL_ENTRIES(Action.CREATE, Entity.PROVISION_JOURNAL_ENTRIES, "/provisioningentries/"),

    RECREATE_PROVISIONING_ENTRIES(Action.RECREATE, Entity.PROVISION_ENTRIES, "/provisioningentries/"),

    CREATE_FLOATING_RATE(Action.CREATE, Entity.FLOATING_RATE, "/floatingrates"),

    UPDATE_FLOATING_RATE(Action.UPDATE, Entity.FLOATING_RATE, "/floatingrates/"),

    CREATE_SCHEDULE_EXCEPTIONS(Action.CREATESCHEDULEEXCEPTIONS, Entity.LOAN, "/loans/"),

    DELETE_SCHEDULE_EXCEPTIONS(Action.DELETESCHEDULEEXCEPTIONS, Entity.LOAN, "/loans/"),

    CREATE_PRODUCT(Action.CREATE, Entity.LOAN, "/products/"),

    UPDATE_PRODUCT(Action.UPDATE, Entity.LOAN, "/products/"),

    CREATE_ACCOUNT(Action.CREATE, Entity.LOAN, "/accounts/"),

    UPDATE_ACCOUNT(Action.UPDATE, Entity.LOAN, "/accounts/"),

    APPROVE_SHARE_PRODUCT_DIVIDEND_PAYOUT_COMMAND(Action.APPROVE_DIVIDEND, Entity.SHARE_PRODUCT, "/shareproduct/"),

    DELETE_SHARE_PRODUCT_DIVIDEND_PAYOUT_COMMAND(Action.DELETE_DIVIDEND, Entity.SHARE_PRODUCT, "/shareproduct/"),

    CREATE_TAX_COMPONENT(Action.CREATE, Entity.TAX_COMPONENT, "/taxes/component"),

    UPDATE_TAX_COMPONENT(Action.UPDATE, Entity.TAX_COMPONENT, "/taxes/component/"),

    CREATE_TAX_GROUP(Action.CREATE, Entity.TAXGROUP, "/taxes/group"),

    UPDATE_TAX_GROUP(Action.UPDATE, Entity.TAXGROUP, "/taxes/group/"),

    UPDATE_WITHHOLD_TAX(Action.UPDATEWITHHOLDTAX, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    CREATE_ENTITY_DATATABLE_CHECKS(Action.CREATE, Entity.ENTITY_DATATABLE_CHECK, "/entityDatatableChecks/"),

    DELETE_ENTITY_DATA_TABLE_CHECKS(Action.DELETE, Entity.ENTITY_DATATABLE_CHECK, "/entityDatatableChecks/"),

    ADD_SELF_SERVICE_BENEFICIARY_TPT(Action.CREATE, Entity.SS_BENEFICIARY_TPT, "/self/beneficiaries/tpt"),

    UPDATE_SELF_SERVICE_BENEFICIARY_TPT(Action.UPDATE, Entity.SS_BENEFICIARY_TPT, "/self/beneficiaries/tpt/"),

    DELETE_SELF_SERVICE_BENEFICIARY_TPT(Action.DELETE, Entity.SS_BENEFICIARY_TPT, "/self/beneficiaries/tpt/"),

    CREATE_REPORT_MAILING_JOB(Action.CREATE, Entity.SS_BENEFICIARY_TPT, "/reportmailingjobs"),

    UPDATE_REPORT_MAILING_JOB(Action.UPDATE, Entity.SS_BENEFICIARY_TPT, "/reportmailingjobs/"),

    DELETE_REPORT_MAILING_JOB(Action.DELETE, Entity.SS_BENEFICIARY_TPT, "/reportmailingjobs/"),

    CREATE_SMS_CAMPAIGN(Action.CREATE, Entity.SMS_CAMPAIGN, "/smscampaigns"),

    UPDATE_SMS_CAMPAIGN(Action.UPDATE, Entity.SMS_CAMPAIGN, "/smscampaigns/"),

    ACTIVATE_SMS_CAMPAIGN(Action.ACTIVATE, Entity.SMS_CAMPAIGN, "/smscampaigns/"),

    CLOSE_SMS_CAMPAIGN(Action.CLOSE, Entity.SMS_CAMPAIGN, "/smscampaigns/"),

    REACTIVATE_SMS_CAMPAIGN(Action.REACTIVATE, Entity.SMS_CAMPAIGN, "/smscampaigns/"),

    DELETE_SMS_CAMPAIGN(Action.DELETE, Entity.SMS_CAMPAIGN, "/smscampaigns/"),

    HOLD_AMOUNT(Action.HOLDAMOUNT, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    RELEASE_AMOUNT(Action.RELEASEAMOUNT, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    BLOCK_DEBITS_FROM_SAVINGS_ACCOUNT(Action.BLOCKDEBIT, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    UNBLOCK_DEBITS_FROM_SAVINGS_ACCOUNT(Action.UNBLOCKDEBIT, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    BLOCK_CREDITS_TO_SAVINGS_ACCOUNT(Action.BLOCKCREDIT, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    UNBLOCK_CREDITS_TO_SAVINGS_ACCOUNT(Action.UNBLOCKCREDIT, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    BLOCK_SAVINGS_ACCOUNT(Action.BLOCK, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    UNBLOCK_SAVINGS_ACCOUNT(Action.UNBLOCK, Entity.SAVINGS_ACCOUNT, "/savingsaccounts/"),

    DISABLE_ADHOC(Action.DISABLE, Entity.ADHOC, "/adhoc/"),

    ENABLE_ADHOC(Action.ENABLE, Entity.ADHOC, "/adhoc/"),

    CREATE_ADHOC(Action.CREATE, Entity.ADHOC, "/adhocquery/template"),

    UPDATE_ADHOC(Action.UPDATE, Entity.ADHOC, "/adhocquery/"),

    DELETE_ADHOC(Action.DELETE, Entity.ADHOC, "/adhocquery/"),

    CREATE_EMAIL(Action.CREATE, Entity.EMAIL, "/emailcampaigns/template"),

    UPDATE_EMAIL(Action.UPDATE, Entity.EMAIL, "/emailcampaigns/"),

    DELETE_EMAIL(Action.DELETE, Entity.EMAIL, "/emailcampaigns/"),

    CREATE_EMAIL_CAMPAIGN(Action.CREATE, Entity.EMAIL_CAMPAIGN, "/emailcampaigns/campaign"),

    UPDATE_EMAIL_CAMPAIGN(Action.UPDATE, Entity.EMAIL_CAMPAIGN, "/emailcampaigns/"),

    DELETE_EMAIL_CAMPAIGN(Action.DELETE, Entity.EMAIL_CAMPAIGN, "/emailcampaigns/"),

    ACTIVATE_EMAIL_CAMPAIGN(Action.ACTIVATE, Entity.EMAIL_CAMPAIGN, "/emailcampaigns/"),

    CLOSE_EMAIL_CAMPAIGN(Action.CLOSE, Entity.EMAIL_CAMPAIGN, "/emailcampaigns/"),

    REACTIVATE_EMAIL_CAMPAIGN(Action.REACTIVATE, Entity.EMAIL_CAMPAIGN, "/emailcampaigns/"),

    UPDATE_EMAIL_CONFIGURATION(Action.UPDATE, Entity.EMAIL_CONFIGURATION, "/emailcampaigns/configuration/"),

    INVALIDATE_TWO_FACTOR_ACCESS_TOKEN(Action.INVALIDATE, Entity.TWOFACTOR_ACCESSTOKEN, "/twofactor/invalidate"),

    UPDATE_TWO_FACTOR_CONFIGURATION(Action.UPDATE, Entity.TWOFACTOR_CONFIGURATION, "/twofactor/configure"),

    LINK_ACCOUNTS_TO_POCKET(Action.UPDATE, Entity.TWOFACTOR_CONFIGURATION, "/self/pocket?command="),

    DELINK_ACCOUNTS_FROM_POCKET(Action.UPDATE, Entity.TWOFACTOR_CONFIGURATION, "/self/pocket?command="),

    CREATE_RATE(Action.CREATE, Entity.RATE, "/rates/template"),

    UPDATE_RATE(Action.UPDATE, Entity.RATE, "/rates/"),

    UPDATE_BUSINESS_DATE(Action.UPDATE, Entity.BUSINESS_DATE, "/businessdate"),

    CREATE_DELINQUENCY_RANGE(Action.CREATE, Entity.DELINQUENCY_RANGE, "/delinquency/range"),

    UPDATE_DELINQUENCY_RANGE(Action.UPDATE, Entity.DELINQUENCY_RANGE, "/delinquency/range"),

    DELETE_DELINQUENCY_RANGE(Action.DELETE, Entity.DELINQUENCY_RANGE, "/delinquency/range"),

    CREATE_DELINQUENCY_BUCKET(Action.CREATE, Entity.DELINQUENCY_BUCKET, "/delinquency/bucket"),

    UPDATE_DELINQUENCY_BUCKET(Action.UPDATE, Entity.DELINQUENCY_BUCKET, "/delinquency/bucket"),

    DELETE_DELINQUENCY_BUCKET(Action.DELETE, Entity.DELINQUENCY_BUCKET, "/delinquency/bucket"),

    UPDATE_BUSINESS_STEP_CONFIG(Action.UPDATE, Entity.BATCH_BUSINESS_STEP, "/jobs/"),

    EXECUTE_INLINE_JOB(Action.EXECUTE, Entity.INLINE_JOB, "/jobs/"),

    UPDATE_EXTERNAL_EVENT_CONFIGURATIONS(Action.UPDATE, Entity.EXTERNAL_EVENT_CONFIGURATION, "/externaleventconfiguration"),

    CHARGEOFF(Action.CHARGEOFF, Entity.LOAN, "/loans/"),

    UNDO_CHARGEOFF(Action.UNDOCHARGEOFF, Entity.LOAN, "/loans/"),

    CREATE_EXTERNAL_ASSET_OWNER_LOAN_PRODUCT_ATTRIBUTE(Action.CREATE, Entity.EXTERNAL_ASSET_OWNER_LOAN_PRODUCT_ATTRIBUTE,
            "/external-asset-owners/loan-product/"),

    UPDATE_EXTERNAL_ASSET_OWNER_LOAN_PRODUCT_ATTRIBUTE(Action.UPDATE, Entity.EXTERNAL_ASSET_OWNER_LOAN_PRODUCT_ATTRIBUTE,
            "/external-asset-owners/loan-product/"),

    INTERMEDIARY_SALE_LOAN_TO_EXTERNAL_ASSET_OWNER(Action.INTERMEDIARYSALE, Entity.LOAN, "/external-asset-owners/transfers/loans/"),

    SALE_LOAN_TO_EXTERNAL_ASSET_OWNER(Action.SALE, Entity.LOAN, "/external-asset-owners/transfers/loans/"),

    BUYBACK_LOAN_TO_EXTERNAL_ASSET_OWNER(Action.BUYBACK, Entity.LOAN, "/external-asset-owners/transfers/loans/"),

    CANCEL_TRANSACTION_BY_ID_TO_EXTERNAL_ASSET_OWNER(Action.CANCEL, Entity.ASSET_OWNER_TRANSACTION, "/external-asset-owners/transfers/"),

    DOWN_PAYMENT(Action.DOWNPAYMENT, Entity.LOAN, "/loans/"),

    REAGE(Action.REAGE, Entity.LOAN, "/loans/"),

    UNDO_REAGE(Action.UNDO_REAGE, Entity.LOAN, "/loans/"),

    REAMORTIZE(Action.REAMORTIZE, Entity.LOAN, "/loans/"),

    UNDO_REAMORTIZE(Action.UNDO_REAMORTIZE, Entity.LOAN, "/loans/"),

    CREATE_DELINQUENCY_ACTION(Action.CREATE, Entity.DELINQUENCY_ACTION, "/loans/"),

    CREATE_INTEREST_PAUSE(Action.CREATE, Entity.INTEREST_PAUSE, "/v1/loans/"),

    CREATE_INTEREST_PAUSE_BY_EXTERNAL_ID(Action.CREATE, Entity.INTEREST_PAUSE, "/v1/loans/external-id/"),

    DELETE_INTEREST_PAUSE(Action.DELETE, Entity.INTEREST_PAUSE, "/v1/loans/"),

    UPDATE_INTEREST_PAUSE(Action.UPDATE, Entity.INTEREST_PAUSE, "/v1/loans/"),

    ADD_CAPITALIZED_INCOME(Action.CAPITALIZEDINCOME, Entity.LOAN, "/loans/"),

    CAPITALIZED_INCOME_ADJUSTMENT(Action.CAPITALIZEDINCOMEADJUSTMENT, Entity.LOAN, "/loans/"),

    BUYDOWN_FEE_ADJUSTMENT(Action.BUYDOWNFEEADJUSTMENT, Entity.LOAN, "/loans/"),

    APPLY_CONTRACT_TERMINATION(Action.CONTRACT_TERMINATION, Entity.LOAN, "/loans/"),

    UNDO_CONTRACT_TERMINATION(Action.CONTRACT_TERMINATION_UNDO, Entity.LOAN, "/loans/"),

    MAKE_LOAN_BUYDOWN_FEE(Action.BUYDOWNFEE, Entity.LOAN, "/loans/"),

    UPDATE_LOAN_APPROVED_AMOUNT(Action.UPDATE_APPROVED_AMOUNT, Entity.LOAN, "/loans/"),

    MANUAL_INTEREST_REFUND(Action.MANUAL_INTEREST_REFUND_TRANSACTION, Entity.LOAN, "/loans/"),

    UPDATE_LOAN_AVAILABLE_DISBURSEMENT_AMOUNT(Action.UPDATE, Entity.LOAN_AVAILABLE_DISBURSEMENT_AMOUNT, "/loans/");

    ;

    private final Action actionName;
    private final Entity entityName;
    private final String href;

    @RequiredArgsConstructor
    private enum Action {

        CREATE("CREATE"), UPDATE("UPDATE"), DELETE("DELETE"), GET("GET"), SAVE("SAVE"), PERMISSIONS("PERMISSIONS"), CHANGEPWD(
                "CHANGEPWD"), RECOVERGUARANTEES("RECOVERGUARANTEES"), ACTIVATE("ACTIVATE"), CLOSE("CLOSE"), REJECT("REJECT"), WITHDRAW(
                        "WITHDRAW"), REACTIVATE("REACTIVATE"), PROPOSETRANSFER("PROPOSETRANSFER"), PROPOSEANDACCEPTTRANSFER(
                                "PROPOSEANDACCEPTTRANSFER"), WITHDRAWTRANSFER("WITHDRAWTRANSFER"), ACCEPTTRANSFER(
                                        "ACCEPTTRANSFER"), REJECTTRANSFER("REJECTTRANSFER"), UNDOREJECT("UNDOREJECT"), UNDOWITHDRAWAL(
                                                "UNDOWITHDRAWAL"), WAIVE("WAIVE"), PAY("PAY"), ADJUSTMENT("ADJUSTMENT"), DEACTIVATEOVERDUE(
                                                        "DEACTIVATEOVERDUE"), REPAYMENT("REPAYMENT"), MERCHANTISSUEDREFUND(
                                                                "MERCHANTISSUEDREFUND"), PAYOUTREFUND("PAYOUTREFUND"), GOODWILLCREDIT(
                                                                        "GOODWILLCREDIT"), INTERESTPAYMENTWAIVER(
                                                                                "INTERESTPAYMENTWAIVER"), CHARGEREFUND(
                                                                                        "CHARGEREFUND"), RECOVERYPAYMENT(
                                                                                                "RECOVERYPAYMENT"), WAIVEINTERESTPORTION(
                                                                                                        "WAIVEINTERESTPORTION"), WRITEOFF(
                                                                                                                "WRITEOFF"), UNDOWRITEOFF(
                                                                                                                        "UNDOWRITEOFF"), CLOSEASRESCHEDULED(
                                                                                                                                "CLOSEASRESCHEDULED"), ADJUST(
                                                                                                                                        "ADJUST"), REFUNDBYCASH(
                                                                                                                                                "REFUNDBYCASH"), CHARGEBACK(
                                                                                                                                                        "CHARGEBACK"), FORECLOSURE(
                                                                                                                                                                "FORECLOSURE"), CREDITBALANCEREFUND(
                                                                                                                                                                        "CREDITBALANCEREFUND"), UNDO(
                                                                                                                                                                                "UNDO"), BOUNCE(
                                                                                                                                                                                        "BOUNCE"), SETFRAUD(
                                                                                                                                                                                                "SETFRAUD"), APPROVE(
                                                                                                                                                                                                        "APPROVE"), DISBURSE(
                                                                                                                                                                                                                "DISBURSE"), UNDODISBURSAL(
                                                                                                                                                                                                                        "UNDODISBURSAL"), UNDOAPPROVAL(
                                                                                                                                                                                                                                "UNDOAPPROVAL"), DISBURSETOSAVINGS(
                                                                                                                                                                                                                                        "DISBURSETOSAVINGS"), DISBURSEWITHOUTAUTODOWNPAYMENT(
                                                                                                                                                                                                                                                "DISBURSEWITHOUTAUTODOWNPAYMENT"), APPROVALUNDO(
                                                                                                                                                                                                                                                        "APPROVALUNDO"), DISBURSALUNDO(
                                                                                                                                                                                                                                                                "DISBURSALUNDO"), DISBURSALLASTUNDO(
                                                                                                                                                                                                                                                                        "DISBURSALLASTUNDO"), UPDATELOANOFFICER(
                                                                                                                                                                                                                                                                                "UPDATELOANOFFICER"), REMOVELOANOFFICER(
                                                                                                                                                                                                                                                                                        "REMOVELOANOFFICER"), BULKREASSIGN(
                                                                                                                                                                                                                                                                                                "BULKREASSIGN"), UPDATEDELINQUENCY(
                                                                                                                                                                                                                                                                                                        "UPDATEDELINQUENCY"), EXECUTE(
                                                                                                                                                                                                                                                                                                                "EXECUTE"), REVERSE(
                                                                                                                                                                                                                                                                                                                        "REVERSE"), UPDATERUNNINGBALANCE(
                                                                                                                                                                                                                                                                                                                                "UPDATERUNNINGBALANCE"), DEFINEOPENINGBALANCE(
                                                                                                                                                                                                                                                                                                                                        "DEFINEOPENINGBALANCE"), UPDATEOPENINGBALANCE(
                                                                                                                                                                                                                                                                                                                                                "UPDATEOPENINGBALANCE"), DEPOSIT(
                                                                                                                                                                                                                                                                                                                                                        "DEPOSIT"), WITHDRAWAL(
                                                                                                                                                                                                                                                                                                                                                                "WITHDRAWAL"), UNDOTRANSACTION(
                                                                                                                                                                                                                                                                                                                                                                        "UNDOTRANSACTION"), REVERSETRANSACTION(
                                                                                                                                                                                                                                                                                                                                                                                "REVERSETRANSACTION"), ADJUSTTRANSACTION(
                                                                                                                                                                                                                                                                                                                                                                                        "ADJUSTTRANSACTION"), CALCULATEINTEREST(
                                                                                                                                                                                                                                                                                                                                                                                                "CALCULATEINTEREST"), POSTINTEREST(
                                                                                                                                                                                                                                                                                                                                                                                                        "POSTINTEREST"), APPLYANNUALFEE(
                                                                                                                                                                                                                                                                                                                                                                                                                "APPLYANNUALFEE"), INACTIVATE(
                                                                                                                                                                                                                                                                                                                                                                                                                        "INACTIVATE"), SAVECOLLECTIONSHEET(
                                                                                                                                                                                                                                                                                                                                                                                                                                "SAVECOLLECTIONSHEET"), ASSOCIATECLIENTS(
                                                                                                                                                                                                                                                                                                                                                                                                                                        "ASSOCIATECLIENTS"), DISASSOCIATECLIENTS(
                                                                                                                                                                                                                                                                                                                                                                                                                                                "DISASSOCIATECLIENTS"), TRANSFERCLIENTS(
                                                                                                                                                                                                                                                                                                                                                                                                                                                        "TRANSFERCLIENTS"), UNASSIGNSTAFF(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                "UNASSIGNSTAFF"), ASSIGNSTAFF(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "ASSIGNSTAFF"), ASSOCIATEGROUPS(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "ASSOCIATEGROUPS"), DISASSOCIATEGROUPS(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "DISASSOCIATEGROUPS"), ASSIGNROLE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "ASSIGNROLE"), UNASSIGNROLE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "UNASSIGNROLE"), UPDATEROLE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "UPDATEROLE"), UPDATESAVINGSACCOUNT(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "UPDATESAVINGSACCOUNT"), SAVEORUPDATEATTENDANCE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "SAVEORUPDATEATTENDANCE"), PREMATURECLOSE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "PREMATURECLOSE"), RECURRINGDEPOSITACCOUNT(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "RECURRINGDEPOSITACCOUNT"), REGISTER(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "REGISTER"), UPDATESAVINGSOFFICER(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "UPDATESAVINGSOFFICER"), REMOVESAVINGSOFFICER(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "REMOVESAVINGSOFFICER"), POSTINTERESTASONDATE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "POSTINTERESTASONDATE"), REFUNDBYTRANSFER(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "REFUNDBYTRANSFER"), ALLOCATECASHIER(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "ALLOCATECASHIER"), UPDATECASHIERALLOCATION(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "UPDATECASHIERALLOCATION"), DELETECASHIERALLOCATION(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "DELETECASHIERALLOCATION"), ALLOCATECASHTOCASHIER(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "ALLOCATECASHTOCASHIER"), SETTLECASHFROMCASHIER(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "SETTLECASHFROMCASHIER"), ENABLE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "ENABLE"), RECREATE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "RECREATE"), CREATESCHEDULEEXCEPTIONS(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "CREATESCHEDULEEXCEPTIONS"), DELETESCHEDULEEXCEPTIONS(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "DELETESCHEDULEEXCEPTIONS"), SHAREPRODUCT(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "SHAREPRODUCT"), UPDATEWITHHOLDTAX(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "UPDATEWITHHOLDTAX"), HOLDAMOUNT(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "HOLDAMOUNT"), RELEASEAMOUNT(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "RELEASEAMOUNT"), BLOCKDEBIT(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "BLOCKDEBIT"), UNBLOCKDEBIT(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "UNBLOCKDEBIT"), BLOCKCREDIT(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "BLOCKCREDIT"), UNBLOCKCREDIT(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "UNBLOCKCREDIT"), BLOCK(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "BLOCK"), UNBLOCK(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "UNBLOCK"), DISABLE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "DISABLE"), INVALIDATE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "INVALIDATE"), CHARGEOFF(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "CHARGEOFF"), UNDOCHARGEOFF(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "UNDOCHARGEOFF"), INTERMEDIARYSALE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "INTERMEDIARYSALE"), SALE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "SALE"), BUYBACK(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "BUYBACK"), CANCEL(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "CANCEL"), DOWNPAYMENT(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "DOWNPAYMENT"), REAGE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "REAGE"), UNDO_REAGE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "UNDO_REAGE"), REAMORTIZE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "REAMORTIZE"), UNDO_REAMORTIZE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "UNDO_REAMORTIZE"), CAPITALIZEDINCOME(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "CAPITALIZEDINCOME"), CAPITALIZEDINCOMEADJUSTMENT(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "CAPITALIZEDINCOMEADJUSTMENT"), BUYDOWNFEEADJUSTMENT(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "BUYDOWNFEEADJUSTMENT"), CONTRACT_TERMINATION(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "CONTRACT_TERMINATION"), CONTRACT_TERMINATION_UNDO(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "CONTRACT_TERMINATION_UNDO"), BUYDOWNFEE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "BUYDOWNFEE"), UPDATE_APPROVED_AMOUNT(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "UPDATE_APPROVED_AMOUNT"), MANUAL_INTEREST_REFUND_TRANSACTION(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "MANUAL_INTEREST_REFUND_TRANSACTION"), APPROVE_DIVIDEND(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "APPROVE_DIVIDEND"), DELETE_DIVIDEND(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "DELETE_DIVIDEND");

        @Getter
        private final String value;
    }

    @RequiredArgsConstructor
    private enum Entity {

        ORGANISATION_CREDIT_BUREAU("ORGANISATIONCREDITBUREAU"), CREDIT_BUREAU_LOANPRODUCT_MAPPING(
                "CREDITBUREAU_LOANPRODUCT_MAPPING"), CREDIT_REPORT("CREDITREPORT"), CREDIT_BUREAU_CONFIGURATION(
                        "CREDITBUREAU_CONFIGURATION"), ADDRESS("ADDRESS"), FAMILY_MEMBERS("FAMILYMEMBERS"), CONFIGURATION(
                                "CONFIGURATION"), PERMISSION("PERMISSION"), ROLE("ROLE"), USER(
                                        "USER"), OFFICE("OFFICE"), OFFICE_TRANSACTION("OFFICETRANSACTION"), STAFF("STAFF"), GUARANTOR(
                                                "GUARANTOR"), LOAN("LOAN"), FUND("FUND"), REPORT("REPORT"), CURRENCY("CURRENCY"), SMS(
                                                        "SMS"), CODE("CODE"), HOOK("HOOK"), CHARGE("CHARGE"), COLLATERAL_PRODUCT(
                                                                "COLLATERAL_PRODUCT"), LOAN_PRODUCT("LOANPRODUCT"), CLIENT_IDENTIFIER(
                                                                        "CLIENTIDENTIFIER"), CLIENT("CLIENT"), DATATABLE(
                                                                                "DATATABLE"), LOANCHARGE("LOANCHARGE"), WAIVECHARGE(
                                                                                        "WAIVECHARGE"), REPAYMENT_WITH_POSTDATEDCHECKS(
                                                                                                "REPAYMENT_WITH_POSTDATEDCHECKS"), DISBURSEMENT_DETAIL(
                                                                                                        "DISBURSEMENTDETAIL"), GLIM_LOAN(
                                                                                                                "GLIMLOAN"), CODE_VALUE(
                                                                                                                        "CODEVALUE"), GL_CLOSURE(
                                                                                                                                "GLCLOSURE"), PERIODIC_ACCRUAL_ACCOUNTING(
                                                                                                                                        "PERIODICACCRUALACCOUNTING"), GL_ACCOUNT(
                                                                                                                                                "GLACCOUNT"), JOURNAL_ENTRY(
                                                                                                                                                        "JOURNALENTRY"), SAVINGS_PRODUCT(
                                                                                                                                                                "SAVINGSPRODUCT"), SAVINGS_ACCOUNT(
                                                                                                                                                                        "SAVINGSACCOUNT"), GSIM_ACCOUNT(
                                                                                                                                                                                "GSIMACCOUNT"), ACCOUNT_TRANSFER(
                                                                                                                                                                                        "ACCOUNTTRANSFER"), STANDING_INSTRUCTION(
                                                                                                                                                                                                "STANDINGINSTRUCTION"), SAVINGS_ACCOUNT_CHARGE(
                                                                                                                                                                                                        "SAVINGSACCOUNTCHARGE"), FIXED_DEPOSIT_PRODUCT(
                                                                                                                                                                                                                "FIXEDDEPOSITPRODUCT"), RECURRING_DEPOSIT_PRODUCT(
                                                                                                                                                                                                                        "RECURRINGDEPOSITPRODUCT"), INTEREST_RATE_CHART(
                                                                                                                                                                                                                                "INTERESTRATECHART"), CHARTSLAB(
                                                                                                                                                                                                                                        "CHARTSLAB"), CALENDAR(
                                                                                                                                                                                                                                                "CALENDAR"), GROUP(
                                                                                                                                                                                                                                                        "GROUP"), COLLECTIONSHEET(
                                                                                                                                                                                                                                                                "COLLECTIONSHEET"), COLLATERAL(
                                                                                                                                                                                                                                                                        "COLLATERAL"), CLIENT_COLLATERAL_PRODUCT(
                                                                                                                                                                                                                                                                                "CLIENT_COLLATERAL_PRODUCT"), LOAN_COLLATERAL_PRODUCT(
                                                                                                                                                                                                                                                                                        "LOAN_COLLATERAL_PRODUCT"), CENTER(
                                                                                                                                                                                                                                                                                                "CENTER"), ACCOUNTING_RULE(
                                                                                                                                                                                                                                                                                                        "ACCOUNTINGRULE"), XBRLMAPPING(
                                                                                                                                                                                                                                                                                                                "XBRLMAPPING"), HOLIDAY(
                                                                                                                                                                                                                                                                                                                        "HOLIDAY"), TEMPLATE(
                                                                                                                                                                                                                                                                                                                                "TEMPLATE"), PRODUCTMIX(
                                                                                                                                                                                                                                                                                                                                        "PRODUCTMIX"), SCHEDULER(
                                                                                                                                                                                                                                                                                                                                                "SCHEDULER"), MEETING(
                                                                                                                                                                                                                                                                                                                                                        "MEETING"), CACHE(
                                                                                                                                                                                                                                                                                                                                                                "CACHE"), FIXEDDEPOSIT_ACCOUNT(
                                                                                                                                                                                                                                                                                                                                                                        "FIXEDDEPOSITACCOUNT"), RECURRINGDEPOSIT_ACCOUNT(
                                                                                                                                                                                                                                                                                                                                                                                "RECURRINGDEPOSITACCOUNT"), FINANCIALACTIVITY_ACCOUNT(
                                                                                                                                                                                                                                                                                                                                                                                        "FINANCIALACTIVITYACCOUNT"), SURVEY(
                                                                                                                                                                                                                                                                                                                                                                                                "SURVEY"), LIKELIHOOD(
                                                                                                                                                                                                                                                                                                                                                                                                        "LIKELIHOOD"), TELLER(
                                                                                                                                                                                                                                                                                                                                                                                                                "TELLER"), ENTITY_MAPPING(
                                                                                                                                                                                                                                                                                                                                                                                                                        "ENTITYMAPPING"), WORKINGDAYS(
                                                                                                                                                                                                                                                                                                                                                                                                                                "WORKINGDAYS"), PAYMENT_TYPE(
                                                                                                                                                                                                                                                                                                                                                                                                                                        "PAYMENTTYPE"), EXTERNAL_SERVICES(
                                                                                                                                                                                                                                                                                                                                                                                                                                                "EXTERNALSERVICES"), PROVISION_CATEGORY(
                                                                                                                                                                                                                                                                                                                                                                                                                                                        "PROVISIONCATEGORY"), PROVISION_CRITERIA(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                "PROVISIONCRITERIA"), PROVISION_ENTRIES(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "PROVISIONENTRIES"), PROVISION_JOURNAL_ENTRIES(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "PROVISIONJOURNALENTRIES"), FLOATING_RATE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "FLOATINGRATE"), SHARE_PRODUCT(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "SHAREPRODUCT"), TAX_COMPONENT(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "TAXCOMPONENT"), TAXGROUP(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "TAXGROUP"), ENTITY_DATATABLE_CHECK(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "ENTITY_DATATABLE_CHECK"), SS_BENEFICIARY_TPT(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "SSBENEFICIARYTPT"), SMS_CAMPAIGN(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "SMSCAMPAIGN"), ADHOC(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "ADHOC"), EMAIL(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "EMAIL"), EMAIL_CAMPAIGN(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "EMAIL_CAMPAIGN"), TWOFACTOR_ACCESS_TOKEN(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "TWOFACTOR_ACCESSTOKEN"), TWOFACTOR_CONFIGURATION(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "TWOFACTOR_CONFIGURATION"), RATE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "RATE"), BUSINESS_DATE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "BUSINESS_DATE"), DELINQUENCY_RANGE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "DELINQUENCY_RANGE"), DELINQUENCY_BUCKET(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "DELINQUENCY_BUCKET"), BATCH_BUSINESS_STEP(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "BATCH_BUSINESS_STEP"), INLINE_JOB(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "INLINE_JOB"), EXTERNAL_EVENT_CONFIGURATION(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "EXTERNAL_EVENT_CONFIGURATION"), EXTERNAL_ASSET_OWNER_LOAN_PRODUCT_ATTRIBUTE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "EXTERNAL_ASSET_OWNER_LOAN_PRODUCT_ATTRIBUTE"), ASSET_OWNER_TRANSACTION(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "ASSET_OWNER_TRANSACTION"), DELINQUENCY_ACTION(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "DELINQUENCY_ACTION"), INTEREST_PAUSE(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "INTEREST_PAUSE"), LOAN_AVAILABLE_DISBURSEMENT_AMOUNT(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "LOAN_AVAILABLE_DISBURSEMENT_AMOUNT"), EMAIL_CONFIGURATION(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "EMAIL_CONFIGURATION"), TWOFACTOR_ACCESSTOKEN(
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "TWOFACTOR_ACCESSTOKEN");

        @Getter
        private final String value;
    }
}
