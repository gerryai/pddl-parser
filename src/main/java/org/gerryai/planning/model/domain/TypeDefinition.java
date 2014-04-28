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
package org.gerryai.planning.model.domain;

import org.gerryai.planning.model.logic.PrimitiveType;
import org.gerryai.planning.model.logic.Type;

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
