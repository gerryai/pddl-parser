package org.gerryai.pddl.model.problem;

import org.gerryai.pddl.model.ConstantDefinition;
import org.gerryai.pddl.model.ConstantDefinitions;
import org.gerryai.pddl.model.logic.Formula;

/**
 * Defines a planning problem.
 */
public class Problem {

    private String name;
    private String domainName;
    private ConstantDefinitions objects;
    private InitialState initialState;
    private Goal goal;

    /**
     * Constructor.
     * @param builder the builder to build from
     */
    private Problem(final Builder builder) {
        name = builder.name;
        domainName = builder.domainName;
        objects = builder.objects.build();
        initialState = builder.initialState.build();
        goal = new Goal(builder.goal);
    }

    /**
     * Get the name of the problem.
     * @return the problem name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the name of the domain.
     * @return the problem name
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * Get the objects defined by this problem.
     * @return the objects
     */
    public ConstantDefinitions getObjects() {
        return objects;
    }

    /**
     * Get the initial state for this problem.
     * @return the state
     */
    public InitialState getInitialState() {
        return initialState;
    }

    /**
     * Get the goal of this problem.
     * @return the goal
     */
    public Goal getGoal() {
        return goal;
    }

    /**
     * Builder class for {@link Problem} objects.
     */
    public static class Builder {

        private String name;
        private String domainName;
        private ConstantDefinitions.Builder objects  = new ConstantDefinitions.Builder();
        private InitialState.Builder initialState = new InitialState.Builder();
        private Formula goal;

        /**
         * Set the name of the problem.
         * @param name the name
         * @return an updated builder
         */
        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        /**
         * Set the name of the domain.
         * @param name the name
         * @return an updated builder
         */
        public Builder domain(final String name) {
            this.domainName = name;
            return this;
        }

        /**
         * Add an object to the set used by this problem.
         * @param object the object to add
         * @return an updated builder
         */
        public Builder object(final ConstantDefinition object) {
            this.objects.constant(object);
            return this;
        }

        /**
         * Add a formula to the initial state.
         * @param formula the formula to add
         * @return an updated builder
         */
        public Builder initialState(final Formula formula) {
            initialState.formula(formula);
            return this;
        }

        /**
         * Set the goal of this problem.
         * @param formula the formula defining the goal
         * @return the goal
         */
        public Builder goal(final Formula formula) {
            goal = formula;
            return this;
        }

        /**
         * Build the completed {@link Problem}.
         * @return the domain
         */
        public Problem build() {
            return new Problem(this);
        }
    }
}
