package org.gerryai.planning.parser.pddl.internal;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * Interface for a parse tree listener that can extract an entity of type T after parsing.
 * @param <T> the type of entity that the listener can extract
 */
public interface ExtractingListener<T>  extends ParseTreeListener {

    /**
     * Extract an entity of type T.
     * @return the extracted entity
     */
    T extract();
}
