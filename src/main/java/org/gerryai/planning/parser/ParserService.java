package org.gerryai.planning.parser;

import org.gerryai.planning.model.domain.Domain;
import org.gerryai.planning.model.problem.Problem;
import org.gerryai.planning.parser.error.ParseException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Interface for parsing domains and problems described using PDDL.
 */
public interface ParserService {

    /**
     * Parse an input stream and extract a {@link org.gerryai.planning.model.domain.Domain}.
     * @param inputStream the input stream to parse
     * @return the result of parsing the file
     * @throws java.io.IOException if the input could not be read correctly
     * @throws org.gerryai.planning.parser.error.ParseException if there was a syntax error parsing the input
     */
    Domain parseDomain(final InputStream inputStream) throws IOException, ParseException;

    /**
     * Parse an input stream and extract a {@link org.gerryai.planning.model.problem.Problem}.
     * @param inputStream the input stream to parse
     * @return the result of parsing the file
     * @throws java.io.IOException if the input could not be read correctly
     * @throws ParseException if there was a syntax error parsing the input
     */
    Problem parseProblem(final InputStream inputStream) throws IOException, ParseException;


}
