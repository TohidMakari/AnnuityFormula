package com.company.annuityformula.api;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by t.makari on 4/7/2019.
 * <p>
 *      generator for RepaymentPlan output table
 *
 * </p>
 */
public interface RepaymentPlanGenerator {

    /**
     * @param loanAmount initial amount
     * @param nominalInterestRate rate of interest
     * @param duration
     * @param startDate
     * @return
     */
    PaymentPlan createRepaymentPlan(BigDecimal loanAmount,
                                    BigDecimal nominalInterestRate,
                                    Duration duration,
                                    LocalDateTime startDate);
}
