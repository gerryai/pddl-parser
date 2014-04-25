package org.gerryai.planning.parser.pddl.integration;

import org.gerryai.planning.model.problem.Problem;
import org.gerryai.planning.parser.ParseException;
import org.gerryai.planning.parser.pddl.PDDLParserService;

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
    protected Problem parse(PDDLParserService parserService, InputStream inputStream) throws IOException, ParseException {
        return parserService.parseProblem(inputStream);
    }
}
