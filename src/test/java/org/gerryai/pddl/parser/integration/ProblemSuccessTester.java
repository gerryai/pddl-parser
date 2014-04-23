package org.gerryai.pddl.parser.integration;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Base class for PDDL problem parser integration tests expecting a successful parse.
 */
public abstract class ProblemSuccessTester extends PDDLProblemLoader {

    @Test
    public void parsedWithNoSyntaxErrors() {
        assertEquals("Parsed with no syntax errors", 0, errors);
    }

}
