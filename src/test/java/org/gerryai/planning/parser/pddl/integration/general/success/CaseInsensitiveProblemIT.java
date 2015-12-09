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
package org.gerryai.planning.parser.pddl.integration.general.success;

import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.problem.Goal;
import org.gerryai.planning.parser.pddl.integration.ProblemSuccessTester;
import org.junit.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that PDDL parsing is case insensitive.
 */
public class CaseInsensitiveProblemIT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/general/success/case-insensitive-problem.pddl";
    }

    @Test
    public void testProblemHasLowerCaseName() {
        assertEquals("test", problem.getName());
    }

    @Test
    public void testProblemHasLowerCaseDomainName() {
        assertEquals("test", problem.getDomainName());
    }

    @Test
    public void testProblemHasObjectTest1() {
        assertTrue("Problem contains the test object", problem.getObjects().asSet().contains(new ConstantDefinition("test1", type("testtype"))));
    }

    @Test
    public void testProblemHasObjectTest2() {
        assertTrue("Problem contains the test object", problem.getObjects().asSet().contains(new ConstantDefinition("test2", type("testtype1", "testtype2"))));
    }

    @Test
    public void testProblemHasGoal() {
        Goal goal = new Goal(predicate("test", constant("a"), constant("b")));
        assertEquals(goal, problem.getGoal());
    }
}
