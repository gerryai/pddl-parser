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
package org.gerryai.planning.parser.pddl.internal.error;

import org.gerryai.planning.parser.error.SyntaxError;

import java.util.ArrayList;
import java.util.List;

/**
 * Receptacle for syntax errors collected whilst parsing.
 */
public class SyntaxErrorCollector {

    private List<SyntaxError> syntaxErrors = new ArrayList<>();

    /**
     * Add a syntax error to the list collected.
     * @param syntaxError the syntax error to add
     */
    public void add(final SyntaxError syntaxError) {
        syntaxErrors.add(syntaxError);
    }

    /**
     * Get the list of syntax error collected.
     * @return the list of syntax errors
     */
    public List<SyntaxError> getErrors() {
        return syntaxErrors;
    }
}
