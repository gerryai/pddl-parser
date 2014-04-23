package org.gerryai.pddl.model.logic;

import com.google.common.base.Optional;

import java.util.Objects;

/**
 * Class representing a logical constant.
 */
public class Constant extends Function {

    private String name;
    private Optional<Type> type = Optional.absent();

    /**
     * Constructor.
     * @param name the name of the constant
     */
    public Constant(final String name) {
        this.name = name;
    }

    /**
     * Constructor.
     * @param name the name of the constant
     * @param type the type of the constant
     */
    public Constant(final String name, final Type type) {
        this.name = name;
        this.type = Optional.fromNullable(type);
    }

    /**
     * Get the name of the constant.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the type of the constant.
     * @return the optional type of this constant
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
        final Constant other = (Constant) obj;
        return Objects.equals(this.name, other.name) && Objects.equals(this.type, other.type);
    }
}
