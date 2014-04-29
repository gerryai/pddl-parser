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
package org.gerryai.planning.parser.pddl.integration.general.failure;

import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.parser.pddl.integration.PDDLDomainLoader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the paser copes with missing requirements.
 * TODO: Make this parse but fail while building the domain
 */
public class MissingEqualityIT extends PDDLDomainLoader {

    protected String getFilePath() {
        return "pddl/general/failure/missing-equality.pddl";
    }

    @Test
    public void parseFailsWithMissingEqualityRequirement() {
        assertEquals(1, missingRequirements.size());
        assertTrue(missingRequirements.contains(Requirement.EQUALITY));
    }
}
