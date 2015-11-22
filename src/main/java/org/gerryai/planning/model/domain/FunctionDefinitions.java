package org.gerryai.planning.model.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Class encapsulating the functions defined by the domain.
 */
public class FunctionDefinitions {

    private Set<FunctionDefinition> functionDefinitions;

    /**
     * Constructor.
     *
     * @param builder the builder to build from
     */
    private FunctionDefinitions(final Builder builder) {
        this.functionDefinitions = builder.functionDefinitions;
    }

    /**
     * Get the functions as a set.
     *
     * @return the functions
     */
    public Set<FunctionDefinition> asSet() {
        return Collections.unmodifiableSet(functionDefinitions);
    }

    /**
     * Builder class for {@link FunctionDefinitions}.
     */
    public static class Builder {

        private Set<FunctionDefinition> functionDefinitions;

        /**
         * Constructor.
         */
        public Builder() {
            functionDefinitions = new HashSet<>(0);
        }

        /**
         * Add a functions to the set of functions being built.
         *
         * @param functionDefinition the function
         * @return an updated builder
         */
        public Builder addFunction(final FunctionDefinition functionDefinition) {
            functionDefinitions.add(functionDefinition);
            return this;
        }

        /**
         * Build the finished set of functions.
         *
         * @return the functions
         */
        public FunctionDefinitions build() {
            return new FunctionDefinitions(this);
        }
    }

}
