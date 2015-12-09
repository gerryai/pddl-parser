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

import com.google.common.base.Optional;
import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.parser.error.MissingRequirementsException;
import org.gerryai.planning.parser.error.ParseException;
import org.gerryai.planning.parser.error.SyntaxErrorException;
import org.gerryai.planning.parser.pddl.PDDLParserService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Abstract base class for PDDL parser integration tests. Subclasses must implement the getFilePath method to
 * indicate which PDDL file to load for parsing.
 */
public abstract class PDDLLoader<T> {

    private Optional<T> result = Optional.absent();

    private int syntaxErrors = 0;

    private Set<Requirement> missingRequirements = Collections.emptySet();

    protected abstract String getFilePath();

    public PDDLLoader() {
        checkNotNull(getFilePath(), "Path to PDDL file needs to be set before tests can be run");

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(getFilePath());

        PDDLParserService parserService = new PDDLParserService();

        try {
            result = Optional.fromNullable(parse(parserService, inputStream));
        } catch (SyntaxErrorException ex) {
            syntaxErrors = ex.getSyntaxErrors().size();
        } catch (MissingRequirementsException ex) {
            missingRequirements = ex.getMissingRequirements();
        } catch (ParseException ex) {
            throw new IllegalStateException("Unhandled parsing exception thrown", ex);
        } catch (IOException ex) {
            throw new IllegalStateException("Could not read PDDL file for parsing", ex);
        }
    }

    public Optional<T> getResult() {
        return result;
    }

    public int getSyntaxErrorCount() {
        return syntaxErrors;
    }

    public Set<Requirement> getMissingRequirements() {
        return missingRequirements;
    }

    protected abstract T parse(PDDLParserService parserService, InputStream inputStream) throws IOException, ParseException;
}
