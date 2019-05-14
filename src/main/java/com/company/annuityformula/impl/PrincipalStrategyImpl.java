package com.company.annuityformula.impl;


import com.company.annuityformula.api.PrincipalStrategy;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by t.makari on 4/7/2019.
 */
public class PrincipalStrategyImpl implements PrincipalStrategy {
    /**
     * @param annuity  calculated annuity formula
     * @param interest intrest rate
     * @return
     */
    @Override
    public BigDecimal calculate(BigDecimal annuity, BigDecimal interest) {

        Objects.requireNonNull(annuity);
        Objects.requireNonNull(interest);

        return annuity.subtract(interest);
    }
}
