package org.gerryai.pddl.parser.integration.example.blocksworld;

import org.gerryai.pddl.model.ConstantDefinition;
import org.gerryai.pddl.model.problem.Goal;
import org.gerryai.pddl.parser.integration.ProblemSuccessTester;
import org.junit.Test;

import static org.gerryai.pddl.model.logic.FormulaBuilder.and;
import static org.gerryai.pddl.model.logic.FormulaBuilder.constant;
import static org.gerryai.pddl.model.logic.FormulaBuilder.predicate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Blocksworld example files are parsed correctly.
 */
public class BlocksWorldPb2IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/blockworld/pb2.pddl";
    }

    @Test
    public void blocksWorldProblem2HasCorrectName() {
        assertEquals("pb2", problem.getName());
    }

    @Test
    public void blocksWorldProblem2HasCorrectDomain() {
        assertEquals("blocksworld", problem.getDomainName());
    }

    @Test
    public void blocksWorldProblem2Has2Objects() {
        assertEquals(2, problem.getObjects().asSet().size());
    }

    @Test
    public void blocksWorldProblem2HasObjectA() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("a")));
    }

    @Test
    public void blocksWorldProblem2HasObjectB() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("b")));
    }

    @Test
    public void blocksWorldProblem2HasFiveStateTerms() {
        assertEquals(5, problem.getInitialState().asSet().size());
    }

    @Test
    public void blocksWorldProblem2InitialStateHasOnTableA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("a"))));
    }

    @Test
    public void blocksWorldProblem2InitialStateHasOnTableB() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("b"))));
    }

    @Test
    public void blocksWorldProblem2InitialStateHasClearA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("a"))));
    }

    @Test
    public void blocksWorldProblem2InitialStateHasClearB() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("b"))));
    }

    @Test
    public void blocksWorldProblem2InitialStateHasArmEmpty() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("arm-empty")));
    }

    @Test
    public void blocksWorldProblem2HasGoal() {
        Goal goal = new Goal(
                and(predicate("on", constant("a"), constant("b"))));
        assertEquals(goal, problem.getGoal());
    }
}
