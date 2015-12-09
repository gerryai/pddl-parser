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
package org.gerryai.planning.parser.pddl.integration.example.gripper;

import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.domain.Action;
import org.gerryai.planning.model.logic.Predicate;
import org.gerryai.planning.parser.pddl.integration.DomainSuccessTester;
import org.junit.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Gripper example files are parsed correctly.
 */
public class GripperIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/example/gripper/gripper.pddl";
    }

    @Test
    public void gripperDomainHasCorrectName() {
        assertEquals("gripper", domain.getName());
    }

    @Test
    public void gripperDomainHasOneRequirement() {
        assertEquals(1, domain.getRequirements().asSet().size());
    }

    @Test
    public void gripperDomainHasStripsRequirement() {
        assertTrue(domain.getRequirements().asSet().contains(Requirement.STRIPS));
    }

    @Test
    public void gripperDomainHasSevenPredicates() {
        assertEquals(7, domain.getPredicates().asSet().size());
    }

    @Test
    public void gripperDomainHasPredicateRoom() {
        Predicate room = new Predicate.Builder()
                .name("room")
                .variable("r")
                .build();
        assertTrue("Domain contains the (room ?r) predicate", domain.getPredicates().asSet().contains(room));
    }

    @Test
    public void gripperDomainHasPredicateBall() {
        Predicate ball = new Predicate.Builder()
                .name("ball")
                .variable("b")
                .build();
        assertTrue("Domain contains the (ball ?b) predicate", domain.getPredicates().asSet().contains(ball));
    }

    @Test
    public void gripperDomainHasPredicateGripper() {
        Predicate ball = new Predicate.Builder()
                .name("gripper")
                .variable("g")
                .build();
        assertTrue("Domain contains the (gripper ?g) predicate", domain.getPredicates().asSet().contains(ball));
    }

    @Test
    public void gripperDomainHasPredicateAtRobby() {
        Predicate atRobby = new Predicate.Builder()
                .name("at-robby")
                .variable("r")
                .build();
        assertTrue("Domain contains the (at-robby ?r) predicate", domain.getPredicates().asSet().contains(atRobby));
    }

    @Test
    public void gripperDomainHasPredicateAt() {
        Predicate at = new Predicate.Builder()
                .name("at")
                .variable("b")
                .variable("r")
                .build();
        assertTrue("Domain contains the (at ?b ?r) predicate", domain.getPredicates().asSet().contains(at));
    }

    @Test
    public void gripperDomainHasPredicateFree() {
        Predicate free = new Predicate.Builder()
                .name("free")
                .variable("g")
                .build();
        assertTrue("Domain contains the (free ?g) predicate", domain.getPredicates().asSet().contains(free));
    }

    @Test
    public void gripperDomainHasPredicateCarry() {
        Predicate carry = new Predicate.Builder()
                .name("carry")
                .variable("o")
                .variable("g")
                .build();
        assertTrue("Domain contains the (carry ?o ?g) predicate", domain.getPredicates().asSet().contains(carry));
    }

    @Test
    public void gripperDomainHasThreeActions() {
        assertEquals(3, domain.getActions().asSet().size());
    }

    @Test
    public void gripperDomainHasActionMove() {
        Action move = new Action.Builder()
                .name("move")
                .parameter("from")
                .parameter("to")
                .precondition(
                        and(
                                predicate("room", variable("from")),
                                predicate("room", variable("to")),
                                predicate("at-robby", variable("from")))
                )
                .effect(
                        and(
                                predicate("at-robby", variable("to")),
                                not(predicate("at-robby", variable("from"))))
                )
                .build();
        assertTrue("Domain contains the move action", domain.getActions().asSet().contains(move));
    }

    @Test
    public void gripperDomainHasActionPick() {
        Action pick = new Action.Builder()
                .name("pick")
                .parameter("obj")
                .parameter("room")
                .parameter("gripper")
                .precondition(
                        and(
                                predicate("ball", variable("obj")),
                                predicate("room", variable("room")),
                                predicate("gripper", variable("gripper")),
                                predicate("at", variable("obj"), variable("room")),
                                predicate("at-robby", variable("room")),
                                predicate("free", variable("gripper")))
                )
                .effect(
                        and(
                                predicate("carry", variable("obj"), variable("gripper")),
                                not(predicate("at", variable("obj"), variable("room"))),
                                not(predicate("free", variable("gripper"))))
                )
                .build();
        assertTrue("Domain contains the pick action", domain.getActions().asSet().contains(pick));
    }

    @Test
    public void gripperDomainHasActionDrop() {
        Action pick = new Action.Builder()
                .name("drop")
                .parameter("obj")
                .parameter("room")
                .parameter("gripper")
                .precondition(
                        and(
                                predicate("ball", variable("obj")),
                                predicate("room", variable("room")),
                                predicate("gripper", variable("gripper")),
                                predicate("carry", variable("obj"), variable("gripper")),
                                predicate("at-robby", variable("room")))
                )
                .effect(
                        and(
                                predicate("at", variable("obj"), variable("room")),
                                predicate("free", variable("gripper")),
                                not(predicate("carry", variable("obj"), variable("gripper"))))
                )
                .build();
        assertTrue("Domain contains the pick action", domain.getActions().asSet().contains(pick));
    }
}
