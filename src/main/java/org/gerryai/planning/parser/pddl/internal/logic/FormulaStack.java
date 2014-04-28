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

import java.util.Stack;

import static com.google.common.base.Preconditions.checkState;
import static java.lang.String.format;

/**
 * Stack for recording formulas that haven't been finished yet.
 * Each item on the stack has a type and a stash of the formulas that had been built previously but not collected yet.
 */
public class FormulaStack {

    private Stack<FormulaStackItem> formulaStack = new Stack<>();

    /**
     * Push a new formula onto the stack.
     * @param type the type of the new formula being built
     * @param queue the list of formula built so far for the previous stack entry
     * @param termStash the stash of terms collected for the previous stack entry
     */
    public void push(final FormulaType type, final FormulaStash queue, final TermStash termStash) {
        formulaStack.push(new FormulaStackItem(type, queue, termStash));
    }

    /**
     * Pop a formula from the stack and add it to the queue awaiting collection.
     * @param type the type of formula to expect
     * @return the formula stash that was stashed before the current formula was started
     */
    public FormulaStackItem pop(final FormulaType type) {
        checkType(type);
        return formulaStack.pop();
    }

    /**
     * Peek at the top of the stack and check that the formula is of the expected type.
     * @param type the formula type expected
     */
    public void checkType(final FormulaType type) {
        checkState(type.equals(formulaStack.peek().formulaType),
                format("Expected the top of the stack to be %s", type));
    }

    /**
     * Private class describing a stack item.
     * Each entry on the stack defines the type of formula being built and the list of formulas that had been built
     * as part of the previous stack entry but have not yet been collected.
     */
    public class FormulaStackItem {
        private FormulaType formulaType;
        private FormulaStash formulaStash;
        private TermStash termStash;

        /**
         * Constructor.
         * @param type the formula type
         * @param queue the formula queue from before we started building this current formula
         * @param termStash the term stash from berofre we started building this current formula
         */
        public FormulaStackItem(final FormulaType type, final FormulaStash queue, final TermStash termStash) {
            this.formulaStash = queue;
            this.formulaType = type;
            this.termStash = termStash;
        }
//
//        /**
//         * Get the formula type.
//         * @return the formula type
//         */
//        public FormulaType getFormulaType() {
//            return formulaType;
//        }

        /**
         * Get the formula queue.
         * @return the formula queue
         */
        public FormulaStash getFormulaStash() {
            return formulaStash;
        }

        /**
         * Get the term stash.
         * @return the term stash
         */
        public TermStash getTermStash() {
            return termStash;
        }
    }
}
