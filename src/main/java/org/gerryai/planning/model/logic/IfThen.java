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
