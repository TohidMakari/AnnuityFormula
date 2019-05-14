package com.company;


import com.company.annuityformula.api.FutureValueFormulaCalculator;

import java.math.BigDecimal;

/**
 * Created by t.makari on 4/8/2019.
 */
public class FutureValueStub implements FutureValueFormulaCalculator {
    @Override
    public BigDecimal calculate(BigDecimal ratePerPeriod, BigDecimal presentValue, Integer duration) {
        return BigDecimal.valueOf(5020.84);
    }
}
