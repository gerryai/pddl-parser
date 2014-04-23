package org.gerryai.pddl.model.domain;

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
