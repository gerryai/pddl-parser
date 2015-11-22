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
package org.gerryai.planning.parser.pddl.internal.logic;

import com.google.common.base.Optional;
import org.gerryai.planning.model.domain.FunctionDefinition;
import org.gerryai.planning.model.logic.Constant;
import org.gerryai.planning.model.logic.Formula;
import org.gerryai.planning.model.logic.FunctionTerm;
import org.gerryai.planning.model.logic.Operation;
import org.gerryai.planning.model.logic.Predicate;
import org.gerryai.planning.model.logic.Type;
import org.gerryai.planning.model.logic.Variable;
import org.gerryai.planning.parser.pddl.internal.logic.builders.AndBuilder;
import org.gerryai.planning.parser.pddl.internal.logic.builders.EqualsBuilder;
import org.gerryai.planning.parser.pddl.internal.logic.builders.ForAllBuilder;
import org.gerryai.planning.parser.pddl.internal.logic.builders.FormulaBuilder;
import org.gerryai.planning.parser.pddl.internal.logic.builders.FunctionBuilder;
import org.gerryai.planning.parser.pddl.internal.logic.builders.FunctionTermBuilder;
import org.gerryai.planning.parser.pddl.internal.logic.builders.IfThenBuilder;
import org.gerryai.planning.parser.pddl.internal.logic.builders.NotBuilder;
import org.gerryai.planning.parser.pddl.internal.logic.builders.OperationBuilder;
import org.gerryai.planning.parser.pddl.internal.logic.builders.PredicateBuilder;

import java.util.List;

import static com.google.common.base.Preconditions.checkState;
import static java.lang.String.format;

/**
 * Helper methods for dealing with logical nodes in the parser.
 */
public class LogicStackHandler {

    /**
     * The stash for symbols awaiting collection.
     */
    private SymbolStash symbolStash = new SymbolStash();

    /**
     * The stash for symbols awaiting collection.
     */

    private SymbolStash operatorStash = new SymbolStash();
    /**
     * The queue of terms awaiting collection.
     */
    private TermStash termStash = new TermStash();

    /**
     * The stash of type names awaiting collection.
     */
    private TypeStash typeNameStash = new TypeStash();

    /**
     * The stack of formulas being built.
     */
    private FormulaStack formulaStack = new FormulaStack();

    /**
     * The queue of completed formulas awaiting collection.
     */
    private FormulaStash formulaStash = new FormulaStash();

    /**
     * Add a type name to the stash.
     *
     * @param name the name of the type
     */
    public void type(final String name) {
        typeNameStash.add(name);
    }

    /**
     * Start collecting a list of types for an (either XXX YYY) list.
     */
    public void beginEitherTypeList() {
        typeNameStash.beginEither();
    }

    /**
     * Stop collecting a list of types for an (either XXX YYY) list.
     */
    public void endEitherTypeList() {
        typeNameStash.endEither();
    }

    /**
     * Apply the given type to the untyped terms in the term stash.
     *
     * @param type the type to apply
     */
    public void applyType(final Type type) {
        termStash.apply(type);
    }

    /**
     * Add a constant to the stash to be collected.
     *
     * @param name the name of the constant to add
     */
    public void addConstant(final String name) {
        termStash.addConstant(name);
    }

    /**
     * Add a number to the stash to be collected.
     *
     * @param number the number to be collected
     */
    public void addNumber(final String number) {
        termStash.addNumber(number);
    }

    /**
     * Add a variable to the stash to be collected.
     *
     * @param name the name of the variable to add
     */
    public void addVariable(final String name) {
        termStash.addVariable(name);
    }

    /**
     * Begin a function.
     */
    public void beginFunction() {
        beginFormula(FormulaType.FUNCTION);
    }

    /**
     * End a function.
     */
    public void endFunction() {
        endFormula(FormulaType.FUNCTION);
    }

    /**
     * Begin a predicate.
     */
    public void beginPredicate() {
        beginFormula(FormulaType.PREDICATE);
    }

    /**
     * Set the symbol of the predicate or function at the top of the stack.
     *
     * @param name the name
     */
    public void symbol(final String name) {
        symbolStash.push(name);
    }

    /**
     * Set the operator for an operation.
     *
     * @param operator to set
     */
    public void operator(final String operator) {
        operatorStash.push(operator);
    }

    /**
     * Finish building the predicate on top of the stack.
     */
    public void endPredicate() {
        endFormula(FormulaType.PREDICATE);
    }

    /**
     * Begin a negated formula.
     */
    public void beginNot() {
        beginFormula(FormulaType.NOT);
    }

    /**
     * End a negated formula.
     */
    public void endNot() {
        endFormula(FormulaType.NOT);
    }

    /**
     * Begin an operation.
     */
    public void beginOperation() {
        beginFormula(FormulaType.OPERATION);
    }

    /**
     * End an operation.
     */
    public void endOperation() {
        endFormula(FormulaType.OPERATION);
    }

    /**
     * Begin an function term.
     */
    public void beginFunctionTerm() {
        beginFormula(FormulaType.FUNCTION_TERM);
    }

    /**
     * End an function term.
     */
    public void endFunctionTerm() {
        endFormula(FormulaType.FUNCTION_TERM);
    }

    /**
     * Begin a conjunctive formula.
     */
    public void beginAnd() {
        beginFormula(FormulaType.AND);
    }

    /**
     * End a negated formula.
     */
    public void endAnd() {
        endFormula(FormulaType.AND);
    }

    /**
     * Begin an equality formula.
     */
    public void beginEquals() {
        beginFormula(FormulaType.EQUALS);
    }

