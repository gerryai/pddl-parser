package org.gerryai.pddl.model.logic;

import java.util.Objects;

/**
 * Class representing a logical variable.
 */
public class Variable implements Term {

    private String name;

    /**
     * Constructor.
     * @param name the name of the constant.
     */
    public Variable(final String name) {
        this.name = name;
    }

    /**
     * Get the name of the constant.
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
        final Variable other = (Variable) obj;
        return Objects.equals(this.name, other.name);
    }
}
