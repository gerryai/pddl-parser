package org.gerryai.pddl.parser;

import org.gerryai.pddl.parser.antlr.PDDL31Parser;

/**
 * Exception representing a grammar/syntax-related problem whilst parsing an input.
 */
public class ParseException extends Exception {

    private PDDL31Parser parser;

    /**
     * Constructor.
     * @param parser the parser that caused the problem
     */
    public ParseException(final PDDL31Parser parser) {
        this.parser = parser;
    }

    /**
     * Get the parser that caused the problem.
     * @return the parser
     */
    public PDDL31Parser getParser() {
        return parser;
    }
}
