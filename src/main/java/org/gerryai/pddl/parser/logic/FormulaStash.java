package org.gerryai.pddl.parser.logic;

import com.google.common.base.Optional;
import org.gerryai.pddl.model.logic.And;
import org.gerryai.pddl.model.logic.Formula;
import org.gerryai.pddl.model.logic.Not;
import org.gerryai.pddl.model.logic.Predicate;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static com.google.common.base.Preconditions.checkState;
import static java.lang.String.format;

/**
 * Wrapper class for handling a stash of completed formulas.
 */
public class FormulaStash {

    private Deque<StashItem> formulas = new ArrayDeque<>();

    /**
     * Add a completed predicate.
     * @param predicate the predicate
     */
    public void add(final Predicate predicate) {
        formulas.add(new StashItem(FormulaType.PREDICATE, predicate));
    }

    /**
     * Add a completed negated formula.
     * @param not the formula
     */
    public void add(final Not not) {
        formulas.add(new StashItem(FormulaType.NOT, not));
    }

    /**
     * Add a completed conjuntive formula.
     * @param and the formula
     */
    public void add(final And and) {
        formulas.add(new StashItem(FormulaType.AND, and));
    }

    /**
     * Add a completed formula to the stash.
     * @param type the type of formula being added
     * @param formula the formula
     */
    public void add(final FormulaType type, final Formula formula) {
        formulas.add(new StashItem(type, formula));
    }

    /**
     * Remove a predicate from the stash.
     * This will be the oldest formula in the stash and if it isn't a predicate then an exception will be thrown.
     * @return the predicate
     */
    public Predicate removePredicate() {
        return (Predicate) remove(FormulaType.PREDICATE);
    }

    /**
     * Remove the oldest formula from the stash.
     * @return the predicate
     */
    public Formula remove() {
        return formulas.removeFirst().getFormula();
    }

    /**
     * Remove all formulas from the stash and return them as a list.
     * @return the list of formulas
     */
    public List<Formula> removeAll() {
        List<Formula> formulaList = new ArrayList<>(formulas.size());
        while (!formulas.isEmpty()) {
            formulaList.add(remove());
        }
        return formulaList;
    }

    /**
     * Check if the stash is empty.
     * @return true if the stash is empty
     */
    public boolean isEmpty() {
        return formulas.isEmpty();
    }

    /**
     * Get the size of the queue.
     * @return the number of items in the queue
     */
    public int size() {
        return formulas.size();
    }

    /**
     * Peek at the type of the oldest formula in the stash.
     * @return the type of formula
     */
    public Optional<FormulaType> peek() {
        if (formulas.isEmpty()) {
            return Optional.absent();
        } else {
            return Optional.fromNullable(formulas.peek().getFormulaType());
        }
    }

    /**
     * Remove a formula of the specified type from the stash.
     * The oldest formula in the stash will be taken and if it is of the wrong type then an exception will be thrown.
     * @param type the type of formula to expect
     * @return the formula
     */
    private Formula remove(final FormulaType type) {
        checkState(type.equals(formulas.peekFirst().getFormulaType()),
                format("Expected a %s to be available", type));
        return remove();
    }

    /**
     * Private class combining a formula and a type as a single item that can be kept in the stash.
     */
    private class StashItem {

        private final FormulaType formulaType;
        private final Formula formula;

        /**
         * Constructor.
         * @param type the formula type
         * @param formula the formula
         */
        public StashItem(final FormulaType type, final Formula formula) {
            this.formula = formula;
            this.formulaType = type;
        }

        /**
         * Get the formula type.
         * @return the formula type
         */
        public FormulaType getFormulaType() {
            return formulaType;
        }

        /**
         * Get the formula.
         * @return the formula
         */
        public Formula getFormula() {
            return formula;
        }
    }
}
