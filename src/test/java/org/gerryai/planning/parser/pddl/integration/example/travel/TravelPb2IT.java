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
public class TravelPb2IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/travel/pb2.pddl";
    }

    @Test
    public void travelProblem2HasCorrectName() {
        assertEquals("big-bull2", problem.getName());
    }

    @Test
    public void travelProblem2HasCorrectDomain() {
        assertEquals("bulldozer", problem.getDomainName());
    }

    @Test
    public void travelProblem2Has16Objects() {
        assertEquals(16, problem.getObjects().asSet().size());
    }

    @Test
    public void travelProblem2HasObjectA() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("a")));
    }

    @Test
    public void travelProblem2HasObjectB() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("b")));
    }

    @Test
    public void travelProblem2HasObjectC() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("c")));
    }

    @Test
    public void travelProblem2HasObjectD() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("d")));
    }

    @Test
    public void travelProblem2HasObjectE() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("e")));
    }

    @Test
    public void travelProblem2HasObjectF() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("f")));
    }

    @Test
    public void travelProblem2HasObjectG() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("g")));
    }

    @Test
    public void travelProblem2HasObjectH() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("h")));
    }

    @Test
    public void travelProblem2HasObjectI() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("i")));
    }

    @Test
    public void travelProblem2HasObjectJ() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("j")));
    }

    @Test
    public void travelProblem2HasObjectK() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("k")));
    }

    @Test
    public void travelProblem2HasObjectL() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("l")));
    }

    @Test
    public void travelProblem2HasObjectM() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("m")));
    }

    @Test
    public void travelProblem2HasObjectN() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("n")));
    }


    @Test
    public void travelProblem2HasObjectJack() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("jack")));
    }

    @Test
    public void travelProblem2HasObjectBulldozer() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("bulldozer")));
    }

    @Test
    public void travelProblem2Has37StateFormulas() {
        assertEquals(37, problem.getInitialState().asSet().size());
    }

    @Test
    public void travelProblem2InitialStateHasAtJackA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("jack"), constant("a"))));
    }

    @Test
    public void travelProblem2InitialStateHasAtBulldozerE() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("bulldozer"), constant("e"))));
    }

    @Test
    public void travelProblem2InitialStateHasVehicleBulldozer() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("vehicle", constant("bulldozer"))));
    }

    @Test
    public void travelProblem2InitialStateHasMobileJack() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("mobile", constant("jack"))));
    }

    @Test
    public void travelProblem2InitialStateHasPersonJack() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("person", constant("jack"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadAB() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("a"), constant("b"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadBA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("b"), constant("a"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadAC() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("a"), constant("c"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadCA() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("c"), constant("a"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadCD() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("c"), constant("d"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadDC() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("d"), constant("c"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadDE() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("d"), constant("e"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadED() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("e"), constant("d"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadEJ() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("e"), constant("j"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadJE() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("j"), constant("e"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadDF() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("d"), constant("f"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadFD() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("f"), constant("d"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadFJ() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("f"), constant("j"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadJF() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("j"), constant("f"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadFK() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("f"), constant("k"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadKF() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("k"), constant("f"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadJH() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("j"), constant("h"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadHJ() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("h"), constant("j"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadHK() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("h"), constant("k"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadKH() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("k"), constant("h"))));
    }

    @Test
    public void travelProblem2InitialStateHasBridgeKL() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("bridge", constant("k"), constant("l"))));
    }

    @Test
    public void travelProblem2InitialStateHasBridgeLK() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("bridge", constant("l"), constant("k"))));
    }

    @Test
    public void travelProblem2InitialStateHasBridgeKN() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("bridge", constant("k"), constant("n"))));
    }

    @Test
    public void travelProblem2InitialStateHasBridgeNK() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("bridge", constant("n"), constant("k"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadLM() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("l"), constant("m"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadML() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("m"), constant("l"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadMN() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("m"), constant("n"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadNM() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("n"), constant("m"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadMG() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("m"), constant("g"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadGM() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("g"), constant("m"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadNG() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("n"), constant("g"))));
    }

    @Test
    public void travelProblem2InitialStateHasRoadGN() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("road", constant("g"), constant("n"))));
    }

    @Test
    public void travelProblem2HasGoal() {
        Goal goal = new Goal(and(predicate("at", constant("bulldozer"), constant("g"))));
        assertEquals(goal, problem.getGoal());
    }
}
