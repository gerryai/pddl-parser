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
