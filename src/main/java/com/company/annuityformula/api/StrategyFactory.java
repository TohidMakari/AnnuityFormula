package com.company.annuityformula.api;


import com.company.annuityformula.impl.*;

/**
 * Created by t.makari on 4/7/2019.
 * <p>
 *      a factory for RepaymentPlanGenerator
 *      because there is two package API and Impl and client should access to
 *      api, this class created to create instantiate for client.
 *
 * </p>
 */
public final class StrategyFactory {


    private static final InitialOutstandingPrincipalStrategy initialOutstandingPrincipal = new InitialOutstandingPrincipalStrategyImpl();

    private static final PrincipalStrategy principalStrategy = new PrincipalStrategyImpl();

    private static final InterestStrategy interestStrategy = new InterestStrategyImpl();

    private static final RemainingOutstandingPrincipalStrategy remainStrategy = new RemainingOutstandingPrincipalStrategyImpl();

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<T> tClass) {
        if (tClass == AnnuityFormula.class) {
            return (T) new AnnuityFormulaImpl( new PresentValueFormulaCalculatorImpl(new FutureValueFormulaCalculatorImpl()));
        }

        if (tClass == PresentValueFormulaCalculator.class) {
            return (T) new PresentValueFormulaCalculatorImpl(new FutureValueFormulaCalculatorImpl());
        }

        if (tClass == InitialOutstandingPrincipalStrategy.class) {
            return (T) initialOutstandingPrincipal;
        }

        if (tClass == PrincipalStrategy.class) {
            return (T) principalStrategy;
        }

        if (tClass == InterestStrategy.class) {
            return (T) interestStrategy;
        }

        if (tClass == RemainingOutstandingPrincipalStrategy.class) {
            return (T) remainStrategy;
        }

        if (tClass == RepaymentPlanGenerator.class) {
            RepaymentPlanGeneratorImpl repaymentPlanStrategy = new RepaymentPlanGeneratorImpl();
            repaymentPlanStrategy.setAnnuityFormula(new AnnuityFormulaImpl( new PresentValueFormulaCalculatorImpl(new FutureValueFormulaCalculatorImpl())));
            repaymentPlanStrategy.setInitialOutstandingPrincipal(initialOutstandingPrincipal);
            repaymentPlanStrategy.setInterestCalculationStrategy(interestStrategy);
            repaymentPlanStrategy.setPrincipalStrategy(principalStrategy);
            repaymentPlanStrategy.setRemainingOutstandingPrincipalStrategy(remainStrategy);
            repaymentPlanStrategy.setInterestThresholdRule(new InterestThresholdRuleImpl());
            return (T) repaymentPlanStrategy;
        }

        throw new IllegalArgumentException("no class of input type found");
    }
}
