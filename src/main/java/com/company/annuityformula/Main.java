package com.company.annuityformula;


import com.company.annuityformula.api.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by t.makari on 4/7/2019.
 */
public class Main {


    public static void main(String[] args) {

        BigDecimal loanAmount = BigDecimal.valueOf(5000);
        BigDecimal nominalInterestRate = BigDecimal.valueOf(0.05);
        LocalDateTime startDate = LocalDateTime.now();
        int duration = 2;

        PaymentPlan paymentPlan = StrategyFactory.getInstance(RepaymentPlanGenerator.class)
                .createRepaymentPlan(loanAmount,
                        nominalInterestRate,
                        Duration.of(duration),
                        startDate
        );

        int counter = 1;
        for (MonthlyPaymentPlan monthlyPaymentPlan : paymentPlan.getMonthlyPaymentPlans()) {
            System.out.println(counter + " -> "+ monthlyPaymentPlan.toString());
            counter++;
        }


    }
}
