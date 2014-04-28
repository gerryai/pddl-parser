/*
 * Gerry AI - Open framework for automated planning
 * Copyright (c) 2014 David Edwards <david@more.fool.me.uk>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
