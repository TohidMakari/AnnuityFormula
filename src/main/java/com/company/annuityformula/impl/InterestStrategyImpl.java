package com.company.annuityformula.impl;



import com.company.annuityformula.api.CalculationContract;
import com.company.annuityformula.api.InterestStrategy;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by t.makari on 4/7/2019.
 */
public class InterestStrategyImpl implements InterestStrategy {


    /**
     * @param nominalInterestRate       interest rate
     * @param initOutstandingPrincipal  loan amount value in every period
     * @return
     */
    @Override
    public BigDecimal calculate( BigDecimal nominalInterestRate, BigDecimal initOutstandingPrincipal) {
        Objects.requireNonNull(nominalInterestRate);
        Objects.requireNonNull(initOutstandingPrincipal);

        return (nominalInterestRate.multiply(BigDecimal.valueOf(30L))
                .multiply(initOutstandingPrincipal)).divide(BigDecimal.valueOf(360), CalculationContract.getMathContext())
                .setScale(2, CalculationContract.getRoundingMode());
    }
}
