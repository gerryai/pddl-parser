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
package org.gerryai.planning.parser.pddl.integration.example.tasks;

import org.gerryai.planning.model.logic.Constant;
import org.gerryai.planning.model.logic.Formula;
import org.gerryai.planning.model.logic.FunctionTerm;
import org.gerryai.planning.model.logic.NumberTerm;
import org.gerryai.planning.model.logic.Operation;
import org.gerryai.planning.parser.pddl.integration.ProblemSuccessTester;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Blocksworld example files are parsed correctly.
 */
public class TasksPb1IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/tasks/pb1.pddl";
    }

    @Test
    public void tasksDomainHasCorrectName() {
        assertEquals("pb1", problem.getName());
    }

    @Test
    public void hasThreeAssignmentOperations() {
        Set<Formula> allStateFormulas = problem.getInitialState().asSet();
        Set<Formula> onlyOperations = new HashSet<>();
        for (Formula allStateFormula : allStateFormulas) {
            if (allStateFormula instanceof Operation) {
                onlyOperations.add(allStateFormula);
            }
        }

        assertEquals(5, onlyOperations.size());
    }

    @Test
    public void containsAllRequiresRewardOperations() throws Exception {
        Operation mark = new Operation.Builder()
            .operator("=")
            .antecedent(new FunctionTerm.Builder().term(new NumberTerm("50")).build())
            .consequent(new FunctionTerm.Builder().name("requires_reward").term(new Constant("mark")).build())
            .build();

        Operation toby = new Operation.Builder()
            .operator("=")
            .antecedent(new FunctionTerm.Builder().term(new NumberTerm("60")).build())
            .consequent(new FunctionTerm.Builder().name("requires_reward").term(new Constant("toby")).build())
            .build();

        Operation luke = new Operation.Builder()
            .operator("=")
            .antecedent(new FunctionTerm.Builder().term(new NumberTerm("70")).build())
            .consequent(new FunctionTerm.Builder().name("requires_reward").term(new Constant("luke")).build())
            .build();

        Operation phil = new Operation.Builder()
            .operator("=")
            .antecedent(new FunctionTerm.Builder().term(new NumberTerm("170")).build())
            .consequent(new FunctionTerm.Builder().name("requires_reward").term(new Constant("phil")).build())
            .build();

        Set<Formula> formulas = problem.getInitialState().asSet();
        assertTrue(formulas.contains(mark));
        assertTrue(formulas.contains(toby));
        assertTrue(formulas.contains(luke));
        assertTrue(formulas.contains(phil));
    }

    @Test
    public void containsTotalCostOperation() throws Exception {
        Operation totalCost = new Operation.Builder()
            .operator("=")
            .antecedent(new FunctionTerm.Builder().term(new NumberTerm("0")).build())
            .consequent(new FunctionTerm.Builder().name("total-cost").build())
            .build();

        Set<Formula> formulas = problem.getInitialState().asSet();
        assertTrue(formulas.contains(totalCost));
    }

    @Test
    public void containsMetricDefinition() {
        String metricName = problem.getMetric().getName();
        FunctionTerm term = (FunctionTerm) problem.getMetric().getFormula();

        assertEquals("minimize", metricName);
        assertEquals("total-cost", term.getName());
    }
}
