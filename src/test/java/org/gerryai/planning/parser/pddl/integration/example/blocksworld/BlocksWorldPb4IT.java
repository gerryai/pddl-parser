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
package org.gerryai.planning.parser.pddl.integration.example.blocksworld;

import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.problem.Goal;
import org.gerryai.planning.parser.pddl.integration.ProblemSuccessTester;
import org.junit.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.*;
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
