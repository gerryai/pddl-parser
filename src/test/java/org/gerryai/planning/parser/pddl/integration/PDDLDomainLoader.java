package org.gerryai.planning.parser.pddl.integration;

import org.gerryai.planning.model.domain.Domain;
import org.gerryai.planning.parser.error.ParseException;
import org.gerryai.planning.parser.pddl.PDDLParserService;

import java.io.IOException;
import java.io.InputStream;

/**
 * Abstract base class for PDDL parser integration tests. Subclasses must implement the getFilePath method to
 * indicate which PDDL file to load for parsing.
 */
public abstract class PDDLDomainLoader extends PDDLLoader<Domain> {

    protected Domain domain;

    protected int errors;

    public PDDLDomainLoader() {
        super();

        domain = result();
        errors = errors();
    }

    protected Domain parse(PDDLParserService parserService, InputStream inputStream) throws IOException, ParseException {
        return parserService.parseDomain(inputStream);
    }
}
