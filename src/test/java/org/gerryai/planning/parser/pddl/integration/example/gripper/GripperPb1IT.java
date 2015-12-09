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
package org.gerryai.planning.parser.pddl.integration.example.gripper;

import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.problem.Goal;
import org.gerryai.planning.parser.pddl.integration.ProblemSuccessTester;
import org.junit.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Gripper example files are parsed correctly.
 */
public class GripperPb1IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/gripper/pb1.pddl";
    }

    @Test
    public void gripperProblem1HasCorrectName() {
        assertEquals("pb1", problem.getName());
    }

    @Test
    public void gripperProblem1HasCorrectDomain() {
        assertEquals("gripper", problem.getDomainName());
    }

    @Test
    public void gripperProblem1HasOneRequirement() {
        assertEquals(1, problem.getRequirements().asSet().size());
    }

    @Test
    public void gripperProblem1HasStripsRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.STRIPS));
    }

    @Test
    public void gripperProblem1Has6Objects() {
        assertEquals(6, problem.getObjects().asSet().size());
    }

    @Test
    public void gripperProblem1HasObjectRoomA() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("rooma")));
    }

    @Test
    public void gripperProblem1HasObjectRoomB() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("roomb")));
    }

    @Test
    public void gripperProblem1HasObjectBall1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("ball1")));
    }

    @Test
    public void gripperProblem1HasObjectBall2() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("ball2")));
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
    public void gripperProblem1HasElevenStateTerms() {
        assertEquals(11, problem.getInitialState().asSet().size());
    }

    @Test
    public void gripperProblem1InitialStateHasRoomA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("room", constant("rooma"))));
    }

    @Test
    public void gripperProblem1InitialStateHasRoomB() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("room", constant("roomb"))));
    }

    @Test
    public void gripperProblem1InitialStateHasBall1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("ball", constant("ball1"))));
    }

    @Test
    public void gripperProblem1InitialStateHasBall2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("ball", constant("ball2"))));
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
        assertTrue(problem.getInitialState().asSet().contains(predicate("at-robby", constant("rooma"))));
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
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("ball1"), constant("rooma"))));
    }

    @Test
    public void gripperProblem1InitialStateHasAtBall2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("ball2"), constant("rooma"))));
    }

    @Test
    public void gripperProblem1HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("at", constant("ball1"), constant("roomb")),
                        predicate("at", constant("ball2"), constant("roomb"))));
        assertEquals(goal, problem.getGoal());
    }
}
