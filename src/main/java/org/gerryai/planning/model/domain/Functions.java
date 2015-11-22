package org.gerryai.planning.model.domain;

import org.gerryai.planning.model.logic.Function;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Class encapsulating the functions defined by the domain.
 */
public class Functions {

    private Set<Function> functions;

    /**
     * Constructor.
     *
     * @param builder the builder to build from
     */
    private Functions(final Builder builder) {
        this.functions = builder.functions;
    }

    /**
     * Get the functions as a set.
     *
     * @return the functions
     */
    public Set<Function> asSet() {
        return Collections.unmodifiableSet(functions);
    }

    /**
     * Builder class for {@link Functions}.
     */
    public static class Builder {

        private Set<Function> functions;

        /**
         * Constructor.
         */
        public Builder() {
            functions = new HashSet<>(0);
        }

        /**
         * Add a functions to the set of functions being built.
         *
         * @param function the function
         * @return an updated builder
         */
        public Builder addFunction(final Function function) {
            functions.add(function);
            return this;
        }

        /**
         * Build the finished set of functions.
         *
         * @return the functions
         */
        public Functions build() {
            return new Functions(this);
        }
    }

}
