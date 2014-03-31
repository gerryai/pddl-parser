package org.gerryai.pddl.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.gerryai.pddl.model.Domain;
import org.gerryai.pddl.parser.antlr.PDDL31Parser;

import java.io.IOException;
import java.io.InputStream;

/**
 * Class for parsing domains and problems described using PDDL.
 */
public class ParserService {

    /**
     * Helper for reading files, etc.
     */
    private ParserServiceUtils parserServiceUtils;

    /**
     * Constructor.
     * @param utils the helper class to use for parsing files, etc
     */
    public ParserService(final ParserServiceUtils utils) {
        this.parserServiceUtils = utils;
    }

    /**
     * Parse an input stream.
     * @param inputStream the input stream to parse
     * @return the result of parsing the file
     * @throws java.io.IOException if the input could not be read correctly
     * @throws org.gerryai.pddl.parser.ParseException if there was a syntax error parsing the input
     */
    public Domain parse(final InputStream inputStream) throws IOException, ParseException {
        CharStream charStream = parserServiceUtils.createInputStream(inputStream);
        Lexer lexer = parserServiceUtils.createLexer(charStream);
        TokenStream tokenStream = parserServiceUtils.createTokenStream(lexer);
        PDDL31Parser parser = parserServiceUtils.createParser(tokenStream);
        ParseTreeWalker parseTreeWalker = parserServiceUtils.createParseTreeWalker();
        ExtractDomainListener extractDomainListener = parserServiceUtils.createExtractDomainListener();
        ParseTree tree = parserServiceUtils.getDomainContext(parser);
        if (parser.getNumberOfSyntaxErrors() > 0) {
           throw new ParseException(parser);
        }
        //System.out.println(tree.toStringTree(parser));
        parseTreeWalker.walk(extractDomainListener, tree);

        return extractDomainListener.extract();
    }

}
