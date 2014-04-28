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
package org.gerryai.planning.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Class encapsulating the constants defined by the domain.
 */
public class ConstantDefinitions {

    private Set<ConstantDefinition> constants;

    /**
     * Constructor.
     * @param builder the builder to build from
     */
    private ConstantDefinitions(final Builder builder) {
        this.constants = builder.constants;
    }

    /**
     * Get the constants as a set.
     * @return the constants
     */
    public Set<ConstantDefinition> asSet() {
        return Collections.unmodifiableSet(constants);
    }

    /**
     * Builder class for {@link ConstantDefinitions}.
     */
    public static class Builder {

        private Set<ConstantDefinition> constants;

        /**
         * Constructor.
         */
        public Builder() {
            constants = new HashSet<>(0);
        }

        /**
         * Add a constant to the set of constants being built.
         * @param constant the constant
         * @return an updated builder
         */
        public Builder constant(final ConstantDefinition constant) {
            constants.add(constant);
            return this;
        }

        /**
         * Build the finished set of constants.
         * @return the constants
         */
        public ConstantDefinitions build() {
            return new ConstantDefinitions(this);
        }
    }
}
