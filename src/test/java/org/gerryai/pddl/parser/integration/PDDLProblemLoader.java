package org.gerryai.pddl.parser.integration;

import org.gerryai.pddl.model.problem.Problem;
import org.gerryai.pddl.parser.ParseException;
import org.gerryai.pddl.parser.ParserService;

import java.io.IOException;
import java.io.InputStream;

/**
 * Abstract base class for PDDL problem parser integration tests.
 */
public abstract class PDDLProblemLoader extends PDDLLoader<Problem> {

    protected Problem problem;

    protected int errors;

    public PDDLProblemLoader() {
        super();
        problem = result();
        errors = errors();
    }

    @Override
    protected Problem parse(ParserService parserService, InputStream inputStream) throws IOException, ParseException {
        return parserService.parseProblem(inputStream);
    }
}
