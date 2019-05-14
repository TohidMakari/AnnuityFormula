package com.company;


import com.company.annuityformula.api.AnnuityFormula;
import com.company.annuityformula.api.Interest;
import com.company.annuityformula.impl.AnnuityFormulaImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/**
 * Created by t.makari on 4/7/2019.
 */
public class AnnuityTest {


    private AnnuityFormula annuityFormula;


    @Before
    public void setup() {

        annuityFormula = new AnnuityFormulaImpl(new PresentValueStub());

    }

    @Test
    public void annuityFormulaReturnsCorrectResultWithGivenInput() {

        //given
        BigDecimal loanAmount = BigDecimal.valueOf(5000);
        BigDecimal nominalInterestRate = BigDecimal.valueOf(0.05);
        int duration = 24;
        Integer period = 1;

        //when
        Interest interest = new Interest(nominalInterestRate);
        BigDecimal calculatedAnnuity=annuityFormula.calculate(loanAmount,interest,period,duration);

        //then
        System.out.println(calculatedAnnuity);
        Assert.assertTrue(calculatedAnnuity.equals(BigDecimal.valueOf(219.35)));
    }

}
