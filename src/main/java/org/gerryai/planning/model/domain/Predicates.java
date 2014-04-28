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

import org.gerryai.planning.model.logic.Predicate;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Class encapsulating the predicates defined by the domain.
 */
public class Predicates {

    private Set<Predicate> predicates;

    /**
     * Constructor.
     * @param builder the builder to build from
     */
    private Predicates(final Builder builder) {
        this.predicates = builder.predicates;
    }

    /**
     * Get the predicates as a set.
     * @return the predicates
     */
    public Set<Predicate> asSet() {
        return Collections.unmodifiableSet(predicates);
    }

    /**
     * Builder class for {@link Predicates}.
     */
    public static class Builder {

        private Set<Predicate> predicates;

        /**
         * Constructor.
         */
        public Builder() {
            predicates = new HashSet<>(0);
        }

        /**
         * Add a predicate to the set of predicates being built.
         * @param predicate the predicate
         * @return an updated builder
         */
        public Builder addPredicate(final Predicate predicate) {
            predicates.add(predicate);
            return this;
        }

        /**
         * Build the finished set of requirements.
         * @return the requirements
         */
        public Predicates build() {
            return new Predicates(this);
        }
    }
}
