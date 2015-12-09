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

import static org.gerryai.planning.model.logic.FormulaBuilder.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that PDDL parsing is case insensitive.
 */
public class CaseInsensitiveDomainIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/general/success/case-insensitive-domain.pddl";
    }

    @Test
    public void testDomainHasLowerCaseDomainName() {
        assertEquals("test", domain.getName());
    }

    @Test
    public void testDomainHasConstantTestConst() {
        assertTrue("Domain contains constant testconst", domain.getConstants().asSet().contains(constantDefinition("testconst", type("testconst2"))));
    }

    @Test
    public void testDomainHasConstantTestConst2() {
        assertTrue("Domain contains constant testconst2", domain.getConstants().asSet().contains(constantDefinition("testconst2")));
    }

    @Test
    public void testDomainHasPredicateTestType() {
        assertTrue("Domain contains type testtype", domain.getTypes().asSet().contains(typeDefinition("testtype", type("testtype2"))));
    }

    @Test
    public void testDomainHasPredicateTestType1() {
        assertTrue("Domain contains type testtype1", domain.getTypes().asSet().contains(typeDefinition("testtype1", type("testtype2"))));
    }

    @Test
    public void testDomainHasPredicateTestType2() {
        assertTrue("Domain contains type testtype2", domain.getTypes().asSet().contains(typeDefinition("testtype2")));
    }

    @Test
    public void testDomainHasPredicateTest1() {
        assertTrue("Domain contains the test1 predicate", domain.getPredicates().asSet().contains(predicate("test1", variable("x"))));
    }

    @Test
    public void testDomainHasPredicateTest2() {
        assertTrue("Domain contains the test2 predicate", domain.getPredicates().asSet().contains(predicate("test2", variable("x", type("testtype")))));
    }

    @Test
    public void testDomainHasPredicateTest3() {
        assertTrue("Domain contains the test3 predicate", domain.getPredicates().asSet().contains(predicate("test3", variable("x", type("testtype1", "testtype2")))));
    }

    @Test
    public void testDomainHasActionTest() {
        Action testing = new Action.Builder()
                .name("test")
                .parameter("x")
                .precondition(
                        predicate("test", variable("x"))
                )
                .effect()
                .build();
        assertTrue("Domain contains the test action", domain.getActions().asSet().contains(testing));
    }
}
