package org.gerryai.planning.parser.pddl;

import org.gerryai.planning.model.domain.Domain;
import org.gerryai.planning.model.problem.Problem;
import org.gerryai.planning.parser.ParseException;
import org.gerryai.planning.parser.ParserService;
import org.gerryai.planning.parser.pddl.internal.PDDLParser;
import org.gerryai.planning.parser.pddl.internal.PDDLParserUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * A serice that can be used for parsing PDDL files into planning problems or domains.
 */
public class PDDLParserService implements ParserService {

    private PDDLParser parserService;

    /**
     * Constructor.
     */
    public PDDLParserService() {
        parserService = new PDDLParser(new PDDLParserUtils());
    }

    @Override
    public Problem parseProblem(final InputStream inputStream) throws IOException, ParseException {
        return parserService.parseProblem(inputStream);
    }

    @Override
    public Domain parseDomain(final InputStream inputStream) throws IOException, ParseException {
        return parserService.parseDomain(inputStream);
    }
}
