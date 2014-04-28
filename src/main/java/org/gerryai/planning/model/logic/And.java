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
 * Represents a conjunctive formula.
 * Note that {@link #equals(Object)} is not implemented as a logical equality check; the order of the formulas matters.
 */
public class And implements Formula {

    private List<Formula> conjuncts;

    /**
     * Constructor.
     * @param builder the builder to build from
     */
    private And(final Builder builder) {
        conjuncts = builder.conjuncts;
    }

    /**
     * Get the conjuncts as a list, ordered as they were added.
     * @return the conjuncts
     */
    public List<Formula> asList() {
        return Collections.unmodifiableList(conjuncts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conjuncts);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final And other = (And) obj;
        return Objects.equals(this.conjuncts, other.conjuncts);
    }

    /**
     * Builder class for {@link org.gerryai.planning.model.logic.And}.
     */
    public static class Builder {

        private List<Formula> conjuncts;

        /**
         * Builder for conjunctive formulae.
         */
        public Builder() {
            conjuncts = new ArrayList<>();
        }

        /**
         * Add a formula to the the list.
         * @param formula the formula to add
         * @return an updated builder
         */
        public Builder and(final Formula formula) {
            conjuncts.add(formula);
            return this;
        }
        /**
         * Build the finished conjunctive formula.
         * @return the formula
         */
        public And build() {
            return new And(this);
        }
    }
}
