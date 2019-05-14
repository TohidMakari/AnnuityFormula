package com.company.annuityformula.api;

import java.math.BigDecimal;

/**
 * Created by t.makari on 4/7/2019.
 */
public interface RemainingOutstandingPrincipalStrategy {

    BigDecimal calculate(BigDecimal initialOutstandingPrincipal, BigDecimal principal);
}
