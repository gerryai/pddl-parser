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
package org.gerryai.planning.parser.pddl.integration.example.hanoi;

import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.problem.Goal;
import org.gerryai.planning.parser.pddl.integration.ProblemSuccessTester;
import org.junit.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Hanoi example files are parsed correctly.
 */
public class HanoiPb2IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/hanoi/pb2.pddl";
    }

    @Test
    public void hanoiProblem2HasCorrectName() {
        assertEquals("pb2", problem.getName());
    }

    @Test
    public void hanoiProblem2HasCorrectDomain() {
        assertEquals("hanoi", problem.getDomainName());
    }

    @Test
    public void hanoiProblem2HasOneRequirement() {
        assertEquals(1, problem.getRequirements().asSet().size());
    }

    @Test
    public void hanoiProblem2HasStripsRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.STRIPS));
    }

    @Test
    public void hanoiProblem2Has7Objects() {
        assertEquals(7, problem.getObjects().asSet().size());
    }

    @Test
    public void hanoiProblem2HasObjectPeg1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("peg1")));
    }

    @Test
    public void hanoiProblem2HasObjectPeg2() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("peg2")));
    }

    @Test
    public void hanoiProblem2HasObjectPeg3() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("peg3")));
    }

    @Test
    public void hanoiProblem2HasObjectD1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d1")));
    }

    @Test
    public void hanoiProblem2HasObjectD2() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d2")));
    }

    @Test
    public void hanoiProblem2HasObjectD3() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d3")));
    }

    @Test
    public void hanoiProblem2HasObjectD4() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d4")));
    }

    @Test
    public void hanoiProblem2Has25StateForumlas() {
        assertEquals(25, problem.getInitialState().asSet().size());
    }

    @Test
    public void hanoiProblem2InitialStateHasSmallerPeg1D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg1"), constant("d1"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasSmallerPeg1D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg1"), constant("d2"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasSmallerPeg1D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg1"), constant("d3"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasSmallerPeg1D4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg1"), constant("d4"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasSmallerPeg2D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg2"), constant("d1"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasSmallerPeg2D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg2"), constant("d2"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasSmallerPeg2D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg2"), constant("d3"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasSmallerPeg2D4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg2"), constant("d4"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasSmallerPeg3D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg3"), constant("d1"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasSmallerPeg3D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg3"), constant("d2"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasSmallerPeg3D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg3"), constant("d3"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasSmallerPeg3D4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg3"), constant("d4"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasSmallerD2D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d2"), constant("d1"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasSmallerD3D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d3"), constant("d1"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasSmallerD3D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d3"), constant("d2"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasSmallerD4D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d4"), constant("d1"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasSmallerD4D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d4"), constant("d2"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasSmallerD4D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d4"), constant("d3"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasClearPeg2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("peg2"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasClearPeg3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("peg3"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasClearD1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("d1"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasHanoiOnD4Peg1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("d4"), constant("peg1"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasHanoiOnD3D4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("d3"), constant("d4"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasHanoiOnD2D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("d2"), constant("d3"))));
    }

    @Test
    public void hanoiProblem2InitialStateHasHanoiOnD1D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("d1"), constant("d2"))));
    }

    @Test
    public void hanoiProblem2HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("on", constant("d4"), constant("peg3")),
                        predicate("on", constant("d3"), constant("d4")),
                        predicate("on", constant("d2"), constant("d3")),
                        predicate("on", constant("d1"), constant("d2"))));
        assertEquals(goal, problem.getGoal());
    }
}
