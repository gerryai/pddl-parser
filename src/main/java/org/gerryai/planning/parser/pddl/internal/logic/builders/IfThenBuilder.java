package org.gerryai.planning.parser.pddl.internal.logic.builders;

import org.gerryai.planning.model.logic.IfThen;
import org.gerryai.planning.parser.pddl.internal.logic.FormulaStash;
import org.gerryai.planning.parser.pddl.internal.logic.SymbolStash;
import org.gerryai.planning.parser.pddl.internal.logic.TermStash;

import static com.google.common.base.Preconditions.checkState;

/**
 * Formula builder for conditional formulas.
 */
public class IfThenBuilder implements FormulaBuilder<IfThen> {

    @Override
    public IfThen build(final SymbolStash symbolStash, final TermStash termStash, final FormulaStash formulaStash) {
        checkState(symbolStash.isEmpty(), "Not expecting a symbol");
        checkState(formulaStash.size() == 2, "Expected two formulas for collection");
        checkState(termStash.isEmpty(), "Expected no uncollected terms");

        return new IfThen.If(formulaStash.remove())
                .then(formulaStash.remove());
    }
}
