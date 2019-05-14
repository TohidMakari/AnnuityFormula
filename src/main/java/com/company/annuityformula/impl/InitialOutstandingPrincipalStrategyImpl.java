package com.company.annuityformula.impl;


import com.company.annuityformula.api.CalculationContract;
import com.company.annuityformula.api.InitialOutstandingPrincipalStrategy;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by t.makari on 4/7/2019.
 */
public class InitialOutstandingPrincipalStrategyImpl implements InitialOutstandingPrincipalStrategy {
    /**
     * @param initialOutstandingPrincipal is loan amount value in every period
     * @param principal     calculated calculated by the following.
     *                      Principal= Annuity - Interest
     * @return
     */
    @Override
    public BigDecimal calculate(BigDecimal initialOutstandingPrincipal, BigDecimal principal) {

        Objects.requireNonNull(initialOutstandingPrincipal);
        Objects.requireNonNull(principal);

        return initialOutstandingPrincipal.subtract(principal)
                .setScale(2, CalculationContract.getRoundingMode());
    }
}
