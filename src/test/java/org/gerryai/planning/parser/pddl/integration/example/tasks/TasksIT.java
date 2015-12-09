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

import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.domain.Action;
import org.gerryai.planning.model.domain.FunctionDefinition;
import org.gerryai.planning.model.logic.And;
import org.gerryai.planning.model.logic.Operation;
import org.gerryai.planning.model.logic.PrimitiveType;
import org.gerryai.planning.model.logic.Variable;
import org.gerryai.planning.parser.pddl.integration.DomainSuccessTester;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Blocksworld example files are parsed correctly.
 */
public class TasksIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/example/tasks/tasks.pddl";
    }

    @Test
    public void tasksDomainHasCorrectName() {
        assertEquals("tasks", domain.getName());
    }


    @Test
    public void containsNumericFluentsRequirement() throws Exception {
        assertTrue(domain.getRequirements().asSet().contains(Requirement.NUMERIC_FLUENTS));
    }

    @Test
    public void containsActionCostsRequirement() throws Exception {
        assertTrue(domain.getRequirements().asSet().contains(Requirement.ACTION_COSTS));
    }

    @Test
    public void hasTwoFunctionDefs() throws Exception {
        assertTrue(domain.getFunctions().asSet().size() == 2);
    }

    @Test
    public void containsFunctionRequiresReward() throws Exception {
        FunctionDefinition functionDefinition = new FunctionDefinition.Builder()
            .name("requires_reward")
            .variable(new Variable("p", new PrimitiveType("person")))
            .build();

        Set<FunctionDefinition> functionDefinitions = domain.getFunctions().asSet();
        assertTrue(functionDefinitions.contains(functionDefinition));
    }

    @Test
    public void containsFunctionTotalCost() throws Exception {
        FunctionDefinition functionDefinition = new FunctionDefinition.Builder()
            .name("total-cost")
            .build();

        Set<FunctionDefinition> functionDefinitions = domain.getFunctions().asSet();
        assertTrue(functionDefinitions.contains(functionDefinition));
    }

    @Test
    public void hasIncreaseOperationAsAnEffect() throws Exception {
        Action action = domain.getActions().byName("resolve").get();
        And effect = (And) action.getEffect().getEffect().get();
        Operation operation = (Operation) effect.asList().get(2);

        String operator = operation.getOperator();
        String antecedentName = operation.getAntecedent().getName();
        Variable antecedentVariable = (Variable) operation.getAntecedent().getTerms().get(0);
        String consequentName = operation.getConsequent().getName();

        assertEquals("increase", operator);
        assertEquals("requires_reward", antecedentName);
        assertEquals("p", antecedentVariable.getName());
        assertEquals("total-cost", consequentName);
    }
}

