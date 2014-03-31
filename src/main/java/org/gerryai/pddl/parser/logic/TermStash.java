package org.gerryai.pddl.parser.logic;

import org.gerryai.pddl.model.logic.Constant;
import org.gerryai.pddl.model.logic.Term;
import org.gerryai.pddl.model.logic.Variable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
    private Deque<Term> termDeque = new ArrayDeque<>();

    /**
     * Add a term to the queue to be collected.
     * @param term the term to add
     */
    public void add(final Term term) {
        termDeque.add(term);
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
        return termDeque.removeFirst();
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
            if (termDeque.peekFirst() instanceof Constant) {
                return (Constant) termDeque.removeFirst();
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
            if (termDeque.peekFirst() instanceof Variable) {
                return (Variable) termDeque.removeFirst();
            } else {
                throw new IllegalStateException("First element of the queue was not a variable");
            }
        }
    }
}
