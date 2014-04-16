package org.gerryai.pddl.parser.integration.example.logistics;

import org.gerryai.pddl.model.Action;
import org.gerryai.pddl.model.Requirement;
import org.gerryai.pddl.model.logic.Predicate;
import org.gerryai.pddl.parser.integration.SuccessTester;
import org.junit.Test;

import static org.gerryai.pddl.model.logic.FormulaBuilder.type;
import static org.gerryai.pddl.model.logic.FormulaBuilder.and;
import static org.gerryai.pddl.model.logic.FormulaBuilder.not;
import static org.gerryai.pddl.model.logic.FormulaBuilder.predicate;
import static org.gerryai.pddl.model.logic.FormulaBuilder.typeDefinition;
import static org.gerryai.pddl.model.logic.FormulaBuilder.variable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Logistics example files are parsed correctly.
 */
public class LogisticsIT extends SuccessTester {

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

//    @Test
//    public void logisticsDomainHasPredicateClear() {
//        Predicate clear = new Predicate.Builder()
//                .name("clear")
//                .variable("x")
//                .build();
//        assertTrue("Domain contains the (clear ?x) predicate", domain.getPredicates().asSet().contains(clear));
//    }
//
//    @Test
//    public void logisticsDomainHasPredicateOn() {
//        Predicate on = new Predicate.Builder()
//                .name("on")
//                .variable("x")
//                .variable("y")
//                .build();
//        assertTrue("Domain contains the (on ?x ?y) predicate", domain.getPredicates().asSet().contains(on));
//    }
//
//    @Test
//    public void logisticsDomainHasPredicateSmaller() {
//        Predicate smaller = new Predicate.Builder()
//                .name("smaller")
//                .variable("x")
//                .variable("y")
//                .build();
//        assertTrue("Domain contains the (smaller ?x ?y) predicate", domain.getPredicates().asSet().contains(smaller));
//    }
//
//    @Test
//    public void logisticsDomainHasOneAction() {
//        assertEquals(1, domain.getActions().asSet().size());
//    }
//
//    @Test
//    public void logisticsDomainHasActionMove() {
//        Action move = new Action.Builder()
//                .name("move")
//                .parameter("disc")
//                .parameter("from")
//                .parameter("to")
//                .precondition(
//                        and(
//                                predicate("smaller", variable("to"), variable("disc")),
//                                predicate("on", variable("disc"), variable("from")),
//                                predicate("clear", variable("disc")),
//                                predicate("clear", variable("to")))
//                )
//                .effect(
//                        and(
//                                predicate("clear", variable("from")),
//                                predicate("on", variable("disc"), variable("to")),
//                                not(predicate("on", variable("disc"), variable("from"))),
//                                not(predicate("clear", variable("to"))))
//                )
//                .build();
//        assertTrue("Domain contains the move action", domain.getActions().asSet().contains(move));
//    }
}
