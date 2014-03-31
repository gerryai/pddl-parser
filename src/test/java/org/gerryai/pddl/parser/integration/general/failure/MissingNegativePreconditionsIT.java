package org.gerryai.pddl.parser.integration.general.failure;

import org.gerryai.pddl.parser.integration.PDDLLoader;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Blocksworld example files are parsed correctly.
 */
public class MissingNegativePreconditionsIT extends PDDLLoader {

    protected String getFilePath() {
        return "pddl/general/failure/missing-negative-preconditions.pddl";
    }

    @Test
    public void parseFailsWithSyntaxErrors() {
        assertTrue("Should have syntax error(s) when parsing", errors > 0);
    }
}
