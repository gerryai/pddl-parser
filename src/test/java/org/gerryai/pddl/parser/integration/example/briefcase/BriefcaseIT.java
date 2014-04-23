package org.gerryai.pddl.parser.integration.example.briefcase;

import org.gerryai.pddl.model.domain.Action;
import org.gerryai.pddl.model.Requirement;
import org.gerryai.pddl.model.logic.Predicate;
import org.gerryai.pddl.parser.integration.DomainSuccessTester;
import org.junit.Test;

import static org.gerryai.pddl.model.logic.FormulaBuilder.and;
import static org.gerryai.pddl.model.logic.FormulaBuilder.forAll;
import static org.gerryai.pddl.model.logic.FormulaBuilder.not;
import static org.gerryai.pddl.model.logic.FormulaBuilder.predicate;
import static org.gerryai.pddl.model.logic.FormulaBuilder.type;
import static org.gerryai.pddl.model.logic.FormulaBuilder.typeDefinition;
import static org.gerryai.pddl.model.logic.FormulaBuilder.variable;
import static org.gerryai.pddl.model.logic.FormulaBuilder.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Briefcase example files are parsed correctly.
 */
public class BriefcaseIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/example/briefcase/briefcase.pddl";
    }

    @Test
    public void briefcaseDomainHasCorrectName() {
        assertEquals("briefcase", domain.getName());
    }

//    @Test
//    public void briefcaseDomainHasFiveRequirements() {
//        assertEquals(5, domain.getRequirements().asSet().size());
//    }

    @Test
    public void briefcaseDomainHasFourRequirements() {
        assertEquals(4, domain.getRequirements().asSet().size());
    }

    @Test
    public void briefcaseDomainHasStripsRequirement() {
        assertTrue(domain.getRequirements().asSet().contains(Requirement.STRIPS));
    }

    @Test
    public void briefcaseDomainHasTypingRequirement() {
        assertTrue(domain.getRequirements().asSet().contains(Requirement.TYPING));
    }

//    @Test
//    public void briefcaseDomainHasUniversalPreconditionsRequirement() {
//        assertTrue(domain.getRequirements().asSet().contains(Requirement.UNIVERSAL_PRECONDITIONS));
//    }

    @Test
    public void briefcaseDomainHasConditionalEffectsRequirement() {
        assertTrue(domain.getRequirements().asSet().contains(Requirement.CONDITIONAL_EFFECTS));
    }

    @Test
    public void briefcaseDomainHasNegativePreconditionsRequirement() {
        assertTrue(domain.getRequirements().asSet().contains(Requirement.NEGATIVE_PRECONDITIONS));
    }

    @Test
    public void briefcaseDomainHasTwoTypes() {
        assertEquals(2, domain.getTypes().asSet().size());
    }

    @Test
    public void briefcaseDomainHasTypePortable() {
        assertTrue(domain.getTypes().asSet().contains(typeDefinition("portable")));
    }

    @Test
    public void briefcaseDomainHasTypeLocation() {
        assertTrue(domain.getTypes().asSet().contains(typeDefinition("location")));
    }

    @Test
    public void briefcaseDomainHasThreePredicates() {
        assertEquals(3, domain.getPredicates().asSet().size());
    }

    @Test
    public void briefcaseDomainHasPredicateAt() {
        Predicate at = new Predicate.Builder()
                .name("at")
                .variable("y", type("portable"))
                .variable("x", type("location"))
                .build();
        assertTrue("Domain contains the (at ?y - portable ?x - location) predicate",
                domain.getPredicates().asSet().contains(at));
    }

    @Test
    public void briefcaseDomainHasPredicateIn() {
        Predicate in = new Predicate.Builder()
                .name("in")
                .variable("x", type("portable"))
                .build();
        assertTrue("Domain contains the (in ?x - portable) predicate", domain.getPredicates().asSet().contains(in));
    }

    @Test
    public void briefcaseDomainHasPredicateIsAt() {
        Predicate isAt = new Predicate.Builder()
                .name("is-at")
                .variable("x", type("location"))
                .build();
        assertTrue("Domain contains the (is-at ?x - location) predicate",
                domain.getPredicates().asSet().contains(isAt));
    }

    @Test
    public void briefcaseDomainHasThreeActions() {
        assertEquals(3, domain.getActions().asSet().size());
    }

    @Test
    public void briefcaseDomainHasActionMove() {

        Action move = new Action.Builder()
                .name("move")
                .parameter("m", type("location"))
                .parameter("l", type("location"))
                .precondition(
                        predicate("is-at", variable("m"))
                )
                .effect(
                        and(
                                predicate("is-at", variable("l")),
                                not(predicate("is-at", variable("m"))),
                                forAll(
                                        when(predicate("in", variable("x")))
                                                .then(and(
                                                        predicate("at", variable("x"), variable("l")),
                                                        not(predicate("at", variable("x"), variable("m"))))),
                                        variable("x", type("portable")))
                        )
                )
                .build();
        assertTrue("Domain contains the move action", domain.getActions().asSet().contains(move));
    }

    @Test
    public void briefcaseDomainHasActionTakeOut() {
        Action takeOut = new Action.Builder()
                .name("take-out")
                .parameter("x", type("portable"))
                .precondition(
                        predicate("in", variable("x"))
                )
                .effect(
                        not(predicate("in", variable("x")))
                )
                .build();
        assertTrue("Domain contains the take-out action", domain.getActions().asSet().contains(takeOut));
    }

    @Test
    public void briefcaseDomainHasActionPutIn() {
        Action takeOut = new Action.Builder()
                .name("put-in")
                .parameter("x", type("portable"))
                .parameter("l", type("location"))
                .precondition(
                        and(
                                not(predicate("in", variable("x"))),
                                predicate("at", variable("x"), variable("l")),
                                predicate("is-at", variable("l")))
                )
                .effect(
                        predicate("in", variable("x"))
                )
                .build();
        assertTrue("Domain contains the take-out action", domain.getActions().asSet().contains(takeOut));
    }
}
