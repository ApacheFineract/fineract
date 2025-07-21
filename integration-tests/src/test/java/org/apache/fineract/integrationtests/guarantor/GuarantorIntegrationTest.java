package org.apache.fineract.integrationtests.guarantor;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.fineract.client.models.GetClientsClientIdResponse;
import org.apache.fineract.client.models.PostClientsRequest;
import org.apache.fineract.client.models.PostClientsResponse;
import org.apache.fineract.client.models.PostLoanProductsRequest;
import org.apache.fineract.client.models.PostLoanProductsResponse;
import org.apache.fineract.client.models.PostSavingsAccountsRequest;
import org.apache.fineract.client.models.PostSavingsAccountsResponse;
import org.apache.fineract.integrationtests.common.FineractClientHelper;
import org.apache.fineract.integrationtests.common.loans.LoanTestLifecycleExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import retrofit2.Call;
import retrofit2.Response;

@ExtendWith(LoanTestLifecycleExtension.class)
@Slf4j
public class GuarantorIntegrationTest {

    private static final Float SELF1_BALANCE = Float.valueOf((float) 5000);
    private static final Float EXTERNAL1_BALANCE = Float.valueOf((float) 5000);
    private static final Float EXTERNAL2_BALANCE = Float.valueOf((float) 5000);
    private static final Float SELF1_GURANTEE = Float.valueOf((float) 2000);
    private static final Float EXTERNAL1_GURANTEE = Float.valueOf((float) 2000);
    private static final Float EXTERNAL2_GURANTEE = Float.valueOf((float) 1000);

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testGuarantor() throws IOException {

        // Enable full HTTP logging
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logging).build();

        final String ERROR_RESPONSE = "Error: Request didn't receive a valid response!";

        // Create client request
        final PostClientsRequest request = new PostClientsRequest();
        request.setFirstname("FirstName1 " + UUID.randomUUID().toString());
        request.setLastname("LastName1 " + UUID.randomUUID().toString());
        request.setActive(true);
        request.setActivationDate("01 July 2025");
        request.setDateFormat("dd MMMM yyyy");
        request.setLocale("en");
        request.setOfficeId(1L);
        request.setLegalFormId(1L);

        final Integer clientID = createClient(request);
        log.info("Client Id: {}", clientID);
        if (clientID.equals(Integer.MIN_VALUE)) {
            fail(ERROR_RESPONSE);
        }

        final GetClientsClientIdResponse verifyClientCreated = verifyClientCreated(clientID.longValue(), false);
        log.info(verifyClientCreated.toString());

        final Integer clientID_external = createClient(request);
        log.info("External Client Id: {}", clientID_external);
        if (clientID_external.equals(Integer.MIN_VALUE)) {
            fail(ERROR_RESPONSE);
        }

        final GetClientsClientIdResponse verifyExternalClientCreated = verifyClientCreated(clientID.longValue(), false);
        log.info(verifyExternalClientCreated.toString());

        final Integer clientID_external2 = createClient(request);
        log.info("External Client 2 Id: {}", clientID_external2);
        if (clientID_external2.equals(Integer.MIN_VALUE)) {
            fail(ERROR_RESPONSE);
        }

        PostSavingsAccountsRequest savingsRequest = new PostSavingsAccountsRequest();
        savingsRequest.setClientId(clientID.longValue());
        savingsRequest.setDateFormat("dd MMMM yyyy");
        savingsRequest.setLocale("en");
        savingsRequest.setProductId(1L);
        savingsRequest.setSubmittedOnDate("01 July 2025");
        savingsRequest.setExternalId(UUID.randomUUID().toString());

        PostSavingsAccountsRequest savingsRequestExternal = new PostSavingsAccountsRequest();
        savingsRequestExternal.setClientId(clientID_external.longValue());
        savingsRequestExternal.setDateFormat("dd MMMM yyyy");
        savingsRequestExternal.setLocale("en");
        savingsRequestExternal.setProductId(2L);
        savingsRequestExternal.setSubmittedOnDate("01 July 2025");
        savingsRequestExternal.setExternalId(UUID.randomUUID().toString());

        PostSavingsAccountsRequest savingsRequestExternal2 = new PostSavingsAccountsRequest();
        savingsRequestExternal2.setClientId(clientID_external.longValue());
        savingsRequestExternal2.setDateFormat("dd MMMM yyyy");
        savingsRequestExternal2.setLocale("en");
        savingsRequestExternal2.setProductId(3L);
        savingsRequestExternal2.setSubmittedOnDate("01 July 2025");
        savingsRequestExternal2.setExternalId(UUID.randomUUID().toString());

