package org.gerryai.planning.parser.error;

import java.util.List;

/**
 * Exception representing a grammar/syntax-related problem whilst parsing an input.
 */
public class ParseException extends Exception {

    private List<SyntaxError> syntaxErrors;

    /**
     * Constructor.
     * @param syntaxErrors a list of syntax errors causing the problem
     */
    public ParseException(final List<SyntaxError> syntaxErrors) {
        this.syntaxErrors = syntaxErrors;
    }

    /**
     * Get the syntax errors that caused the problem.
     * @return the errors
     */
    public List<SyntaxError> getSyntaxErrors() {
        return syntaxErrors;
    }
}
