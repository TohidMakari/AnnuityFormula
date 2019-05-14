package com.company.annuityformula.api;

import java.math.BigDecimal;

/**
 * Created by t.makari on 4/7/2019.
 * <p>
 *      interest is calculated by the following formula
 *      Interest = (Nominal-Rate * Days in Month * Initial Outstanding* Principal) / days in year
 * </p>
 */
public interface InterestStrategy {

    /**
     * @param nominalInterestRate      is interest rate
     * @param initOutstandingPrincipal is loan amount value in every period
     * @return
     */
    BigDecimal calculate(BigDecimal nominalInterestRate, BigDecimal initOutstandingPrincipal);
}
