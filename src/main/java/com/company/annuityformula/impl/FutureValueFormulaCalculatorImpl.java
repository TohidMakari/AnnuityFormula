package com.company.annuityformula.impl;


import com.company.annuityformula.api.CalculationContract;
import com.company.annuityformula.api.FutureValueFormulaCalculator;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by t.makari on 4/7/2019.
 */
public class FutureValueFormulaCalculatorImpl implements FutureValueFormulaCalculator {

    /**
     * @param r interest rate
     * @param c0 present value
     * @param n duration
     * @return
     */
    @Override
    public BigDecimal calculate(BigDecimal r, BigDecimal c0, Integer n) {

        Objects.requireNonNull(r);
        Objects.requireNonNull(c0);
        Objects.requireNonNull(n);

        BigDecimal calculatedValue=(BigDecimal.valueOf(Math.pow((r.add(BigDecimal.ONE))
                .doubleValue(),n)));
        return c0.multiply(calculatedValue).setScale(2, CalculationContract.getRoundingMode());
    }
}
