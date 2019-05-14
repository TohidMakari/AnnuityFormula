package com.company.annuityformula.api;

import java.math.BigDecimal;

/**
 * Created by t.makari on 4/7/2019.
 * <p>
 *     Principal is calculated by the following
 *     formula Principal = Annuity - Interest
 *
 * </p>
 *
 */
public interface PrincipalStrategy {

    /**
     * @param annuity  calculated annuity formula
     * @param interest intrest rate
     * @return
     */
    BigDecimal calculate(BigDecimal annuity, BigDecimal interest);
}
