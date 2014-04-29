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
package org.gerryai.planning.parser.pddl.internal;

import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.parser.error.ParseException;

import java.util.Set;

/**
 * Interface for a parse tree listener that can extract an entity of type T after parsing.
 * @param <T> the type of entity that the listener can extract
 */
public interface ExtractingListener<T>  extends ParseTreeListener {

    /**
     * Extract an entity of type T.
     * @return the extracted entity
     */
    T extract();

    /**
     * Extract an entity of type T, checking that it has declared the requirements that it needs.
     * @param requirementsNeeded the set of requirements that the entity actually needs
     * @return the extracted entity
     * @throws ParseException if the extraction failed the requirements check
     */
    T extract(final Set<Requirement> requirementsNeeded) throws ParseException;

}
