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
package org.gerryai.planning.parser.pddl.internal;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.gerryai.planning.parser.pddl.antlr.PDDL31Lexer;
import org.gerryai.planning.parser.pddl.antlr.PDDL31Parser;
import org.gerryai.planning.parser.pddl.internal.error.ErrorListener;
import org.gerryai.planning.parser.pddl.internal.error.SyntaxErrorCollector;
import org.gerryai.planning.parser.pddl.internal.logic.LogicStackHandler;

import java.io.IOException;
import java.io.InputStream;

/**
 * Helper functions for handling parser input, etc.
 */
public class PDDLParserUtils {

    /**
     * Create a {@link CaseInsensitiveInputStream} from a file.
     * @param inputStream the InputStream to read
     * @return the ANTLR input stream
     * @throws java.io.IOException if there was a problem reading the input stream
     */
    public CharStream createInputStream(final InputStream inputStream) throws IOException {
        return new CaseInsensitiveInputStream(inputStream);
    }

    /**
     * Create a {@link TokenStream} from a {@link Lexer}.
     * @param lexer the lexer to use
     * @return the token stream
     */
    public TokenStream createTokenStream(final Lexer lexer) {
        return new CommonTokenStream(lexer);
    }

    /**
     * Create a Lexer from the given input stream.
     * @param inputStream the input stream to process
     * @return the lexer
     */
    public Lexer createLexer(final CharStream inputStream) {
        return new PDDL31Lexer(inputStream);
    }

    /**
     * Create a collector for syntax errors.
     * @return the syntax error collector
     */
    public SyntaxErrorCollector createSyntaxErrorCollector() {
        return new SyntaxErrorCollector();
    }

    /**
     * Create a PDDL parser from the given token stream.
     * @param tokenStream the token stream to process
     * @param syntaxErrorCollector the collector to put syntax errors in
     * @return the parser
     */
    public PDDL31Parser createParser(final TokenStream tokenStream, final SyntaxErrorCollector syntaxErrorCollector) {
        PDDL31Parser parser = new PDDL31Parser(tokenStream);
        parser.setEnforceRequirments(false);
        parser.removeErrorListeners(); // remove ConsoleErrorListener
        parser.addErrorListener(new ErrorListener(syntaxErrorCollector));
        return parser;
    }

    /**
     * Get the domain context from the given parser.
     * @param parser the parser to use
     * @return the domain context
     */
    public PDDL31Parser.DomainContext getDomainContext(final PDDL31Parser parser) {
        return parser.domain();
    }

    /**
     * Get the problem context from the given parser.
     * @param parser the parser to use
     * @return the domain context
     */
    public PDDL31Parser.ProblemContext getProblemContext(final PDDL31Parser parser) {
        return parser.problem();
    }

    /**
     * Create a parse tree walker.
     * This is primarily to facilitate unit testing.
     * @return a new parse tree walker
     */
    public ParseTreeWalker createParseTreeWalker() {
        return new ParseTreeWalker();
    }

    /**
     * Create the listener for extracting the {@link org.gerryai.planning.model.domain.Domain} from the parser.
     * @return the listener to apply when walking the parse tree
     */
    public ExtractDomainListener createExtractDomainListener() {
        return new ExtractDomainListener(new LogicStackHandler());
    }

    /**
     * Create the listener for extracting the {@link org.gerryai.planning.model.problem.Problem} from the parser.
     * @return the listener to apply when walking the parse tree
     */
    public ExtractProblemListener createExtractProblemListener() {
        return new ExtractProblemListener(new LogicStackHandler());
    }
}
