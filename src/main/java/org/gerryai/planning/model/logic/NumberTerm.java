package org.gerryai.planning.model.logic;

/**
 * Represents a numeric term.
 */
public class NumberTerm implements Term {
    private String value;

    /**
     * Builds a number with a given value.
     * @param value the value of the number
     */
    public NumberTerm(final String value) {
        this.value = value;
    }
}
