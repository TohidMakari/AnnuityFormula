package com.company.annuityformula.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by t.makari on 4/7/2019.
 */
public class PaymentPlan {

    private final List<MonthlyPaymentPlan> monthlyPaymentPlans;

    public PaymentPlan(List<MonthlyPaymentPlan> monthlyPaymentPlans) {
        this.monthlyPaymentPlans = monthlyPaymentPlans;
    }

    public PaymentPlan() {
        this.monthlyPaymentPlans = new ArrayList();
    }

    public void addMonthlyPaymentPlan(MonthlyPaymentPlan monthlyPaymentPlan){
        this.monthlyPaymentPlans.add(monthlyPaymentPlan);
    }

    public List<MonthlyPaymentPlan> getMonthlyPaymentPlans() {
        return monthlyPaymentPlans;
    }
}
