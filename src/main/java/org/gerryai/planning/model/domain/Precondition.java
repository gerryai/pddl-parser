package org.gerryai.planning.model.domain;

import com.google.common.base.Optional;
import org.gerryai.planning.model.logic.Formula;

import java.util.Objects;

/**
 * Class encapsulating the preconditions of an action.
 */
public class Precondition {

    private final Optional<Formula> precondition;

    private static final Precondition EMPTY = new Precondition();

    /**
     * Returns an empty {@link Precondition}.
     * @return an empty {@link Precondition}
     */
    public static Precondition empty() {
        return EMPTY;
    }

    /**
     * Private constructor to create an empty precondition.
     */
    private Precondition() {
        precondition = Optional.absent();
    }

    /**
     * Constructor.
     * @param precondition the formula describing the precondition
     */
    public Precondition(final Formula precondition) {
        this.precondition = Optional.fromNullable(precondition);
    }

    /**
     * Get the formula describing this effect.
     * @return the formula
     */
    public Optional<Formula> getPrecondition() {
        return precondition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(precondition);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Precondition other = (Precondition) obj;
        return Objects.equals(this.precondition, other.precondition);
    }
}
