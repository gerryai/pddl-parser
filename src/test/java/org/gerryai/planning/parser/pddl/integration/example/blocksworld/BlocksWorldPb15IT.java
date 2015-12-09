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
public class BlocksWorldPb15IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/blocksworld/pb15.pddl";
    }

    @Test
    public void blocksWorldProblem15HasCorrectName() {
        assertEquals("pb15", problem.getName());
    }

    @Test
    public void blocksWorldProblem15HasCorrectDomain() {
        assertEquals("blocksworld", problem.getDomainName());
    }

    @Test
    public void blocksWorldProblem15Has15Objects() {
        assertEquals(15, problem.getObjects().asSet().size());
    }

    @Test
    public void blocksWorldProblem15HasObjectA() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("a")));
    }

    @Test
    public void blocksWorldProblem15HasObjectB() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("b")));
    }

    @Test
    public void blocksWorldProblem15HasObjectC() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("c")));
    }

    @Test
    public void blocksWorldProblem15HasObjectD() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d")));
    }

    @Test
    public void blocksWorldProblem15HasObjectE() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("e")));
    }

    @Test
    public void blocksWorldProblem15HasObjectF() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("f")));
    }

    @Test
    public void blocksWorldProblem15HasObjectG() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("g")));
    }

    @Test
    public void blocksWorldProblem15HasObjectH() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("h")));
    }

    @Test
    public void blocksWorldProblem15HasObjectI() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("i")));
    }

    @Test
    public void blocksWorldProblem15HasObjectJ() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("j")));
    }

    @Test
    public void blocksWorldProblem15HasObjectK() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("k")));
    }

    @Test
    public void blocksWorldProblem15HasObjectL() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("l")));
    }

    @Test
    public void blocksWorldProblem15HasObjectM() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("m")));
    }

    @Test
    public void blocksWorldProblem15HasObjectN() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("n")));
    }

    @Test
    public void blocksWorldProblem15HasObjectO() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("o")));
    }

    @Test
    public void blocksWorldProblem15Has31StateFormulas() {
        assertEquals(31, problem.getInitialState().asSet().size());
    }

    @Test
    public void blocksWorldProblem15InitialStateHasOnTableA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("a"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasOnTableB() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("b"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasOnTableC() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("c"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasOnTableD() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("d"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasOnTableE() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("e"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasOnTableF() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("f"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasOnTableG() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("g"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasOnTableH() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("h"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasOnTableI() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("i"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasOnTableJ() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("j"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasOnTableK() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("k"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasOnTableL() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("l"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasOnTableM() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("m"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasOnTableN() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("n"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasOnTableO() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("o"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasClearA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("a"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasClearB() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("b"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasClearC() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("c"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasClearD() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("d"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasClearE() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("e"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasClearF() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("f"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasClearG() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("g"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasClearH() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("h"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasClearI() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("i"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasClearJ() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("j"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasClearK() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("k"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasClearL() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("l"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasClearM() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("m"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasClearN() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("n"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasClearO() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("o"))));
    }

    @Test
    public void blocksWorldProblem15InitialStateHasArmEmpty() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("arm-empty")));
    }

    @Test
    public void blocksWorldProblem15HasGoal() {
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
                        predicate("on", constant("l"), constant("m")),
                        predicate("on", constant("m"), constant("n")),
                        predicate("on", constant("n"), constant("o"))));
        assertEquals(goal, problem.getGoal());
    }
}
