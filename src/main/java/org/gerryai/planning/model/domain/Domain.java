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
package org.gerryai.planning.model.domain;

import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.ConstantDefinitions;
import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.Requirements;
import org.gerryai.planning.model.logic.Predicate;

/**
 * Defines a planning domain.
 * TODO: Ensure that types are only supported if the :typing requirement is present, etc
 */
public class Domain {

    private String name;
    private Requirements requirements;
    private TypeDefinitions types;
    private ConstantDefinitions constants;
    private Predicates predicates;
    private Actions actions;

    /**
     * Constructor.
     * @param builder the builder to build from
     */
    private Domain(final Builder builder) {
        name = builder.name;
        requirements = builder.requirementsBuilder.build();
        types = builder.typesBuilder.build();
        constants = builder.constantsBuilder.build();
        predicates = builder.predicatesBuilder.build();
        actions = builder.actionsBuilder.build();
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
     * Get the types used by this domain.
     * @return the types
     */
    public TypeDefinitions getTypes() {
        return types;
    }

    /**
     * Get the domain's constants.
     * @return the constants
     */
    public ConstantDefinitions getConstants() {
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
     * Builder class for {@link Domain} objects.
     */
    public static class Builder {

        private String name;
        private Requirements.Builder requirementsBuilder  = new Requirements.Builder();
        private TypeDefinitions.Builder typesBuilder = new TypeDefinitions.Builder();
        private ConstantDefinitions.Builder constantsBuilder  = new ConstantDefinitions.Builder();
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
            requirementsBuilder = requirementsBuilder.requirement(requirement);
            return this;
        }

        /**
         * Add a type definition to the set of types this domain will use.
         * @param typeDefinition the type
         * @return an updated builder
         */
        public Builder type(final TypeDefinition typeDefinition) {
            typesBuilder = typesBuilder.type(typeDefinition);
            return this;
        }

        /**
         * Add a constant definition.
         * @param constant the constant to add
         * @return an updated builder
         */
        public Builder constant(final ConstantDefinition constant) {
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
         * Build the completed {@link Domain}.
         * @return the domain
         */
        public Domain build() {
            return new Domain(this);
        }
    }
}
