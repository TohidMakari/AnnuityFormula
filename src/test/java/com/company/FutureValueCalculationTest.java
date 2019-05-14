package com.company;


import com.company.annuityformula.api.FutureValueFormulaCalculator;
import com.company.annuityformula.api.Interest;
import com.company.annuityformula.impl.FutureValueFormulaCalculatorImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by t.makari on 4/8/2019.
 */
public class FutureValueCalculationTest {

    private FutureValueFormulaCalculator futureValueFormulaCalculator;

    @Before
    public void setup(){
        futureValueFormulaCalculator  = new FutureValueFormulaCalculatorImpl();
    }

    @Test
    public void futureValueCalculatorShouldReturnCorrectResultWithGivenInput()
    {
        //given
        BigDecimal loanAmount = BigDecimal.valueOf(5000);
        BigDecimal nominalInterestRate = BigDecimal.valueOf(0.05);
        Integer period = 1;
        Interest interest = new Interest(nominalInterestRate);

        //when
        BigDecimal calculatedFutureValue = futureValueFormulaCalculator
                .calculate(interest.getInterestPerPeriod(), loanAmount, period);

        //then
        System.out.println(calculatedFutureValue);
        Assert.assertTrue(calculatedFutureValue.equals(BigDecimal.valueOf(5020.84)));
    }
}