        final Integer selfSavingsId = openSavingsAccount(savingsRequest, String.valueOf(SELF1_BALANCE)); // SavingsAccountHelper.openSavingsAccount(this.requestSpec,
        log.info("Saving Account Id: {}", selfSavingsId);

        final Integer externalSavigsId_1 = openSavingsAccount(savingsRequestExternal, String.valueOf(EXTERNAL1_BALANCE));
        log.info("Saving Account External 1 Id: {}", externalSavigsId_1);

        final Integer externalSavigsId_2 = openSavingsAccount(savingsRequestExternal2, String.valueOf(EXTERNAL2_BALANCE));
        log.info("Saving Account External 2 Id: {}", externalSavigsId_2);
        
        final Integer loanProductID = createLoanProductWithHoldFunds("50", "20", "20");
        log.info("LoanProduct Id: {}", loanProductID.toString());

        //// final Integer clientID = ClientHelper.createClient(this.requestSpec, this.responseSpec);
        //// ClientHelper.verifyClientCreatedOnServer(this.requestSpec, this.responseSpec, clientID);
        //// final Integer clientID_external = ClientHelper.createClient(this.requestSpec, this.responseSpec);
        //// final Integer clientID_external2 = ClientHelper.createClient(this.requestSpec, this.responseSpec);
        ////
        //// ClientHelper.verifyClientCreatedOnServer(this.requestSpec, this.responseSpec, clientID_external);
        ////
        //// final Integer selfSavigsId = SavingsAccountHelper.openSavingsAccount(this.requestSpec, this.responseSpec,
        //// clientID,
        //// String.valueOf(SELF1_BALANCE));
        //// final Integer externalSavigsId_1 = SavingsAccountHelper.openSavingsAccount(this.requestSpec,
        //// this.responseSpec, clientID_external,
        //// String.valueOf(EXTERNAL1_BALANCE));
        //// final Integer externalSavigsId_2 = SavingsAccountHelper.openSavingsAccount(this.requestSpec,
        //// this.responseSpec, clientID_external2,
        //// String.valueOf(EXTERNAL2_BALANCE));
        //// final Integer loanProductID = createLoanProductWithHoldFunds("50", "20", "20");
        // DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.US);
        // Calendar todaysDate = Calendar.getInstance();
        // todaysDate.add(Calendar.DAY_OF_MONTH, -7 * 4);
        // final String loanDisbursementDate = dateFormat.format(todaysDate.getTime());
        // final Integer loanID = applyForLoanApplication(clientID, loanProductID, loanDisbursementDate);
        // Assertions.assertNotNull(loanID);
        // HashMap loanStatusHashMap = LoanStatusChecker.getStatusOfLoan(this.requestSpec, this.responseSpec, loanID);
        // LoanStatusChecker.verifyLoanIsPending(loanStatusHashMap);
        //
        // String guarantorJSON = new GuarantorTestBuilder().externalCustomer().build();
        // Integer externalGuarantor = this.guarantorHelper.createGuarantor(loanID, guarantorJSON);
        // Assertions.assertNotNull(externalGuarantor);
        //
        // guarantorJSON = new
        //// GuarantorTestBuilder().existingCustomerWithoutGuaranteeAmount(String.valueOf(clientID_external)).build();
        // Integer withoutGuaranteeAmount = this.guarantorHelper.createGuarantor(loanID, guarantorJSON);
        // Assertions.assertNotNull(withoutGuaranteeAmount);
        //
        // ArrayList<HashMap> errorData = (ArrayList<HashMap>)
        //// this.loanTransactionHelper.approveLoan(loanDisbursementDate, null, loanID,
        // CommonConstants.RESPONSE_ERROR);
        // assertTrue(checkForErrorCode(errorData, "validation.msg.loan.guarantor.min.self.guarantee.required"));
        // assertTrue(checkForErrorCode(errorData, "validation.msg.loan.guarantor.min.external.guarantee.required"));
        // assertTrue(checkForErrorCode(errorData, "validation.msg.loan.guarantor.mandated.guarantee.required"));
        //
        // guarantorJSON = new GuarantorTestBuilder()
        // .existingCustomerWithGuaranteeAmount(String.valueOf(clientID), String.valueOf(selfSavigsId),
        //// String.valueOf(SELF1_GURANTEE))
        // .build();
        // Integer selfGuarantee = this.guarantorHelper.createGuarantor(loanID, guarantorJSON);
        // verifySavingsOnHoldBalance(selfSavigsId, null);
        // Assertions.assertNotNull(selfGuarantee);
        //
        // errorData = (ArrayList<HashMap>) this.loanTransactionHelper.approveLoan(loanDisbursementDate, null, loanID,
        // CommonConstants.RESPONSE_ERROR);
        // assertFalse(checkForErrorCode(errorData, "validation.msg.loan.guarantor.min.self.guarantee.required"));
        // assertTrue(checkForErrorCode(errorData, "validation.msg.loan.guarantor.min.external.guarantee.required"));
        // assertTrue(checkForErrorCode(errorData, "validation.msg.loan.guarantor.mandated.guarantee.required"));
        //
        // guarantorJSON = new
        //// GuarantorTestBuilder().existingCustomerWithGuaranteeAmount(String.valueOf(clientID_external),
        // String.valueOf(externalSavigsId_1), String.valueOf(EXTERNAL1_GURANTEE)).build();
        // Integer externalGuarantee_1 = this.guarantorHelper.createGuarantor(loanID, guarantorJSON);
        // verifySavingsOnHoldBalance(externalSavigsId_1, null);
        // Assertions.assertNotNull(externalGuarantee_1);
        //
        // errorData = (ArrayList<HashMap>) this.loanTransactionHelper.approveLoan(loanDisbursementDate, null, loanID,
        // CommonConstants.RESPONSE_ERROR);
        // assertFalse(checkForErrorCode(errorData, "validation.msg.loan.guarantor.min.self.guarantee.required"));
        // assertFalse(checkForErrorCode(errorData, "validation.msg.loan.guarantor.min.external.guarantee.required"));
        // assertTrue(checkForErrorCode(errorData, "validation.msg.loan.guarantor.mandated.guarantee.required"));
        //
        // guarantorJSON = new
        //// GuarantorTestBuilder().existingCustomerWithGuaranteeAmount(String.valueOf(clientID_external2),
        // String.valueOf(externalSavigsId_2), String.valueOf(EXTERNAL2_GURANTEE)).build();
        // Integer externalGuarantee_2 = this.guarantorHelper.createGuarantor(loanID, guarantorJSON);
        // verifySavingsOnHoldBalance(externalSavigsId_2, null);
        // Assertions.assertNotNull(externalGuarantee_2);
        //
        // LOG.info("-----------------------------------APPROVE LOAN-----------------------------------------");
        // loanStatusHashMap = this.loanTransactionHelper.approveLoan(loanDisbursementDate, loanID);
        // LoanStatusChecker.verifyLoanIsApproved(loanStatusHashMap);
        // LoanStatusChecker.verifyLoanIsWaitingForDisbursal(loanStatusHashMap);
        // self1_hold_funds += SELF1_GURANTEE;
        // external1_hold_funds += EXTERNAL1_GURANTEE;
        // external2_hold_funds += EXTERNAL2_GURANTEE;
        // verifySavingsOnHoldBalance(selfSavigsId, self1_hold_funds);
        // verifySavingsOnHoldBalance(externalSavigsId_1, external1_hold_funds);
        // verifySavingsOnHoldBalance(externalSavigsId_2, external2_hold_funds);
        //
        // LOG.info("-----------------------------------UNDO APPROVE LOAN-----------------------------------------");
        // loanStatusHashMap = this.loanTransactionHelper.undoApproval(loanID);
        // LoanStatusChecker.verifyLoanIsPending(loanStatusHashMap);
        // verifySavingsOnHoldBalance(selfSavigsId, Float.valueOf((float) 0));
        // verifySavingsOnHoldBalance(externalSavigsId_1, Float.valueOf((float) 0));
        // verifySavingsOnHoldBalance(externalSavigsId_2, Float.valueOf((float) 0));
        //
        // LOG.info("-----------------------------------APPROVE LOAN-----------------------------------------");
        // loanStatusHashMap = this.loanTransactionHelper.approveLoan(loanDisbursementDate, loanID);
        // LoanStatusChecker.verifyLoanIsApproved(loanStatusHashMap);
        // LoanStatusChecker.verifyLoanIsWaitingForDisbursal(loanStatusHashMap);
        // verifySavingsOnHoldBalance(selfSavigsId, self1_hold_funds);
        // verifySavingsOnHoldBalance(externalSavigsId_1, external1_hold_funds);
        // verifySavingsOnHoldBalance(externalSavigsId_2, external2_hold_funds);
        //
        // LOG.info("-------------------------------DISBURSE LOAN-------------------------------------------");
        // String loanDetails = this.loanTransactionHelper.getLoanDetails(this.requestSpec, this.responseSpec, loanID);
        // loanStatusHashMap = this.loanTransactionHelper.disburseLoanWithNetDisbursalAmount(loanDisbursementDate,
        //// loanID,
        // JsonPath.from(loanDetails).get("netDisbursalAmount").toString());
        // LoanStatusChecker.verifyLoanIsActive(loanStatusHashMap);
        //
        // // First repayment
        // ArrayList<HashMap> loanSchedule = this.loanTransactionHelper.getLoanRepaymentSchedule(this.requestSpec,
        //// this.responseSpec, loanID);
        // todaysDate = Calendar.getInstance();
        // todaysDate.add(Calendar.DAY_OF_MONTH, -7 * 3);
        // String loanRepaymentDate = dateFormat.format(todaysDate.getTime());
        // Float totalDueForCurrentPeriod = (Float) loanSchedule.get(1).get("totalDueForPeriod");
        // external1_hold_funds -= Float.valueOf((float) 827.5867);
        // external2_hold_funds -= Float.valueOf((float) 413.7933);
        // this.loanTransactionHelper.makeRepayment(loanRepaymentDate, totalDueForCurrentPeriod, loanID);
        // verifySavingsOnHoldBalance(selfSavigsId, self1_hold_funds);
        // verifySavingsOnHoldBalance(externalSavigsId_1, external1_hold_funds);
        // verifySavingsOnHoldBalance(externalSavigsId_2, external2_hold_funds);
        //
        // // Second repayment
        // todaysDate = Calendar.getInstance();
        // todaysDate.add(Calendar.DAY_OF_MONTH, -7 * 2);
        // loanRepaymentDate = dateFormat.format(todaysDate.getTime());
        // totalDueForCurrentPeriod = (Float) loanSchedule.get(2).get("totalDueForPeriod");
        // external1_hold_funds -= Float.valueOf((float) 831.4067);
        // external2_hold_funds -= Float.valueOf((float) 415.7033333);
        // this.loanTransactionHelper.makeRepayment(loanRepaymentDate, totalDueForCurrentPeriod, loanID);
        // verifySavingsOnHoldBalance(selfSavigsId, self1_hold_funds);
        // verifySavingsOnHoldBalance(externalSavigsId_1, external1_hold_funds);
        // verifySavingsOnHoldBalance(externalSavigsId_2, external2_hold_funds);
        //
        // // third repayment
        // todaysDate = Calendar.getInstance();
        // todaysDate.add(Calendar.DAY_OF_MONTH, -7);
        // loanRepaymentDate = dateFormat.format(todaysDate.getTime());
        // totalDueForCurrentPeriod = (Float) loanSchedule.get(3).get("totalDueForPeriod");
        // self1_hold_funds -= Float.valueOf((float) 741.355);
        // this.loanTransactionHelper.makeRepayment(loanRepaymentDate, totalDueForCurrentPeriod, loanID);
        // verifySavingsOnHoldBalance(selfSavigsId, self1_hold_funds);
        // verifySavingsOnHoldBalance(externalSavigsId_1, Float.valueOf((float) 0));
        // verifySavingsOnHoldBalance(externalSavigsId_2, Float.valueOf((float) 0));
        //
        // // forth repayment
        // todaysDate = Calendar.getInstance();
        // loanRepaymentDate = dateFormat.format(todaysDate.getTime());
        // totalDueForCurrentPeriod = (Float) loanSchedule.get(3).get("totalDueForPeriod");
        // this.loanTransactionHelper.makeRepayment(loanRepaymentDate, totalDueForCurrentPeriod, loanID);
        // verifySavingsOnHoldBalance(selfSavigsId, Float.valueOf((float) 0));
        // verifySavingsOnHoldBalance(externalSavigsId_1, Float.valueOf((float) 0));
        // verifySavingsOnHoldBalance(externalSavigsId_2, Float.valueOf((float) 0));
        //
        // loanStatusHashMap = LoanStatusChecker.getStatusOfLoan(this.requestSpec, this.responseSpec, loanID);
        // LoanStatusChecker.verifyLoanAccountIsClosed(loanStatusHashMap);
    }

    private Integer createLoanProductWithHoldFunds(final String mandatoryGuarantee, final String minimumGuaranteeFromGuarantor,
        final String minimumGuaranteeFromOwnFunds) throws IOException {

      log.info("------------------------------CREATING NEW LOAN PRODUCT ---------------------------------------");

      PostLoanProductsRequest request = new PostLoanProductsRequest();
      request.setName("Test Loan Product");
      request.setShortName("TLP");
      request.setDescription("Product created from test builder");
      request.setLocale("en_GB");
      request.setDateFormat("dd MMMM yyyy");

      request.setPrincipal(10000.00);
      request.setMinPrincipal(5000.00);
      request.setMaxPrincipal(15000.00);

      request.setNumberOfRepayments(4);
      request.setRepaymentEvery(1);
      request.setRepaymentFrequencyType(2L);

      request.setInterestRatePerPeriod(2.0);
      request.setMinInterestRatePerPeriod(0.0);
      request.setMaxInterestRatePerPeriod(23.4);
      request.setInterestRateFrequencyType(2);

      request.setAmortizationType(1);
      request.setInterestType(0);
      request.setInterestCalculationPeriodType(1);

      request.setCurrencyCode("USD");
      request.setDigitsAfterDecimal(2);

      request.setHoldGuaranteeFunds(true);
      request.setMultiDisburseLoan(false);

      request.setInstallmentAmountInMultiplesOf(1);
      request.setInMultiplesOf(1);
      request.setAllowPartialPeriodInterestCalcualtion(true);
      request.setDaysInMonthType(1);
      request.setDaysInYearType(1);
      request.setEnableAccrualActivityPosting(false);

      final Call<PostLoanProductsResponse> createLoanProduct = FineractClientHelper.getFineractClient().loanProducts.createLoanProduct(request);
      final Response<PostLoanProductsResponse> response = createLoanProduct.execute();

      if (response.isSuccessful() && response.body() != null) {
        return response.body().getResourceId().intValue();
      }

      final String error = response.errorBody() != null ? response.errorBody().string() : "No error body";
      fail("Loan Product creation failed. HTTP Code: " + response.code() + ", Error: " + error);

      return Integer.MIN_VALUE;
    }

    private Integer openSavingsAccount(final PostSavingsAccountsRequest savingsRequest, final String selfBalanceVal) throws IOException {
        final Call<PostSavingsAccountsResponse> callSavingsAccount = FineractClientHelper.getFineractClient().savingsAccounts
                .submitApplication2(savingsRequest);
        final Response<PostSavingsAccountsResponse> response = callSavingsAccount.execute();

        if (response.isSuccessful() && response.body() != null) {
            return response.body().getSavingsId().intValue();
        }

        final String error = response.errorBody() != null ? response.errorBody().string() : "No error body";
        fail("Savings Account creation failed. HTTP Code: " + response.code() + ", Error: " + error);

        return Integer.MIN_VALUE;
    }

    private GetClientsClientIdResponse verifyClientCreated(final Long clientID, final Boolean staffInSelectedOfficeOnly) throws IOException {
        final Call<GetClientsClientIdResponse> verifyCall = FineractClientHelper.getFineractClient().clients
                .retrieveOne11(clientID.longValue(), false);

        final Response<GetClientsClientIdResponse> verifyResponse = verifyCall.execute();
        if (verifyResponse.isSuccessful() && verifyResponse.body() != null) {
            log.info("Client verification successful: {}", verifyResponse.body());
        } else {
            fail("Client verification failed. HTTP Code: " + verifyResponse.code());
        }
        return verifyResponse.body();
    }

    private Integer createClient(final PostClientsRequest request) throws IOException {
        final Call<PostClientsResponse> callClient = FineractClientHelper.getFineractClient().clients.create6(request);
        final Response<PostClientsResponse> response = callClient.execute();

        if (response.isSuccessful() && response.body() != null) {
            return response.body().getClientId().intValue();
        }

        final String error = response.errorBody() != null ? response.errorBody().string() : "No error body";
        fail("Client creation failed. HTTP Code: " + response.code() + ", Error: " + error);

        return Integer.MIN_VALUE;
    }
}
