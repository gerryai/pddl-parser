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
 * Represents a universal quantifier - ie, a "for all" statement.
 */
public class ForAll implements Formula {

    private List<Variable> variables;
    private Formula formula;

    /**
     * Constructor.
     * @param builder the builder to build from
     */
    private ForAll(final Builder builder) {
        variables = builder.variables;
        formula = builder.formula;
    }

    /**
     * Get the variables used by the proposition.
     * @return the variables
     */
    public List<Variable> getVariables() {
        return Collections.unmodifiableList(variables);
    }

    /**
     * The formula representing the proposition.
     * @return the formula
     */
    public Formula getFormula() {
        return formula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(variables, formula);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ForAll other = (ForAll) obj;
        return Objects.equals(this.variables, other.variables) && Objects.equals(this.formula, other.formula);
    }

    /**
     * Builder for {@link org.gerryai.planning.model.logic.ForAll} formulas.
     */
    public static class Builder {
        private List<Variable> variables = new ArrayList<>();
        private Formula formula;

        /**
         * Add a variable to the list used by the formula being quantified.
         * @param variable the variable
         * @return an updated builder
         */
        public Builder variable(final Variable variable) {
            variables.add(variable);
            return this;
        }

        /**
         * Set the formula being quantified.
         * @param formula the formula
         * @return an updated builder
         */
        public Builder formula(final Formula formula) {
            this.formula = formula;
            return this;
        }

        /**
         * Build the finished formula.
         * @return the formula
         */
        public ForAll build() {
            return new ForAll(this);
        }
    }
}
