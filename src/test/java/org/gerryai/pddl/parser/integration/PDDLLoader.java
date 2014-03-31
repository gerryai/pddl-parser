package org.gerryai.pddl.parser.integration;

import org.gerryai.pddl.model.Domain;
import org.gerryai.pddl.parser.ParseException;
import org.gerryai.pddl.parser.ParserService;
import org.gerryai.pddl.parser.ParserServiceUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Abstract base class for PDDL parser integration tests. Subclasses must implement the getFilePath method to
 * indicate which PDDL file to load for parsing.
 */
public abstract class PDDLLoader {

    protected Domain domain;

    protected int errors;

    protected abstract String getFilePath();

    public PDDLLoader() {
        checkNotNull(getFilePath(), "Path to PDDL file needs to be set before tests can be run");

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(getFilePath());

        ParserServiceUtils parserServiceUtils = new ParserServiceUtils();
        ParserService parserService = new ParserService(parserServiceUtils);

        try {
            domain = parserService.parse(inputStream);
        } catch (ParseException ex) {
            errors = ex.getParser().getNumberOfSyntaxErrors();
        } catch (IOException ex) {
            throw new IllegalStateException("Could not read PDDL file for parsing", ex);
        }
    }

}
