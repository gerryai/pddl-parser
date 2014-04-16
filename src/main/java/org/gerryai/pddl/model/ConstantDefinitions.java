package org.gerryai.pddl.model;

import org.gerryai.pddl.model.logic.ConstantDefinition;

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
