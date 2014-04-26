package org.gerryai.planning.parser.pddl.internal;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.gerryai.planning.parser.pddl.antlr.PDDL31Lexer;
import org.gerryai.planning.parser.pddl.antlr.PDDL31Parser;
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
     * Create a PDDL parser from the given token stream.
     * @param tokenStream the token stream to process
     * @return the parser
     */
    public PDDL31Parser createParser(final TokenStream tokenStream) {
        return new PDDL31Parser(tokenStream);
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
