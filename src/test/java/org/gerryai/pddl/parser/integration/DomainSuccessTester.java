package org.gerryai.pddl.parser.integration;

import org.junit.Test;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Abstract base class for PDDL parser integration tests. Subclasses must implement the getFilePath method to
 * indicate which PDDL file to load for parsing.
 */
public abstract class DomainSuccessTester extends PDDLDomainLoader {

    @Test
    public void parsedWithNoSyntaxErrors() {
        assertEquals("Parsed with no syntax errors", 0, errors);
    }

}
