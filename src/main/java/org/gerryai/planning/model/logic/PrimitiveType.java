package org.gerryai.planning.model.logic;

import java.util.Objects;

/**
 * Represents the type of a logical constant or variable. A primitive type is effectively just a type name.
 */
public class PrimitiveType implements Type {

    private String name;

    /**
     * Constructor.
     * @param name the type's name.
     */
    public PrimitiveType(final String name) {
        this.name = name;
    }

    /**
     * Get the name of the type.
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final PrimitiveType other = (PrimitiveType) obj;
        return Objects.equals(this.name, other.name);
    }
}
