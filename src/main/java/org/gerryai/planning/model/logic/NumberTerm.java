package org.gerryai.planning.model.logic;

import java.util.Objects;

/**
 * Represents a numeric term.
 */
public class NumberTerm implements Term {
    private String value;

    /**
     * Builds a number with a given value.
     *
     * @param value the value of the number
     */
    public NumberTerm(final String value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Term)) {
            return false;
        }
        NumberTerm that = (NumberTerm) obj;
        return Objects.equals(this.value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
