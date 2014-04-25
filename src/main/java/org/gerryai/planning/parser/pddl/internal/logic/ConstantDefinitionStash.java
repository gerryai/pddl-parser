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
