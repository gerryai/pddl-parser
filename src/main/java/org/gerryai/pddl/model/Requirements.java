package org.gerryai.pddl.model;

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
     * Builder class for {@link org.gerryai.pddl.model.Requirements}.
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
        public Builder addRequirement(final Requirement requirement) {
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
