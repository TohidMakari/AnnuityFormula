package com.company;


import com.company.annuityformula.api.PresentValueFormulaCalculator;

import java.math.BigDecimal;

/**
 * Created by t.makari on 4/8/2019.
 */
public class PresentValueStub implements PresentValueFormulaCalculator {
    @Override
    public BigDecimal calculate(BigDecimal ratePerPeriod, BigDecimal futureValue, Integer periodN) {
        return BigDecimal.valueOf(4999.85);
    }
}
