package org.gerryai.pddl.model.logic;

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
     * Builder class for {@link org.gerryai.pddl.model.logic.Or}.
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
