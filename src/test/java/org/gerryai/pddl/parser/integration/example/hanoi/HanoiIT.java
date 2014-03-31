package org.gerryai.pddl.parser.integration.example.hanoi;

import org.gerryai.pddl.model.Action;
import org.gerryai.pddl.model.Requirement;
import org.gerryai.pddl.model.logic.Predicate;
import org.gerryai.pddl.parser.integration.SuccessTester;
import org.junit.Test;

import static org.gerryai.pddl.model.logic.FormulaBuilder.and;
import static org.gerryai.pddl.model.logic.FormulaBuilder.not;
import static org.gerryai.pddl.model.logic.FormulaBuilder.predicate;
import static org.gerryai.pddl.model.logic.FormulaBuilder.variable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Hanoi example files are parsed correctly.
 */
public class HanoiIT extends SuccessTester {

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
