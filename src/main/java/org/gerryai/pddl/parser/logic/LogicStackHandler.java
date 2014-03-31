package org.gerryai.pddl.parser.logic;

import com.google.common.base.Optional;
import org.gerryai.pddl.model.logic.Constant;
import org.gerryai.pddl.model.logic.Formula;
import org.gerryai.pddl.model.logic.Predicate;
import org.gerryai.pddl.model.logic.Term;
import org.gerryai.pddl.model.logic.Variable;
import org.gerryai.pddl.parser.logic.builders.AndBuilder;
import org.gerryai.pddl.parser.logic.builders.EqualsBuilder;
import org.gerryai.pddl.parser.logic.builders.FormulaBuilder;
import org.gerryai.pddl.parser.logic.builders.NotBuilder;
import org.gerryai.pddl.parser.logic.builders.PredicateBuilder;

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
     * The queue of terms awaiting collection.
     */
    private TermStash termStash = new TermStash();

    /**
     * The stack of formulas being built.
     */
    private FormulaStack formulaStack = new FormulaStack();

    /**
     * The queue of completed formulas awaiting collection.
     */
    private FormulaStash formulaStash = new FormulaStash();

    /**
     * Add a term to the stash to be collected.
     * @param term the term to add
     */
    public void term(final Term term) {
        termStash.add(term);
    }

    /**
     * Begin a predicate.
     */
    public void beginPredicate() {
        beginFormula(FormulaType.PREDICATE);
    }

    /**
     * Set the symbol of the predicate or function at the top of the stack.
     * @param name the name
     */
    public void symbol(final String name) {
        symbolStash.push(name);
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
     * Pop the latest formula from the stack.
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
                return formulaStash.remove();
            default:
                throw new IllegalStateException(format("Unimplemented formula type found on stack %s",
                        nextType.get()));
        }
    }

    /**
     * Gets a formula if one is present.
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
     * Get a completed constant.
     * @return the constant
     */
    public Constant getConstant() {
        return termStash.constant();
    }

    /**
     * Get a completed predicate.
     * @return the predicate
     */
    public Predicate getPredicate() {
        return formulaStash.removePredicate();
    }

    /**
     * Get the variables we have built.
     * @return the variables
     */
    public List<Variable> variables() {
        return termStash.variables();
    }

    /**
     * Check that the stack is clean.
     * @return true if there are no unclaimed terms or formulas
     */
    public boolean isEmpty() {
        return symbolStash.isEmpty() && termStash.isEmpty() && formulaStash.isEmpty();
    }

    /**
     * Push a new formula onto the stack.
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
        formulaStack.push(type, formulaStash);
        formulaStash = new FormulaStash();
    }

    /**
     * Build a formula using the stashes, pop it from the stack and add it to the stash awaiting collection.
     * @param type the type of formula to expect
     */
    private void endFormula(final FormulaType type) {
        formulaStack.checkType(type);
        FormulaBuilder builder = builder(type);
        Formula formula = builder.build(symbolStash, termStash, formulaStash);
        checkState(symbolStash.isEmpty(), "Expected symbol stash to be empty after building current formula");
        checkState(termStash.isEmpty(), "Expected term stash to be empty after building current formula");
        checkState(formulaStash.isEmpty(), "Expected formula stash to be empty after building current formula");
        formulaStash = formulaStack.pop(type);
        formulaStash.add(type, formula);
    }

    /**
     * Get the correct formula builder based on the type.
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
            default:
                throw new IllegalStateException(format("Unimplemented formula type %s", type));
        }
    }

}
