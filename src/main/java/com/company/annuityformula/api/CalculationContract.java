package com.company.annuityformula.api;

import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by t.makari on 4/7/2019.
 * <p>
 *     define a standard of calculation for formula that used in whole project
 *
 * </p>
 *
 */
public class CalculationContract {

    public static RoundingMode getRoundingMode(){
        return RoundingMode.HALF_EVEN;
    }

    public static MathContext getMathContext(){
        return MathContext.DECIMAL128;
    }
}
