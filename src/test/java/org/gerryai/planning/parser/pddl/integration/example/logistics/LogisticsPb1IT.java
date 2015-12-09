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
public class LogisticsPb1IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/logistics/pb1.pddl";
    }

    @Test
    public void logisticsProblem1HasCorrectName() {
        assertEquals("pb1", problem.getName());
    }

    @Test
    public void logisticsProblem1HasCorrectDomain() {
        assertEquals("logistics", problem.getDomainName());
    }

    @Test
    public void logisticsProblem1Has2Requirements() {
        assertEquals(2, problem.getRequirements().asSet().size());
    }

    @Test
    public void logisticsProblem1HasStripsRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.STRIPS));
    }

    @Test
    public void logisticsProblem1HasTypingRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.TYPING));
    }

    @Test
    public void logisticsProblem1Has16Objects() {
        assertEquals(16, problem.getObjects().asSet().size());
    }

    @Test
    public void logisticsProblem1HasObjectMxf() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("mxf", type("package"))));
    }

    @Test
    public void logisticsProblem1HasObjectAvrim() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("avrim", type("package"))));
    }

    @Test
    public void logisticsProblem1HasObjectAlex() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("alex", type("package"))));
    }

    @Test
    public void logisticsProblem1HasObjectJason() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("jason", type("package"))));
    }

    @Test
    public void logisticsProblem1HasObjectPencil() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("pencil", type("package"))));
    }

    @Test
    public void logisticsProblem1HasObjectPaper() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("paper", type("package"))));
    }

    @Test
    public void logisticsProblem1HasObjectApril() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("april", type("package"))));
    }

    @Test
    public void logisticsProblem1HasObjectMichelle() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("michelle", type("package"))));
    }

    @Test
    public void logisticsProblem1HasObjectBetty() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("betty", type("package"))));
    }

    @Test
    public void logisticsProblem1HasObjectLisa() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("lisa", type("package"))));
    }

    @Test
    public void logisticsProblem1HasObjectAirplane1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("airplane1", type("airplane"))));
    }

    @Test
    public void logisticsProblem1HasObjectAirplane2() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("airplane2", type("airplane"))));
    }

    @Test
    public void logisticsProblem1HasObjectLonAirport() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("lon-airport", type("airport"))));
    }

    @Test
    public void logisticsProblem1HasObjectParAirport() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("par-airport", type("airport"))));
    }

    @Test
    public void logisticsProblem1HasObjectJFKAirport() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("jfk-airport", type("airport"))));
    }

    @Test
    public void logisticsProblem1HasObjectBosAirport() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("bos-airport", type("airport"))));
    }

    @Test
    public void logisticsProblem1Has12StateTerms() {
        assertEquals(12, problem.getInitialState().asSet().size());
    }

    @Test
    public void logisticsProblem1InitialStateHasAtAirplane1JFKAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("airplane1"), constant("jfk-airport"))));
    }

    @Test
    public void logisticsProblem1InitialStateHasAtAirplane2BosAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("airplane2"), constant("bos-airport"))));
    }

    @Test
    public void logisticsProblem1InitialStateHasAtMxfBosAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("mxf"), constant("par-airport"))));
    }

    @Test
    public void logisticsProblem1InitialStateHasAtAvrimBosAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("avrim"), constant("par-airport"))));
    }

    @Test
    public void logisticsProblem1InitialStateHasAtAlexBosAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("alex"), constant("par-airport"))));
    }

    @Test
    public void logisticsProblem1InitialStateHasAtJasonJFKAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("jason"), constant("jfk-airport"))));
    }

    @Test
    public void logisticsProblem1InitialStateHasAtPencilLonAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("pencil"), constant("lon-airport"))));
    }

    @Test
    public void logisticsProblem1InitialStateHasAtPaperLonAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("paper"), constant("lon-airport"))));
    }

    @Test
    public void logisticsProblem1InitialStateHasAtMichelleLonAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("michelle"), constant("lon-airport"))));
    }

    @Test
    public void logisticsProblem1InitialStateHasAtAprilLonAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("april"), constant("lon-airport"))));
    }

    @Test
    public void logisticsProblem1InitialStateHasAtBettyLonAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("betty"), constant("lon-airport"))));
    }

    @Test
    public void logisticsProblem1InitialStateHasAtLisaLonAirport() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("lisa"), constant("lon-airport"))));
    }

    @Test
    public void logisticsProblem1HasGoal() {
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
