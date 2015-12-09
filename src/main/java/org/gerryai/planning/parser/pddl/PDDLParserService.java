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
package org.gerryai.planning.parser.pddl;

import org.gerryai.planning.model.domain.Domain;
import org.gerryai.planning.model.problem.Problem;
import org.gerryai.planning.parser.ParserService;
import org.gerryai.planning.parser.error.ParseException;
import org.gerryai.planning.parser.pddl.internal.PDDLParser;
import org.gerryai.planning.parser.pddl.internal.PDDLParserUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * A service that can be used for parsing PDDL files into planning problems or domains.
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
