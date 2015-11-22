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
package org.gerryai.planning.parser.pddl.integration.example.hanoi;

import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.domain.Action;
import org.gerryai.planning.model.logic.Predicate;
import org.gerryai.planning.parser.pddl.integration.DomainSuccessTester;
import org.junit.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Hanoi example files are parsed correctly.
 */
public class HanoiIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/example/hanoi/hanoi.pddl";
    }

    @Test
    public void hanoiDomainHasCorrectName() {
        assertEquals("hanoi", domain.getName());
    }

    @Test
    public void hanoiDomainHasOneRequirement() {
        assertEquals(1, domain.getRequirements().asSet().size());
    }

    @Test
    public void hanoiDomainHasStripsRequirement() {
        assertTrue(domain.getRequirements().asSet().contains(Requirement.STRIPS));
    }

    @Test
    public void hanoiDomainHasThreePredicates() {
        assertEquals(3, domain.getPredicates().asSet().size());
    }

    @Test
    public void hanoiDomainHasPredicateClear() {
        Predicate clear = new Predicate.Builder()
                .name("clear")
                .variable("x")
                .build();
        assertTrue("Domain contains the (clear ?x) predicate", domain.getPredicates().asSet().contains(clear));
    }

    @Test
    public void hanoiDomainHasPredicateOn() {
        Predicate on = new Predicate.Builder()
                .name("on")
                .variable("x")
                .variable("y")
                .build();
        assertTrue("Domain contains the (on ?x ?y) predicate", domain.getPredicates().asSet().contains(on));
    }

    @Test
    public void hanoiDomainHasPredicateSmaller() {
        Predicate smaller = new Predicate.Builder()
                .name("smaller")
                .variable("x")
                .variable("y")
                .build();
        assertTrue("Domain contains the (smaller ?x ?y) predicate", domain.getPredicates().asSet().contains(smaller));
    }

    @Test
    public void hanoiDomainHasOneAction() {
        assertEquals(1, domain.getActions().asSet().size());
    }

    @Test
    public void hanoiDomainHasActionMove() {
        Action move = new Action.Builder()
                .name("move")
                .parameter("disc")
                .parameter("from")
                .parameter("to")
                .precondition(
                        and(
                                predicate("smaller", variable("to"), variable("disc")),
                                predicate("on", variable("disc"), variable("from")),
                                predicate("clear", variable("disc")),
                                predicate("clear", variable("to")))
                )
                .effect(
                        and(
                                predicate("clear", variable("from")),
                                predicate("on", variable("disc"), variable("to")),
                                not(predicate("on", variable("disc"), variable("from"))),
                                not(predicate("clear", variable("to"))))
                )
                .build();
        assertTrue("Domain contains the move action", domain.getActions().asSet().contains(move));
    }
}
