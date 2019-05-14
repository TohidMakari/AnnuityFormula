package com.company.annuityformula.api;

import java.math.BigDecimal;

/**
 * Created by t.makari on 4/7/2019.
 * <p>
 *     define a separate class for calculate of Interest
 * </p>
 *
 */
public class Interest {
    private BigDecimal interest;

    public Interest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getTotalInterest() {
        return this.interest;
    }

    public BigDecimal getInterestPerPeriod() {
        return this.interest.divide(BigDecimal
                .valueOf(12), CalculationContract.getMathContext()).setScale(6, CalculationContract.getRoundingMode());
    }
}
