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
public class BlocksWorldPb9IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/blocksworld/pb9.pddl";
    }

    @Test
    public void blocksWorldProblem9HasCorrectName() {
        assertEquals("tower9", problem.getName());
    }

    @Test
    public void blocksWorldProblem9HasCorrectDomain() {
        assertEquals("blocksworld", problem.getDomainName());
    }

    @Test
    public void blocksWorldProblem9Has9Objects() {
        assertEquals(9, problem.getObjects().asSet().size());
    }

    @Test
    public void blocksWorldProblem9HasObjectA() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("a")));
    }

    @Test
    public void blocksWorldProblem9HasObjectB() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("b")));
    }

    @Test
    public void blocksWorldProblem9HasObjectC() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("c")));
    }

    @Test
    public void blocksWorldProblem9HasObjectD() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d")));
    }

    @Test
    public void blocksWorldProblem9HasObjectE() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("e")));
    }

    @Test
    public void blocksWorldProblem9HasObjectF() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("f")));
    }

    @Test
    public void blocksWorldProblem9HasObjectG() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("g")));
    }

    @Test
    public void blocksWorldProblem9HasObjectH() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("h")));
    }

    @Test
    public void blocksWorldProblem9HasObjectI() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("i")));
    }

    @Test
    public void blocksWorldProblem9Has19StateFormulas() {
        assertEquals(19, problem.getInitialState().asSet().size());
    }

    @Test
    public void blocksWorldProblem9InitialStateHasOnTableA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("a"))));
    }

    @Test
    public void blocksWorldProblem9InitialStateHasOnTableB() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("b"))));
    }

    @Test
    public void blocksWorldProblem9InitialStateHasOnTableC() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("c"))));
    }

    @Test
    public void blocksWorldProblem9InitialStateHasOnTableD() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("d"))));
    }

    @Test
    public void blocksWorldProblem9InitialStateHasOnTableE() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("e"))));
    }

    @Test
    public void blocksWorldProblem9InitialStateHasOnTableF() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("f"))));
    }

    @Test
    public void blocksWorldProblem9InitialStateHasOnTableG() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("g"))));
    }

    @Test
    public void blocksWorldProblem9InitialStateHasOnTableH() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("h"))));
    }

    @Test
    public void blocksWorldProblem9InitialStateHasOnTableI() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("i"))));
    }

    @Test
    public void blocksWorldProblem9InitialStateHasClearA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("a"))));
    }

    @Test
    public void blocksWorldProblem9InitialStateHasClearB() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("b"))));
    }

    @Test
    public void blocksWorldProblem9InitialStateHasClearC() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("c"))));
    }

    @Test
    public void blocksWorldProblem9InitialStateHasClearD() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("d"))));
    }

    @Test
    public void blocksWorldProblem9InitialStateHasClearE() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("e"))));
    }

    @Test
    public void blocksWorldProblem9InitialStateHasClearF() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("f"))));
    }

    @Test
    public void blocksWorldProblem9InitialStateHasClearG() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("g"))));
    }

    @Test
    public void blocksWorldProblem9InitialStateHasClearH() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("h"))));
    }

    @Test
    public void blocksWorldProblem9InitialStateHasClearI() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("i"))));
    }

    @Test
    public void blocksWorldProblem9InitialStateHasArmEmpty() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("arm-empty")));
    }

    @Test
    public void blocksWorldProblem9HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("on", constant("a"), constant("b")),
                        predicate("on", constant("b"), constant("c")),
                        predicate("on", constant("c"), constant("d")),
                        predicate("on", constant("d"), constant("e")),
                        predicate("on", constant("e"), constant("f")),
                        predicate("on", constant("f"), constant("g")),
                        predicate("on", constant("g"), constant("h")),
                        predicate("on", constant("h"), constant("i"))));
        assertEquals(goal, problem.getGoal());
    }
}
