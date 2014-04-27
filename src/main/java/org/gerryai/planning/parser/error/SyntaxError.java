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
