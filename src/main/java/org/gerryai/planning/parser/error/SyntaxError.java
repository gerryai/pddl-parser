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
 * Represents a syntax error.
 */
public class SyntaxError {

    private Object offendingSymbol;
    private int line;
    private int charPositionInLine;
    private String message;
    private List<String> stack;

    /**
     * Constructor.
     * @param offendingSymbol the offending symbol
     * @param line the line where the error occurred
     * @param charPositionInLine the character position within the line
     * @param message the error message
     * @param stack the rule invocation stack
     */
    public SyntaxError(final Object offendingSymbol, final int line, final int charPositionInLine, final String message,
                       final  List<String> stack) {
        this.offendingSymbol = offendingSymbol;
        this.line = line;
        this.charPositionInLine = charPositionInLine;
        this.message = message;
        this.stack = stack;
    }

    /**
     * Get the offending symbol.
     * @return the symbol
     */
    public Object getOffendingSymbol() {
        return offendingSymbol;
    }

    /**
     * Get the line where the error occurred.
     * @return the line number
     */
    public int getLine() {
        return line;
    }

    /**
     * Get the character position within the line where the error occurred.
     * @return the character position
     */
    public int getCharPositionInLine() {
        return charPositionInLine;
    }

    /**
     * Get the error message.
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Get the rule invocation stack.
     * @return the stack
     */
    public List<String> getStack() {
        return stack;
    }
}
