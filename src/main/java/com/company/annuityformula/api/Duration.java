package com.company.annuityformula.api;

/**
 * Created by t.makari on 4/7/2019.
 * <p>
 *     define a separate class for calculate of Duration
 * </p>
 *
 */
public class Duration {

    private final int years;

    private Duration(int years){
        this.years = years;
    }

    public static Duration of(int years){
        return new Duration(years);
    }

    public int getDurationInMonth(){
        return this.years * 12;
    }

    public int getDurationInDays()
    {
        return this.years * 12 * 365;
    }
}
