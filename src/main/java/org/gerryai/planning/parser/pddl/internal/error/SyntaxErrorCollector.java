package org.gerryai.planning.parser.pddl.internal.error;

import org.gerryai.planning.parser.error.SyntaxError;

import java.util.ArrayList;
import java.util.List;

/**
 * Receptacle for syntax errors collected whilst parsing.
 */
public class SyntaxErrorCollector {

    private List<SyntaxError> syntaxErrors = new ArrayList<>();

    /**
     * Add a syntax error to the list collected.
     * @param syntaxError the syntax error to add
     */
    public void add(final SyntaxError syntaxError) {
        syntaxErrors.add(syntaxError);
    }

    /**
     * Get the list of syntax error collected.
     * @return the list of syntax errors
     */
    public List<SyntaxError> getErrors() {
        return syntaxErrors;
    }
}
