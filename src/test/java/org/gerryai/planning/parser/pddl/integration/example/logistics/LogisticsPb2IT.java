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
public class LogisticsPb2IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/logistics/pb2.pddl";
    }

    @Test
    public void logisticsProblem2HasCorrectName() {
        assertEquals("pb2", problem.getName());
    }

    @Test
    public void logisticsProblem2HasCorrectDomain() {
        assertEquals("logistics", problem.getDomainName());
    }

    @Test
    public void logisticsProblem2Has2Requirements() {
        assertEquals(2, problem.getRequirements().asSet().size());
    }

    @Test
    public void logisticsProblem2HasStripsRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.STRIPS));
    }

    @Test
    public void logisticsProblem2HasTypingRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.TYPING));
    }

    @Test
    public void logisticsProblem2Has23Objects() {
        assertEquals(23, problem.getObjects().asSet().size());
    }

    @Test
    public void logisticsProblem2HasObjectPackage1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("package1", type("package"))));
    }

    @Test
    public void logisticsProblem2HasObjectPackage2() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("package2", type("package"))));
    }

    @Test
    public void logisticsProblem2HasObjectPackage3() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("package3", type("package"))));
    }

    @Test
    public void logisticsProblem2HasObjectPackage4() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("package4", type("package"))));
    }

    @Test
    public void logisticsProblem2HasObjectPackage5() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("package5", type("package"))));
    }

    @Test
    public void logisticsProblem2HasObjectPackage6() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("package6", type("package"))));
    }

    @Test
    public void logisticsProblem2HasObjectPackage7() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("package7", type("package"))));
    }

    @Test
    public void logisticsProblem2HasObjectPackage8() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("package8", type("package"))));
    }

    @Test
    public void logisticsProblem2HasObjectAirpplane1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("airplane1", type("airplane"))));
    }

    @Test
    public void logisticsProblem2HasObjectAirplane2() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("airplane2", type("airplane"))));
    }

    @Test
    public void logisticsProblem2HasObjectPgh() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("pgh", type("city"))));
    }

    @Test
    public void logisticsProblem2HasObjectBos() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("bos", type("city"))));
    }

    @Test
    public void logisticsProblem2HasObjectLa() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("la", type("city"))));
    }

    @Test
    public void logisticsProblem2HasObjectPghTruck() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("pgh-truck", type("truck"))));
    }

    @Test
    public void logisticsProblem2HasObjectBosTruck() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("bos-truck", type("truck"))));
    }

    @Test
    public void logisticsProblem2HasObjectLaTruck() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("la-truck", type("truck"))));
    }

    @Test
    public void logisticsProblem2HasObjectPghPo() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("pgh-po", type("location"))));
    }

    @Test
    public void logisticsProblem2HasObjectBosPo() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("bos-po", type("location"))));
    }

    @Test
    public void logisticsProblem2HasObjectLaPo() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("la-po", type("location"))));
    }

    @Test
    public void logisticsProblem2HasObjectPghAirport() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("pgh-airport", type("location", "airport"))));
    }

    @Test
    public void logisticsProblem2HasObjectBosAirport() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("bos-airport", type("location", "airport"))));
    }

    @Test
    public void logisticsProblem2HasObjectLaAirport() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("la-airport", type("location", "airport"))));
    }

    @Test
    public void logisticsProblem2Has19StateTerms() {
        assertEquals(19, problem.getInitialState().asSet().size());
    }

    @Test
    public void logisticsProblem2InitialStateHasInCityPghPoPgh() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("pgh-po"), constant("pgh"))));
    }

    @Test
    public void logisticsProblem2InitialStateHasInCityPghAirportPgh() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("pgh-airport"), constant("pgh"))));
    }

    @Test
    public void logisticsProblem2InitialStateHasInCityBosPoBos() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("bos-po"), constant("bos"))));
    }

    @Test
    public void logisticsProblem2InitialStateHasInCityBosAirportBos() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("bos-airport"), constant("bos"))));
    }

    @Test
    public void logisticsProblem2InitialStateHasInCityLaPoLa() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("la-po"), constant("la"))));
    }

    @Test
    public void logisticsProblem2InitialStateHasInCityLaAirportLa() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("la-airport"), constant("la"))));
    }

    @Test
    public void logisticsProblem2InitialStateHasAtPackage1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("package1"), constant("pgh-po"))));
    }

    @Test
    public void logisticsProblem2InitialStateHasAtPackage2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("package2"), constant("pgh-po"))));
    }

    @Test
    public void logisticsProblem2InitialStateHasAtPackage3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("package3"), constant("pgh-po"))));
    }

    @Test
    public void logisticsProblem2InitialStateHasAtPackage4() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("package4"), constant("pgh-po"))));
    }

    @Test
    public void logisticsProblem2InitialStateHasAtPackage5() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("package5"), constant("bos-po"))));
    }

    @Test
    public void logisticsProblem2InitialStateHasAtPackage6() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("package6"), constant("bos-po"))));
    }

    @Test
    public void logisticsProblem2InitialStateHasAtPackage7() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("package7"), constant("bos-po"))));
    }

    @Test
    public void logisticsProblem2InitialStateHasAtPackage8() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("package8"), constant("la-po"))));
    }

    @Test
    public void logisticsProblem2InitialStateHasAtAirplane1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("airplane1"), constant("pgh-airport"))));
    }

    @Test
    public void logisticsProblem2InitialStateHasAtAirplane2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("airplane2"), constant("pgh-airport"))));
    }

    @Test
    public void logisticsProblem2InitialStateHasAtBosTruck() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("bos-truck"), constant("bos-po"))));
    }

    @Test
    public void logisticsProblem2InitialStateHasAtPghTruck() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("pgh-truck"), constant("pgh-po"))));
    }

    @Test
    public void logisticsProblem2InitialStateHasAtLaTruck() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("la-truck"), constant("la-po"))));
    }

    @Test
    public void logisticsProblem2HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("at", constant("package1"), constant("bos-po")),
                        predicate("at", constant("package2"), constant("bos-airport")),
                        predicate("at", constant("package3"), constant("la-po")),
                        predicate("at", constant("package4"), constant("la-airport")),
                        predicate("at", constant("package5"), constant("pgh-po")),
                        predicate("at", constant("package6"), constant("pgh-airport")),
                        predicate("at", constant("package7"), constant("pgh-po")),
                        predicate("at", constant("package8"), constant("pgh-po"))));
        assertEquals(goal, problem.getGoal());
    }
}
