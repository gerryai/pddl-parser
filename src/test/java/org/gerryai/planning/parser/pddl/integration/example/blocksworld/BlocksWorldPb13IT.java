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
public class BlocksWorldPb13IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/blocksworld/pb13.pddl";
    }

    @Test
    public void blocksWorldProblem13HasCorrectName() {
        assertEquals("pb13", problem.getName());
    }

    @Test
    public void blocksWorldProblem13HasCorrectDomain() {
        assertEquals("blocksworld", problem.getDomainName());
    }

    @Test
    public void blocksWorldProblem13Has13bjects() {
        assertEquals(13, problem.getObjects().asSet().size());
    }

    @Test
    public void blocksWorldProblem13HasObjectA() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("a")));
    }

    @Test
    public void blocksWorldProblem13HasObjectB() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("b")));
    }

    @Test
    public void blocksWorldProblem13HasObjectC() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("c")));
    }

    @Test
    public void blocksWorldProblem13HasObjectD() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d")));
    }

    @Test
    public void blocksWorldProblem13HasObjectE() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("e")));
    }

    @Test
    public void blocksWorldProblem13HasObjectF() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("f")));
    }

    @Test
    public void blocksWorldProblem13HasObjectG() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("g")));
    }

    @Test
    public void blocksWorldProblem13HasObjectH() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("h")));
    }

    @Test
    public void blocksWorldProblem13HasObjectI() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("i")));
    }

    @Test
    public void blocksWorldProblem13HasObjectJ() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("j")));
    }

    @Test
    public void blocksWorldProblem13HasObjectK() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("k")));
    }

    @Test
    public void blocksWorldProblem13HasObjectL() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("l")));
    }

    @Test
    public void blocksWorldProblem13HasObjectM() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("m")));
    }

    @Test
    public void blocksWorldProblem13Has27StateFormulas() {
        assertEquals(27, problem.getInitialState().asSet().size());
    }

    @Test
    public void blocksWorldProblem13InitialStateHasOnTableA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("a"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasOnTableB() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("b"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasOnTableC() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("c"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasOnTableD() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("d"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasOnTableE() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("e"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasOnTableF() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("f"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasOnTableG() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("g"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasOnTableH() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("h"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasOnTableI() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("i"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasOnTableJ() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("j"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasOnTableK() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("k"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasOnTableL() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("l"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasOnTableM() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("m"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasClearA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("a"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasClearB() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("b"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasClearC() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("c"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasClearD() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("d"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasClearE() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("e"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasClearF() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("f"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasClearG() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("g"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasClearH() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("h"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasClearI() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("i"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasClearJ() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("j"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasClearK() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("k"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasClearL() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("l"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasClearM() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("m"))));
    }

    @Test
    public void blocksWorldProblem13InitialStateHasArmEmpty() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("arm-empty")));
    }

    @Test
    public void blocksWorldProblem13HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("on", constant("a"), constant("b")),
                        predicate("on", constant("b"), constant("c")),
                        predicate("on", constant("c"), constant("d")),
                        predicate("on", constant("d"), constant("e")),
                        predicate("on", constant("e"), constant("f")),
                        predicate("on", constant("f"), constant("g")),
                        predicate("on", constant("g"), constant("h")),
                        predicate("on", constant("h"), constant("i")),
                        predicate("on", constant("i"), constant("j")),
                        predicate("on", constant("j"), constant("k")),
                        predicate("on", constant("k"), constant("l")),
                        predicate("on", constant("l"), constant("m"))));
        assertEquals(goal, problem.getGoal());
    }
}
