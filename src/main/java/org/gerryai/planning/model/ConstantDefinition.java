package org.gerryai.planning.model;

import com.google.common.base.Optional;
import org.gerryai.planning.model.logic.Type;

import java.util.Objects;

/**
 * Defines a constant used by the domain being described.
 */
public class ConstantDefinition {

    private String name;

    private Optional<Type> type = Optional.absent();

    /**
     * Constructor.
     * @param name the type's name.
     */
    public ConstantDefinition(final String name) {
        this.name = name;
    }

    /**
     * Constructor.
     * @param name the constant's name.
     * @param type the constant's type.
     */
    public ConstantDefinition(final String name, final Type type) {
        this.name = name;
        this.type = Optional.fromNullable(type);
    }

    /**
     * Get the name of the type.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the type of the constant.
     * @return the optional type of this variable
     */
    public Optional<Type> getType() {
        return type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ConstantDefinition other = (ConstantDefinition) obj;
        return Objects.equals(this.name, other.name) && Objects.equals(this.type, other.type);
    }
}
