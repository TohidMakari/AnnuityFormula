package com.company.annuityformula.impl;

import com.company.annuityformula.api.AnnuityFormula;
import com.company.annuityformula.api.CalculationContract;
import com.company.annuityformula.api.Interest;
import com.company.annuityformula.api.PresentValueFormulaCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * Created by t.makari on 4/7/2019.
 */
public class AnnuityFormulaImpl implements AnnuityFormula {


    private PresentValueFormulaCalculator presentValueFormulaCalculator;

    public AnnuityFormulaImpl(PresentValueFormulaCalculator presentValueFormulaCalculator) {
        this.presentValueFormulaCalculator = presentValueFormulaCalculator;
    }

    /**
     * @param pv present value
     * @param r interest rate
     * @param period # period (n)
     * @param n duration
     * @return
     */
    @Override
    public BigDecimal calculate(BigDecimal pv,
                                Interest r,
                                Integer period,
                                Integer n) {

        Objects.requireNonNull(pv);
        Objects.requireNonNull(r);
        Objects.requireNonNull(period);
        Objects.requireNonNull(n);

        n = n - period + 1;

        BigDecimal value=(BigDecimal.valueOf(Math.pow((BigDecimal.ONE.add(r.getInterestPerPeriod())).doubleValue(),n*-1)));
        BigDecimal down=((BigDecimal.ONE.subtract(value)).divide(r.getInterestPerPeriod(), CalculationContract.getMathContext())).abs();
        pv=presentValueFormulaCalculator.calculate(r.getTotalInterest(),pv,n);
        BigDecimal result= pv.divide(down,CalculationContract.getMathContext()).setScale(2,RoundingMode.HALF_EVEN);

        return result;
    }
}
