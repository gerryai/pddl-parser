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
package org.gerryai.planning.parser.pddl.integration.example.briefcase;

import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.problem.Goal;
import org.gerryai.planning.parser.pddl.integration.ProblemSuccessTester;
import org.junit.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Briefcase example files are parsed correctly.
 */
public class BriefcasePb1IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/briefcase/pb1.pddl";
    }

    @Test
    public void briefcaseProblem1HasCorrectName() {
        assertEquals("pb1", problem.getName());
    }

    @Test
    public void briefcaseProblem1HasCorrectDomain() {
        assertEquals("briefcase", problem.getDomainName());
    }

    @Test
    public void briefcaseProblem1HasFourRequirements() {
        assertEquals(4, problem.getRequirements().asSet().size());
    }

    @Test
    public void briefcaseProblem1HasStripsRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.STRIPS));
    }

    @Test
    public void briefcaseProblem1HasTypingRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.TYPING));
    }

    @Test
    public void briefcaseProblem1HasUniversalPreconditionsRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.UNIVERSAL_PRECONDITIONS));
    }

    @Test
    public void briefcaseProblem1HasConditionalEffectsRequirement() {
        assertTrue(problem.getRequirements().asSet().contains(Requirement.CONDITIONAL_EFFECTS));
    }

    @Test
    public void briefcaseProblem1Has3Objects() {
        assertEquals(3, problem.getObjects().asSet().size());
    }

    @Test
    public void briefcaseProblem1HasObjectHome() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("home", type("location"))));
    }

    @Test
    public void briefcaseProblem1HasObjectL1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("l1", type("location"))));
    }

    @Test
    public void briefcaseProblem1HasObjectO1() {
        assertTrue(problem.getObjects().asSet().contains(new ConstantDefinition("o1", type("portable"))));
    }

    @Test
    public void briefcaseProblem1HasTwoStateTerms() {
        assertEquals(2, problem.getInitialState().asSet().size());
    }

    @Test
    public void briefcaseProblem1InitialStateHasIsAt() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("is-at", constant("home"))));
    }

    @Test
    public void briefcaseProblem1InitialStateHasAt() {
        assertTrue(problem.getInitialState().asSet().contains(predicate("at", constant("o1"), constant("l1"))));
    }

    @Test
    public void briefcaseProblem1HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("is-at", constant("home")),
                        predicate("at", constant("o1"), constant("home"))));
        assertEquals(goal, problem.getGoal());
    }
}
