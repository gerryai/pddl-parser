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
package org.gerryai.planning.model.problem;

import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.ConstantDefinitions;
import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.Requirements;
import org.gerryai.planning.model.logic.Formula;

/**
 * Defines a planning problem.
 */
public class Problem {

    private String name;
    private String domainName;
    private Requirements requirements;
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
        requirements = builder.requirementsBuilder.build();
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
     * Get the planner feature requirements.
     * @return the requirements
     */
    public Requirements getRequirements() {
        return requirements;
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
        private Requirements.Builder requirementsBuilder  = new Requirements.Builder();
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
         * Add a planner feature requirement.
         * @param requirement the requirement to add
         * @return an updated builder
         */
        public Builder requirement(final Requirement requirement) {
            requirementsBuilder = requirementsBuilder.requirement(requirement);
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
