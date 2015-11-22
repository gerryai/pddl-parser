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
package org.gerryai.planning.parser.pddl.integration.example.logistics;

import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.domain.Action;
import org.gerryai.planning.model.logic.Predicate;
import org.gerryai.planning.parser.pddl.integration.DomainSuccessTester;
import org.junit.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Logistics example files are parsed correctly.
 */
public class LogisticsIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/example/logistics/logistics.pddl";
    }

    @Test
    public void logisticsDomainHasCorrectName() {
        assertEquals("logistics", domain.getName());
    }

    @Test
    public void logisticsDomainHasTwoRequirements() {
        assertEquals(2, domain.getRequirements().asSet().size());
    }

    @Test
    public void logisticsDomainHasStripsRequirement() {
        assertTrue(domain.getRequirements().asSet().contains(Requirement.STRIPS));
    }

    @Test
    public void logisticsDomainHasTypingRequirement() {
        assertTrue(domain.getRequirements().asSet().contains(Requirement.TYPING));
    }

    @Test
    public void logisticsDomainHasSevenTypes() {
        assertEquals(7, domain.getTypes().asSet().size());
    }

    @Test
    public void logisticsDomainHasTypePackage() {
        assertTrue(domain.getTypes().asSet().contains(typeDefinition("package")));
    }

    @Test
    public void logisticsDomainHasTypeLocation() {
        assertTrue(domain.getTypes().asSet().contains(typeDefinition("location")));
    }

    @Test
    public void logisticsDomainHasTypeVehicle() {
        assertTrue(domain.getTypes().asSet().contains(typeDefinition("vehicle")));
    }

    @Test
    public void logisticsDomainHasTypeTruck() {
        assertTrue(domain.getTypes().asSet().contains(typeDefinition("truck", type("vehicle"))));
    }

    @Test
    public void logisticsDomainHasTypeAirplane() {
        assertTrue(domain.getTypes().asSet().contains(typeDefinition("airplane", type("vehicle"))));
    }

    @Test
    public void logisticsDomainHasTypeCity() {
        assertTrue(domain.getTypes().asSet().contains(typeDefinition("city", type("location"))));
    }

    @Test
    public void logisticsDomainHasTypeAirport() {
        assertTrue(domain.getTypes().asSet().contains(typeDefinition("airport", type("location"))));
    }

    @Test
    public void logisticsDomainHasThreePredicates() {
        assertEquals(3, domain.getPredicates().asSet().size());
    }

    @Test
    public void logisticsDomainHasPredicateAt() {
        Predicate at = new Predicate.Builder()
                .name("at")
                .variable("vehicle-or-package", type("vehicle", "package"))
                .variable("location", type("location"))
                .build();
        assertTrue("Domain contains the (at ?vehicle-or-package - (either vehicle package)  ?location - location) "
                + "predicate", domain.getPredicates().asSet().contains(at));
    }

    @Test
    public void logisticsDomainHasPredicateIn() {
        Predicate in = new Predicate.Builder()
                .name("in")
                .variable("package", type("package"))
                .variable("vehicle", type("vehicle"))
                .build();
        assertTrue("Domain contains the (in ?package - package ?vehicle - vehicle) predicate",
                domain.getPredicates().asSet().contains(in));
    }

    @Test
    public void logisticsDomainHasPredicateInCity() {
        Predicate inCity = new Predicate.Builder()
                .name("in-city")
                .variable("loc-or-truck", type("location", "truck"))
                .variable("citys", type("city"))
                .build();
        assertTrue("Domain contains the (in-city ?loc-or-truck - (either location truck) ?citys - city) predicate",
                domain.getPredicates().asSet().contains(inCity));
    }


    @Test
    public void logisticsDomainHasSixActions() {
        assertEquals(6, domain.getActions().asSet().size());
    }

    @Test
    public void logisticsDomainHasActionLoadTruck() {
        Action loadTruck = new Action.Builder()
                .name("load-truck")
                .parameter("obj", type("package"))
                .parameter("truck", type("truck"))
                .parameter("loc", type("location"))
                .precondition(
                        and(
                                predicate("at", variable("truck"), variable("loc")),
                                predicate("at", variable("obj"), variable("loc"))))
                .effect(
                        and(
                                not(predicate("at", variable("obj"), variable("loc"))),
                                predicate("in", variable("obj"), variable("truck"))))
                .build();
        assertTrue("Domain contains the load-truck action", domain.getActions().asSet().contains(loadTruck));
    }

    @Test
    public void logisticsDomainHasActionLoadAirplane() {
        Action loadAirplane = new Action.Builder()
                .name("load-airplane")
                .parameter("obj", type("package"))
                .parameter("airplane", type("airplane"))
                .parameter("loc", type("airport"))
                .precondition(
                        and(
                                predicate("at", variable("obj"), variable("loc")),
                                predicate("at", variable("airplane"), variable("loc"))))
                .effect(
                        and(
                                not(predicate("at", variable("obj"), variable("loc"))),
                                predicate("in", variable("obj"), variable("airplane"))))
                .build();
        assertTrue("Domain contains the load-airplane action", domain.getActions().asSet().contains(loadAirplane));
    }

    @Test
    public void logisticsDomainHasActionUnloadTruck() {
        Action unloadTruck = new Action.Builder()
                .name("unload-truck")
                .parameter("obj", type("package"))
                .parameter("truck", type("truck"))
                .parameter("loc", type("location"))
                .precondition(
                        and(
                                predicate("at", variable("truck"), variable("loc")),
                                predicate("in", variable("obj"), variable("truck"))))
                .effect(
                        and(
                                not(predicate("in", variable("obj"), variable("truck"))),
                                predicate("at", variable("obj"), variable("loc"))))
                .build();
        assertTrue("Domain contains the unload-truck action", domain.getActions().asSet().contains(unloadTruck));
    }

    @Test
    public void logisticsDomainHasActionUnloadAirplane() {
        Action unloadAirplane = new Action.Builder()
                .name("unload-airplane")
                .parameter("obj", type("package"))
                .parameter("airplane", type("airplane"))
                .parameter("loc", type("airport"))
                .precondition(
                        and(
                                predicate("in", variable("obj"), variable("airplane")),
                                predicate("at", variable("airplane"), variable("loc"))))
                .effect(
                        and(
                                not(predicate("in", variable("obj"), variable("airplane"))),
                                predicate("at", variable("obj"), variable("loc"))))
                .build();
        assertTrue("Domain contains the unload-airplane action", domain.getActions().asSet().contains(unloadAirplane));
    }

    @Test
    public void logisticsDomainHasActionDriveTruck() {
        Action driveTruck = new Action.Builder()
                .name("drive-truck")
                .parameter("truck", type("truck"))
                .parameter("loc-from", type("location"))
                .parameter("loc-to", type("location"))
                .parameter("city", type("city"))
                .precondition(
                        and(
                                predicate("at", variable("truck"), variable("loc-from")),
                                predicate("in-city", variable("loc-from"), variable("city")),
                                predicate("in-city", variable("loc-to"), variable("city"))))
                .effect(
                        and(
                                not(predicate("at", variable("truck"), variable("loc-from"))),
                                predicate("at", variable("truck"), variable("loc-to"))))
                .build();
        assertTrue("Domain contains the drive-truck action", domain.getActions().asSet().contains(driveTruck));
    }

    @Test
    public void logisticsDomainHasActionFryAirplane() {
        Action flyAirplane = new Action.Builder()
                .name("fly-airplane")
                .parameter("airplane", type("airplane"))
                .parameter("loc-from", type("airport"))
                .parameter("loc-to", type("airport"))
                .precondition(
                        predicate("at", variable("airplane"), variable("loc-from")))
                .effect(
                        and(
                                not(predicate("at", variable("airplane"), variable("loc-from"))),
                                predicate("at", variable("airplane"), variable("loc-to")))
                )
                .build();
        assertTrue("Domain contains the fly-airplane action", domain.getActions().asSet().contains(flyAirplane));
    }
}
