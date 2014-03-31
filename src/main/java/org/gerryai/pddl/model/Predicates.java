package org.gerryai.pddl.model;

import org.gerryai.pddl.model.logic.Predicate;

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
     * Builder class for {@link org.gerryai.pddl.model.Predicates}.
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
