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
import org.gerryai.planning.model.logic.Constant;
import org.gerryai.planning.model.logic.NumberTerm;
import org.gerryai.planning.model.logic.Term;
import org.gerryai.planning.model.logic.Type;
import org.gerryai.planning.model.logic.Variable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class handling a queue of logical terms. Any rule that expects to get terms must have cleared out this queue
 * by the time it has exited.
 */
public class TermStash {

    /**
     * Used to hold any terms we come across.
     */
    private Deque<TermStashItem> termDeque = new ArrayDeque<>();

    /**
     * Add a constant to the queue to be collected.
     * @param name the name of the constant to add
     */
    public void addConstant(final String name) {
        termDeque.add(new TermStashItem(name, TermType.CONSTANT));
    }

    /**
     * Add a variable to the queue to be collected.
     * @param name the name of the variable to add
     */
    public void addVariable(final String name) {
        termDeque.add(new TermStashItem(name, TermType.VARIABLE));
    }

    /**
     * Add a number to the queue to be collected.
     * @param number to be added
     */
    public void addNumber(final String number) {
        termDeque.add(new TermStashItem(number, TermType.NUMBER));
    }

    /**
     * Apply the given type to the untyped terms in the stash.
     * @param type the type
     */
    public void apply(final Type type) {
        Iterator<TermStashItem> itemIterator = termDeque.descendingIterator();
        while (itemIterator.hasNext()) {
            TermStashItem item = itemIterator.next();
            if (item.getType().isPresent()) {
                break;
            } else {
                item.setType(type);
            }
        }
    }

    /**
     * Get a list of variables collected, clearing the queue in the process.
     * If any of the terms in the queue are not variables, an {@link java.lang.IllegalStateException} will be thrown.
     * @return the variables
     */
    public List<Variable> variables() {
        List<Variable> variables = new ArrayList<>(termDeque.size());
        while (!termDeque.isEmpty()) {
            variables.add(dequeueVariable());
        }
        return variables;
    }

    /**
     * Get a list of terms collected, clearing the queue in the process.
     * @return the terms
     */
    public List<Term> terms() {
        List<Term> terms = new ArrayList<>(termDeque.size());
        while (!termDeque.isEmpty()) {
            terms.add(remove());
        }
        return terms;
    }

    /**
     * Remove the oldest term from the stash as a constant.
     * @return the term
     */
    public Constant constant() {
        return dequeueConstant();
    }

    /**
     * Remove the oldest term from the stash.
     * @return the term
     */
    public Term remove() {
        switch (termDeque.peekFirst().getTermType()) {
            case CONSTANT:
                return dequeueConstant();
            case VARIABLE:
                return dequeueVariable();
            case NUMBER:
                return dequeueNumber();
            default:
                throw new IllegalStateException("Unexpected term type");
        }
    }

    /**
     * Check if the term queue is empty.
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
        return termDeque.isEmpty();
    }

    /**
     * Check the the number of terms in the stash.
     * @return the number of terms
     */
    public int size() {
        return termDeque.size();
    }

    /**
     * Remove the first element of the queue and return it as a constant.
     * @return the variable
     */
    private Constant dequeueConstant() {
        if (termDeque.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            if (TermType.CONSTANT.equals(termDeque.peekFirst().getTermType())) {
                TermStashItem item = termDeque.removeFirst();
                return new Constant(item.getName());
            } else {
                throw new IllegalStateException("First element of the queue was not a variable");
            }
        }
    }

    /**
     * Remove the first element of the queue and return it as a variable.
     * @return the variable
     */
    private Variable dequeueVariable() {
        if (termDeque.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            if (TermType.VARIABLE.equals(termDeque.peekFirst().getTermType())) {
                TermStashItem item = termDeque.removeFirst();
                if (item.getType().isPresent()) {
                    return new Variable(item.getName(), item.getType().get());
                } else {
                    return new Variable(item.getName());
                }
            } else {
                throw new IllegalStateException("First element of the queue was not a variable");
            }
        }
    }

    /**
     * Remove the first element of the queue and return it as a number.
     * @return the number
     */
    private NumberTerm dequeueNumber() {
        if (termDeque.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            if (TermType.NUMBER.equals(termDeque.peekFirst().getTermType())) {
                TermStashItem item = termDeque.removeFirst();
                return new NumberTerm(item.getName());
            } else {
                throw new IllegalStateException("First element of the queue was not a number");
            }
        }
    }

    /**
     * Used to record whether a term in the stash will be a constant or a variable when it is built.
     */
    private enum TermType {
        CONSTANT,
        NUMBER, VARIABLE
    }

    /**
     * An item in the term stash.
     */
    private class TermStashItem {

        private TermType termType;
        private String name;
        private Optional<Type> type = Optional.absent();

        /**
         * Constuctor.
         * @param name the name of the term
         * @param termType the type of the term
         */
        TermStashItem(final String name, final TermType termType) {
            this.name = name;
            this.termType = termType;
        }

        /**
         * Get the {@link org.gerryai.planning.parser.pddl.internal.logic.TermStash.TermType} - whether it is a
         * constant or a variable.
         * @return the type of term
         */
        public TermType getTermType() {
            return termType;
        }

        /**
         * Get the name of the term.
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * Get the term type.
         * @return the term type
         */
        public Optional<Type> getType() {
            return type;
        }

        /**
         * Set the term type.
         * @param type the type
         */
        public void setType(final Type type) {
            this.type = Optional.fromNullable(type);
        }
    }
}
