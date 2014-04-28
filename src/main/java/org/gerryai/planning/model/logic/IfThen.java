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

import java.util.Objects;

/**
 * Represents a conditional logical formula - ie, "if x then y", or "x implies y".
 */
public class IfThen implements Formula {

    private Formula condition;
    private Formula consequence;

    /**
     * Constructor.
     * @param condition the condition that must be true
     * @param consequence the consequence of the condition being true
     */
    public IfThen(final Formula condition, final Formula consequence) {
        this.condition = condition;
        this.consequence = consequence;
    }

    @Override
    public int hashCode() {
        return Objects.hash(condition, consequence);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final IfThen other = (IfThen) obj;
        return Objects.equals(this.condition, other.condition) && Objects.equals(this.consequence, other.consequence);
    }

    /**
     * Builder class for creating {@link org.gerryai.planning.model.logic.IfThen} formulas in two steps.
     */
    public static class If {
        private Formula condition;

        /**
         * Constructor.
         * @param formula the condition that must be true
         */
        public If(final Formula formula) {
            condition = formula;
        }

        /**
         * Build a completed if... then... formula using the condition already given and the consequence provided.
         * @param consequence the consequence of the condition being true
         * @return the completed formula
         */
        public IfThen then(final Formula consequence) {
            return new IfThen(condition, consequence);
        }
    }
}
