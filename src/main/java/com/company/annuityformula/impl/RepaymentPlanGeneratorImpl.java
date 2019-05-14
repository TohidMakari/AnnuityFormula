package com.company.annuityformula.impl;



import com.company.annuityformula.api.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * Created by t.makari on 4/7/2019.
 */
public class RepaymentPlanGeneratorImpl implements RepaymentPlanGenerator {

    private InterestThresholdRule interestThresholdRule;
    private AnnuityFormula annuityFormula;

    private InitialOutstandingPrincipalStrategy initialOutstandingPrincipal;

    private PrincipalStrategy principalStrategy;

    private InterestStrategy interestCalculationStrategy;

    private RemainingOutstandingPrincipalStrategy remainingOutstandingPrincipalStrategy;


    @Override
    public PaymentPlan createRepaymentPlan(BigDecimal loanAmount,
                                           BigDecimal nominalInterestRate,
                                           Duration duration,
                                           LocalDateTime startDate) {
        PaymentPlan paymentPlan = new PaymentPlan();
        IntStream.rangeClosed(1, duration.getDurationInMonth()).forEach(period -> {
            MonthlyPaymentPlan monthlyRepaymentPlan = createMonthlyRepaymentPlan(loanAmount,
                    nominalInterestRate,
                    previousPeriod(paymentPlan) == null ? null : previousPeriod(paymentPlan).getAnnuity(),
                    startDate,
                    previousPeriod(paymentPlan),
                    period,
                    duration.getDurationInMonth());
            paymentPlan.addMonthlyPaymentPlan(monthlyRepaymentPlan);

        });
        return paymentPlan;

    }

    private MonthlyPaymentPlan previousPeriod(PaymentPlan paymentPlan) {
        if (paymentPlan.getMonthlyPaymentPlans().size() == 0)
            return null;

        int previousMonthIndex = paymentPlan.getMonthlyPaymentPlans().size() - 1;
        previousMonthIndex = previousMonthIndex >= 0 ? previousMonthIndex : 0;

        return paymentPlan.getMonthlyPaymentPlans().get(previousMonthIndex);
    }

    private MonthlyPaymentPlan createMonthlyRepaymentPlan(BigDecimal loanAmount,
                                                          BigDecimal nominalInterestRate,
                                                          BigDecimal annuity,
                                                          LocalDateTime startDate,
                                                          MonthlyPaymentPlan previousMonthPlan,
                                                          Integer period,
                                                          Integer duration) {


        if(isInitialMonthlyPlan(annuity, previousMonthPlan))
        {
            return createInitialMonthlyRepaymentPlan(loanAmount,nominalInterestRate,startDate,period,duration);
        }

        MonthlyPaymentPlan plan = new MonthlyPaymentPlan();

        plan.setDate(startDate.plusMonths(period));
        plan.setInitOutstandingPrincipal(previousMonthPlan.getRemainOutstandingPrincipal());
        plan.setInterest(interestCalculationStrategy.calculate(nominalInterestRate,plan.getInitOutstandingPrincipal()));
        plan.setAnnuity(annuityFormula.calculate(plan.getInitOutstandingPrincipal()
                ,new Interest(nominalInterestRate),period, duration));
        plan.setPrincipal(principalStrategy.calculate(plan.getAnnuity()
                ,interestThresholdRule.getValue(plan.getInterest(),plan.getInitOutstandingPrincipal())));

        plan.setRemainOutstandingPrincipal(remainingOutstandingPrincipalStrategy
                .calculate(plan.getInitOutstandingPrincipal(),plan.getPrincipal()));

        return plan;
    }

    private boolean isInitialMonthlyPlan(BigDecimal annuity, MonthlyPaymentPlan previousMonthPlan) {
        return annuity == null && previousMonthPlan == null;
    }

