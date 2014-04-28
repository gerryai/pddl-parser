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
