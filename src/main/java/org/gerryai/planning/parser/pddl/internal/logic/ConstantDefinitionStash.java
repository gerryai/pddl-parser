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

import org.gerryai.planning.model.ConstantDefinition;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Stash for storing completed constants.
 */
public class ConstantDefinitionStash {

    private Deque<ConstantDefinition> constantDeque = new ArrayDeque<>();

    /**
     * Add a finished constant to the stash.
     * @param constant the type to add
     */
    public void add(final ConstantDefinition constant) {
        constantDeque.add(constant);
    }

    /**
     * Remove all the constants from the stash.
     * @return a list of types
     */
    public List<ConstantDefinition> removeAll() {
        List<ConstantDefinition> types = new ArrayList<>(constantDeque.size());
        while (!constantDeque.isEmpty()) {
            types.add(remove());
        }
        return types;
    }

    /**
     * Remove the constant type from the stash.
     * @return the constant
     */
    public ConstantDefinition remove() {
        return constantDeque.removeFirst();
    }
}
