package org.gerryai.pddl.model.logic;

import com.google.common.base.Optional;

import java.util.Objects;

/**
 * Class representing a logical variable.
 */
public class Variable implements Term {

    private String name;
    private Optional<Type> type = Optional.absent();

    /**
     * Constructor.
     * @param name the name of the variable
     */
    public Variable(final String name) {
        this.name = name;
    }

    /**
     * Constructor.
     * @param name the name of the variable
     * @param type the type of the variable
     */
    public Variable(final String name, final Type type) {
        this.name = name;
        this.type = Optional.fromNullable(type);
    }

    /**
     * Get the name of the variable.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the type of the variable.
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
        final Variable other = (Variable) obj;
        return Objects.equals(this.name, other.name) && Objects.equals(this.type, other.type);
    }
}