    private MonthlyPaymentPlan createInitialMonthlyRepaymentPlan(BigDecimal loanAmount,
                                                                 BigDecimal nominalInterestRate,
                                                                 LocalDateTime startDate,
                                                                 Integer period,
                                                                 Integer duration){

        MonthlyPaymentPlan plan = new MonthlyPaymentPlan();

        plan.setDate(startDate.plusMonths(period));
        BigDecimal calculatedInitialOutstandingPrincipal = this.initialOutstandingPrincipal.calculate(loanAmount, BigDecimal.ZERO);
        BigDecimal calculatedInterest = interestCalculationStrategy.calculate(nominalInterestRate, calculatedInitialOutstandingPrincipal);
        BigDecimal calculatedAnnuity = annuityFormula.calculate(loanAmount, new Interest(nominalInterestRate), period, duration);
        BigDecimal calculatedPrincipal = principalStrategy.calculate(calculatedAnnuity,
                interestThresholdRule.getValue(calculatedInterest,calculatedInitialOutstandingPrincipal));
        BigDecimal calculatedRemainOutStandingPrincipal = remainingOutstandingPrincipalStrategy
                .calculate(calculatedInitialOutstandingPrincipal,calculatedPrincipal);


        plan.setPrincipal(calculatedPrincipal);
        plan.setInitOutstandingPrincipal(calculatedInitialOutstandingPrincipal);
        plan.setInterest(calculatedInterest);
        plan.setAnnuity(calculatedAnnuity);
        plan.setRemainOutstandingPrincipal(calculatedRemainOutStandingPrincipal);

        return plan;
    }


    public RepaymentPlanGeneratorImpl() {
    }

    public RepaymentPlanGeneratorImpl(AnnuityFormula annuityFormula,
                                      InitialOutstandingPrincipalStrategy initialOutstandingPrincipal,
                                      PrincipalStrategy principalStrategy,
                                      InterestStrategy interestCalculationStrategy,
                                      RemainingOutstandingPrincipalStrategy remainingOutstandingPrincipalStrategy,
                                      InterestThresholdRule interestThresholdRule) {

        Objects.requireNonNull(annuityFormula);
        Objects.requireNonNull(initialOutstandingPrincipal);
        Objects.requireNonNull(principalStrategy);
        Objects.requireNonNull(interestCalculationStrategy);
        Objects.requireNonNull(remainingOutstandingPrincipalStrategy);
        Objects.requireNonNull(interestThresholdRule);

        this.annuityFormula = annuityFormula;
        this.initialOutstandingPrincipal = initialOutstandingPrincipal;
        this.principalStrategy = principalStrategy;
        this.interestCalculationStrategy = interestCalculationStrategy;
        this.remainingOutstandingPrincipalStrategy = remainingOutstandingPrincipalStrategy;
        this.interestThresholdRule = interestThresholdRule;
    }

    public AnnuityFormula getAnnuityFormula() {
        return annuityFormula;
    }

    public void setAnnuityFormula(AnnuityFormula annuityFormula) {
        this.annuityFormula = annuityFormula;
    }

    public InitialOutstandingPrincipalStrategy getInitialOutstandingPrincipal() {
        return initialOutstandingPrincipal;
    }

    public void setInitialOutstandingPrincipal(InitialOutstandingPrincipalStrategy initialOutstandingPrincipal) {
        this.initialOutstandingPrincipal = initialOutstandingPrincipal;
    }

    public PrincipalStrategy getPrincipalStrategy() {
        return principalStrategy;
    }

    public void setPrincipalStrategy(PrincipalStrategy principalStrategy) {
        this.principalStrategy = principalStrategy;
    }

    public InterestStrategy getInterestCalculationStrategy() {
        return interestCalculationStrategy;
    }

    public void setInterestCalculationStrategy(InterestStrategy interestCalculationStrategy) {
        this.interestCalculationStrategy = interestCalculationStrategy;
    }

    public RemainingOutstandingPrincipalStrategy getRemainingOutstandingPrincipalStrategy() {
        return remainingOutstandingPrincipalStrategy;
    }

    public void setRemainingOutstandingPrincipalStrategy(RemainingOutstandingPrincipalStrategy remainingOutstandingPrincipalStrategy) {
        this.remainingOutstandingPrincipalStrategy = remainingOutstandingPrincipalStrategy;
    }

    public InterestThresholdRule getInterestThresholdRule() {
        return interestThresholdRule;
    }

    public void setInterestThresholdRule(InterestThresholdRule interestThresholdRule) {
        this.interestThresholdRule = interestThresholdRule;
    }
}
