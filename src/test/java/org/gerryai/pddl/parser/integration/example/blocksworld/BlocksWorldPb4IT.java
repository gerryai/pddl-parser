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
public class BlocksWorldPb4IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/blocksworld/pb4.pddl";
    }

    @Test
    public void blocksWorldProblem4HasCorrectName() {
        assertEquals("pb4", problem.getName());
    }

    @Test
    public void blocksWorldProblem4HasCorrectDomain() {
        assertEquals("blocksworld", problem.getDomainName());
    }

    @Test
    public void blocksWorldProblem4Has4Objects() {
        assertEquals(4, problem.getObjects().asSet().size());
    }

    @Test
    public void blocksWorldProblem4HasObjectA() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("a")));
    }

    @Test
    public void blocksWorldProblem4HasObjectB() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("b")));
    }

    @Test
    public void blocksWorldProblem4HasObjectC() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("c")));
    }

    @Test
    public void blocksWorldProblem4HasObjectD() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d")));
    }

    @Test
    public void blocksWorldProblem4Has6StateFormulas() {
        assertEquals(6, problem.getInitialState().asSet().size());
    }

    @Test
    public void blocksWorldProblem4InitialStateHasOnTableA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("a"))));
    }

    @Test
    public void blocksWorldProblem4InitialStateHasOnBA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("b"), constant("a"))));
    }

    @Test
    public void blocksWorldProblem4InitialStateHasOnCB() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("c"), constant("b"))));
    }

    @Test
    public void blocksWorldProblem4InitialStateHasOnDC() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("d"), constant("c"))));
    }

    @Test
    public void blocksWorldProblem4InitialStateHasClearD() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("d"))));
    }

    @Test
    public void blocksWorldProblem4InitialStateHasArmEmpty() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("arm-empty")));
    }

    @Test
    public void blocksWorldProblem4HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("on", constant("b"), constant("a")),
                        predicate("on", constant("c"), constant("b")),
                        predicate("on", constant("a"), constant("d"))));
        assertEquals(goal, problem.getGoal());
    }
}
