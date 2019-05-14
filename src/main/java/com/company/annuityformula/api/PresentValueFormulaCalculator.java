package com.company.annuityformula.api;

import java.math.BigDecimal;

/**
 * Created by t.makari on 4/7/2019.
 * <p>
 *      PresentValue Formula is calculated by the following formula
 *      PresentValue = FV * (1/ (1+r)^n
 * </p>
 */
public interface PresentValueFormulaCalculator {

    /**
     * @param ratePerPeriod rate of each month
     * @param futureValue calculated value from  future formula (FV)
     * @param periodN # # of Periods (n)
     * @return
     */
    BigDecimal calculate(BigDecimal ratePerPeriod,
                         BigDecimal futureValue,
                         Integer periodN);




}
