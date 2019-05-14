package com.company.annuityformula.impl;



import com.company.annuityformula.api.CalculationContract;
import com.company.annuityformula.api.FutureValueFormulaCalculator;
import com.company.annuityformula.api.PresentValueFormulaCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * Created by t.makari on 4/7/2019.
 */
public class PresentValueFormulaCalculatorImpl implements PresentValueFormulaCalculator {

    private final FutureValueFormulaCalculator futureValueFormulaCalculator;

    public PresentValueFormulaCalculatorImpl(FutureValueFormulaCalculator futureValueFormulaCalculator) {
        this.futureValueFormulaCalculator = futureValueFormulaCalculator;
    }

    /**
     * @param r
     * @param initialOutstandingPrincipal
     * @param periodN # of Periods (n)
     * @return
     */
    @Override
    public BigDecimal calculate(BigDecimal r,BigDecimal initialOutstandingPrincipal, Integer periodN) {
        Objects.requireNonNull(r);
        Objects.requireNonNull(initialOutstandingPrincipal);
        Objects.requireNonNull(periodN);

        BigDecimal result=(BigDecimal.valueOf(Math.pow((r.setScale(4, RoundingMode.HALF_EVEN).add(BigDecimal.ONE))
                .doubleValue(),periodN)));
        BigDecimal FV =futureValueFormulaCalculator.calculate(r,initialOutstandingPrincipal,periodN);
        return FV.divide(result, CalculationContract.getMathContext()).setScale(2,CalculationContract.getRoundingMode());

    }
}
