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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Class encapsulating the types defined by the domain.
 */
public class TypeDefinitions {

    private Set<TypeDefinition> types;

    /**
     * Constructor.
     * @param builder the builder to build from
     */
    private TypeDefinitions(final Builder builder) {
        this.types = builder.types;
    }

    /**
     * Get the types as a set.
     * @return the types
     */
    public Set<TypeDefinition> asSet() {
        return Collections.unmodifiableSet(types);
    }

    /**
     * Builder class for {@link TypeDefinitions}.
     */
    public static class Builder {

        private Set<TypeDefinition> types;

        /**
         * Constructor.
         */
        public Builder() {
            types = new HashSet<>(0);
        }

        /**
         * Add a type definition to the set of type definitions being built.
         * @param typeDefinition the type definition
         * @return an updated builder
         */
        public Builder type(final TypeDefinition typeDefinition) {
            types.add(typeDefinition);
            return this;
        }

        /**
         * Build the finished set of types.
         * @return the constants
         */
        public TypeDefinitions build() {
            return new TypeDefinitions(this);
        }
    }
}
