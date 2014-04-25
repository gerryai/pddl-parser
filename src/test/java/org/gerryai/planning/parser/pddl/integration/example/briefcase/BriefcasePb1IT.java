package org.gerryai.planning.parser.pddl.integration.example.briefcase;

import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.problem.Goal;
import org.gerryai.planning.parser.pddl.integration.ProblemSuccessTester;
import org.junit.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.and;
import static org.gerryai.planning.model.logic.FormulaBuilder.constant;
import static org.gerryai.planning.model.logic.FormulaBuilder.predicate;
import static org.gerryai.planning.model.logic.FormulaBuilder.type;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Briefcase example files are parsed correctly.
 */
public class BriefcasePb1IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/briefcase/pb1.pddl";
    }

    @Test
    public void briefcaseProblem1HasCorrectName() {
        assertEquals("pb1", problem.getName());
    }

    @Test
    public void briefcaseProblem1HasCorrectDomain() {
        assertEquals("briefcase", problem.getDomainName());
    }

    @Test
    public void briefcaseProblem1HasFourRequirements() {
        assertEquals(4, problem.getRequirements().asSet().size());
    }

    @Test
    public void briefcaseProblem1HasStripsRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.STRIPS));
    }

    @Test
    public void briefcaseProblem1HasTypingRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.TYPING));
    }

    @Test
    public void briefcaseProblem1HasUniversalPreconditionsRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.UNIVERSAL_PRECONDITIONS));
    }

    @Test
    public void briefcaseProblem1HasConditionalEffectsRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.CONDITIONAL_EFFECTS));
    }

    @Test
    public void briefcaseProblem1Has3Objects() {
        assertEquals(3, problem.getObjects().asSet().size());
    }

    @Test
    public void briefcaseProblem1HasObjectHome() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("home", type("location"))));
    }

    @Test
    public void briefcaseProblem1HasObjectL1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("l1", type("location"))));
    }

    @Test
    public void briefcaseProblem1HasObjectO1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("o1", type("portable"))));
    }

    @Test
    public void briefcaseProblem1HasTwoStateTerms() {
        assertEquals(2, problem.getInitialState().asSet().size());
    }

    @Test
    public void briefcaseProblem1InitialStateHasIsAt() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("is-at", constant("home"))));
    }

    @Test
    public void briefcaseProblem1InitialStateHasAt() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("o1"), constant("l1"))));
    }

    @Test
    public void briefcaseProblem1HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("is-at", constant("home")),
                        predicate("at", constant("o1"), constant("home"))));
        assertEquals(goal, problem.getGoal());
    }
}
