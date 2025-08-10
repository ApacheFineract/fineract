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
package org.apache.fineract.portfolio.loanaccount.data;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.fineract.organisation.monetary.data.CurrencyData;
import org.apache.fineract.portfolio.calendar.data.CalendarHistoryDataWrapper;
import org.apache.fineract.portfolio.calendar.domain.Calendar;
import org.apache.fineract.portfolio.calendar.domain.CalendarInstance;
import org.apache.fineract.portfolio.floatingrates.data.FloatingRateDTO;
import org.apache.fineract.portfolio.loanaccount.loanschedule.domain.LoanScheduleGeneratorFactory;

@Getter
@AllArgsConstructor
@Builder
public class ScheduleGeneratorDTO {

    private final LoanScheduleGeneratorFactory loanScheduleFactory;
    private final CurrencyData currency;
    private final LocalDate calculatedRepaymentsStartingFromDate;
    private final HolidayDetailDTO holidayDetailDTO;
    private final CalendarInstance calendarInstanceForInterestRecalculation;
    private final CalendarInstance compoundingCalendarInstance;

    @Setter
    private LocalDate recalculateFrom;
    private LocalDate recalculateTill;
    private final Long overdurPenaltyWaitPeriod;
    private final FloatingRateDTO floatingRateDTO;
    private final Calendar calendar;
    private final CalendarHistoryDataWrapper calendarHistoryDataWrapper;
    private final Boolean isInterestChargedFromDateAsDisbursementDateEnabled;
    private final Integer numberOfdays;
    private final Boolean isSkipRepaymentOnFirstDayofMonth;
    private final Boolean isChangeEmiIfRepaymentDateSameAsDisbursementDateEnabled;
    private final Boolean isFirstRepaymentDateAllowedOnHoliday;
    private final Boolean isInterestToBeRecoveredFirstWhenGreaterThanEMI;
    private final Boolean isPrincipalCompoundingDisabledForOverdueLoans;

    public int getPenaltyWaitPeriod() {
        int penaltyWaitPeriod = 0;
        if (this.overdurPenaltyWaitPeriod != null) {
            penaltyWaitPeriod = this.overdurPenaltyWaitPeriod.intValue();
        }
        return penaltyWaitPeriod;
    }

    public Boolean isInterestChargedFromDateAsDisbursementDateEnabled() {
        return this.isInterestChargedFromDateAsDisbursementDateEnabled;
    }

    public boolean isSkipRepaymentOnFirstDayofMonth() {
        return isSkipRepaymentOnFirstDayofMonth;
    }

    public Boolean isChangeEmiIfRepaymentDateSameAsDisbursementDateEnabled() {
        return this.isChangeEmiIfRepaymentDateSameAsDisbursementDateEnabled;
    }

    public boolean isFirstRepaymentDateAllowedOnHoliday() {
        return isFirstRepaymentDateAllowedOnHoliday;
    }

    public boolean isInterestToBeRecoveredFirstWhenGreaterThanEMI() {
        return isInterestToBeRecoveredFirstWhenGreaterThanEMI;
    }

    public boolean isPrincipalCompoundingDisabledForOverdueLoans() {
        return isPrincipalCompoundingDisabledForOverdueLoans;
    }
}
