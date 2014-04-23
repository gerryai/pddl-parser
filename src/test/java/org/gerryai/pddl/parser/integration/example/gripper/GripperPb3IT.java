package org.gerryai.pddl.parser.integration.example.gripper;

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
 * Integration test to check that the Gripper example files are parsed correctly.
 */
public class GripperPb3IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/gripper/pb3.pddl";
    }

    @Test
    public void gripperProblem1HasCorrectName() {
        assertEquals("pb3", problem.getName());
    }

    @Test
    public void gripperProblem1HasCorrectDomain() {
        assertEquals("gripper", problem.getDomainName());
    }

    @Test
    public void gripperProblem1HasNoRequirements() {
        assertEquals(0, problem.getRequirements().asSet().size());
    }

    @Test
    public void gripperProblem1Has10Objects() {
        assertEquals(10, problem.getObjects().asSet().size());
    }

    @Test
    public void gripperProblem1HasObjectRoomA() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("roomA")));
    }

    @Test
    public void gripperProblem1HasObjectRoomB() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("roomB")));
    }

    @Test
    public void gripperProblem1HasObjectBall1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("Ball1")));
    }

    @Test
    public void gripperProblem1HasObjectBall2() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("Ball2")));
    }

    @Test
    public void gripperProblem1HasObjectBall3() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("Ball3")));
    }

    @Test
    public void gripperProblem1HasObjectBall4() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("Ball4")));
    }

    @Test
    public void gripperProblem1HasObjectBall5() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("Ball5")));
    }

    @Test
    public void gripperProblem1HasObjectBall6() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("Ball6")));
    }

    @Test
    public void gripperProblem1HasObjectLeft() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("left")));
    }

    @Test
    public void gripperProblem1HasObjectRight() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("right")));
    }

    @Test
    public void gripperProblem1Has19StateTerms() {
        assertEquals(19, problem.getInitialState().asSet().size());
    }

    @Test
    public void gripperProblem1InitialStateHasRoomA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("room", constant("roomA"))));
    }

    @Test
    public void gripperProblem1InitialStateHasRoomB() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("room", constant("roomB"))));
    }

    @Test
    public void gripperProblem1InitialStateHasBall1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("ball", constant("Ball1"))));
    }

    @Test
    public void gripperProblem1InitialStateHasBall2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("ball", constant("Ball2"))));
    }

    @Test
    public void gripperProblem1InitialStateHasBall3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("ball", constant("Ball3"))));
    }

    @Test
    public void gripperProblem1InitialStateHasBall4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("ball", constant("Ball4"))));
    }

    @Test
    public void gripperProblem1InitialStateHasBall5() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("ball", constant("Ball5"))));
    }

    @Test
    public void gripperProblem1InitialStateHasBall6() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("ball", constant("Ball6"))));
    }

    @Test
    public void gripperProblem1InitialStateHasGripperLeft() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("gripper", constant("left"))));
    }

    @Test
    public void gripperProblem1InitialStateHasGripperRight() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("gripper", constant("right"))));
    }

    @Test
    public void gripperProblem1InitialStateHasArRobby() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at-robby", constant("roomA"))));
    }

    @Test
    public void gripperProblem1InitialStateHasFreeLeft() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("free", constant("left"))));
    }

    @Test
    public void gripperProblem1InitialStateHasFreeRight() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("free", constant("right"))));
    }

    @Test
    public void gripperProblem1InitialStateHasAtBall1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("Ball1"), constant("roomA"))));
    }

    @Test
    public void gripperProblem1InitialStateHasAtBall2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("Ball2"), constant("roomA"))));
    }

    @Test
    public void gripperProblem1InitialStateHasAtBall3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("Ball3"), constant("roomA"))));
    }

    @Test
    public void gripperProblem1InitialStateHasAtBall4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("Ball4"), constant("roomA"))));
    }

    @Test
    public void gripperProblem1InitialStateHasAtBall5() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("Ball5"), constant("roomA"))));
    }

    @Test
    public void gripperProblem1InitialStateHasAtBall6() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("Ball6"), constant("roomA"))));
    }

    @Test
    public void gripperProblem1HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("at", constant("Ball1"), constant("roomB")),
                        predicate("at", constant("Ball2"), constant("roomB")),
                        predicate("at", constant("Ball3"), constant("roomB")),
                        predicate("at", constant("Ball4"), constant("roomB")),
                        predicate("at", constant("Ball5"), constant("roomB")),
                        predicate("at", constant("Ball6"), constant("roomB"))));
        assertEquals(goal, problem.getGoal());
    }
}
