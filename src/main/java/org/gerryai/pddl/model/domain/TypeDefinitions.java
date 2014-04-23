package org.gerryai.pddl.model.domain;

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
