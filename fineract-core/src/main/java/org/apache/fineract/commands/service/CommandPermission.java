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

  UPDATE_CREDIT_BUREAU(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),
  UPDATE_CREDIT_BUREAU_LOANPRODUCT_MAPPING(Action.UPDATE, Entity.CREDIT_BUREAU_LOANPRODUCT_MAPPING,
          "/creditBureauConfiguration/template"),
  ADD_ORGANISATION_CREDIT_BUREAU(Action.CREATE, Entity.ORGANISATION_CREDIT_BUREAU,
          "/creditBureauConfiguration/organizationCreditBureau/template"),

  GET_CREDIT_REPORT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  SAVE_CREDIT_REPORT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_CREDIT_REPORT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_CREDIT_BUREAU_LOAN_PRODUCT_MAPPING(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ADD_CREDIT_BUREAU_CONFIGURATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_CREDIT_BUREAU_CONFIGURATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ADD_CLIENT_ADDRESS(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_CLIENT_ADDRESS(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ADD_FAMILY_MEMBERS(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_FAMILY_MEMBERS(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_FAMILY_MEMBERS(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_GLOBAL_CONFIGURATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_PERMISSIONS(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_ROLE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_ROLE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_ROLE_PERMISSIONS(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_USER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CHANGE_USER_PASSWORD(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_USER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_USER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_OFFICE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_OFFICE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_OFFICE_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_OFFICE_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_STAFF(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_STAFF(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),


  CREATE_GUARANTOR(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  RECOVER_FROM_GUARANTOR(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_GUARANTOR(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_GUARANTOR(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_FUND(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_FUND(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_REPORT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_REPORT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_REPORT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_CURRENCIES(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_SMS(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_SMS(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_SMS(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_CODE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_CODE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_CODE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_HOOK(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_HOOK(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_HOOK(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_COLLATERAL(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_LOAN_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_LOAN_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_CLIENT_IDENTIFIER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_CLIENT_IDENTIFIER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_CLIENT_IDENTIFIER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_CLIENT(Action.CREATE, Entity.CLIENT, "/clients/template"),

  ACTIVATE_CLIENT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CLOSE_CLIENT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REJECT_CLIENT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  WITHDRAW_CLIENT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REACTIVATE_CLIENT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  PROPOSE_CLIENT_TRANSFER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  PROPOSE_AND_ACCEPT_CLIENT_TRANSFER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  WITHDRAW_CLIENT_TRANSFER_REQUEST(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ACCEPT_CLIENT_TRANSFER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REJECT_CLIENT_TRANSFER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_CLIENT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_CLIENT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_DB_DATATABLE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_DB_DATATABLE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_DB_DATATABLE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_REJECTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_WITHDRAWAL(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_DATATABLE_ENTRY(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_DATATABLE_ENTRY(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_DATATABLE_ENTRY(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_LOAN_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_LOAN_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  WAIVE_LOANCHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration" +
          "/template"),

  PAY_LOANCHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration" +
          "/template"),

  ADJUSTMENT_FOR_LOAN_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DEACTIVATE_OVERDUE_LOAN_CHARGES(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_LOAN_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  LOAN_REPAYMENT_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  LOAN_MERCHANT_ISSUED_REFUND_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  LOAN_PAYOUT_REFUND_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  LOAN_GOODWILL_CREDIT_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  LOAN_INTEREST_PAYMENT_WAIVER_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REFUND_LOAN_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  LOAN_RECOVERY_PAYMENT_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  WAIVE_INTEREST_PORTION_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  WRITEOFF_LOAN_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_WRITEOFF_LOAN_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CLOSE_LOAN_AS_RESCHEDULED_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CLOSE_LOAN_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ADJUST_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REFUND_LOAN_TRANSACTION_BY_CASH(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CHARGE_BACK_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  LOAN_FORECLOSURE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREDIT_BALANCE_REFUND(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_WAIVE_CHARGE_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_LOAN_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_POST_DATED_CHEQUE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  BOUNCED_CHEQUE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_POSTDATED_CHEQUE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_LOAN_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  MARK_AS_FRAUD(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_DISBURSEMENT_DATE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU,
          "/creditBureauConfiguration/template"),

  ADD_AND_DELETE_DISBURSEMENT_DETAILS(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_LOAN_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REJECT_LOAN_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REJECT_GLIM_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  WITHDRAW_LOAN_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  APPROVE_LOAN_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  APPROVE_GLIM_LOAN_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DISBURSE_GLIM_LOAN_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REPAYMENT_GLIM_LOAN_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_GLIM_LOAN_DISBURSAL(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_GLIM_LOAN_APPROVAL(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DISBURSE_LOAN_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DISBURSE_LOAN_TO_SAVINGS_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DISBURSE_WITHOUT_AUTO_DOWNPAYMENT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_LOAN_APPLICATION_APPROVAL(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_LOAN_APPLICATION_DISBURSAL(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_LAST_DISBURSAL_LOAN_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ASSIGN_LOAN_OFFICER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNASSIGN_LOAN_OFFICER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ASSIGN_LOAN_OFFICERS_IN_BULK(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ASSIGN_DELINQUENCY(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_CODEVALUE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_CODEVALUE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_CODEVALUE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_GLCLOSURE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_GLCLOSURE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_GLCLOSURE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  EXECUTE_ACCRUAL_ACCOUNTING(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU,
          "/creditBureauConfiguration/template"),

  CREATE_GL_ACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_GL_ACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_GL_ACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_JOURNAL_ENTRY(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU,
          "/creditBureauConfiguration/template"),

  REVERSE_JOURNAL_ENTRY(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU,
          "/creditBureauConfiguration/template"),

  UPDATE_RUNNING_BALANCE_FOR_JOURNALENTRY(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DEFINE_OPENING_BALANCE_FOR_JOURNALENTRY(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_OPENING_BALANCE_FOR_JOURNALENTRY(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_SAVING_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU,
          "/creditBureauConfiguration/template"),

  UPDATE_SAVING_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU,
          "/creditBureauConfiguration/template"),

  DELETE_SAVING_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU,
          "/creditBureauConfiguration/template"),

  CREATE_SAVINGSACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_GSIM_ACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_SAVINGSACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_GSIM_ACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_SAVINGSACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REJECT_SAVINGSACCOUNT_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REJECT_GSIM_ACCOUNT_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  WITHDRAW_SAVINGS_ACCOUNT_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  APPROVE_SAVINGS_ACCOUNT_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  APPROVE_GSIM_ACCOUNT_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_SAVINGS_ACCOUNT_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_GSIM_APPLICATION_APPROVAL(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  SAVINGS_ACCOUNT_ACTIVATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  GSIM_ACCOUNT_ACTIVATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CLOSE_SAVINGSACCOUNT_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CLOSE_GSIM_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_ACCOUNT_TRANSFER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_STANDING_INSTRUCTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_STANDING_INSTRUCTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_STANDING_INSTRUCTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  SAVINGSACCOUNT_DEPOSIT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  GSIM_SAVINGSACCOUNT_DEPOSIT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  SAVINGSACCOUNT_WITHDRAWAL(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_SAVINGSACCOUNT_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REVERSE_SAVINGSACCOUNT_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ADJUST_SAVINGSACCOUNT_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  SAVINGSACCOUNT_INTEREST_CALCULATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  SAVINGSACCOUNT_INTEREST_POSTING(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  SAVINGSACCOUNT_APPLY_ANNUAL_FEES(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_SAVINGSACCOUNT_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_SAVINGSACCOUNT_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  WAIVE_SAVINGSACCOUNT_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  PAY_SAVINGSACCOUNT_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  INACTIVATE_SAVINGSACCOUNT_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_SAVINGSACCOUNT_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_FIXED_DEPOSIT_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_FIXED_DEPOSIT_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_FIXED_DEPOSIT_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_RECURRING_DEPOSIT_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_RECURRING_DEPOSIT_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_RECURRING_DEPOSIT_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_INTEREST_RATE_CHART(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_INTEREST_RATE_CHART(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_INTEREST_RATE_CHART(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_INTEREST_RATE_CHARTS_LAB(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_INTEREST_RATE_CHARTS_LAB(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_INTEREST_RATE_CHARTS_LAB(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_CALENDAR(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_CALENDAR(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_CALENDAR(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_NOTE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_NOTE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_NOTE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_GROUP(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_GROUP(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ACTIVATE_GROUP(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  SAVE_GROUP_COLLECTIONSHEET(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  SAVE_INDIVIDUAL_COLLECTIONSHEET(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_GROUP(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ASSOCIATE_CLIENT_TO_GROUP(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DISASSOCIATE_CLIENT_FROM_GROUP(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  TRANSFER_CLIENT_BETWEEN_GROUPS(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNASSIGN_GROUP_STAFF(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ASSIGN_GROUP_STAFF(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CLOSE_GROUP(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_COLLATERAL(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_COLLATERAL_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_CLIENT_COLLATERAL_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_LOAN_COLLATERAL(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_COLLATERAL(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_COLLATERAL_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_CLIENT_COLLATERAL_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ADD_CLIENT_COLLATERAL_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_COLLECTIONSHEET(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_CENTER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_CENTER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_CENTER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ACTIVATE_CENTER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  SAVE_CENTER_COLLECTIONSHEET(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CLOSE_CENTER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ASSOCIATE_GROUPS_TO_CENTER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DISASSOCIATE_GROUPS_FROM_CENTER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_ACCOUNTING_RULE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_ACCOUNTING_RULE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_ACCOUNTING_RULE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_TAXONOMY_MAPPING(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_HOLIDAY(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ACTIVATE_HOLIDAY(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_HOLIDAY(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_HOLIDAY(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ASSIGN_ROLE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNASSIGN_ROLE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNASSIGN_CLIENT_STAFF(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_TEMPLATE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_TEMPLATE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_TEMPLATE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ASSIGN_CLIENT_STAFF(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_CLIENT_SAVINGSACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_PRODUCT_MIX(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_PRODUCT_MIX(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_PRODUCT_MIX(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  WITH_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration" +

          "/template"),

  UPDATE_JOB_DETAIL(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_MEETING(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_MEETING(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_MEETING(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  SAVE_OR_UPDATE_ATTENDANCE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_CACHE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_FIXED_DEPOSIT_ACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_FIXED_DEPOSIT_ACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_FIXED_DEPOSIT_ACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REJECT_FIXED_DEPOSIT_ACCOUNT_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  WITHDRAW_FIXED_DEPOSIT_ACCOUNT_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  APPROVE_FIXED_DEPOSIT_ACCOUNT_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_FIXED_DEPOSIT_ACCOUNT_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  FIXED_DEPOSIT_ACCOUNT_ACTIVATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CLOSE_FIXED_DEPOSIT_ACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  PREMATURE_CLOSE_FIXED_DEPOSIT_ACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  FIXED_DEPOSITACCOUNT_INTEREST_CALCULATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  FIXED_DEPOSITACCOUNT_INTEREST_POSTING(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  FIXED_DEPOSITACCOUNT_DEPOSIT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  FIXED_DEPOSITACCOUNT_WITHDRAWAL(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_RECURRING_DEPOSITACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_RECURRING_DEPOSITACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  RECURRING_ACCOUNT_DEPOSIT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  RECURRING_ACCOUNT_WITHDRAWAL(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ADJUST_RECURRING_ACCOUNT_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_RECURRING_ACCOUNT_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_RECURRING_DEPOSIT_ACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REJECT_RECURRING_DEPOSIT_ACCOUNT_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  WITHDRAW_RECURRING_DEPOSIT_ACCOUNT_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  APPROVE_RECURRING_DEPOSIT_ACCOUNT_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_RECURRING_DEPOSIT_ACCOUNT_APPLICATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  RECURRING_DEPOSIT_ACCOUNT_ACTIVATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CLOSE_RECURRING_DEPOSIT_ACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_DEPOSIT_AMOUNT_FOR_RECURRING_DEPOSIT_ACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  PREMATURE_CLOSE_RECURRING_DEPOSITACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  RECURRING_DEPOSIT_ACCOUNT_INTEREST_CALCULATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  RECURRING_DEPOSIT_ACCOUNT_INTEREST_POSTING(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_OFFICE_TO_GL_ACCOUNT_MAPPING(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_OFFICE_TO_GL_ACCOUNT_MAPPING(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_OFFICE_TO_GL_ACCOUNT_MAPPING(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REGISTER_DB_DATATABLE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REGISTER_SURVEY(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  FULFILL_SURVEY(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration" +
          "/template"),

  UPDATE_LIKELIHOOD(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ASSIGN_SAVINGS_OFFICER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNASSIGN_SAVINGS_OFFICER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  SAVINGS_INTEREST_POSTING_AS_ON_DATE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_LOAN_RESCHEDULE_REQUEST(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  APPROVE_LOAN_RESCHEDULE_REQUEST(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU,
          "/creditBureauConfiguration/template"),

  REJECT_LOAN_RESCHEDULE_REQUEST(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_ACCOUNT_NUMBER_FORMAT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_ACCOUNT_NUMBER_FORMAT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_ACCOUNT_NUMBER_FORMAT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REFUND_BY_TRANSFER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_TELLER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_TELLER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_TELLER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ALLOCATE_TELLER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_ALLOCATION_TELLER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_ALLOCATION_TELLER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ALLOCATE_CASH_TO_CASHIER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  SETTLE_CASH_FROM_CASHIER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_ROLE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DISABLE_ROLE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ENABLE_ROLE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_MAP(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_MAP(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_MAP(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_WORKING_DAYS(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_PASSWORD_PREFERENCES(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_PAYMENT_TYPE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_PAYMENT_TYPE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_PAYMENT_TYPE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_EXTERNAL_SERVICE_PROPERTIES(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_CLIENT_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_CLIENT_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  WAIVE_CLIENT_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  PAY_CLIENT_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  INACTIVATE_CLIENT_CHARGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_CLIENT_TRANSACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_PROVISIONING_CATEGORY(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_PROVISIONING_CATEGORY(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_PROVISIONING_CATEGORY(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_PROVISIONING_CRITERIA(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_PROVISIONING_CRITERIA(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_PROVISIONING_CRITERIA(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_PROVISIONING_ENTRIES(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_PROVISIONING_JOURNAL_ENTRIES(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  RECREATE_PROVISIONING_ENTRIES(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_FLOATING_RATE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_FLOATING_RATE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_SCHEDULE_EXCEPTIONS(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_SCHEDULE_EXCEPTIONS(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_PRODUCT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_ACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_ACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_PRODUCT_COMMAND(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_SHARE_PRODUCT_DIVIDEND_PAYOUT_COMMAND(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  APPROVE_SHARE_PRODUCT_DIVIDEND_PAYOUT_COMMAND(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_SHARE_PRODUCT_DIVIDEND_PAYOUT_COMMAND(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_ACCOUNT_COMMAND(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_TAX_COMPONENT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_TAX_COMPONENT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_TAXGROUP(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_TAXGROUP(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_WITHHOLD_TAX(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration" +
          "/template"),

  CREATE_ENTITY_DATATABLE_CHECKS(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_ENTITY_DATATABLE_CHECKS(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ADD_SELF_SERVICE_BENEFICIARY_TPT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_SELF_SERVICE_BENEFICIARY_TPT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_SELF_SERVICE_BENEFICIARY_TPT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_REPORT_MAILING_JOB(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_REPORT_MAILING_JOB(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_REPORT_MAILING_JOB(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_SMS_CAMPAIGN(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_SMS_CAMPAIGN(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ACTIVATE_SMS_CAMPAIGN(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CLOSE_SMS_CAMPAIGN(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REACTIVATE_SMS_CAMPAIGN(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_SMS_CAMPAIGN(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  HOLD_AMOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  RELEASE_AMOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  BLOCK_DEBITS_FROM_SAVINGSACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNBLOCK_DEBITS_FROM_SAVINGSACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  BLOCK_CREDIT_TO_SAVINGSACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNBLOCK_CREDIT_TO_SAVINGSACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  BLOCK_SAVINGSACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNBLOCK_SAVINGSACCOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DISABLE_ADHOC(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ENABLE_ADHOC(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_ADHOC(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_ADHOC(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_ADHOC(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_EMAIL(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_EMAIL(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_EMAIL(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_EMAIL_CAMPAIGN(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_EMAIL_CAMPAIGN(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_EMAIL_CAMPAIGN(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ACTIVATE_EMAIL_CAMPAIGN(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CLOSE_EMAIL_CAMPAIGN(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REACTIVATE_EMAIL_CAMPAIGN(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_EMAIL_CONFIGURATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  INVALIDATE_TWOFACTOR_ACCESS_TOKEN(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_TWOFACTOR_CONFIGURATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  LINK_ACCOUNTS_TO_POCKET(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELINK_ACCOUNTS_FROM_POCKET(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_RATE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_RATE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_BUSINESSDATE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_DELINQUENCY_RANGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_DELINQUENCY_RANGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_DELINQUENCY_RANGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_DELINQUENCY_BUCKET(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_DELINQUENCY_BUCKET(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_DELINQUENCY_BUCKET(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_BUSINESS_STEP_CONFIG(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  EXECUTE_IN_LINE_JOB(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_EXTERNAL_EVENT_CONFIGURATIONS(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CHARGEOFF(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_CHARGEOFF(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_EXTERNAL_ASSET_OWNER_LOAN_PRODUCT_ATTRIBUTE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_EXTERNAL_ASSET_OWNER_LOAN_PRODUCT_ATTRIBUTE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  INTERMEDIARY_SALE_LOAN_TO_EXTERNAL_ASSET_OWNER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  SALE_LOAN_TO_EXTERNAL_ASSET_OWNER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  BUY_BACK_LOAN_TO_EXTERNAL_ASSET_OWNER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CANCEL_TRANSACTION_BY_ID_TO_EXTERNAL_ASSET_OWNER(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DOWNPAYMENT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REAGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_REAGE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  REAMORTIZE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_REAMORTIZE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_DELINQUENCY_ACTION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_INTEREST_PAUSE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CREATE_INTEREST_PAUSE_BY_EXTERNAL_ID(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  DELETE_INTEREST_PAUSE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_INTEREST_PAUSE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  ADD_CAPITALIZED_INCOME(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  CAPITALIZED_INCOME_ADJUSTMENT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  BUY_DOWN_FEE_ADJUSTMENT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  APPLY_CONTRACT_TERMINATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UNDO_CONTRACT_TERMINATION(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  MAKE_LOAN_BUY_DOWN_FEE(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU,
          "/creditBureauConfiguration/template"),

  UPDATE_LOAN_APPROVED_AMOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  MANUAL_INTEREST_REFUND(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU, "/creditBureauConfiguration/template"),

  UPDATE_LOAN_AVAILABLE_DISBURSEMENT_AMOUNT(Action.UPDATE, Entity.ORGANISATION_CREDIT_BUREAU,

          "/creditBureauConfiguration/template");

  private final Action actionName;
  private final Entity entityName;
  private final String href;

  @RequiredArgsConstructor
  private enum Action {
    CREATE("CREATE"),
    UPDATE("UPDATE"),
    DELETE("DELETE"),
    GET("GET"),
    SAVE("SAVE"),
    PERMISSIONS("PERMISSIONS"),
    CHANGEPWD("CHANGEPWD"),
    RECOVERGUARANTEES("RECOVERGUARANTEES"),
    ACTIVATE("ACTIVATE"),
    CLOSE("CLOSE"),
    REJECT("REJECT"),
    WITHDRAW("WITHDRAW"),
    REACTIVATE("REACTIVATE"),
    PROPOSETRANSFER("PROPOSETRANSFER"),
    PROPOSEANDACCEPTTRANSFER("PROPOSEANDACCEPTTRANSFER"),
    WITHDRAWTRANSFER("WITHDRAWTRANSFER"),
    ACCEPTTRANSFER("ACCEPTTRANSFER"),
    REJECTTRANSFER("REJECTTRANSFER"),
    UNDOREJECT("UNDOREJECT"),
    UNDOWITHDRAWAL("UNDOWITHDRAWAL"),
    WAIVE("WAIVE"),
    PAY("PAY"),
    ADJUSTMENT("ADJUSTMENT"),
    DEACTIVATEOVERDUE("DEACTIVATEOVERDUE"),
    REPAYMENT("REPAYMENT"),
    MERCHANTISSUEDREFUND("MERCHANTISSUEDREFUND"),
    PAYOUTREFUND("PAYOUTREFUND"),
    GOODWILLCREDIT("GOODWILLCREDIT"),
    INTERESTPAYMENTWAIVER("INTERESTPAYMENTWAIVER"),
    CHARGEREFUND("CHARGEREFUND"),
    RECOVERYPAYMENT("RECOVERYPAYMENT"),
    WAIVEINTERESTPORTION("WAIVEINTERESTPORTION"),
    WRITEOFF("WRITEOFF"),
    UNDOWRITEOFF("UNDOWRITEOFF"),
    CLOSEASRESCHEDULED("CLOSEASRESCHEDULED"),
    ADJUST("ADJUST"),
    REFUNDBYCASH("REFUNDBYCASH"),
    CHARGEBACK("CHARGEBACK"),
    FORECLOSURE("FORECLOSURE"),
    CREDITBALANCEREFUND("CREDITBALANCEREFUND"),
    UNDO("UNDO"),
    BOUNCE("BOUNCE"),
    SETFRAUD("SETFRAUD"),
    APPROVE("APPROVE"),
    DISBURSE("DISBURSE"),
    UNDODISBURSAL("UNDODISBURSAL"),
    UNDOAPPROVAL("UNDOAPPROVAL"),
    DISBURSETOSAVINGS("DISBURSETOSAVINGS"),
    DISBURSEWITHOUTAUTODOWNPAYMENT("DISBURSEWITHOUTAUTODOWNPAYMENT"),
    APPROVALUNDO("APPROVALUNDO"),
    DISBURSALUNDO("DISBURSALUNDO"),
    DISBURSALLASTUNDO("DISBURSALLASTUNDO"),
    UPDATELOANOFFICER("UPDATELOANOFFICER"),
    REMOVELOANOFFICER("REMOVELOANOFFICER"),
    BULKREASSIGN("BULKREASSIGN"),
    UPDATEDELINQUENCY("UPDATEDELINQUENCY"),
    EXECUTE("EXECUTE"),
    REVERSE("REVERSE"),
    UPDATERUNNINGBALANCE("UPDATERUNNINGBALANCE"),
    DEFINEOPENINGBALANCE("DEFINEOPENINGBALANCE"),
    UPDATEOPENINGBALANCE("UPDATEOPENINGBALANCE"),
    DEPOSIT("DEPOSIT"),
    WITHDRAWAL("WITHDRAWAL"),
    UNDOTRANSACTION("UNDOTRANSACTION"),
    REVERSETRANSACTION("REVERSETRANSACTION"),
    ADJUSTTRANSACTION("ADJUSTTRANSACTION"),
    CALCULATEINTEREST("CALCULATEINTEREST"),
    POSTINTEREST("POSTINTEREST"),
    APPLYANNUALFEE("APPLYANNUALFEE"),
    INACTIVATE("INACTIVATE"),
    SAVECOLLECTIONSHEET("SAVECOLLECTIONSHEET"),
    ASSOCIATECLIENTS("ASSOCIATECLIENTS"),
    DISASSOCIATECLIENTS("DISASSOCIATECLIENTS"),
    TRANSFERCLIENTS("TRANSFERCLIENTS"),
    UNASSIGNSTAFF("UNASSIGNSTAFF"),
    ASSIGNSTAFF("ASSIGNSTAFF"),
    ASSOCIATEGROUPS("ASSOCIATEGROUPS"),
    DISASSOCIATEGROUPS("DISASSOCIATEGROUPS"),
    ASSIGNROLE("ASSIGNROLE"),
    UNASSIGNROLE("UNASSIGNROLE"),
    UPDATEROLE("UPDATEROLE"),
    UPDATESAVINGSACCOUNT("UPDATESAVINGSACCOUNT"),
    SAVEORUPDATEATTENDANCE("SAVEORUPDATEATTENDANCE"),
    PREMATURECLOSE("PREMATURECLOSE"),
    RECURRINGDEPOSITACCOUNT("RECURRINGDEPOSITACCOUNT"),
    REGISTER("REGISTER"),
    UPDATESAVINGSOFFICER("UPDATESAVINGSOFFICER"),
    REMOVESAVINGSOFFICER("REMOVESAVINGSOFFICER"),
    POSTINTERESTASONDATE("POSTINTERESTASONDATE"),
    REFUNDBYTRANSFER("REFUNDBYTRANSFER"),
    ALLOCATECASHIER("ALLOCATECASHIER"),
    UPDATECASHIERALLOCATION("UPDATECASHIERALLOCATION"),
    DELETECASHIERALLOCATION("DELETECASHIERALLOCATION"),
    ALLOCATECASHTOCASHIER("ALLOCATECASHTOCASHIER"),
    SETTLECASHFROMCASHIER("SETTLECASHFROMCASHIER"),
    ENABLE("ENABLE"),
    RECREATE("RECREATE"),
    CREATESCHEDULEEXCEPTIONS("CREATESCHEDULEEXCEPTIONS"),
    DELETESCHEDULEEXCEPTIONS("DELETESCHEDULEEXCEPTIONS"),
    SHAREPRODUCT("SHAREPRODUCT"),
    UPDATEWITHHOLDTAX("UPDATEWITHHOLDTAX"),
    HOLDAMOUNT("HOLDAMOUNT"),
    RELEASEAMOUNT("RELEASEAMOUNT"),
    BLOCKDEBIT("BLOCKDEBIT"),
    UNBLOCKDEBIT("UNBLOCKDEBIT"),
    BLOCKCREDIT("BLOCKCREDIT"),
    UNBLOCKCREDIT("UNBLOCKCREDIT"),
    BLOCK("BLOCK"),
    UNBLOCK("UNBLOCK"),
    DISABLE("DISABLE"),
    INVALIDATE("INVALIDATE"),
    CHARGEOFF("CHARGEOFF"),
    UNDOCHARGEOFF("UNDOCHARGEOFF"),
    INTERMEDIARYSALE("INTERMEDIARYSALE"),
    SALE("SALE"),
    BUYBACK("BUYBACK"),
    CANCEL("CANCEL"),
    DOWNPAYMENT("DOWNPAYMENT"),
    REAGE("REAGE"),
    UNDO_REAGE("UNDO_REAGE"),
    REAMORTIZE("REAMORTIZE"),
    UNDO_REAMORTIZE("UNDO_REAMORTIZE"),
    CAPITALIZEDINCOME("CAPITALIZEDINCOME"),
    CAPITALIZEDINCOMEADJUSTMENT("CAPITALIZEDINCOMEADJUSTMENT"),
    BUYDOWNFEEADJUSTMENT("BUYDOWNFEEADJUSTMENT"),
    CONTRACT_TERMINATION("CONTRACT_TERMINATION"),
    CONTRACT_TERMINATION_UNDO("CONTRACT_TERMINATION_UNDO"),
    BUYDOWNFEE("BUYDOWNFEE"),
    UPDATE_APPROVED_AMOUNT("UPDATE_APPROVED_AMOUNT"),
    MANUAL_INTEREST_REFUND_TRANSACTION("MANUAL_INTEREST_REFUND_TRANSACTION");

    @Getter
    private final String value;
  }

  @RequiredArgsConstructor
  private enum Entity {
    ORGANISATION_CREDIT_BUREAU("ORGANISATIONCREDITBUREAU"),
    CREDIT_BUREAU_LOANPRODUCT_MAPPING("CREDITBUREAU_LOANPRODUCT_MAPPING"),
    CREDIT_REPORT("CREDITREPORT"),
    CREDIT_BUREAU_CONFIGURATION("CREDITBUREAU_CONFIGURATION"),
    ADDRESS("ADDRESS"),
    FAMILY_MEMBERS("FAMILYMEMBERS"),
    CONFIGURATION("CONFIGURATION"),
    PERMISSION("PERMISSION"),
    ROLE("ROLE"),
    USER("USER"),
    OFFICE("OFFICE"),
    OFFICE_TRANSACTION("OFFICETRANSACTION"),
    STAFF("STAFF"),
    GUARANTOR("GUARANTOR"),
    LOAN("LOAN"),
    FUND("FUND"),
    REPORT("REPORT"),
    CURRENCY("CURRENCY"),
    SMS("SMS"),
    CODE("CODE"),
    HOOK("HOOK"),
    CHARGE("CHARGE"),
    COLLATERAL_PRODUCT("COLLATERAL_PRODUCT"),
    LOAN_PRODUCT("LOANPRODUCT"),
    CLIENT_IDENTIFIER("CLIENTIDENTIFIER"),
    CLIENT("CLIENT"),
    DATATABLE("DATATABLE"),
    LOANCHARGE("LOANCHARGE"),
    WAIVECHARGE("WAIVECHARGE"),
    REPAYMENT_WITH_POSTDATEDCHECKS("REPAYMENT_WITH_POSTDATEDCHECKS"),
    DISBURSEMENT_DETAIL("DISBURSEMENTDETAIL"),
    GLIM_LOAN("GLIMLOAN"),
    CODE_VALUE("CODEVALUE"),
    GL_CLOSURE("GLCLOSURE"),
    PERIODIC_ACCRUAL_ACCOUNTING("PERIODICACCRUALACCOUNTING"),
    GL_ACCOUNT("GLACCOUNT"),
    JOURNAL_ENTRY("JOURNALENTRY"),
    SAVINGS_PRODUCT("SAVINGSPRODUCT"),
    SAVINGS_ACCOUNT("SAVINGSACCOUNT"),
    GSIM_ACCOUNT("GSIMACCOUNT"),
    ACCOUNT_TRANSFER("ACCOUNTTRANSFER"),
    STANDING_INSTRUCTION("STANDINGINSTRUCTION"),
    SAVINGS_ACCOUNT_CHARGE("SAVINGSACCOUNTCHARGE"),
    FIXED_DEPOSIT_PRODUCT("FIXEDDEPOSITPRODUCT"),
    RECURRING_DEPOSIT_PRODUCT("RECURRINGDEPOSITPRODUCT"),
    INTEREST_RATE_CHART("INTERESTRATECHART"),
    CHARTSLAB("CHARTSLAB"),
    CALENDAR("CALENDAR"),
    GROUP("GROUP"),
    COLLECTIONSHEET("COLLECTIONSHEET"),
    COLLATERAL("COLLATERAL"),
    CLIENT_COLLATERAL_PRODUCT("CLIENT_COLLATERAL_PRODUCT"),
    LOAN_COLLATERAL_PRODUCT("LOAN_COLLATERAL_PRODUCT"),
    CENTER("CENTER"),
    ACCOUNTING_RULE("ACCOUNTINGRULE"),
    XBRLMAPPING("XBRLMAPPING"),
    HOLIDAY("HOLIDAY"),
    TEMPLATE("TEMPLATE"),
    PRODUCTMIX("PRODUCTMIX"),
    SCHEDULER("SCHEDULER"),
    MEETING("MEETING"),
    CACHE("CACHE"),
    FIXEDDEPOSIT_ACCOUNT("FIXEDDEPOSITACCOUNT"),
    RECURRINGDEPOSIT_ACCOUNT("RECURRINGDEPOSITACCOUNT"),
    FINANCIALACTIVITY_ACCOUNT("FINANCIALACTIVITYACCOUNT"),
    SURVEY("SURVEY"),
    LIKELIHOOD("LIKELIHOOD"),
    TELLER("TELLER"),
    ENTITY_MAPPING("ENTITYMAPPING"),
    WORKINGDAYS("WORKINGDAYS"),
    PAYMENT_TYPE("PAYMENTTYPE"),
    EXTERNAL_SERVICES("EXTERNALSERVICES"),
    PROVISION_CATEGORY("PROVISIONCATEGORY"),
    PROVISION_CRITERIA("PROVISIONCRITERIA"),
    PROVISION_ENTRIES("PROVISIONENTRIES"),
    PROVISION_JOURNAL_ENTRIES("PROVISIONJOURNALENTRIES"),
    FLOATING_RATE("FLOATINGRATE"),
    SHARE_PRODUCT("SHAREPRODUCT"),
    TAX_COMPONENT("TAXCOMPONENT"),
    TAXGROUP("TAXGROUP"),
    ENTITY_DATATABLE_CHECK("ENTITY_DATATABLE_CHECK"),
    SS_BENEFICIARY_TPT("SSBENEFICIARYTPT"),
    SMS_CAMPAIGN("SMSCAMPAIGN"),
    ADHOC("ADHOC"),
    EMAIL("EMAIL"),
    EMAIL_CAMPAIGN("EMAIL_CAMPAIGN"),
    TWOFACTOR_ACCESS_TOKEN("TWOFACTOR_ACCESSTOKEN"),
    TWOFACTOR_CONFIGURATION("TWOFACTOR_CONFIGURATION"),
    RATE("RATE"),
    BUSINESS_DATE("BUSINESS_DATE"),
    DELINQUENCY_RANGE("DELINQUENCY_RANGE"),
    DELINQUENCY_BUCKET("DELINQUENCY_BUCKET"),
    BATCH_BUSINESS_STEP("BATCH_BUSINESS_STEP"),
    INLINE_JOB("INLINE_JOB"),
    EXTERNAL_EVENT_CONFIGURATION("EXTERNAL_EVENT_CONFIGURATION"),
    EXTERNAL_ASSET_OWNER_LOAN_PRODUCT_ATTRIBUTE("EXTERNAL_ASSET_OWNER_LOAN_PRODUCT_ATTRIBUTE"),
    ASSET_OWNER_TRANSACTION("ASSET_OWNER_TRANSACTION"),
    DELINQUENCY_ACTION("DELINQUENCY_ACTION"),
    INTEREST_PAUSE("INTEREST_PAUSE"),
    LOAN_AVAILABLE_DISBURSEMENT_AMOUNT("LOAN_AVAILABLE_DISBURSEMENT_AMOUNT"),;

    @Getter
    private final String value;
  }
}
