package org.gerryai.planning.parser;

import org.antlr.v4.runtime.Parser;

/**
 * Exception representing a grammar/syntax-related problem whilst parsing an input.
 */
public class ParseException extends Exception {

    private Parser parser;

    /**
     * Constructor.
     * @param parser the parser that caused the problem
     */
    public ParseException(final Parser parser) {
        this.parser = parser;
    }

    /**
     * Get the parser that caused the problem.
     * @return the parser
     */
    public Parser getParser() {
        return parser;
    }
}
