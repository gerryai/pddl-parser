package org.gerryai.pddl.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.gerryai.pddl.model.Action;
import org.gerryai.pddl.model.Domain;
import org.gerryai.pddl.model.Requirement;

import org.gerryai.pddl.model.logic.Variable;
import org.gerryai.pddl.parser.antlr.PDDL31Parser;
import org.gerryai.pddl.parser.logic.LogicStackHandler;

import static com.google.common.base.Preconditions.checkState;

/**
 * Listener for extracting the {@link org.gerryai.pddl.model.Domain} when walking the parse tree of a PDDL domain.
 */
public class ExtractDomainListener extends LogicListener {

    private Domain.Builder domainBuilder;

    private Action.Builder actionBuilder;

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

    @Override public void exitPredicateDef(@NotNull final PDDL31Parser.PredicateDefContext ctx) {
        domainBuilder = domainBuilder.predicate(getPredicate());
    }

    @Override public void exitConstantDef(@NotNull final PDDL31Parser.ConstantDefContext ctx) {
        domainBuilder = domainBuilder.constant(getConstant());
    }

    /**
     * Begin building an action by initialising the action builder.
     * @param ctx the rule context
     */
    @Override public void enterActionDef(@NotNull final PDDL31Parser.ActionDefContext ctx) {
        actionBuilder = new Action.Builder();
    }

    /**
     * Set the name of the action being built.
     * @param ctx the rule context
     */
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
