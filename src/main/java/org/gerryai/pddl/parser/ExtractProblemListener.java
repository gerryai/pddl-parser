package org.gerryai.pddl.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.gerryai.pddl.model.ConstantDefinition;
import org.gerryai.pddl.model.logic.Type;
import org.gerryai.pddl.model.problem.Problem;
import org.gerryai.pddl.parser.antlr.PDDL31Parser;
import org.gerryai.pddl.parser.logic.ConstantDefinitionStash;
import org.gerryai.pddl.parser.logic.LogicStackHandler;

import java.util.List;

/**
 * Listener for extracting a {@link org.gerryai.pddl.model.problem.Problem} when walking the parse tree of a PDDL file.
 */
public class ExtractProblemListener extends LogicListener implements ExtractingListener<Problem> {

    private Problem.Builder problemBuilder;

    /**
     * The stash of constants awaiting collection.
     */
    private ConstantDefinitionStash constantDefinitionStash = new ConstantDefinitionStash();

    /**
     * Constructor.
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
        problemBuilder = problemBuilder.name(ctx.NAME().getSymbol().getText());
    }

    @Override
    public void exitProblemDomain(@NotNull final PDDL31Parser.ProblemDomainContext ctx) {
        problemBuilder = problemBuilder.domain(ctx.NAME().getSymbol().getText());
    }

    @Override
    public void exitObjectDec(@NotNull final PDDL31Parser.ObjectDecContext ctx) {
        constantDefinitionStash.add(new ConstantDefinition(ctx.NAME().getSymbol().getText()));
    }

    @Override
    public void exitObjectDecListOfNoType(@NotNull final PDDL31Parser.ObjectDecListOfNoTypeContext ctx) {
        List<ConstantDefinition> constants = constantDefinitionStash.removeAll();
        for (ConstantDefinition constant: constants) {
            problemBuilder = problemBuilder.object(constant);
        }
    }

    @Override
    public void exitObjectDecListOfType(@NotNull final PDDL31Parser.ObjectDecListOfTypeContext ctx) {
        Type type = getType();
        List<ConstantDefinition> constants = constantDefinitionStash.removeAll();
        for (ConstantDefinition constant: constants) {
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
    public Problem extract() {
        return problemBuilder.build();
    }
}
