package org.gerryai.pddl.parser.integration;

import org.gerryai.pddl.model.domain.Domain;
import org.gerryai.pddl.parser.ParseException;
import org.gerryai.pddl.parser.ParserService;

import java.io.IOException;
import java.io.InputStream;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.junit.Assert.assertEquals;

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

    protected Domain parse(ParserService parserService, InputStream inputStream) throws IOException, ParseException {
        return parserService.parseDomain(inputStream);
    }
}
