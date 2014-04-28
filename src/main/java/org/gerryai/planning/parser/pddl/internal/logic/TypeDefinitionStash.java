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

import org.gerryai.planning.model.domain.TypeDefinition;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Stash for storing completed types.
 */
public class TypeDefinitionStash {

    private Deque<TypeDefinition> typeDeque = new ArrayDeque<>();

    /**
     * Add a finished type to the stash.
     * @param type the type to add
     */
    public void add(final TypeDefinition type) {
        typeDeque.add(type);
    }

    /**
     * Remove all the types from the stash.
     * @return a list of types
     */
    public List<TypeDefinition> removeAll() {
        List<TypeDefinition> types = new ArrayList<>(typeDeque.size());
        while (!typeDeque.isEmpty()) {
            types.add(remove());
        }
        return types;
    }

    /**
     * Remove the oldest type from the stash.
     * @return the type
     */
    public TypeDefinition remove() {
        return typeDeque.removeFirst();
    }
}
