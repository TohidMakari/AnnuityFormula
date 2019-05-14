package com.company;


import com.company.annuityformula.api.*;
import com.company.annuityformula.impl.PresentValueFormulaCalculatorImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by t.makari on 4/8/2019.
 */
public class PresentValueCalculationTest {
    private PresentValueFormulaCalculator presentValueFormulaCalculator;

    @Before
    public void setup(){
        presentValueFormulaCalculator  =
                new PresentValueFormulaCalculatorImpl(new FutureValueStub());
    }

    @Test
    public void presentValueCalculatorShouldReturnCorrectResultWithGivenInput()
    {
        //given
        BigDecimal loanAmount = BigDecimal.valueOf(5000);
        BigDecimal nominalInterestRate = BigDecimal.valueOf(0.05);
        Integer period = 1;
        Interest interest = new Interest(nominalInterestRate);

        //when
        BigDecimal calculatedPresent = presentValueFormulaCalculator
                .calculate(interest.getInterestPerPeriod(), loanAmount, period);

        //then
        Assert.assertTrue(calculatedPresent.equals(BigDecimal.valueOf(4999.84)));
    }
}
