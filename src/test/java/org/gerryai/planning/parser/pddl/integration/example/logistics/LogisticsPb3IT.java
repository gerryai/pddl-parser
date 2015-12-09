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
public class LogisticsPb3IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/logistics/pb3.pddl";
    }

    @Test
    public void logisticsProblem3HasCorrectName() {
        assertEquals("pb3", problem.getName());
    }

    @Test
    public void logisticsProblem3HasCorrectDomain() {
        assertEquals("logistics", problem.getDomainName());
    }

    @Test
    public void logisticsProblem3Has2Requirements() {
        assertEquals(2, problem.getRequirements().asSet().size());
    }

    @Test
    public void logisticsProblem3HasStripsRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.STRIPS));
    }

    @Test
    public void logisticsProblem3HasTypingRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.TYPING));
    }

    @Test
    public void logisticsProblem3Has20Objects() {
        assertEquals(20, problem.getObjects().asSet().size());
    }

    @Test
    public void logisticsProblem3HasObjectPackage1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("package1", type("package"))));
    }

    @Test
    public void logisticsProblem3HasObjectPackage2() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("package2", type("package"))));
    }

    @Test
    public void logisticsProblem3HasObjectPackage3() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("package3", type("package"))));
    }

    @Test
    public void logisticsProblem3HasObjectAirpplane1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("airplane1", type("airplane"))));
    }

    @Test
    public void logisticsProblem3HasObjectAirplane2() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("airplane2", type("airplane"))));
    }

    @Test
    public void logisticsProblem3HasObjectPgh() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("pgh", type("city"))));
    }

    @Test
    public void logisticsProblem3HasObjectBos() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("bos", type("city"))));
    }

    @Test
    public void logisticsProblem3HasObjectLa() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("la", type("city"))));
    }

    @Test
    public void logisticsProblem3HasObjectPghTruck() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("pgh-truck", type("truck"))));
    }

    @Test
    public void logisticsProblem3HasObjectBosTruck() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("bos-truck", type("truck"))));
    }

    @Test
    public void logisticsProblem3HasObjectLaTruck() {
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
    public void logisticsProblem2HasObjectPghCentral() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("pgh-central", type("location"))));
    }

    @Test
    public void logisticsProblem2HasObjectBosCentral() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("bos-central", type("location"))));
    }

    @Test
    public void logisticsProblem2HasObjectLaCentral() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("la-central", type("location"))));
    }

    @Test
    public void logisticsProblem3HasObjectPghAirport() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("pgh-airport", type("airport", "location"))));
    }

    @Test
    public void logisticsProblem3HasObjectBosAirport() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("bos-airport", type("airport", "location"))));
    }

    @Test
    public void logisticsProblem3HasObjectLaAirport() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("la-airport", type("airport", "location"))));
    }

    @Test
    public void logisticsProblem3Has17StateTerms() {
        assertEquals(17, problem.getInitialState().asSet().size());
    }

    @Test
    public void logisticsProblem3InitialStateHasInCityPghPoPgh() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("pgh-po"), constant("pgh"))));
    }

    @Test
    public void logisticsProblem3InitialStateHasInCityPghAirportPgh() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("pgh-airport"), constant("pgh"))));
    }

    @Test
    public void logisticsProblem3InitialStateHasInCityPghCentralPgh() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("pgh-central"), constant("pgh"))));
    }

    @Test
    public void logisticsProblem3InitialStateHasInCityBosPoBos() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("bos-po"), constant("bos"))));
    }

    @Test
    public void logisticsProblem3InitialStateHasInCityBosAirportBos() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("bos-airport"), constant("bos"))));
    }

    @Test
    public void logisticsProblem3InitialStateHasInCityBosCentralBos() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("bos-central"), constant("bos"))));
    }

    @Test
    public void logisticsProblem3InitialStateHasInCityLaPoLa() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("la-po"), constant("la"))));
    }

    @Test
    public void logisticsProblem3InitialStateHasInCityLaAirportLa() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("la-airport"), constant("la"))));
    }

    @Test
    public void logisticsProblem3InitialStateHasInCityLaCentralLa() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("la-central"), constant("la"))));
    }

    @Test
    public void logisticsProblem3InitialStateHasAtPackage1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("package1"), constant("pgh-po"))));
    }

    @Test
    public void logisticsProblem3InitialStateHasAtPackage2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("package2"), constant("pgh-po"))));
    }

    @Test
    public void logisticsProblem3InitialStateHasAtPackage3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("package3"), constant("pgh-po"))));
    }

    @Test
    public void logisticsProblem3InitialStateHasAtAirplane1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("airplane1"), constant("pgh-airport"))));
    }

    @Test
    public void logisticsProblem3InitialStateHasAtAirplane2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("airplane2"), constant("pgh-airport"))));
    }

    @Test
    public void logisticsProblem3InitialStateHasAtBosTruck() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("bos-truck"), constant("bos-po"))));
    }

    @Test
    public void logisticsProblem3InitialStateHasAtPghTruck() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("pgh-truck"), constant("pgh-po"))));
    }

    @Test
    public void logisticsProblem3InitialStateHasAtLaTruck() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("la-truck"), constant("la-po"))));
    }

    @Test
    public void logisticsProblem3HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("at", constant("package1"), constant("bos-po")),
                        predicate("at", constant("package2"), constant("la-po")),
                        predicate("at", constant("package3"), constant("bos-po"))));
        assertEquals(goal, problem.getGoal());
    }
}
