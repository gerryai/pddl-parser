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
package org.gerryai.planning.parser.pddl.internal;

import com.google.common.base.Optional;
import org.antlr.v4.runtime.misc.NotNull;
import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.logic.Formula;
import org.gerryai.planning.model.logic.Type;
import org.gerryai.planning.model.problem.Problem;
import org.gerryai.planning.parser.error.MissingRequirementsException;
import org.gerryai.planning.parser.error.ParseException;
import org.gerryai.planning.parser.pddl.antlr.PDDL31Parser;
import org.gerryai.planning.parser.pddl.internal.logic.ConstantDefinitionStash;
import org.gerryai.planning.parser.pddl.internal.logic.LogicStackHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Listener for extracting a {@link org.gerryai.planning.model.problem.Problem} when walking the parse tree of a PDDL
 * file.
 */
public class ExtractProblemListener extends LogicListener implements ExtractingListener<Problem> {

    private Problem.Builder problemBuilder;

    /**
     * The stash of constants awaiting collection.
     */
    private ConstantDefinitionStash constantDefinitionStash = new ConstantDefinitionStash();

    /**
     * Constructor.
     *
     * @param stackHandler the logical stack handler to use
     */
    public ExtractProblemListener(final LogicStackHandler stackHandler) {
        setStackHandler(stackHandler);
    }

    @Override
    public void enterProblem(@NotNull final PDDL31Parser.ProblemContext ctx) {
        this.problemBuilder = new Problem.Builder();
    }

    @Override
    public void exitProblemName(@NotNull final PDDL31Parser.ProblemNameContext ctx) {
        problemBuilder = problemBuilder.name(ctx.NAME().getSymbol().getText().toLowerCase());
    }

    @Override
    public void exitProblemDomain(@NotNull final PDDL31Parser.ProblemDomainContext ctx) {
        problemBuilder = problemBuilder.domain(ctx.NAME().getSymbol().getText().toLowerCase());
    }

    @Override
    public void exitRequireKey(@NotNull final PDDL31Parser.RequireKeyContext ctx) {
        String text = ctx.getText();
        String requirementName = text.substring(1);
        Requirement requirement = Requirement.valueOf(requirementName.toUpperCase().replace('-', '_'));
        problemBuilder = problemBuilder.requirement(requirement);
    }

    @Override
    public void exitObjectDec(@NotNull final PDDL31Parser.ObjectDecContext ctx) {
        constantDefinitionStash.add(new ConstantDefinition(ctx.NAME().getSymbol().getText().toLowerCase()));
    }

    @Override
    public void exitObjectDecListOfNoType(@NotNull final PDDL31Parser.ObjectDecListOfNoTypeContext ctx) {
        List<ConstantDefinition> constants = constantDefinitionStash.removeAll();
        for (ConstantDefinition constant : constants) {
            problemBuilder = problemBuilder.object(constant);
        }
    }

    @Override
    public void exitObjectDecListOfType(@NotNull final PDDL31Parser.ObjectDecListOfTypeContext ctx) {
        Type type = getType();
        List<ConstantDefinition> constants = constantDefinitionStash.removeAll();
        for (ConstantDefinition constant : constants) {
            problemBuilder = problemBuilder.object(new ConstantDefinition(constant.getName(), type));
        }
    }

    @Override
    public void exitInitEl(@NotNull final PDDL31Parser.InitElContext ctx) {
        problemBuilder = problemBuilder.initialState(getFormula().get());
    }


    @Override
    public void exitGoal(@NotNull final PDDL31Parser.GoalContext ctx) {
        problemBuilder = problemBuilder.goal(getFormula().get());
    }

    @Override
    public void enterMetricsDef(@NotNull final PDDL31Parser.MetricsDefContext ctx) {
        problemBuilder = problemBuilder.metric(ctx.NAME().getText().toLowerCase());
    }

    @Override
    public void exitMetricsDef(@NotNull final PDDL31Parser.MetricsDefContext ctx) {
        Optional<Formula> formula = getFormula();
        problemBuilder.metricFormula(formula.get());
    }

    @Override
    public Problem extract() {
        return problemBuilder.build();
    }

    @Override
    public Problem extract(final Set<Requirement> requirementsNeeded) throws ParseException {
        Problem problem = extract();
        Set<Requirement> requirementsDeclared = problem.getRequirements().asSet();
        Set<Requirement> requirementsMissing = new HashSet<>();
        for (Requirement requirement : requirementsNeeded) {
            if (!requirementsDeclared.contains(requirement)) {
                requirementsMissing.add(requirement);
            }
        }
        if (!requirementsMissing.isEmpty()) {
            throw new MissingRequirementsException(requirementsMissing);
        }
        return problem;
    }
}
