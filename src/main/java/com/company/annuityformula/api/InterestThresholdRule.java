package com.company.annuityformula.api;

import java.math.BigDecimal;

/**
 * It's defined there is a limit on interest, if the limit exceeds threshold (e.g initialOutstandingPrincipal)
 * calculators must use the substitute value instead.
 * @see InterestStrategy
 * @see InitialOutstandingPrincipalStrategy
 * Created by t.makari on 4/7/2019.
 */
public interface InterestThresholdRule {

    /**
     * @param interest calculated interest
     * @param initialOutstandingPrincipal claculated initialOutstandingPrincipal
     * @return
     */
    public BigDecimal getValue(BigDecimal interest, BigDecimal initialOutstandingPrincipal);
}
