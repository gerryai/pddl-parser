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
public class LogisticsPb5IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/logistics/pb5.pddl";
    }

    @Test
    public void logisticsProblem5HasCorrectName() {
        assertEquals("pb5", problem.getName());
    }

    @Test
    public void logisticsProblem5HasCorrectDomain() {
        assertEquals("logistics", problem.getDomainName());
    }

    @Test
    public void logisticsProblem5Has2Requirements() {
        assertEquals(2, problem.getRequirements().asSet().size());
    }

    @Test
    public void logisticsProblem5HasStripsRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.STRIPS));
    }

    @Test
    public void logisticsProblem5HasTypingRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.TYPING));
    }

    @Test
    public void logisticsProblem5Has23Objects() {
        assertEquals(23, problem.getObjects().asSet().size());
    }

    @Test
    public void logisticsProblem5HasObjectPackage1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("package1", type("package"))));
    }

    @Test
    public void logisticsProblem5HasObjectPackage2() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("package2", type("package"))));
    }

    @Test
    public void logisticsProblem5HasObjectPackage3() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("package3", type("package"))));
    }

    @Test
    public void logisticsProblem5HasObjectPackage5() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("package5", type("package"))));
    }

    @Test
    public void logisticsProblem5HasObjectPackage7() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("package7", type("package"))));
    }

    @Test
    public void logisticsProblem5HasObjectAirplane1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("airplane1", type("airplane"))));
    }

    @Test
    public void logisticsProblem5HasObjectAirplane2() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("airplane2", type("airplane"))));
    }

    @Test
    public void logisticsProblem5HasObjectPgh() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("pgh", type("city"))));
    }

    @Test
    public void logisticsProblem5HasObjectBos() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("bos", type("city"))));
    }

    @Test
    public void logisticsProblem5HasObjectLa() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("la", type("city"))));
    }

    @Test
    public void logisticsProblem5HasObjectNy() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("ny", type("city"))));
    }

    @Test
    public void logisticsProblem5HasObjectPghTruck() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("pgh-truck", type("truck"))));
    }

    @Test
    public void logisticsProblem5HasObjectBosTruck() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("bos-truck", type("truck"))));
    }

    @Test
    public void logisticsProblem5HasObjectLaTruck() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("la-truck", type("truck"))));
    }

    @Test
    public void logisticsProblem5HasObjectNyTruck() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("ny-truck", type("truck"))));
    }

    @Test
    public void logisticsProblem5HasObjectPghPo() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("pgh-po", type("location"))));
    }

    @Test
    public void logisticsProblem5HasObjectBosPo() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("bos-po", type("location"))));
    }

    @Test
    public void logisticsProblem5HasObjectLaPo() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("la-po", type("location"))));
    }

    @Test
    public void logisticsProblem5HasObjectNyPo() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("ny-po", type("location"))));
    }

    @Test
    public void logisticsProblem5HasObjectPghAirport() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("pgh-airport", type("location", "airport"))));
    }

    @Test
    public void logisticsProblem5HasObjectLaAirport() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("la-airport", type("location", "airport"))));
    }

    @Test
    public void logisticsProblem5HasObjectBosAirport() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("bos-airport", type("location", "airport"))));
    }

    @Test
    public void logisticsProblem5HasObjectNyAirport() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("ny-airport", type("location", "airport"))));
    }

    @Test
    public void logisticsProblem5Has19StateTerms() {
        assertEquals(19, problem.getInitialState().asSet().size());
    }
    @Test
    public void logisticsProblem5InitialStateHasInCityPghPoPgh() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("pgh-po"), constant("pgh"))));
    }

    @Test
    public void logisticsProblem5InitialStateHasInCityPghAirportPgh() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("pgh-airport"), constant("pgh"))));
    }

    @Test
    public void logisticsProblem5InitialStateHasInCityBosPoBos() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("bos-po"), constant("bos"))));
    }

    @Test
    public void logisticsProblem5InitialStateHasInCityBosAirportBos() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("bos-airport"), constant("bos"))));
    }

    @Test
    public void logisticsProblem5InitialStateHasInCityLaPoLa() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("la-po"), constant("la"))));
    }

    @Test
    public void logisticsProblem5InitialStateHasInCityLaAirportLa() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("la-airport"), constant("la"))));
    }

    @Test
    public void logisticsProblem5InitialStateHasInCityNyPoNy() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("ny-po"), constant("ny"))));
    }

    @Test
    public void logisticsProblem5InitialStateHasInCityNyAirportNy() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("in-city", constant("ny-airport"), constant("ny"))));
    }

    @Test
    public void logisticsProblem5InitialStateHasAtPackage1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("package1"), constant("pgh-po"))));
    }

    @Test
    public void logisticsProblem5InitialStateHasAtPackage2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("package2"), constant("pgh-po"))));
    }

    @Test
    public void logisticsProblem5InitialStateHasAtPackage3() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("package3"), constant("pgh-po"))));
    }

    @Test
    public void logisticsProblem5InitialStateHasAtPackage5() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("package5"), constant("bos-po"))));
    }

    @Test
    public void logisticsProblem5InitialStateHasAtPackage7() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("package7"), constant("ny-po"))));
    }

    @Test
    public void logisticsProblem5InitialStateHasAtAirplane1() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("airplane1"), constant("pgh-airport"))));
    }

    @Test
    public void logisticsProblem5InitialStateHasAtAirplane2() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("airplane2"), constant("pgh-airport"))));
    }

    @Test
    public void logisticsProblem5InitialStateHasAtBosTruck() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("bos-truck"), constant("bos-po"))));
    }

    @Test
    public void logisticsProblem5InitialStateHasAtPghTruck() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("pgh-truck"), constant("pgh-po"))));
    }

    @Test
    public void logisticsProblem5InitialStateHasAtLaTruck() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("la-truck"), constant("la-po"))));
    }

    @Test
    public void logisticsProblem5InitialStateHasAtNyTruck() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("ny-truck"), constant("ny-po"))));
    }

    @Test
    public void logisticsProblem5HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("at", constant("package1"), constant("bos-po")),
                        predicate("at", constant("package2"), constant("ny-po")),
                        predicate("at", constant("package3"), constant("la-po")),
                        predicate("at", constant("package5"), constant("pgh-po")),
                        predicate("at", constant("package7"), constant("pgh-po"))));
        assertEquals(goal, problem.getGoal());
    }
}
