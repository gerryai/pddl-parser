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

