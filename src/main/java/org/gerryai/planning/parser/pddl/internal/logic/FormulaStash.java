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
import org.gerryai.planning.model.logic.Formula;
import org.gerryai.planning.model.logic.FunctionTerm;
import org.gerryai.planning.model.logic.Operation;
import org.gerryai.planning.model.logic.Predicate;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static com.google.common.base.Preconditions.checkState;
import static java.lang.String.format;

/**
 * Provides a mechanism for stashing a list of formulas. It is a first-in first-out queue, allowing formulas to be
 * retrieved in the order they were added.
 */
public class FormulaStash {

    private Deque<StashItem> formulas = new ArrayDeque<>();

    /**
     * Add a completed formula to the stash.
     *
     * @param type    the type of formula being added
     * @param formula the formula
     */
    public void add(final FormulaType type, final Formula formula) {
        formulas.add(new StashItem(type, formula));
    }

    /**
     * Remove a predicate from the stash.
     * This will be the oldest formula in the stash and if it isn't a predicate then an exception will be thrown.
     *
     * @return the predicate
     */
    public Predicate removePredicate() {
        return (Predicate) remove(FormulaType.PREDICATE);
    }

    /**
     * Remove a operation from the stash.
     * This will be the oldest formula in the stash and if it isn't a assignment then an exception will be thrown.
     *
     * @return the predicate
     */
    public Operation removeOperation() {
        return (Operation) remove(FormulaType.OPERATION);
    }

    /**
     * Remove a head from the stash.
     * This will be the oldest formula in the stash and if it isn't a assignment head then an exception will be thrown.
     *
     * @return the predicate
     */
    public FunctionTerm removeFunctionTerm() {
        return (FunctionTerm) remove(FormulaType.FUNCTION_TERM);
    }

    /**
     * Remove a function from the stash.
     * This will be the oldest formula in the stash and if it isn't a function then an exception will be thrown.
     *
     * @return the function
     */
    public FunctionDefinition removeFunction() {
        return (FunctionDefinition) remove(FormulaType.FUNCTION);
    }

    /**
     * Remove the oldest formula from the stash.
     *
     * @return the formula
     */
    public Formula remove() {
        return formulas.removeFirst().getFormula();
    }

    /**
     * Remove all formulas from the stash and return them as a list. The order of the formulas in the list will be the
     * same as the order they were added to the stash.
     *
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
     *
     * @return true if the stash is empty
     */
    public boolean isEmpty() {
        return formulas.isEmpty();
    }

    /**
     * Get the size of the stash.
     *
     * @return the number of items in the stash
     */
    public int size() {
        return formulas.size();
    }

    /**
     * Peek at the type of the oldest formula in the stash.
     *
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
     *
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
         *
         * @param type    the formula type
         * @param formula the formula
         */
        StashItem(final FormulaType type, final Formula formula) {
            this.formula = formula;
            this.formulaType = type;
        }

        /**
         * Get the formula type.
         *
         * @return the formula type
         */
        public FormulaType getFormulaType() {
            return formulaType;
        }

        /**
         * Get the formula.
         *
         * @return the formula
         */
        public Formula getFormula() {
            return formula;
        }
    }
}
