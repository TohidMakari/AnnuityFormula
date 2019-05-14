package com.company.annuityformula.impl;



import com.company.annuityformula.api.InterestThresholdRule;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by t.makari on 4/7/2019.
 */
public class InterestThresholdRuleImpl implements InterestThresholdRule {
    /**
     * @param interest                    calculated interest
     * @param initialOutstandingPrincipal claculated initialOutstandingPrincipal
     * @return
     */
    @Override
    public BigDecimal getValue(BigDecimal interest, BigDecimal initialOutstandingPrincipal) {

        Objects.requireNonNull(interest);
        Objects.requireNonNull(initialOutstandingPrincipal);

        return interest.compareTo(initialOutstandingPrincipal) > 0? initialOutstandingPrincipal : interest;
    }
}
