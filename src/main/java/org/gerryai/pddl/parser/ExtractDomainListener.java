package org.gerryai.pddl.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.gerryai.pddl.model.Action;
import org.gerryai.pddl.model.Domain;
import org.gerryai.pddl.model.Requirement;

import org.gerryai.pddl.model.logic.ConstantDefinition;
import org.gerryai.pddl.model.logic.Type;
import org.gerryai.pddl.model.logic.TypeDefinition;
import org.gerryai.pddl.model.logic.Variable;
import org.gerryai.pddl.parser.antlr.PDDL31Parser;
import org.gerryai.pddl.parser.logic.ConstantDefinitionStash;
import org.gerryai.pddl.parser.logic.LogicStackHandler;
import org.gerryai.pddl.parser.logic.TypeDefinitionStash;

import java.util.List;

import static com.google.common.base.Preconditions.checkState;

/**
 * Listener for extracting the {@link org.gerryai.pddl.model.Domain} when walking the parse tree of a PDDL domain.
 */
public class ExtractDomainListener extends LogicListener {

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

    @Override
    public void exitTypeDef(@NotNull final PDDL31Parser.TypeDefContext ctx) {
        typeDefinitionStash.add(new TypeDefinition(ctx.NAME().getSymbol().getText()));
    }

    @Override public void exitTypeDefListOfNoType(@NotNull final PDDL31Parser.TypeDefListOfNoTypeContext ctx) {
        List<TypeDefinition> types = typeDefinitionStash.removeAll();
        for (TypeDefinition type: types) {
            domainBuilder.type(type);
        }
    }

    @Override
    public void exitTypeDefListOfType(@NotNull final PDDL31Parser.TypeDefListOfTypeContext ctx) {
        Type parentType = getType();
        List<TypeDefinition> types = typeDefinitionStash.removeAll();
        for (TypeDefinition type: types) {
            domainBuilder.type(new TypeDefinition(type.getName(), parentType));
        }
    }

    @Override
    public void exitConstantDef(@NotNull final PDDL31Parser.ConstantDefContext ctx) {
        constantDefinitionStash.add(new ConstantDefinition(ctx.NAME().getSymbol().getText()));
    }

    @Override public void exitConstantDefListOfNoType(@NotNull final PDDL31Parser.ConstantDefListOfNoTypeContext ctx) {
        List<ConstantDefinition> constants = constantDefinitionStash.removeAll();
        for (ConstantDefinition constant: constants) {
            domainBuilder.constant(constant);
        }
    }

    @Override
    public void exitConstantDefListOfType(@NotNull final PDDL31Parser.ConstantDefListOfTypeContext ctx) {
        Type type = getType();
        List<ConstantDefinition> constants = constantDefinitionStash.removeAll();
        for (ConstantDefinition constant: constants) {
            domainBuilder.constant(new ConstantDefinition(constant.getName(), type));
        }
    }

    /**
     * Constructor.
     * @param stackHandler the logical stack handler to use
     */
    public ExtractDomainListener(final LogicStackHandler stackHandler) {
        setStackHandler(stackHandler);
    }

    @Override
    public void enterDomain(@NotNull final PDDL31Parser.DomainContext ctx) {
        this.domainBuilder = new Domain.Builder();
    }

    @Override
    public void exitDomainName(@NotNull final PDDL31Parser.DomainNameContext ctx) {
        domainBuilder = domainBuilder.name(ctx.NAME().getSymbol().getText());
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
    public void enterActionDef(@NotNull final PDDL31Parser.ActionDefContext ctx) {
        actionBuilder = new Action.Builder();
    }

    @Override
    public void exitActionSymbol(@NotNull final PDDL31Parser.ActionSymbolContext ctx) {
        actionBuilder.name(ctx.NAME().getSymbol().getText());
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

    /**
     * Build the {@link org.gerryai.pddl.model.Domain} from the information collected whilst walking the parse tree.
     * @return the domain
     */
    public Domain extract() {
        return domainBuilder.build();
    }
}
