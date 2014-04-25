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
