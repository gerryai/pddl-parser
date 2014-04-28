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
 * Class to encapsulate the actions of a domain.
 */
public class Actions {


    private Set<Action> actions;

    /**
     * Constructor.
     * @param actions the actions
     */
    private Actions(final Set<Action> actions) {
        this.actions = actions;
    }

    /**
     * Get the actions as a set.
     * @return the actions
     */
    public Set<Action> asSet() {
        return Collections.unmodifiableSet(actions);
    }

    /**
     * Builder class for {@link Actions}.
     */
    public static class Builder {

        private Set<Action> actions;

        /**
         * Constructor.
         */
        public Builder() {
            actions = new HashSet<>(0);
        }

        /**
         * Add an action to the set of actions being built.
         * @param action the action
         * @return an updated builder
         */
        public Builder addAction(final Action action) {
            actions.add(action);
            return this;
        }

        /**
         * Build the finished set of actions.
         * @return the actions
         */
        public Actions build() {
            return new Actions(actions);
        }
    }
}
