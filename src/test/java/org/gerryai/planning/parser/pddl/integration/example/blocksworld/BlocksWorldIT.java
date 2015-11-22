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
package org.gerryai.planning.parser.pddl.integration.example.blocksworld;

import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.domain.Action;
import org.gerryai.planning.model.logic.Predicate;
import org.gerryai.planning.parser.pddl.integration.DomainSuccessTester;
import org.junit.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Blocksworld example files are parsed correctly.
 */
public class BlocksWorldIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/example/blocksworld/blocksworld.pddl";
    }

    @Test
    public void blocksWorldDomainHasCorrectName() {
        assertEquals("blocksworld", domain.getName());
    }

    @Test
    public void blocksWorldDomainHasOneRequirement() {
        assertEquals(1, domain.getRequirements().asSet().size());
    }

    @Test
    public void blocksWorldDomainHasStripsRequirement() {
        assertTrue(domain.getRequirements().asSet().contains(Requirement.STRIPS));
    }

    @Test
    public void blocksWorldDomainHasFivePredicates() {
        assertEquals(5, domain.getPredicates().asSet().size());
    }

    @Test
    public void blocksWorldDomainHasPredicateClear() {
        Predicate clear = new Predicate.Builder()
                .name("clear")
                .variable("x")
                .build();
        assertTrue("Domain contains the (clear ?x) predicate", domain.getPredicates().asSet().contains(clear));
    }

    @Test
    public void blocksWorldDomainHasPredicateOnTable() {
        Predicate onTable = new Predicate.Builder()
                .name("on-table")
                .variable("x")
                .build();
        assertTrue("Domain contains the (on-table ?x) predicate", domain.getPredicates().asSet().contains(onTable));
    }

    @Test
    public void blocksWorldDomainHasPredicateArmEmpty() {
        Predicate armEmpty = new Predicate.Builder()
                .name("arm-empty")
                .build();
        assertTrue("Domain contains the (arm-empty) predicate", domain.getPredicates().asSet().contains(armEmpty));
    }

    @Test
    public void blocksWorldDomainHasPredicateHolding() {
        Predicate holding = new Predicate.Builder()
                .name("holding")
                .variable("x")
                .build();
        assertTrue("Domain contains the (holding ?x) predicate", domain.getPredicates().asSet().contains(holding));
    }

    @Test
    public void blocksWorldDomainHasPredicateOn() {
        Predicate on = new Predicate.Builder()
                .name("on")
                .variable("x")
                .variable("y")
                .build();
        assertTrue("Domain contains the (on ?x ?y) predicate", domain.getPredicates().asSet().contains(on));
    }

    @Test
    public void blocksWorldDomainHasFourActions() {
        assertEquals(4, domain.getActions().asSet().size());
    }

    @Test
    public void blocksWorldDomainHasActionPickup() {
        Action pickup = new Action.Builder()
                .name("pickup")
                .parameter("ob")
                .precondition(
                        and(
                                predicate("clear", variable("ob")),
                                predicate("on-table", variable("ob")),
                                predicate("arm-empty"))
                )
                .effect(
                        and(
                                predicate("holding", variable("ob")),
                                not(predicate("clear", variable("ob"))),
                                not(predicate("on-table", variable("ob"))),
                                not(predicate("arm-empty")))
                )
                .build();
        assertTrue("Domain contains the pickup action", domain.getActions().asSet().contains(pickup));
    }

    @Test
    public void blocksWorldDomainHasActionPutDown() {
        Action putDown = new Action.Builder()
                .name("putdown")
                .parameter("ob")
                .precondition(
                        and(
                                predicate("holding", variable("ob")))
                )
                .effect(
                        and(
                                predicate("clear", variable("ob")),
                                predicate("arm-empty"),
                                predicate("on-table", variable("ob")),
                                not(predicate("holding", variable("ob"))))
                )
                .build();
        assertTrue("Domain contains the putdown action", domain.getActions().asSet().contains(putDown));
    }

    @Test
    public void blocksWorldDomainHasActionStack() {
        Action stack = new Action.Builder()
                .name("stack")
                .parameter("ob")
                .parameter("underob")
                .precondition(
                        and(
                                predicate("clear", variable("underob")),
                                predicate("holding", variable("ob")))
                )
                .effect(
                        and(
                                predicate("arm-empty"),
                                predicate("clear", variable("ob")),
                                predicate("on", variable("ob"), variable("underob")),
                                not(predicate("clear", variable("underob"))),
                                not(predicate("holding", variable("ob"))))
                )
                .build();
        assertTrue("Domain contains the stack action", domain.getActions().asSet().contains(stack));
    }

    @Test
    public void blocksWorldDomainHasActionUnstack() {
        Action unstack = new Action.Builder()
                .name("unstack")
                .parameter("ob")
                .parameter("underob")
                .precondition(
                        and(
                                predicate("on", variable("ob"), variable("underob")),
                                predicate("clear", variable("ob")),
                                predicate("arm-empty"))
                )
                .effect(
                        and(
                                predicate("holding", variable("ob")),
                                predicate("clear", variable("underob")),
                                not(predicate("on", variable("ob"), variable("underob"))),
                                not(predicate("clear", variable("ob"))),
                                not(predicate("arm-empty")))
                )
                .build();
        assertTrue("Domain contains the unstack action", domain.getActions().asSet().contains(unstack));
    }
}
