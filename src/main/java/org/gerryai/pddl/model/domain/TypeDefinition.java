package org.gerryai.pddl.model.domain;

import org.gerryai.pddl.model.logic.PrimitiveType;
import org.gerryai.pddl.model.logic.Type;

import java.util.Objects;

/**
 * Defines a type used by the domain being described.
 * Note that the parent of a type definition is a type, not a type definition.
 */
public class TypeDefinition {

    private String name;

    private Type parent;

    private static final PrimitiveType OBJECT = new PrimitiveType("object");

    /**
     * Returns the default object type.
     * @return the object type
     */
    public static PrimitiveType object() {
        return OBJECT;
    }

    /**
     * Constructor.
     * @param name the type's name.
     */
    public TypeDefinition(final String name) {
        this.name = name;
        this.parent = OBJECT;
    }

    /**
     * Constructor.
     * @param name the type's name.
     * @param parent the type's parent type.
     */
    public TypeDefinition(final String name, final Type parent) {
        this.name = name;
        this.parent = parent;
    }

    /**
     * Get the name of the type.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the parent of this type.
     * @return the parent type
     */
    public Type getParent() {
        return parent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parent);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final TypeDefinition other = (TypeDefinition) obj;
        return Objects.equals(this.name, other.name) && Objects.equals(this.parent, other.parent);
    }
}
