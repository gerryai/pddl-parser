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

import com.google.common.base.Optional;
import org.gerryai.planning.model.logic.Formula;
import org.gerryai.planning.model.logic.Type;
import org.gerryai.planning.model.logic.Variable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Class encapsulating a domain action.
 */
public class Action {

    private final String name;
    private final List<Variable> parameters;
    private final Precondition precondition;
    private final Effect effect;

    /**
     * Constructor.
     * @param builder the builder to build from
     */
    private Action(final Builder builder) {
        this.name = builder.name;
        this.parameters = builder.parameters;
        this.precondition = builder.precondition;
        this.effect = builder.effect;
    }

    /**
     * Get the action name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the parameters for this action.
     * @return the parameters
     */
    public List<Variable> getParameters() {
        return Collections.unmodifiableList(parameters);
    }

    /**
     * Get the precondition of this action.
     * @return the effect
     */
    public Precondition getPrecondition() {
        return precondition;
    }

    /**
     * Get the effect of this action.
     * @return the effect
     */
    public Effect getEffect() {
        return effect;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parameters, precondition, effect);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Action other = (Action) obj;
        return Objects.equals(this.name, other.name)
                && Objects.equals(this.parameters, other.parameters)
                && Objects.equals(this.precondition, other.precondition)
                && Objects.equals(this.effect, other.effect);
    }

    /**
     * Class for building actions.
     */
    public static class Builder {
        private String name;
        private List<Variable> parameters;
        private Precondition precondition;
        private Effect effect;

        /**
         * Constructor.
         */
        public Builder() {
            this.parameters = new ArrayList<>();
        }

        /**
         * Set the name of the action to be built.
         * @param name the action name
         * @return an updated builder
         */
        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        /**
         * Add a parameter for the action being built.
         * @param parameter the parameter to add
         * @return an updated builder
         */
        public Builder parameter(final String parameter) {
            this.parameters.add(new Variable(parameter));
            return this;
        }

        /**
         * Add a parameter for the action being built.
         * @param parameter the parameter to add
         * @param type the type that the parameter must have
         * @return an updated builder
         */
        public Builder parameter(final String parameter, final Type type) {
            this.parameters.add(new Variable(parameter, type));
            return this;
        }

        /**
         * Add a parameter for the action being built.
         * @param parameter the parameter to add
         * @return an updated builder
         */
        public Builder parameter(final Variable parameter) {
            this.parameters.add(parameter);
            return this;
        }

        /**
         * Set the precondition of the action being built.
         * @param precondition the precondition
         * @return an updated builder
         */
        public Builder precondition(final Optional<Formula> precondition) {
            if (precondition.isPresent()) {
                return precondition(precondition.get());
            } else {
                return precondition();
            }
        }

        /**
         * Set the precondition of the action being built.
         * @param precondition the precondition
         * @return an updated builder
         */
        public Builder precondition(final Formula precondition) {
            this.precondition = new Precondition(precondition);
            return this;
        }

        /**
         * Set an empty precondition for the action being built.
         * @return an updated builder
         */
        public Builder precondition() {
            this.precondition = Precondition.empty();
            return this;
        }

        /**
         * Set the precondition of the action being built.
         * @param effect the effect
         * @return an updated builder
         */
        public Builder effect(final Optional<Formula> effect) {
            if (effect.isPresent()) {
                return effect(effect.get());
            } else {
                return effect();
            }
        }

        /**
         * Set the effect of the action being built.
         * @param effect the effect
         * @return an updated builder
         */
        public Builder effect(final Formula effect) {
            this.effect = new Effect(effect);
            return this;
        }

        /**
         * Set an empty effect for the action being built.
         * @return an updated builder
         */
        public Builder effect() {
            this.effect = Effect.empty();
            return this;
        }

        /**
         * Build the completed action.
         * @return the action
         */
        public Action build() {
            return new Action(this);
        }

    }
}
