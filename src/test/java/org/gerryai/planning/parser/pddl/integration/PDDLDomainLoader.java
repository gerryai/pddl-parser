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
package org.gerryai.planning.parser.pddl.integration;

import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.domain.Domain;
import org.gerryai.planning.parser.error.ParseException;
import org.gerryai.planning.parser.pddl.PDDLParserService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * Abstract base class for PDDL parser integration tests. Subclasses must implement the getFilePath method to
 * indicate which PDDL file to load for parsing.
 */
public abstract class PDDLDomainLoader extends PDDLLoader<Domain> {

    protected Domain domain;

    protected int syntaxErrorCount;

    protected Set<Requirement> missingRequirements;

    public PDDLDomainLoader() {
        super();

        domain = getResult().orNull();
        syntaxErrorCount = getSyntaxErrorCount();
        missingRequirements = getMissingRequirements();
    }

    protected Domain parse(PDDLParserService parserService, InputStream inputStream) throws IOException, ParseException {
        return parserService.parseDomain(inputStream);
    }
}
