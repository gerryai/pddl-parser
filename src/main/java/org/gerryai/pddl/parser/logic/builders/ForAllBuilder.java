package org.gerryai.pddl.parser.logic.builders;

import org.gerryai.pddl.model.logic.ForAll;
import org.gerryai.pddl.model.logic.Variable;
import org.gerryai.pddl.parser.logic.FormulaStash;
import org.gerryai.pddl.parser.logic.SymbolStash;
import org.gerryai.pddl.parser.logic.TermStash;

import static com.google.common.base.Preconditions.checkState;

/**
 * Formula builder for universal quantifiers.
 */
public class ForAllBuilder implements FormulaBuilder<ForAll> {

    @Override
    public ForAll build(final SymbolStash symbolStash, final TermStash termStash, final FormulaStash formulaStash) {
        checkState(symbolStash.isEmpty(), "Not expecting a symbol");
        checkState(formulaStash.size() == 1, "Expected one formula for collection");
        checkState(termStash.size() > 0, "Expected at least one uncollected term");
        // TODO: Explicitly check that the stack contains only variables

        ForAll.Builder forAllBuilder = new ForAll.Builder()
                .formula(formulaStash.remove());
        for (Variable variable: termStash.variables()) {
            forAllBuilder = forAllBuilder.variable(variable);
        }
        return forAllBuilder.build();
    }
}
