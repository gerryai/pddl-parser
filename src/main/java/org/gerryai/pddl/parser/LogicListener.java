package org.gerryai.pddl.parser;

import com.google.common.base.Optional;
import org.antlr.v4.runtime.misc.NotNull;
import org.gerryai.pddl.model.logic.Constant;
import org.gerryai.pddl.model.logic.Formula;
import org.gerryai.pddl.model.logic.Predicate;
import org.gerryai.pddl.model.logic.Variable;
import org.gerryai.pddl.parser.antlr.PDDL31BaseListener;
import org.gerryai.pddl.parser.antlr.PDDL31Parser;
import org.gerryai.pddl.parser.logic.LogicStackHandler;

import java.util.List;

import static org.gerryai.pddl.model.logic.FormulaBuilder.constant;
import static org.gerryai.pddl.model.logic.FormulaBuilder.variable;

/**
 * Listener for extracting the {@link org.gerryai.pddl.model.Domain} when walking the parse tree of a PDDL domain.
 */
public class LogicListener extends PDDL31BaseListener {

    private LogicStackHandler stackHandler;

    /**
     * Set the logical stack handler.
     * @param stackHandler the stack handler
     */
    public void setStackHandler(final LogicStackHandler stackHandler) {
        this.stackHandler = stackHandler;
    }

    @Override
    public void exitConstant(@NotNull final PDDL31Parser.ConstantContext ctx) {
        stackHandler.term(constant(ctx.NAME().getSymbol().getText()));
    }

    @Override
    public void exitVariable(@NotNull final PDDL31Parser.VariableContext ctx) {
        stackHandler.term(variable(ctx.NAME().getSymbol().getText()));
    }

    @Override public void enterUngroundPredicate(@NotNull final PDDL31Parser.UngroundPredicateContext ctx) {
        stackHandler.beginPredicate();
    }

    @Override
    public void exitPredicateName(@NotNull final PDDL31Parser.PredicateNameContext ctx) {
        stackHandler.symbol(ctx.NAME().getSymbol().getText());
    }

    @Override
    public void exitUngroundPredicate(@NotNull final PDDL31Parser.UngroundPredicateContext ctx) {
        stackHandler.endPredicate();
    }

    @Override public void enterPredicate(@NotNull final PDDL31Parser.PredicateContext ctx) {
        stackHandler.beginPredicate();
    }

    @Override
    public void exitPredicate(@NotNull final PDDL31Parser.PredicateContext ctx) {
        stackHandler.endPredicate();
    }

    @Override
    public void enterNegatedAtomicFormulaTerm(@NotNull final PDDL31Parser.NegatedAtomicFormulaTermContext ctx) {
        stackHandler.beginNot();
    }

    @Override
    public void exitNegatedAtomicFormulaTerm(@NotNull final PDDL31Parser.NegatedAtomicFormulaTermContext ctx) {
        stackHandler.endNot();
    }

    @Override
    public void enterPreGDAnd(@NotNull final PDDL31Parser.PreGDAndContext ctx) {
        stackHandler.beginAnd();
    }

    @Override
    public void exitPreGDAnd(@NotNull final PDDL31Parser.PreGDAndContext ctx) {
        stackHandler.endAnd();
    }

    @Override
    public void enterGoalDescAnd(@NotNull final PDDL31Parser.GoalDescAndContext ctx) {
        stackHandler.beginAnd();
    }

    @Override
    public void exitGoalDescAnd(@NotNull final PDDL31Parser.GoalDescAndContext ctx) {
        stackHandler.endAnd();
    }

    @Override
    public void enterCEffectAnd(@NotNull final PDDL31Parser.CEffectAndContext ctx) {
        stackHandler.beginAnd();
    }

    @Override
    public void exitCEffectAnd(@NotNull final PDDL31Parser.CEffectAndContext ctx) {
        stackHandler.endAnd();
    }

    @Override
    public void enterEquality(@NotNull final PDDL31Parser.EqualityContext ctx) {
        stackHandler.beginEquals();
    }

    @Override
    public void exitEquality(@NotNull final PDDL31Parser.EqualityContext ctx) {
        stackHandler.endEquals();
    }

    /**
     * Get the predicate we just built.
     * @return the predicate
     */
    protected Constant getConstant() {
        return stackHandler.getConstant();
    }

    /**
     * Get the predicate we just built.
     * @return the predicate
     */
    protected Predicate getPredicate() {
        return stackHandler.getPredicate();
    }

    /**
     * Get the formula we just built.
     * @return the predicate
     */
    protected Optional<Formula> getFormula() {
        return stackHandler.getOptionalFormula();
    }

    /**
     * Get the variables we have built.
     * @return the variables
     */
    protected List<Variable> getVariables() {
        return stackHandler.variables();
    }

    /**
     * Check that there are no unclaimed terms or formulas collected.
     * @return true if no terms or formulas are unclaimed
     */
    protected boolean isClean() {
        return stackHandler.isEmpty();
    }
}
