package com.company.annuityformula.api;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by t.makari on 4/7/2019.
 * <p>
 *      a class for calculate each of PaymentPlan monthly
 * </p>
 *
 */
public class MonthlyPaymentPlan {
    private LocalDateTime date;
    private BigDecimal annuity;
    private BigDecimal principal;
    private BigDecimal interest;
    private BigDecimal initOutstandingPrincipal;
    private BigDecimal remainOutstandingPrincipal;

    public static MonthlyPaymentPlan initial(BigDecimal initOutstandingPrincipal)
    {
        MonthlyPaymentPlan initialMonthlyPlan = new MonthlyPaymentPlan();
        initialMonthlyPlan.initOutstandingPrincipal = initOutstandingPrincipal;
        return initialMonthlyPlan;
    }

    public MonthlyPaymentPlan(){}

    public MonthlyPaymentPlan(LocalDateTime date, BigDecimal annuity, BigDecimal principal, BigDecimal interest, BigDecimal initOutstandingPrincipal, BigDecimal remainOutstandingPrincipal) {
        this.date = date;
        this.annuity = annuity;
        this.principal = principal;
        this.interest = interest;
        this.initOutstandingPrincipal = initOutstandingPrincipal;
        this.remainOutstandingPrincipal = remainOutstandingPrincipal;
    }

    @Override
    public String toString() {
        return "MonthlyPaymentPlan{" +
                "annuity=" + annuity +
                ", principal=" + principal +
                ", interest=" + interest +
                ", initOutstandingPrincipal=" + initOutstandingPrincipal +
                ", remainOutstandingPrincipal=" + remainOutstandingPrincipal +
                '}';
    }

    public LocalDateTime getDate() {

        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getAnnuity() {
        return annuity;
    }

    public void setAnnuity(BigDecimal annuity) {
        this.annuity = annuity;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getInitOutstandingPrincipal() {
        return initOutstandingPrincipal;
    }

    public void setInitOutstandingPrincipal(BigDecimal initOutstandingPrincipal) {
        this.initOutstandingPrincipal = initOutstandingPrincipal;
    }

    public BigDecimal getRemainOutstandingPrincipal() {
        return remainOutstandingPrincipal;
    }

    public void setRemainOutstandingPrincipal(BigDecimal remainOutstandingPrincipal) {
        this.remainOutstandingPrincipal = remainOutstandingPrincipal;
    }
}
