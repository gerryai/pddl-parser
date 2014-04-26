package org.gerryai.planning.parser.pddl.integration.general.failure;

import org.gerryai.planning.parser.pddl.integration.PDDLDomainLoader;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the paser copes with missing requirements.
 * TODO: Make this parse but fail while building the domain
 */
public class MissingEqualityIT extends PDDLDomainLoader {

    protected String getFilePath() {
        return "pddl/general/failure/missing-equality.pddl";
    }

    @Test
    public void parseFailsWithSyntaxErrors() {
        assertTrue("Should have syntax error(s) when parsing", errors > 0);
    }
}
