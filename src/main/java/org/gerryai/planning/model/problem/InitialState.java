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
