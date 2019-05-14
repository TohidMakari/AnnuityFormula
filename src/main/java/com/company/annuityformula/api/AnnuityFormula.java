package com.company.annuityformula.api;

import java.math.BigDecimal;

/**
 * Created by t.makari on 4/7/2019.
 * <p>
 *     Annuity formula (a.k.a Annuity) is presented by the following formula Annuity = [PV / (1-(1+r)^n/r)]
 * </p>
 *
 */
public interface AnnuityFormula {


    /**
     * @param presentValue that calculate from PresentValueFormula (PV)
     * @param nominalRate
     * @param period
     *@param numberOfPeriods  @return
     */
    BigDecimal calculate(BigDecimal presentValue,
                         Interest nominalRate,
                         Integer period, Integer numberOfPeriods);

}
