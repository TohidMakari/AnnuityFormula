package com.company.annuityformula.api;

import java.math.BigDecimal;

/**
 * Created by t.makari on 4/7/2019.
 * <p>
 *     Future value (a.k.a FV) is presented by the following formula FV = C0 * (1 + r)^n
 * </p>
 * @see PresentValueFormulaCalculator
 * @see AnnuityFormula
 * @see RepaymentPlanGenerator
 */
public interface FutureValueFormulaCalculator {

    /**
     * @param ratePerPeriod (r)
     * @param presentValue calculated value for last month
     * @param duration number of periods (n)
     * @return calculated future value (FV)
     */
    BigDecimal calculate(BigDecimal ratePerPeriod,
                         BigDecimal presentValue,
                         Integer duration);

}
