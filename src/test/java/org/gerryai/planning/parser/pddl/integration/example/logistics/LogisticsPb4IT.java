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
package org.gerryai.planning.parser.pddl.integration.example.logistics;

import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.problem.Goal;
import org.gerryai.planning.parser.pddl.integration.ProblemSuccessTester;
import org.junit.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Logistics example files are parsed correctly.
 */
public class LogisticsPb4IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/logistics/pb4.pddl";
    }

    @Test
    public void logisticsProblem4HasCorrectName() {
        assertEquals("pb4", problem.getName());
    }

    @Test
    public void logisticsProblem4HasCorrectDomain() {
        assertEquals("logistics", problem.getDomainName());
    }

    @Test
    public void logisticsProblem4Has2Requirements() {
        assertEquals(2, problem.getRequirements().asSet().size());
    }

    @Test
    public void logisticsProblem4HasStripsRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.STRIPS));
    }

    @Test
    public void logisticsProblem4HasTypingRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.TYPING));
    }

    @Test
    public void logisticsProblem4Has16Objects() {
        assertEquals(16, problem.getObjects().asSet().size());
    }

    @Test
    public void logisticsProblem4HasObjectMxf() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("mxf", type("package"))));
    }

    @Test
    public void logisticsProblem4HasObjectAvrim() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("avrim", type("package"))));
    }

    @Test
    public void logisticsProblem4HasObjectAlex() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("alex", type("package"))));
    }

    @Test
    public void logisticsProblem4HasObjectJason() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("jason", type("package"))));
    }

    @Test
    public void logisticsProblem4HasObjectPencil() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("pencil", type("package"))));
    }

    @Test
    public void logisticsProblem4HasObjectPaper() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("paper", type("package"))));
    }

    @Test
    public void logisticsProblem4HasObjectApril() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("april", type("package"))));
    }

    @Test
    public void logisticsProblem4HasObjectMichelle() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("michelle", type("package"))));
    }

    @Test
    public void logisticsProblem4HasObjectBetty() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("betty", type("package"))));
    }

    @Test
    public void logisticsProblem4HasObjectLisa() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("lisa", type("package"))));
    }

    @Test
    public void logisticsProblem4HasObjectAirplane1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("airplane1", type("airplane"))));
    }

    @Test
    public void logisticsProblem4HasObjectAirplane2() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("airplane2", type("airplane"))));
    }

    @Test
    public void logisticsProblem4HasObjectLonAirport() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("lon-airport", type("airport"))));
    }

    @Test
    public void logisticsProblem4HasObjectParAirport() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("par-airport", type("airport"))));
    }

    @Test
    public void logisticsProblem4HasObjectJFKAirport() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("jfk-airport", type("airport"))));
    }

    @Test
    public void logisticsProblem4HasObjectBosAirport() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("bos-airport", type("airport"))));
    }

    @Test
    public void logisticsProblem4Has12StateTerms() {
        assertEquals(12, problem.getInitialState().asSet().size());
    }

    @Test
    public void logisticsProblem4InitialStateHasAtAirplane1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("airplane1"), constant("jfk-airport"))));
    }

    @Test
    public void logisticsProblem4InitialStateHasAtAirplane2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("airplane2"), constant("par-airport"))));
    }

    @Test
    public void logisticsProblem4InitialStateHasAtMxfBosAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("mxf"), constant("jfk-airport"))));
    }

    @Test
    public void logisticsProblem4InitialStateHasAtAvrimBosAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("avrim"), constant("par-airport"))));
    }

    @Test
    public void logisticsProblem4InitialStateHasAtAlexBosAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("alex"), constant("bos-airport"))));
    }

    @Test
    public void logisticsProblem4InitialStateHasAtJasonJFKAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("jason"), constant("jfk-airport"))));
    }

    @Test
    public void logisticsProblem4InitialStateHasAtPencilLonAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("pencil"), constant("par-airport"))));
    }

    @Test
    public void logisticsProblem4InitialStateHasAtPaperLonAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("paper"), constant("lon-airport"))));
    }

    @Test
    public void logisticsProblem4InitialStateHasAtMichelleLonAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("michelle"), constant("bos-airport"))));
    }

    @Test
    public void logisticsProblem4InitialStateHasAtAprilLonAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("april"), constant("par-airport"))));
    }

    @Test
    public void logisticsProblem4InitialStateHasAtBettyLonAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("betty"), constant("lon-airport"))));
    }

    @Test
    public void logisticsProblem4InitialStateHasAtLisaLonAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("lisa"), constant("lon-airport"))));
    }

    @Test
    public void logisticsProblem4HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("at", constant("mxf"), constant("bos-airport")),
                        predicate("at", constant("avrim"), constant("jfk-airport")),
                        predicate("at", constant("pencil"), constant("bos-airport")),
                        predicate("at", constant("alex"), constant("jfk-airport")),
                        predicate("at", constant("april"), constant("bos-airport")),
                        predicate("at", constant("lisa"), constant("par-airport")),
                        predicate("at", constant("michelle"), constant("jfk-airport")),
                        predicate("at", constant("jason"), constant("bos-airport")),
                        predicate("at", constant("paper"), constant("par-airport")),
                        predicate("at", constant("betty"), constant("jfk-airport"))));
        assertEquals(goal, problem.getGoal());
    }
}
