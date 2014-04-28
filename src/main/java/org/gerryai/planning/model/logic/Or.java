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
package org.gerryai.planning.model.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Class representing a disjunctive formula.
 */
public class Or implements Formula {

    private List<Formula> disjuncts;

    /**
     * Constructor.
     * @param builder the builder to build from
     */
    private Or(final Builder builder) {
        disjuncts = builder.disjuncts;
    }

    /**
     * Get the disjuncts as a list, ordered as they were added.
     * @return the disjuncts
     */
    public List<Formula> asList() {
        return Collections.unmodifiableList(disjuncts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disjuncts);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Or other = (Or) obj;
        return Objects.equals(this.disjuncts, other.disjuncts);
    }

    /**
     * Builder class for {@link org.gerryai.planning.model.logic.Or}.
     */
    public static class Builder {

        private List<Formula> disjuncts;

        /**
         * Builder for conjunctive formulae.
         */
        public Builder() {
            disjuncts = new ArrayList<>();
        }

        /**
         * Add a formula to the the list.
         * @param formula the formula to add
         * @return an updated builder
         */
        public Builder or(final Formula formula) {
            disjuncts.add(formula);
            return this;
        }
        /**
         * Build the finished disjunctive formula.
         * @return the formula
         */
        public Or build() {
            return new Or(this);
        }
    }
}
