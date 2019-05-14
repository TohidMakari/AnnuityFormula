package com.company.annuityformula.impl;



import com.company.annuityformula.api.CalculationContract;
import com.company.annuityformula.api.RemainingOutstandingPrincipalStrategy;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by t.makari on 4/7/2019.
 *  */
public class RemainingOutstandingPrincipalStrategyImpl implements RemainingOutstandingPrincipalStrategy {

    /**
     * @param remaining rmaining outstanding principal
     * @param principal calculated from principal formula
     * @return
     */
    @Override
    public BigDecimal calculate(BigDecimal remaining, BigDecimal principal){

        Objects.requireNonNull(remaining);
        Objects.requireNonNull(principal);

        return remaining.subtract(principal)
                .setScale(2, CalculationContract.getRoundingMode());
    }
}
