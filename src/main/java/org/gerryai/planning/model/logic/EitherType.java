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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents a list of possible types that a constant or variable is allowed to have.
 */
public class EitherType implements Type {

    private List<PrimitiveType> types;

    /**
     * Constructor.
     * @param names the list of possible type names
     */
    public EitherType(final String... names) {
        List<PrimitiveType> types = new ArrayList<>(names.length);
        for (String name: names) {
            types.add(new PrimitiveType(name));
        }
        this.types = types;
    }

    /**
     * Constructor.
     * @param types the list of possible types
     */
    public EitherType(final List<PrimitiveType> types) {
        this.types = types;
    }

    /**
     * Get the list of types.
     * @return the list of types
     */
    public List<PrimitiveType> getTypes() {
        return Collections.unmodifiableList(types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(types);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final EitherType other = (EitherType) obj;
        return Objects.equals(this.types, other.types);
    }
}
