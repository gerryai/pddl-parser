package org.gerryai.pddl.model;

import org.gerryai.pddl.model.logic.Constant;
import org.gerryai.pddl.model.logic.Predicate;

/**
 * Class defining a PDDL domain.
 */
public class Domain {

    private String name;
    private Requirements requirements;
    private Constants constants;
    private Predicates predicates;
    private Actions actions;

    /**
     * Constructor.
     * @param builder the builder to build from
     */
    private Domain(final Builder builder) {
        this.name = builder.name;
        this.requirements = builder.requirementsBuilder.build();
        this.constants = builder.constantsBuilder.build();
        this.predicates = builder.predicatesBuilder.build();
        this.actions = builder.actionsBuilder.build();
    }

    /**
     * Get the name of the domain.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the planner feature requirements.
     * @return the requirements
     */
    public Requirements getRequirements() {
        return requirements;
    }

    /**
     * Get the domain's constants.
     * @return the constants
     */
    public Constants getConstants() {
        return constants;
    }
    /**
     * Get the domain's predicates.
     * @return the predicates
     */
    public Predicates getPredicates() {
        return predicates;
    }

    /**
     * Get the domains actions.
     * @return the actions
     */
    public Actions getActions() {
        return actions;
    }
    /**
     * Builder class for {@link org.gerryai.pddl.model.Domain} objects.
     */
    public static class Builder {

        private String name;
        private Requirements.Builder requirementsBuilder  = new Requirements.Builder();
        private Constants.Builder constantsBuilder  = new Constants.Builder();
        private Predicates.Builder predicatesBuilder = new Predicates.Builder();
        private Actions.Builder actionsBuilder = new Actions.Builder();

        /**
         * Set the name of the domain.
         * @param name the name
         * @return an updated builder
         */
        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        /**
         * Add a planner feature requirement.
         * @param requirement the requirement to add
         * @return an updated builder
         */
        public Builder requirement(final Requirement requirement) {
            requirementsBuilder = requirementsBuilder.addRequirement(requirement);
            return this;
        }

        /**
         * Add a constant.
         * @param constant the constant to add
         * @return an updated builder
         */
        public Builder constant(final Constant constant) {
            constantsBuilder = constantsBuilder.constant(constant);
            return this;
        }

        /**
         * Add a predicate.
         * @param predicate the predicate to add
         * @return an updated builder
         */
        public Builder predicate(final Predicate predicate) {
            predicatesBuilder = predicatesBuilder.addPredicate(predicate);
            return this;
        }

        /**
         * Add an action.
         * @param action the action to add
         * @return an updated builder
         */
        public Builder action(final Action action) {
            actionsBuilder = actionsBuilder.addAction(action);
            return this;
        }

        /**
         * Build the completed {@link org.gerryai.pddl.model.Domain}.
         * @return the domain
         */
        public Domain build() {
            return new Domain(this);
        }
    }
}
