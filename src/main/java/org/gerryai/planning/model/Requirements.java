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
 * Class encapsulating the planner features required by the domain being defined.
 */
public class Requirements {

    private Set<Requirement> requirements;

    /**
     * Constructor.
     * @param requirements the requirements
     */
    private Requirements(final Set<Requirement> requirements) {
        this.requirements = requirements;
    }

    /**
     * Get the requirements as a set.
     * @return the requirements
     */
    public Set<Requirement> asSet() {
        return Collections.unmodifiableSet(requirements);
    }

    /**
     * Builder class for {@link org.gerryai.planning.model.Requirements}.
     */
    public static class Builder {

        private Set<Requirement> requirements;

        /**
         * Constructor.
         */
        public Builder() {
            requirements = new HashSet<>(0);
        }

        /**
         * Add a requirement to the set of requirements being built.
         * @param requirement the requirement
         * @return an updated builder
         */
        public Builder requirement(final Requirement requirement) {
            requirements.add(requirement);
            return this;
        }

        /**
         * Build the finished set of requirements.
         * @return the requirements
         */
        public Requirements build() {
            return new Requirements(requirements);
        }
    }
}
