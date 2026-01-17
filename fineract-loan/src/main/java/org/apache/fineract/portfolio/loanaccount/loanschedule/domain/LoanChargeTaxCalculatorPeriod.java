package org.apache.fineract.portfolio.loanaccount.loanschedule.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import lombok.Getter;
import org.apache.fineract.organisation.monetary.domain.Money;
import org.apache.fineract.portfolio.loanaccount.domain.LoanInterestRecalcualtionAdditionalDetails;
import org.apache.fineract.portfolio.loanaccount.loanschedule.data.LoanSchedulePeriodData;

@Getter
public class LoanChargeTaxCalculatorPeriod implements LoanScheduleModelPeriod {

  private final Integer periodNumber;
  private final LocalDate periodDate;
  private final Money taxDue;

  public static LoanChargeTaxCalculatorPeriod taxPayment(final Integer periodNumber, final LocalDate periodDate,
                                                               final Money taxDue) {

    return new LoanChargeTaxCalculatorPeriod(periodNumber, periodDate, taxDue);
  }

  public LoanChargeTaxCalculatorPeriod(Integer periodNumber, LocalDate periodDate, Money taxDue) {
    this.periodNumber = periodNumber;
    this.periodDate = periodDate;
    this.taxDue = taxDue;
  }

  @Override
  public LoanSchedulePeriodData toData() {
    return LoanSchedulePeriodData.taxData(this.periodDate, this.taxDue.getAmount());
  }

  @Override
  public boolean isRepaymentPeriod() {
    return false;
  }

  @Override
  public boolean isDownPaymentPeriod() {
    return false;
  }

  @Override
  public Integer periodNumber() {
    return null;
  }

  @Override
  public LocalDate periodFromDate() {
    return null;
  }

  @Override
  public LocalDate periodDueDate() {
    return null;
  }

  @Override
  public BigDecimal principalDue() {
    return null;
  }

  @Override
  public BigDecimal interestDue() {
    return null;
  }

  @Override
  public BigDecimal feeChargesDue() {
    return null;
  }

  @Override
  public BigDecimal penaltyChargesDue() {
    return null;
  }

  @Override
  public void addLoanCharges(BigDecimal feeCharge, BigDecimal penaltyCharge) {

  }

  @Override
  public boolean isRecalculatedInterestComponent() {
    return false;
  }

  @Override
  public void addPrincipalAmount(Money principalDue) {

  }

  @Override
  public void addInterestAmount(Money interestDue) {

  }

  @Override
  public Set<LoanInterestRecalcualtionAdditionalDetails> getLoanCompoundingDetails() {
    return Set.of();
  }

  @Override
  public void setEMIFixedSpecificToInstallmentTrue() {

  }

  @Override
  public boolean isEMIFixedSpecificToInstallment() {
    return false;
  }

  @Override
  public BigDecimal rescheduleInterestPortion() {
    return null;
  }

  @Override
  public void setRescheduleInterestPortion(BigDecimal rescheduleInterestPortion) {

  }
}
