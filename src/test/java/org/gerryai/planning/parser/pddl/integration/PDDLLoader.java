package org.gerryai.planning.parser.pddl.integration;

import org.gerryai.planning.parser.ParseException;
import org.gerryai.planning.parser.pddl.PDDLParserService;

import java.io.IOException;
import java.io.InputStream;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Abstract base class for PDDL parser integration tests. Subclasses must implement the getFilePath method to
 * indicate which PDDL file to load for parsing.
 */
public abstract class PDDLLoader<T> {

    private T result;

    private int errors;

    protected abstract String getFilePath();

    public PDDLLoader() {
        checkNotNull(getFilePath(), "Path to PDDL file needs to be set before tests can be run");

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(getFilePath());

        PDDLParserService parserService = new PDDLParserService();

        try {
            result = parse(parserService, inputStream);
        } catch (ParseException ex) {
            errors = ex.getParser().getNumberOfSyntaxErrors();
        } catch (IOException ex) {
            throw new IllegalStateException("Could not read PDDL file for parsing", ex);
        }
    }

    public T result() {
        return result;
    }

    public int errors() {
        return errors;
    }

    protected abstract T parse(PDDLParserService parserService, InputStream inputStream) throws IOException, ParseException;
}
