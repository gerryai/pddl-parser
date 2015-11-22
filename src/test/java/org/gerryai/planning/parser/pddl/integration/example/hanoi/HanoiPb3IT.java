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
public class HanoiPb3IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/hanoi/pb3.pddl";
    }

    @Test
    public void hanoiProblem3HasCorrectName() {
        assertEquals("pb3", problem.getName());
    }

    @Test
    public void hanoiProblem3HasCorrectDomain() {
        assertEquals("hanoi", problem.getDomainName());
    }

    @Test
    public void hanoiProblem3HasOneRequirement() {
        assertEquals(1, problem.getRequirements().asSet().size());
    }

    @Test
    public void hanoiProblem3HasStripsRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.STRIPS));
    }

    @Test
    public void hanoiProblem3Has8Objects() {
        assertEquals(8, problem.getObjects().asSet().size());
    }

    @Test
    public void hanoiProblem3HasObjectPeg1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("peg1")));
    }

    @Test
    public void hanoiProblem3HasObjectPeg2() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("peg2")));
    }

    @Test
    public void hanoiProblem3HasObjectPeg3() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("peg3")));
    }

    @Test
    public void hanoiProblem3HasObjectD1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d1")));
    }

    @Test
    public void hanoiProblem3HasObjectD2() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d2")));
    }

    @Test
    public void hanoiProblem3HasObjectD3() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d3")));
    }

    @Test
    public void hanoiProblem3HasObjectD4() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d4")));
    }

    @Test
    public void hanoiProblem3HasObjectD5() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d5")));
    }

    @Test
    public void hanoiProblem3Has33StateForumlas() {
        assertEquals(33, problem.getInitialState().asSet().size());
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerPeg1D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg1"), constant("d1"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerPeg1D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg1"), constant("d2"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerPeg1D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg1"), constant("d3"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerPeg1D4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg1"), constant("d4"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerPeg1D5() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg1"), constant("d5"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerPeg2D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg2"), constant("d1"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerPeg2D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg2"), constant("d2"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerPeg2D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg2"), constant("d3"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerPeg2D4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg2"), constant("d4"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerPeg2D5() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg2"), constant("d5"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerPeg3D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg3"), constant("d1"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerPeg3D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg3"), constant("d2"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerPeg3D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg3"), constant("d3"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerPeg3D4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg3"), constant("d4"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerPeg3D5() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg3"), constant("d5"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerD2D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d2"), constant("d1"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerD3D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d3"), constant("d1"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerD3D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d3"), constant("d2"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerD4D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d4"), constant("d1"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerD4D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d4"), constant("d2"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerD4D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d4"), constant("d3"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerD5D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d5"), constant("d1"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerD5D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d5"), constant("d2"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerD5D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d5"), constant("d3"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasSmallerD5D4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d5"), constant("d4"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasClearPeg2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("peg2"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasClearPeg3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("peg3"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasClearD1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("d1"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasHanoiOnD4Peg1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("d5"), constant("peg1"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasHanoiOnD4D5() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("d4"), constant("d5"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasHanoiOnD3D4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("d3"), constant("d4"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasHanoiOnD2D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("d2"), constant("d3"))));
    }

    @Test
    public void hanoiProblem3InitialStateHasHanoiOnD1D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("d1"), constant("d2"))));
    }

    @Test
    public void hanoiProblem3HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("on", constant("d5"), constant("peg3")),
                        predicate("on", constant("d4"), constant("d5")),
                        predicate("on", constant("d3"), constant("d4")),
                        predicate("on", constant("d2"), constant("d3")),
                        predicate("on", constant("d1"), constant("d2"))));
        assertEquals(goal, problem.getGoal());
    }
}
