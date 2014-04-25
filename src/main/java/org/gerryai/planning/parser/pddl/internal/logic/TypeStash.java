package org.gerryai.planning.parser.pddl.internal.logic;

import org.gerryai.planning.model.logic.EitherType;
import org.gerryai.planning.model.logic.PrimitiveType;
import org.gerryai.planning.model.logic.Type;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static com.google.common.base.Preconditions.checkState;

/**
 * Stash for type names.
 */
public class TypeStash {

    private Deque<String> typeDeque = new ArrayDeque<>();

    private boolean isCompletedEither = false;
    private boolean isInEither = false;

    /**
     * Add a type name to the stash.
     * @param name the name of the type to add
     */
    public void add(final String name) {
        checkState(isInEither || typeDeque.isEmpty(), "Can only stash a second name in an Either list");
        typeDeque.add(name);
    }

    /**
     * Mark this stash as being used for an (either XXX YYY) list.
     */
    public void beginEither() {
        checkState(!isInEither, "Cannot start a new Either list before the old one is ended");
        checkState(!isCompletedEither, "Cannot start a new Either list before the old one is collected");
        checkState(typeDeque.isEmpty(), "Cannot start an Either list if there are unclaimed names in the stash");
        isInEither = true;
    }

    /**
     * Mark the current (either XXX YYY) list as complete.
     */
    public void endEither() {
        checkState(isInEither, "Cannot end an Either list if one was never started");
        checkState(typeDeque.size() > 0, "Cannot end an Either list with no types in the list");
        isInEither = false;
        isCompletedEither = true;
    }

    /**
     * Remove the finished type from the stash.
     * @return a list of names
     */
    public Type remove() {
        checkState(!isInEither, "Cannot remove the collected type whilst an Either list is incomplete");
        Type type;
        if (isCompletedEither) {
            List<PrimitiveType> types = new ArrayList<>(typeDeque.size());
            while (!typeDeque.isEmpty()) {
                types.add(new PrimitiveType(typeDeque.remove()));
            }
            type = new EitherType(types);
        } else {
            type = new PrimitiveType(typeDeque.remove());
        }

        checkState(typeDeque.isEmpty(), "Type stash should be empty after the type is collected");
        isCompletedEither = false;
        isInEither = false;

        return type;
    }

    /**
     * Return the size of the type stash.
     * @return the size
     */
    public int size() {
        return typeDeque.size();
    }
}
