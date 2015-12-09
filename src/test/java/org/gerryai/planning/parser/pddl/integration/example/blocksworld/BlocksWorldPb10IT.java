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
public class BlocksWorldPb10IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/blocksworld/pb10.pddl";
    }

    @Test
    public void blocksWorldProblem10HasCorrectName() {
        assertEquals("pb10", problem.getName());
    }

    @Test
    public void blocksWorldProblem10HasCorrectDomain() {
        assertEquals("blocksworld", problem.getDomainName());
    }

    @Test
    public void blocksWorldProblem10Has10Objects() {
        assertEquals(10, problem.getObjects().asSet().size());
    }

    @Test
    public void blocksWorldProblem10HasObjectA() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("a")));
    }

    @Test
    public void blocksWorldProblem10HasObjectB() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("b")));
    }

    @Test
    public void blocksWorldProblem10HasObjectC() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("c")));
    }

    @Test
    public void blocksWorldProblem10HasObjectD() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d")));
    }

    @Test
    public void blocksWorldProblem10HasObjectE() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("e")));
    }

    @Test
    public void blocksWorldProblem10HasObjectF() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("f")));
    }

    @Test
    public void blocksWorldProblem10HasObjectG() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("g")));
    }

    @Test
    public void blocksWorldProblem10HasObjectH() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("h")));
    }

    @Test
    public void blocksWorldProblem10HasObjectI() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("i")));
    }

    @Test
    public void blocksWorldProblem10HasObjectJ() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("j")));
    }

    @Test
    public void blocksWorldProblem10Has21StateFormulas() {
        assertEquals(21, problem.getInitialState().asSet().size());
    }

    @Test
    public void blocksWorldProblem10InitialStateHasOnTableA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("a"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasOnTableB() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("b"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasOnTableC() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("c"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasOnTableD() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("d"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasOnTableE() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("e"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasOnTableF() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("f"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasOnTableG() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("g"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasOnTableH() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("h"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasOnTableI() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("i"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasOnTableJ() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("on-table", constant("j"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasClearA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("a"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasClearB() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("b"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasClearC() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("c"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasClearD() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("d"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasClearE() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("e"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasClearF() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("f"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasClearG() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("g"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasClearH() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("h"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasClearI() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("i"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasClearJ() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("clear", constant("j"))));
    }

    @Test
    public void blocksWorldProblem10InitialStateHasArmEmpty() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("arm-empty")));
    }

    @Test
    public void blocksWorldProblem10HasGoal() {
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
                        predicate("on", constant("i"), constant("j"))));
        assertEquals(goal, problem.getGoal());
    }
}
