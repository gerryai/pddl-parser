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
package org.gerryai.planning.parser.pddl.integration.example.monkey;

import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.problem.Goal;
import org.gerryai.planning.parser.pddl.integration.ProblemSuccessTester;
import org.junit.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Monkey example files are parsed correctly.
 */
public class MonkeyPb1IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/monkey/pb1.pddl";
    }

    @Test
    public void monkeyProblem1HasCorrectName() {
        assertEquals("pb1", problem.getName());
    }

    @Test
    public void monkeyProblem1HasCorrectDomain() {
        assertEquals("monkey", problem.getDomainName());
    }

    @Test
    public void monkeyProblem1HasNoRequirements() {
        assertEquals(0, problem.getRequirements().asSet().size());
    }


    @Test
    public void monkeyProblem1Has8Objects() {
        assertEquals(8, problem.getObjects().asSet().size());
    }

    @Test
    public void monkeyProblem1HasObjectP1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("p1")));
    }

    @Test
    public void monkeyProblem1HasObjectP2() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("p2")));
    }

    @Test
    public void monkeyProblem1HasObjectP3() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("p3")));
    }

    @Test
    public void monkeyProblem1HasObjectP4() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("p4")));
    }

    @Test
    public void monkeyProblem1HasObjectBananas() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("bananas")));
    }

    @Test
    public void monkeyProblem1HasObjectMonkey() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("monkey")));
    }

    @Test
    public void monkeyProblem1HasObjectBox() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("box")));
    }

    @Test
    public void monkeyProblem1HasObjectKnife() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("knife")));
    }

    @Test
    public void monkeyProblem1Has9StateFormulas() {
        assertEquals(9, problem.getInitialState().asSet().size());
    }

    @Test
    public void monkeyProblem1InitialStateHasLocationP1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("location", constant("p1"))));
    }

    @Test
    public void monkeyProblem1InitialStateHasLocationP2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("location", constant("p2"))));
    }

    @Test
    public void monkeyProblem1InitialStateHasLocationP3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("location", constant("p3"))));
    }

    @Test
    public void monkeyProblem1InitialStateHasLocationP4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("location", constant("p4"))));
    }

    @Test
    public void monkeyProblem1InitialStateHasAtMonkeyP1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("monkey"), constant("p1"))));
    }

    @Test
    public void monkeyProblem1InitialStateHasLocationOnFloor() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-floor")));
    }

    @Test
    public void monkeyProblem1InitialStateHasAtBoxP2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("box"), constant("p2"))));
    }

    @Test
    public void monkeyProblem1InitialStateHasAtBananasP3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("bananas"), constant("p3"))));
    }

    @Test
    public void monkeyProblem1InitialStateHasAtKnifeP4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("knife"), constant("p4"))));
    }

    @Test
    public void monkeyProblem1HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("hasbananas")));
        assertEquals(goal, problem.getGoal());
    }
}
