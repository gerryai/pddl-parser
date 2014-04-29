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
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.gerryai.planning.model.domain.Domain;
import org.gerryai.planning.model.problem.Problem;
import org.gerryai.planning.parser.error.ParseException;
import org.gerryai.planning.parser.error.SyntaxErrorException;
import org.gerryai.planning.parser.pddl.antlr.PDDL31Parser;
import org.gerryai.planning.parser.pddl.internal.error.SyntaxErrorCollector;

import java.io.IOException;
import java.io.InputStream;

/**
 * Class for parsing domains and problems described using PDDL.
 */
public class PDDLParser {

    /**
     * Helper for reading files, etc.
     */
    private PDDLParserUtils parserServiceUtils;

    /**
     * Constructor.
     * @param utils the helper class to use for parsing files, etc
     */
    public PDDLParser(final PDDLParserUtils utils) {
        this.parserServiceUtils = utils;
    }

    /**
     * Parse an input stream and extract a {@link org.gerryai.planning.model.domain.Domain}.
     * @param inputStream the input stream to parse
     * @return the result of parsing the file
     * @throws java.io.IOException if the input could not be read correctly
     * @throws org.gerryai.planning.parser.error.ParseException if there was a syntax error parsing the input
     */
    public Domain parseDomain(final InputStream inputStream) throws IOException, ParseException {
        SyntaxErrorCollector syntaxErrorCollector = parserServiceUtils.createSyntaxErrorCollector();
        PDDL31Parser parser = createParser(inputStream, syntaxErrorCollector);
        ExtractDomainListener listener = parserServiceUtils.createExtractDomainListener();
        ParseTree tree = parserServiceUtils.getDomainContext(parser);

        return extract(parser, tree, listener, syntaxErrorCollector);
    }

    /**
     * Parse an input stream and extract a {@link org.gerryai.planning.model.problem.Problem}.
     * @param inputStream the input stream to parse
     * @return the result of parsing the file
     * @throws java.io.IOException if the input could not be read correctly
     * @throws org.gerryai.planning.parser.error.ParseException if there was a syntax error parsing the input
     */
    public Problem parseProblem(final InputStream inputStream) throws IOException, ParseException  {
        SyntaxErrorCollector syntaxErrorCollector = parserServiceUtils.createSyntaxErrorCollector();
        PDDL31Parser parser = createParser(inputStream, syntaxErrorCollector);
        ExtractProblemListener listener = parserServiceUtils.createExtractProblemListener();
        ParseTree tree = parserServiceUtils.getProblemContext(parser);

        return extract(parser, tree, listener, syntaxErrorCollector);
    }

    /**
     * Create a {@link org.gerryai.planning.parser.pddl.antlr.PDDL31Parser} from an {@link java.io.InputStream}.
     * @param inputStream the input stream
     * @param syntaxErrorCollector the collector to put syntax errors in
     * @return the token stream
     * @throws IOException if the input could not be read correctly
     */
    private PDDL31Parser createParser(final InputStream inputStream, final SyntaxErrorCollector syntaxErrorCollector)
            throws IOException {
        CharStream charStream = parserServiceUtils.createInputStream(inputStream);
        Lexer lexer = parserServiceUtils.createLexer(charStream);
        TokenStream tokenStream = parserServiceUtils.createTokenStream(lexer);
        return parserServiceUtils.createParser(tokenStream, syntaxErrorCollector);
    }

    /**
     * Extract an entity of type T using the supplied parsing objects.
     * @param parser the parser to use
     * @param tree the parse tree to use
     * @param listener the listener to use to do the extraction
     * @param syntaxErrorCollector the collector to put syntax errors in
     * @param <T> the type of entity being extracted
     * @return the extracted entity
     * @throws ParseException if there were errors encountered whilst parsing
     */
    private <T>  T extract(final PDDL31Parser parser, final ParseTree tree, final ExtractingListener<T> listener,
                           final SyntaxErrorCollector syntaxErrorCollector)
            throws ParseException {

        if (parser.getNumberOfSyntaxErrors() > 0) {
            throw new SyntaxErrorException(syntaxErrorCollector.getErrors());
        }

        ParseTreeWalker parseTreeWalker = parserServiceUtils.createParseTreeWalker();
        parseTreeWalker.walk(listener, tree);

        if (!parser.getEnforceRequirments()) {
            return listener.extract(parser.getRequirementsNeeded());
        } else {
            return listener.extract();
        }
    }

}