    /**
     * End an equality formula.
     */
    public void endEquals() {
        endFormula(FormulaType.EQUALS);
    }

    /**
     * Begin an if... then... formula.
     */
    public void beginIfThen() {
        beginFormula(FormulaType.IF_THEN);
    }

    /**
     * End an if... then... formula.
     */
    public void endIfThen() {
        endFormula(FormulaType.IF_THEN);
    }

    /**
     * Begin a for all formula.
     */
    public void beginForAll() {
        beginFormula(FormulaType.FOR_ALL);
    }

    /**
     * End a for all formula.
     */
    public void endForAll() {
        endFormula(FormulaType.FOR_ALL);
    }

    /**
     * Pop the latest formula from the stack.
     *
     * @return the completed formula
     */
    public Formula getFormula() {
        Optional<FormulaType> nextType = formulaStash.peek();
        checkState(nextType.isPresent(), "Expected a completed formula to be ready for collection");
        switch (nextType.get()) {
            case PREDICATE:
                return getPredicate();
            case NOT:
            case AND:
            case IF_THEN:
            case FOR_ALL:
                return formulaStash.remove();
            case FUNCTION:
                return getFunction();
            case OPERATION:
                return getOperation();
            case FUNCTION_TERM:
                return getFunctionTerm();
            default:
                throw new IllegalStateException(format("Unimplemented formula type found on stack %s",
                    nextType.get()));
        }
    }

    /**
     * Gets a formula if one is present.
     *
     * @return an optional formula
     */
    public Optional<Formula> getOptionalFormula() {
        Optional<FormulaType> nextType = formulaStash.peek();
        if (nextType.isPresent()) {
            return Optional.fromNullable(getFormula());
        } else {
            return Optional.absent();
        }
    }

    /**
     * Get a completed types.
     *
     * @return the list of types
     */
    public Type getType() {
        return typeNameStash.remove();
    }

    /**
     * Get a completed constant.
     *
     * @return the constant
     */
    public Constant getConstant() {
        return termStash.constant();
    }

    /**
     * Get a completed predicate.
     *
     * @return the predicate
     */
    public Predicate getPredicate() {
        return formulaStash.removePredicate();
    }

    /**
     * Get a completed assignment.
     *
     * @return the predicate
     */
    public Operation getOperation() {
        return formulaStash.removeOperation();
    }

    /**
     * Get a completed function term.
     *
     * @return the function term
     */
    public FunctionTerm getFunctionTerm() {
        return formulaStash.removeFunctionTerm();
    }

    /**
     * Get a completed function.
     *
     * @return the function
     */
    public FunctionDefinition getFunction() {
        return formulaStash.removeFunction();
    }

    /**
     * Get the variables we have built.
     *
     * @return the variables
     */
    public List<Variable> variables() {
        return termStash.variables();
    }

    /**
     * Check that the stack is clean.
     *
     * @return true if there are no unclaimed terms or formulas
     */
    public boolean isEmpty() {
        return symbolStash.isEmpty() && termStash.isEmpty() && formulaStash.isEmpty();
    }

    /**
     * Push a new formula onto the stack.
     *
     * @param type the type of formula to start building
     */
    private void beginFormula(final FormulaType type) {
//        switch (type) {
//            case PREDICATE:
//                checkState(!predicateBuilder.isPresent(),
//                        "Cannot begin a predicate whilst another is still being built");
//                checkState(termQueue.isEmpty(), "Terms queue should be clear before starting a new predicate");
//                predicateBuilder = Optional.fromNullable(new Predicate.Builder());
//                break;
//            case NOT:
//            case AND:
//                break;
//            default:
//                throw new IllegalStateException(format("Unimplemented formula type %s", type));
//        }
        formulaStack.push(type, formulaStash, termStash);
        formulaStash = new FormulaStash();
        termStash = new TermStash();
    }

    /**
     * Build a formula using the stashes, pop it from the stack and add it to the stash awaiting collection.
     *
     * @param type the type of formula to expect
     */
    private void endFormula(final FormulaType type) {
        formulaStack.checkType(type);
        FormulaBuilder builder = builder(type);
        Formula formula = builder.build(symbolStash, operatorStash, termStash, formulaStash);
        checkState(symbolStash.isEmpty(), "Expected symbol stash to be empty after building current formula");
        checkState(termStash.isEmpty(), "Expected term stash to be empty after building current formula");
        checkState(formulaStash.isEmpty(), "Expected formula stash to be empty after building current formula");
        FormulaStack.FormulaStackItem previousStackItem = formulaStack.pop(type);
        formulaStash = previousStackItem.getFormulaStash();
        termStash = previousStackItem.getTermStash();
        formulaStash.add(type, formula);
    }

    /**
     * Get the correct formula builder based on the type.
     *
     * @param type the type of formula to be built
     * @return the formula builder to use
     */
    private FormulaBuilder builder(final FormulaType type) {
        switch (type) {
            case PREDICATE:
                return new PredicateBuilder();
            case NOT:
                return new NotBuilder();
            case AND:
                return new AndBuilder();
            case EQUALS:
                return new EqualsBuilder();
            case IF_THEN:
                return new IfThenBuilder();
            case FOR_ALL:
                return new ForAllBuilder();
            case FUNCTION:
                return new FunctionBuilder();
            case OPERATION:
                return new OperationBuilder();
            case FUNCTION_TERM:
                return new FunctionTermBuilder();
            default:
                throw new IllegalStateException(format("Unimplemented formula type %s", type));
        }
    }
}
