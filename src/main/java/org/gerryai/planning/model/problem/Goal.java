package org.gerryai.planning.model.problem;

import org.gerryai.planning.model.logic.Formula;

import java.util.Objects;

/**
 * Represents the goal of a planning problem, described by a formula.
 */
public class Goal {

    private Formula formula;

    /**
     * Constructor.
     * @param formula the formula describing the goal state
     */
    public Goal(final Formula formula) {
        this.formula = formula;
    }

    /**
     * Get the formula describing the goal state.
     * @return the formula
     */
    public Formula getFormula() {
        return formula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(formula);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Goal other = (Goal) obj;
        return Objects.equals(this.formula, other.formula);
    }
}
