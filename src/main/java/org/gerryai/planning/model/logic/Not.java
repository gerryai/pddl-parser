package org.gerryai.planning.model.logic;

import java.util.Objects;

/**
 * Class representing a negated formula.
 */
public class Not implements Formula {

    private final Formula formula;

    /**
     * Constructor.
     * @param formula the formula being negated.
     */
    public Not(final Formula formula) {
        this.formula = formula;
    }

    /**
     * Get the negated formula.
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
        final Not other = (Not) obj;
        return Objects.equals(this.formula, other.formula);
    }
}
