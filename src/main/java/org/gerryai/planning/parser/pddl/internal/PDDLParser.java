package org.gerryai.planning.parser.pddl.internal;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.gerryai.planning.model.domain.Domain;
import org.gerryai.planning.model.problem.Problem;
import org.gerryai.planning.parser.ParseException;
import org.gerryai.planning.parser.pddl.antlr.PDDL31Parser;

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
     * @throws org.gerryai.planning.parser.ParseException if there was a syntax error parsing the input
     */
    public Domain parseDomain(final InputStream inputStream) throws IOException, ParseException {
        PDDL31Parser parser = createParser(inputStream);
        ExtractDomainListener listener = parserServiceUtils.createExtractDomainListener();
        ParseTree tree = parserServiceUtils.getDomainContext(parser);

        return extract(parser, tree, listener);
    }

    /**
     * Parse an input stream and extract a {@link org.gerryai.planning.model.problem.Problem}.
     * @param inputStream the input stream to parse
     * @return the result of parsing the file
     * @throws java.io.IOException if the input could not be read correctly
     * @throws org.gerryai.planning.parser.ParseException if there was a syntax error parsing the input
     */
    public Problem parseProblem(final InputStream inputStream) throws IOException, ParseException  {
        PDDL31Parser parser = createParser(inputStream);
        ExtractProblemListener listener = parserServiceUtils.createExtractProblemListener();
        ParseTree tree = parserServiceUtils.getProblemContext(parser);

        return extract(parser, tree, listener);
    }

    /**
     * Create a {@link org.gerryai.planning.pddl.parser.antlr.PDDL31Parser} from an {@link java.io.InputStream}.
     * @param inputStream the input stream
     * @return the token stream
     * @throws IOException if the input could not be read correctly
     */
    private PDDL31Parser createParser(final InputStream inputStream) throws IOException {
        CharStream charStream = parserServiceUtils.createInputStream(inputStream);
        Lexer lexer = parserServiceUtils.createLexer(charStream);
        TokenStream tokenStream = parserServiceUtils.createTokenStream(lexer);
        return parserServiceUtils.createParser(tokenStream);
    }

    /**
     * Extract an entity of type T using the supplied parsing objects.
     * @param parser the parser to use
     * @param tree the parse tree to use
     * @param listener the listener to use to do the extraction
     * @param <T> the type of entity being extracted
     * @return the extracted entity
     * @throws ParseException if there were errors encountered whilst parsing
     */
    private <T>  T extract(final Parser parser, final ParseTree tree, final ExtractingListener<T> listener)
            throws ParseException {
        ParseTreeWalker parseTreeWalker = parserServiceUtils.createParseTreeWalker();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            throw new ParseException(parser);
        }
        //System.out.println(tree.toStringTree(parser));
        parseTreeWalker.walk(listener, tree);

        return listener.extract();
    }

}
