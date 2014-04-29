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
package org.gerryai.planning.parser.error;

import java.util.List;

/**
 * Parse exception encapsulation one or more syntax errors.
 */
public class SyntaxErrorException extends ParseException {

    private List<SyntaxError> syntaxErrors;

    /**
     * Constructor.
     * @param syntaxErrors a list of syntax errors causing the problem
     */
    public SyntaxErrorException(final List<SyntaxError> syntaxErrors) {
        super();
        this.syntaxErrors = syntaxErrors;
    }

    /**
     * Get the syntax errors that caused the problem.
     * @return the errors
     */
    public List<SyntaxError> getSyntaxErrors() {
        return syntaxErrors;
    }
}
