package com.company.annuityformula.api;

import java.math.BigDecimal;

/**
 * Created by t.makari on 4/7/2019.
 * <p>
 *     InitialOutstandingPrincipal is calculated by the following
 *     formula InitOut = initialOutstandingPrincipal - principal
 *
 * </p>
 *
 */
public interface InitialOutstandingPrincipalStrategy {

    /**
     * @param initialOutstandingPrincipal is loan amount value in every period
     * @param principal is calculated calculated by the following.
     *               Principal= Annuity - Interest
     * @return
     */
    BigDecimal calculate(BigDecimal initialOutstandingPrincipal, BigDecimal principal);
}
