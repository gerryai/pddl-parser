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
package org.gerryai.planning.parser.pddl.integration.example.travel;

import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.problem.Goal;
import org.gerryai.planning.parser.pddl.integration.ProblemSuccessTester;
import org.junit.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the travel example files are parsed correctly.
 */
public class TravelPb1IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/travel/pb1.pddl";
    }

    @Test
    public void travelProblem1HasCorrectName() {
        assertEquals("big-bull1", problem.getName());
    }

    @Test
    public void travelProblem1HasCorrectDomain() {
        assertEquals("bulldozer", problem.getDomainName());
    }

    @Test
    public void travelProblem1Has9Objects() {
        assertEquals(9, problem.getObjects().asSet().size());
    }

    @Test
    public void travelProblem1HasObjectA() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("a")));
    }

    @Test
    public void travelProblem1HasObjectB() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("b")));
    }

    @Test
    public void travelProblem1HasObjectC() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("c")));
    }

    @Test
    public void travelProblem1HasObjectD() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d")));
    }

    @Test
    public void travelProblem1HasObjectE() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("e")));
    }

    @Test
    public void travelProblem1HasObjectF() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("f")));
    }

    @Test
    public void travelProblem1HasObjectG() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("g")));
    }

    @Test
    public void travelProblem1HasObjectJack() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("jack")));
    }

    @Test
    public void travelProblem1HasObjectBulldozer() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("bulldozer")));
    }

    @Test
    public void travelProblem1Has25StateFormulas() {
        assertEquals(25, problem.getInitialState().asSet().size());
    }

    @Test
    public void travelProblem1InitialStateHasAtJackA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("jack"), constant("a"))));
    }

    @Test
    public void travelProblem1InitialStateHasAtBulldozerE() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("bulldozer"), constant("e"))));
    }

    @Test
    public void travelProblem1InitialStateHasVehicleBulldozer() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("vehicle", constant("bulldozer"))));
    }

    @Test
    public void travelProblem1InitialStateHasMobileJack() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("mobile", constant("jack"))));
    }

    @Test
    public void travelProblem1InitialStateHasPersonJack() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("person", constant("jack"))));
    }

    @Test
    public void travelProblem1InitialStateHasRoadAB() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("a"), constant("b"))));
    }

    @Test
    public void travelProblem1InitialStateHasRoadBA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("b"), constant("a"))));
    }

    @Test
    public void travelProblem1InitialStateHasRoadAE() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("a"), constant("e"))));
    }

    @Test
    public void travelProblem1InitialStateHasRoadEA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("e"), constant("a"))));
    }

    @Test
    public void travelProblem1InitialStateHasRoadEB() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("e"), constant("b"))));
    }

    @Test
    public void travelProblem1InitialStateHasRoadBE() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("b"), constant("e"))));
    }

    @Test
    public void travelProblem1InitialStateHasRoadAC() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("a"), constant("c"))));
    }

    @Test
    public void travelProblem1InitialStateHasRoadCA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("c"), constant("a"))));
    }

    @Test
    public void travelProblem1InitialStateHasRoadCB() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("c"), constant("b"))));
    }

    @Test
    public void travelProblem1InitialStateHasRoadBC() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("b"), constant("c"))));
    }

    @Test
    public void travelProblem1InitialStateHasBridgeBD() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("bridge", constant("b"), constant("d"))));
    }

    @Test
    public void travelProblem1InitialStateHasBridgeDB() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("bridge", constant("d"), constant("b"))));
    }

    @Test
    public void travelProblem1InitialStateHasBridgeCF() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("bridge", constant("c"), constant("f"))));
    }

    @Test
    public void travelProblem1InitialStateHasBridgeFC() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("bridge", constant("f"), constant("c"))));
    }

    @Test
    public void travelProblem1InitialStateHasRoadDF() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("d"), constant("f"))));
    }

    @Test
    public void travelProblem1InitialStateHasRoadFD() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("f"), constant("d"))));
    }

    @Test
    public void travelProblem1InitialStateHasRoadFG() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("f"), constant("g"))));
    }

    @Test
    public void travelProblem1InitialStateHasRoadGF() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("g"), constant("f"))));
    }

    @Test
    public void travelProblem1InitialStateHasRoadDG() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("d"), constant("g"))));
    }

    @Test
    public void travelProblem1InitialStateHasRoadGD() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("g"), constant("d"))));
    }

    @Test
    public void travelProblem1HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("at", constant("bulldozer"), constant("g")),
                        predicate("at", constant("jack"), constant("a"))));
        assertEquals(goal, problem.getGoal());
    }
}
