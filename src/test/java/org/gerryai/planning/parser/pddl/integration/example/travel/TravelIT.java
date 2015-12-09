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
package org.gerryai.planning.parser.pddl.integration.example.travel;

import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.domain.Action;
import org.gerryai.planning.model.logic.Predicate;
import org.gerryai.planning.parser.pddl.integration.DomainSuccessTester;
import org.junit.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Travel example files are parsed correctly.
 */
public class TravelIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/example/travel/travel.pddl";
    }

    @Test
    public void travelDomainHasCorrectName() {
        assertEquals("bulldozer", domain.getName());
    }

    @Test
    public void travelDomainHasThreeRequirements() {
        assertEquals(3, domain.getRequirements().asSet().size());
    }

    @Test
    public void travelDomainHasStripsRequirement() {
        assertTrue(domain.getRequirements().asSet().contains(Requirement.STRIPS));
    }

    @Test
    public void travelDomainHasEqualityRequirement() {
        assertTrue(domain.getRequirements().asSet().contains(Requirement.EQUALITY));
    }

    @Test
    public void travelDomainHasNegativePreconditionsRequirement() {
        assertTrue(domain.getRequirements().asSet().contains(Requirement.NEGATIVE_PRECONDITIONS));
    }

    @Test
    public void travelDomainHasSevenPredicates() {
        assertEquals(7, domain.getPredicates().asSet().size());
    }

    @Test
    public void travelDomainHasPredicateRoad() {
        Predicate road = new Predicate.Builder()
                .name("road")
                .variable("from")
                .variable("to")
                .build();
        assertTrue("Domain contains the (road ?from ?to) predicate", domain.getPredicates().asSet().contains(road));
    }

    @Test
    public void travelDomainHasPredicateAt() {
        Predicate at = new Predicate.Builder()
                .name("at")
                .variable("thing")
                .variable("place")
                .build();
        assertTrue("Domain contains the (at ?thing ?place) predicate", domain.getPredicates().asSet().contains(at));
    }

    @Test
    public void travelDomainHasPredicateMobile() {
        Predicate mobile = new Predicate.Builder()
                .name("mobile")
                .variable("thing")
                .build();
        assertTrue("Domain contains the (mobile ?thing) predicate", domain.getPredicates().asSet().contains(mobile));
    }

    @Test
    public void travelDomainHasPredicateBridge() {
        Predicate bridge = new Predicate.Builder()
                .name("bridge")
                .variable("from")
                .variable("to")
                .build();
        assertTrue("Domain contains the (bridge ?from ?to) predicate", domain.getPredicates().asSet().contains(bridge));
    }

    @Test
    public void travelDomainHasPredicatePerson() {
        Predicate person = new Predicate.Builder()
                .name("person")
                .variable("p")
                .build();
        assertTrue("Domain contains the (person ?p) predicate", domain.getPredicates().asSet().contains(person));
    }

    @Test
    public void travelDomainHasPredicateVehicle() {
        Predicate vehicle = new Predicate.Builder()
                .name("vehicle")
                .variable("v")
                .build();
        assertTrue("Domain contains the (vehicle ?v) predicate", domain.getPredicates().asSet().contains(vehicle));
    }

    @Test
    public void travelDomainHasPredicateDriving() {
        Predicate driving = new Predicate.Builder()
                .name("driving")
                .variable("p")
                .variable("v")
                .build();
        assertTrue("Domain contains the (driving ?p ?v) predicate", domain.getPredicates().asSet().contains(driving));
    }

    @Test
    public void travelDomainHasFourActions() {
        assertEquals(4, domain.getActions().asSet().size());
    }

    @Test
    public void travelDomainHasActionDrive() {
        Action drive = new Action.Builder()
                .name("drive")
                .parameter("thing")
                .parameter("from")
                .parameter("to")
                .precondition(
                        and(
                                predicate("road", variable("from"), variable("to")),
                                predicate("at", variable("thing"), variable("from")),
                                predicate("mobile", variable("thing")),
                                not(equality(variable("from"), variable("to"))))
                )
                .effect(
                        and(
                                predicate("at", variable("thing"), variable("to")),
                                not(predicate("at", variable("thing"), variable("from"))))
                )
                .build();
        assertTrue("Domain contains the Drive action", domain.getActions().asSet().contains(drive));
    }

    @Test
    public void travelDomainHasActionCross() {
        Action cross = new Action.Builder()
                .name("cross")
                .parameter("thing")
                .parameter("from")
                .parameter("to")
                .precondition(
                        and(
                                predicate("bridge", variable("from"), variable("to")),
                                predicate("at", variable("thing"), variable("from")),
                                predicate("mobile", variable("thing")),
                                not(equality(variable("from"), variable("to"))))
                )
                .effect(
                        and(
                                predicate("at", variable("thing"), variable("to")),
                                not(predicate("at", variable("thing"), variable("from"))))
                )
                .build();
        assertTrue("Domain contains the Cross action", domain.getActions().asSet().contains(cross));
    }

    @Test
    public void travelDomainHasActionBoard() {
        Action board = new Action.Builder()
                .name("board")
                .parameter("person")
                .parameter("place")
                .parameter("vehicle")
                .precondition(
                        and(
                                predicate("at", variable("person"), variable("place")),
                                predicate("person", variable("person")),
                                predicate("vehicle", variable("vehicle")),
                                predicate("at", variable("vehicle"), variable("place")))
                )
                .effect(
                        and(
                                predicate("driving", variable("person"), variable("vehicle")),
                                predicate("mobile", variable("vehicle")),
                                not(predicate("at", variable("person"), variable("place"))),
                                not(predicate("mobile", variable("person"))))
                )
                .build();
        assertTrue("Domain contains the Board action", domain.getActions().asSet().contains(board));
    }

    @Test
    public void travelDomainHasActionDisembark() {
        Action disembark = new Action.Builder()
                .name("disembark")
                .parameter("person")
                .parameter("place")
                .parameter("vehicle")
                .precondition(
                        and(
                                predicate("person", variable("person")),
                                predicate("vehicle", variable("vehicle")),
                                predicate("driving", variable("person"), variable("vehicle")),
                                predicate("at", variable("vehicle"), variable("place")))
                )
                .effect(
                        and(
                                predicate("at", variable("person"), variable("place")),
                                predicate("mobile", variable("person")),
                                not(predicate("driving", variable("person"), variable("vehicle"))),
                                not(predicate("mobile", variable("vehicle"))))
                )
                .build();
        assertTrue("Domain contains the Disembark action", domain.getActions().asSet().contains(disembark));
    }
}
