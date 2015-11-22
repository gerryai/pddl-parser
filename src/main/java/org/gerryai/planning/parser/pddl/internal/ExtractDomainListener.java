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

import org.antlr.v4.runtime.misc.NotNull;
import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.domain.Action;
import org.gerryai.planning.model.domain.Domain;
import org.gerryai.planning.model.domain.TypeDefinition;
import org.gerryai.planning.model.logic.Type;
import org.gerryai.planning.model.logic.Variable;
import org.gerryai.planning.parser.error.MissingRequirementsException;
import org.gerryai.planning.parser.error.ParseException;
import org.gerryai.planning.parser.pddl.antlr.PDDL31Parser;
import org.gerryai.planning.parser.pddl.internal.logic.ConstantDefinitionStash;
import org.gerryai.planning.parser.pddl.internal.logic.LogicStackHandler;
import org.gerryai.planning.parser.pddl.internal.logic.TypeDefinitionStash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.google.common.base.Preconditions.checkState;

/**
 * Listener for extracting a {@link org.gerryai.planning.model.domain.Domain} when walking the parse tree of a PDDL
 * file.
 */
public class ExtractDomainListener extends LogicListener implements ExtractingListener<Domain> {

    private Domain.Builder domainBuilder;

    private Action.Builder actionBuilder;

    /**
     * The stash of types awaiting collection.
     */
    private TypeDefinitionStash typeDefinitionStash = new TypeDefinitionStash();

    /**
     * The stash of constants awaiting collection.
     */
    private ConstantDefinitionStash constantDefinitionStash = new ConstantDefinitionStash();

    /**
     * Constructor.
     * @param stackHandler the logical stack handler to use
     */
    public ExtractDomainListener(final LogicStackHandler stackHandler) {
        setStackHandler(stackHandler);
    }

    @Override
    public void exitTypeDef(@NotNull final PDDL31Parser.TypeDefContext ctx) {
        typeDefinitionStash.add(new TypeDefinition(ctx.NAME().getSymbol().getText().toLowerCase()));
    }

    @Override
    public void exitTypeDefListOfNoType(@NotNull final PDDL31Parser.TypeDefListOfNoTypeContext ctx) {
        List<TypeDefinition> types = typeDefinitionStash.removeAll();
        for (TypeDefinition type: types) {
            domainBuilder = domainBuilder.type(type);
        }
    }

    @Override
    public void exitTypeDefListOfType(@NotNull final PDDL31Parser.TypeDefListOfTypeContext ctx) {
        Type parentType = getType();
        List<TypeDefinition> types = typeDefinitionStash.removeAll();
        for (TypeDefinition type: types) {
            domainBuilder = domainBuilder.type(new TypeDefinition(type.getName(), parentType));
        }
    }

    @Override
    public void exitConstantDef(@NotNull final PDDL31Parser.ConstantDefContext ctx) {
        constantDefinitionStash.add(new ConstantDefinition(ctx.NAME().getSymbol().getText().toLowerCase()));
    }

    @Override
    public void exitConstantDefListOfNoType(@NotNull final PDDL31Parser.ConstantDefListOfNoTypeContext ctx) {
        List<ConstantDefinition> constants = constantDefinitionStash.removeAll();
        for (ConstantDefinition constant: constants) {
            domainBuilder = domainBuilder.constant(constant);
        }
    }

    @Override
    public void exitConstantDefListOfType(@NotNull final PDDL31Parser.ConstantDefListOfTypeContext ctx) {
        Type type = getType();
        List<ConstantDefinition> constants = constantDefinitionStash.removeAll();
        for (ConstantDefinition constant: constants) {
            domainBuilder = domainBuilder.constant(new ConstantDefinition(constant.getName(), type));
        }
    }

    @Override
    public void enterDomain(@NotNull final PDDL31Parser.DomainContext ctx) {
        domainBuilder = new Domain.Builder();
    }

    @Override
    public void exitDomainName(@NotNull final PDDL31Parser.DomainNameContext ctx) {
        domainBuilder = domainBuilder.name(ctx.NAME().getSymbol().getText().toLowerCase());
    }

    @Override
    public void exitRequireKey(@NotNull final PDDL31Parser.RequireKeyContext ctx) {
        String text = ctx.getText();
        String requirementName = text.substring(1);
        Requirement requirement = Requirement.valueOf(requirementName.toUpperCase().replace('-', '_'));
        domainBuilder = domainBuilder.requirement(requirement);
    }

    @Override
    public void exitPredicateDef(@NotNull final PDDL31Parser.PredicateDefContext ctx) {
        domainBuilder = domainBuilder.predicate(getPredicate());
    }

    @Override
    public void exitFunctionDef(@NotNull final PDDL31Parser.FunctionDefContext ctx) {
        super.exitFunctionDef(ctx);
        domainBuilder = domainBuilder.function(getFunction());
    }

    @Override
    public void enterActionDef(@NotNull final PDDL31Parser.ActionDefContext ctx) {
        actionBuilder = new Action.Builder();
    }

    @Override
    public void exitActionSymbol(@NotNull final PDDL31Parser.ActionSymbolContext ctx) {
        actionBuilder.name(ctx.NAME().getSymbol().getText().toLowerCase());
    }

    /**
     * Check that the term queue is empty before processing action parameters.
     * @param ctx the rule context
     */
    @Override
    public void enterActionParams(@NotNull final PDDL31Parser.ActionParamsContext ctx) {
        checkState(isClean(), "Term and formula queues should be empty when starting to process action parameters");
    }

    /**
     * Collect the action's parameters and add them to the action builder.
     * @param ctx the rule context.
     */
    @Override public void exitActionParams(@NotNull final PDDL31Parser.ActionParamsContext ctx) {
        for (Variable variable: getVariables()) {
            actionBuilder.parameter(variable);
        }
    }

    /**
     * Build the action's effect and add it to the action builder.
     * @param ctx the rule context
     */
    @Override
    public void exitActionEffect(@NotNull final PDDL31Parser.ActionEffectContext ctx) {
        actionBuilder.effect(getFormula());
    }

    @Override public void exitActionPrecondition(@NotNull final PDDL31Parser.ActionPreconditionContext ctx) {
        actionBuilder.precondition(getFormula());
    }

    @Override
    public void exitActionDef(@NotNull final PDDL31Parser.ActionDefContext ctx) {
        domainBuilder = domainBuilder.action(actionBuilder.build());
    }

    @Override
    public Domain extract() {
        return domainBuilder.build();
    }

    @Override
    public Domain extract(final Set<Requirement> requirementsNeeded) throws ParseException {
        Domain domain = extract();
        Set<Requirement> requirementsDeclared = domain.getRequirements().asSet();
        Set<Requirement> requirementsMissing = new HashSet<>();
        for (Requirement requirement: requirementsNeeded) {
            if (!requirementsDeclared.contains(requirement)) {
                requirementsMissing.add(requirement);
            }
        }
        if (!requirementsMissing.isEmpty()) {
            throw new MissingRequirementsException(requirementsMissing);
        }
        return domain;
    }

}
