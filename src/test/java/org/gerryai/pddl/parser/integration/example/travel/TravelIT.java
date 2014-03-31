package org.gerryai.pddl.parser.integration.example.travel;

import org.gerryai.pddl.model.Action;
import org.gerryai.pddl.model.Requirement;
import org.gerryai.pddl.model.logic.Predicate;
import org.gerryai.pddl.parser.integration.SuccessTester;
import org.junit.Test;

import static org.gerryai.pddl.model.logic.FormulaBuilder.and;
import static org.gerryai.pddl.model.logic.FormulaBuilder.equality;
import static org.gerryai.pddl.model.logic.FormulaBuilder.not;
import static org.gerryai.pddl.model.logic.FormulaBuilder.predicate;
import static org.gerryai.pddl.model.logic.FormulaBuilder.variable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Travel example files are parsed correctly.
 */
public class TravelIT extends SuccessTester {

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
                .name("Drive")
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
                .name("Cross")
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
                .name("Board")
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
                .name("Disembark")
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
