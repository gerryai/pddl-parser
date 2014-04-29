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
package org.gerryai.planning.parser.error;

import org.gerryai.planning.model.Requirement;

import java.util.Set;

/**
 * Parsing exception thrown when a domain or problem do not declare all the requirements that they use.
 */
public class MissingRequirementsException extends ParseException {

    private Set<Requirement> missingRequirements;

    /**
     * Constructor.
     * @param missingRequirements the set of requirements that are missing
     */
    public MissingRequirementsException(final Set<Requirement> missingRequirements) {
        this.missingRequirements = missingRequirements;
    }

    /**
     * Get the set of requirements that are missing.
     * @return the requirements
     */
    public Set<Requirement> getMissingRequirements() {
        return missingRequirements;
    }
}
