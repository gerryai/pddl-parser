/*
 * Gerry AI - Open framework for automated planning
 * Copyright (c) 2014 David Edwards <david@more.fool.me.uk>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gerryai.planning.parser.pddl.internal;

import com.google.common.base.Optional;
import org.antlr.v4.runtime.misc.NotNull;
import org.gerryai.planning.model.domain.FunctionDefinition;
import org.gerryai.planning.model.logic.Constant;
import org.gerryai.planning.model.logic.Formula;
import org.gerryai.planning.model.logic.Predicate;
import org.gerryai.planning.model.logic.Type;
import org.gerryai.planning.model.logic.Variable;
import org.gerryai.planning.parser.pddl.antlr.PDDL31BaseListener;
import org.gerryai.planning.parser.pddl.antlr.PDDL31Parser;
import org.gerryai.planning.parser.pddl.internal.logic.LogicStackHandler;

import java.util.List;

/**
 * Listener for extracting a {@link org.gerryai.planning.model.domain.Domain} when walking the parse tree of a PDDL
 * domain.
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
    public void exitPrimitiveType(@NotNull final PDDL31Parser.PrimitiveTypeContext ctx) {
        stackHandler.type(ctx.NAME().getSymbol().getText().toLowerCase());
    }

    @Override
    public void enterEitherType(@NotNull final PDDL31Parser.EitherTypeContext ctx) {
        stackHandler.beginEitherTypeList();
    }

    @Override
    public void exitEitherType(@NotNull final PDDL31Parser.EitherTypeContext ctx) {
        stackHandler.endEitherTypeList();
    }


    @Override
    public void exitConstant(@NotNull final PDDL31Parser.ConstantContext ctx) {
        stackHandler.addConstant(ctx.NAME().getSymbol().getText().toLowerCase());
    }

    @Override
    public void exitNumber(@NotNull final PDDL31Parser.NumberContext ctx) {
        stackHandler.addNumber(ctx.NUMBER().getSymbol().getText());
    }

    @Override
    public void exitVariable(@NotNull final PDDL31Parser.VariableContext ctx) {
        stackHandler.addVariable(ctx.NAME().getSymbol().getText().toLowerCase());
    }

    @Override
    public void exitTypedVariableListOfType(@NotNull final PDDL31Parser.TypedVariableListOfTypeContext ctx) {
        stackHandler.applyType(getType());
    }

    @Override
    public void enterFunctionDef(@NotNull final PDDL31Parser.FunctionDefContext ctx) {
        stackHandler.beginFunction();
    }

    @Override
    public void exitFunctionDef(@NotNull final PDDL31Parser.FunctionDefContext ctx) {
        stackHandler.endFunction();
    }

    @Override
    public void exitFunctionName(@NotNull final PDDL31Parser.FunctionNameContext ctx) {
        stackHandler.symbol(ctx.NAME().getSymbol().getText().toLowerCase());
    }

    @Override public void enterUngroundPredicate(@NotNull final PDDL31Parser.UngroundPredicateContext ctx) {
        stackHandler.beginPredicate();
    }

    @Override
    public void exitPredicateName(@NotNull final PDDL31Parser.PredicateNameContext ctx) {
        stackHandler.symbol(ctx.NAME().getSymbol().getText().toLowerCase());
    }

    @Override
    public void exitUngroundPredicate(@NotNull final PDDL31Parser.UngroundPredicateContext ctx) {
        stackHandler.endPredicate();
    }

    @Override public void enterPredicateTerm(@NotNull final PDDL31Parser.PredicateTermContext ctx) {
        stackHandler.beginPredicate();
    }

    @Override
    public void exitPredicateTerm(@NotNull final PDDL31Parser.PredicateTermContext ctx) {
        stackHandler.endPredicate();
    }

    @Override public void enterPredicateConstant(@NotNull final PDDL31Parser.PredicateConstantContext ctx) {
        stackHandler.beginPredicate();
    }

    @Override
    public void exitPredicateConstant(@NotNull final PDDL31Parser.PredicateConstantContext ctx) {
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
    public void enterOperation(@NotNull final PDDL31Parser.OperationContext ctx) {
        stackHandler.beginOperation();
    }

    @Override
    public void exitOperation(@NotNull final PDDL31Parser.OperationContext ctx) {
        stackHandler.endOperation();
    }

    @Override
    public void exitOperator(@NotNull final PDDL31Parser.OperatorContext ctx) {
        stackHandler.operator(ctx.getText().toLowerCase());
    }

    @Override
    public void enterFunctionTerm(@NotNull final PDDL31Parser.FunctionTermContext ctx) {
        stackHandler.beginFunctionTerm();
    }

    @Override
    public void exitFunctionTerm(@NotNull final PDDL31Parser.FunctionTermContext ctx) {
        stackHandler.endFunctionTerm();
    }

    @Override
    public void enterPreconditionGoalDescriptionAnd(
            @NotNull final PDDL31Parser.PreconditionGoalDescriptionAndContext ctx) {
        stackHandler.beginAnd();
    }

    @Override
    public void exitPreconditionGoalDescriptionAnd(
            @NotNull final PDDL31Parser.PreconditionGoalDescriptionAndContext ctx) {
        stackHandler.endAnd();
    }

    @Override
    public void enterGoalDescriptionAnd(@NotNull final PDDL31Parser.GoalDescriptionAndContext ctx) {
        stackHandler.beginAnd();
    }

    @Override
    public void exitGoalDescriptionAnd(@NotNull final PDDL31Parser.GoalDescriptionAndContext ctx) {
        stackHandler.endAnd();
    }

    @Override
    public void enterCondEffectAnd(@NotNull final PDDL31Parser.CondEffectAndContext ctx) {
        stackHandler.beginAnd();
    }

    @Override
    public void exitCondEffectAnd(@NotNull final PDDL31Parser.CondEffectAndContext ctx) {
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
    public void enterEqualityTerm(@NotNull final PDDL31Parser.EqualityTermContext ctx) {
        stackHandler.beginEquals();
    }

    @Override
    public void exitEqualityTerm(@NotNull final PDDL31Parser.EqualityTermContext ctx) {
        stackHandler.endEquals();
    }

    @Override
    public void enterEqualityConstant(@NotNull final PDDL31Parser.EqualityConstantContext ctx) {
        stackHandler.beginEquals();
    }

    @Override
    public void exitEqualityConstant(@NotNull final PDDL31Parser.EqualityConstantContext ctx) {
        stackHandler.endEquals();
    }

    @Override
    public void enterWhenEffect(@NotNull final PDDL31Parser.WhenEffectContext ctx) {
        stackHandler.beginIfThen();
    }

    @Override
    public void exitWhenEffect(@NotNull final PDDL31Parser.WhenEffectContext ctx) {
        stackHandler.endIfThen();
    }

    @Override
    public void enterForAllEffect(@NotNull final PDDL31Parser.ForAllEffectContext ctx) {
        stackHandler.beginForAll();
    }

    @Override
    public void exitForAllEffect(@NotNull final PDDL31Parser.ForAllEffectContext ctx) {
        stackHandler.endForAll();
    }

    /**
     * Get a completed type.
     * @return the type
     */
    protected Type getType() {
        return stackHandler.getType();
    }

    /**
     * Get the constant we just built.
     * @return the constant
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
     * Get the function we just built.
     * @return the function
     */
    protected FunctionDefinition getFunction() {
        return stackHandler.getFunction();
    }

    /**
     * Get the formula we just built.
     * @return the function
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
