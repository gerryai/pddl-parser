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
public class HanoiPb6IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/hanoi/pb6.pddl";
    }

    @Test
    public void hanoiProblem6HasCorrectName() {
        assertEquals("pb6", problem.getName());
    }

    @Test
    public void hanoiProblem6HasCorrectDomain() {
        assertEquals("hanoi", problem.getDomainName());
    }

    @Test
    public void hanoiProblem6HasOneRequirement() {
        assertEquals(1, problem.getRequirements().asSet().size());
    }

    @Test
    public void hanoiProblem6HasStripsRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.STRIPS));
    }

    @Test
    public void hanoiProblem6Has11Objects() {
        assertEquals(11, problem.getObjects().asSet().size());
    }

    @Test
    public void hanoiProblem6HasObjectPeg1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("peg1")));
    }

    @Test
    public void hanoiProblem6HasObjectPeg2() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("peg2")));
    }

    @Test
    public void hanoiProblem6HasObjectPeg3() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("peg3")));
    }

    @Test
    public void hanoiProblem6HasObjectD1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d1")));
    }

    @Test
    public void hanoiProblem6HasObjectD2() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d2")));
    }

    @Test
    public void hanoiProblem6HasObjectD3() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d3")));
    }

    @Test
    public void hanoiProblem6HasObjectD4() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d4")));
    }

    @Test
    public void hanoiProblem6HasObjectD5() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d5")));
    }

    @Test
    public void hanoiProblem6HasObjectD6() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d6")));
    }

    @Test
    public void hanoiProblem6HasObjectD7() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d7")));
    }

    @Test
    public void hanoiProblem6HasObjectD8() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d8")));
    }

    @Test
    public void hanoiProblem6Has63StateForumlas() {
        assertEquals(63, problem.getInitialState().asSet().size());
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg1D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg1"), constant("d1"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg1D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg1"), constant("d2"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg1D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg1"), constant("d3"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg1D4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg1"), constant("d4"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg1D5() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg1"), constant("d5"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg1D6() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg1"), constant("d6"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg1D7() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg1"), constant("d7"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg1D8() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg1"), constant("d8"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg2D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg2"), constant("d1"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg2D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg2"), constant("d2"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg2D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg2"), constant("d3"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg2D4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg2"), constant("d4"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg2D5() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg2"), constant("d5"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg2D6() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg2"), constant("d6"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg2D7() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg2"), constant("d7"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg2D8() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg2"), constant("d8"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg3D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg3"), constant("d1"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg3D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg3"), constant("d2"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg3D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg3"), constant("d3"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg3D4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg3"), constant("d4"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg3D5() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg3"), constant("d5"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg3D6() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg3"), constant("d6"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg3D7() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg3"), constant("d7"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerPeg3D8() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("peg3"), constant("d8"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD2D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d2"), constant("d1"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD3D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d3"), constant("d1"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD3D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d3"), constant("d2"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD4D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d4"), constant("d1"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD4D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d4"), constant("d2"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD4D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d4"), constant("d3"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD5D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d5"), constant("d1"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD5D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d5"), constant("d2"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD5D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d5"), constant("d3"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD5D4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d5"), constant("d4"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD6D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d6"), constant("d1"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD6D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d6"), constant("d2"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD6D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d6"), constant("d3"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD6D4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d6"), constant("d4"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD6D5() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d6"), constant("d5"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD7D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d7"), constant("d1"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD7D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d7"), constant("d2"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD7D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d7"), constant("d3"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD7D4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d7"), constant("d4"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD7D5() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d7"), constant("d5"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD7D6() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d7"), constant("d6"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD8D1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d8"), constant("d1"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD8D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d8"), constant("d2"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD8D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d8"), constant("d3"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD8D4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d8"), constant("d4"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD8D5() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d8"), constant("d5"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD8D6() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d8"), constant("d6"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasSmallerD8D7() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("smaller", constant("d8"), constant("d7"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasClearPeg2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("peg2"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasClearPeg3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("peg3"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasClearD1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("d1"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasHanoiOnD4Peg1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("d8"), constant("peg1"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasHanoiOnD7D8() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("d7"), constant("d8"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasHanoiOnD6D7() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("d6"), constant("d7"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasHanoiOnD5D6() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("d5"), constant("d6"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasHanoiOnD4D5() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("d4"), constant("d5"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasHanoiOnD3D4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("d3"), constant("d4"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasHanoiOnD2D3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("d2"), constant("d3"))));
    }

    @Test
    public void hanoiProblem6InitialStateHasHanoiOnD1D2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on", constant("d1"), constant("d2"))));
    }

    @Test
    public void hanoiProblem6HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("on", constant("d8"), constant("peg3")),
                        predicate("on", constant("d7"), constant("d8")),
                        predicate("on", constant("d6"), constant("d7")),
                        predicate("on", constant("d5"), constant("d6")),
                        predicate("on", constant("d4"), constant("d5")),
                        predicate("on", constant("d3"), constant("d4")),
                        predicate("on", constant("d2"), constant("d3")),
                        predicate("on", constant("d1"), constant("d2"))));
        assertEquals(goal, problem.getGoal());
    }
}
