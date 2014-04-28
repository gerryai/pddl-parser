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

import org.gerryai.planning.model.domain.Action;
import org.gerryai.planning.parser.pddl.integration.DomainSuccessTester;
import org.junit.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.predicate;
import static org.gerryai.planning.model.logic.FormulaBuilder.variable;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that actions with no precondition are parsed correctly.
 */
public class ActionWithNoPreconditionIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/general/success/action-with-no-precondition.pddl";
    }

    @Test
    public void testDomainHasActionTest() {
        Action testing = new Action.Builder()
                .name("test")
                .parameter("x")
                .precondition()
                .effect(
                        predicate("testing", variable("x"))
                )
                .build();
        assertTrue("Domain contains the test action", domain.getActions().asSet().contains(testing));
    }
}
