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
