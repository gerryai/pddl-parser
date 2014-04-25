package org.gerryai.planning.model.problem;

import org.gerryai.planning.model.logic.Formula;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents the initial state of a problem using a set of terms.
 */
public class InitialState {

    private Set<Formula> formulas;

    /**
     * Constructor.
     * @param builder the builder to build from
     */
    private InitialState(final Builder builder) {
        formulas = builder.formulas;
    }

    /**
     * Get the formulas in this state.
     * @return the terms
     */
    public Set<Formula> asSet() {
        return Collections.unmodifiableSet(formulas);
    }

    /**
     * Builder class for {@link org.gerryai.planning.model.problem.InitialState} objects.
     */
    public static class Builder {

        private Set<Formula> formulas = new HashSet<>();

        /**
         * Add a formula to the state being built.
         * @param term the term to add
         * @return an updated builder
         */
        public Builder formula(final Formula term) {
            formulas.add(term);
            return this;
        }

        /**
         * Build the completed state.
         * @return the state
         */
        public InitialState build() {
            return new InitialState(this);
        }
    }
}
