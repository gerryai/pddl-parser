package org.gerryai.planning.parser.pddl.internal.logic;

import com.google.common.base.Optional;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

/**
 * Class for holding the name of a symbol being built.
 */
public class SymbolStash {

    private Optional<String> symbol = Optional.absent();

    /**
     * Push a symbol name into the stash.
     * @param name the name of the symbol being built.
     */
    public void push(final String name) {
        checkState(!symbol.isPresent(), "Cannot push a symbol if the last one hasn't been collected yet");
        checkNotNull(name);
        symbol = Optional.fromNullable(name);
    }

    /**
     * Pop the name of the symbol being built from the stash.
     * @return the symbol name
     */
    public String pop() {
        checkState(symbol.isPresent(), "Expected a symbol to be ready for collection");
        String name = symbol.get();
        symbol = Optional.absent();
        return name;
    }

    /**
     * Check if the stash is empty.
     * @return true if no symbol name has been stashed.
     */
    public boolean isEmpty() {
        return !symbol.isPresent();
    }
}
