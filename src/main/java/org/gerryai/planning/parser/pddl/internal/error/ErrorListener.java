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

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.gerryai.planning.parser.error.SyntaxError;

import java.util.Collections;
import java.util.List;

/**
 * Error listener to capture syntax errors instead of writing them to stderr.
 */
public class ErrorListener extends BaseErrorListener {

    private SyntaxErrorCollector syntaxErrorCollector;

    /**
     * Constructor.
     * @param syntaxErrorCollector the collector to store errors in.
     */
    public ErrorListener(final SyntaxErrorCollector syntaxErrorCollector) {
        this.syntaxErrorCollector = syntaxErrorCollector;
    }

    @Override
    public void syntaxError(final Recognizer<?, ?> recognizer, final Object offendingSymbol, final int line,
                            final int charPositionInLine, final String msg, final RecognitionException e) {

        List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
        Collections.reverse(stack);

        syntaxErrorCollector.add(new SyntaxError(offendingSymbol, line, charPositionInLine, msg, stack));
    }
}

