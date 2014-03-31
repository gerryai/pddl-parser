package org.gerryai.pddl.parser.logic.builders;

import org.gerryai.pddl.model.logic.Not;
import org.gerryai.pddl.parser.logic.FormulaStash;
import org.gerryai.pddl.parser.logic.SymbolStash;
import org.gerryai.pddl.parser.logic.TermStash;

import static com.google.common.base.Preconditions.checkState;

/**
 * Formula builder for negations.
 */
public class NotBuilder implements FormulaBuilder<Not> {

    @Override
    public Not build(final SymbolStash symbolStash, final TermStash termStash, final FormulaStash formulas) {
        checkState(symbolStash.isEmpty(), "Not expecting a symbol");
        checkState(termStash.isEmpty(), "Not expecting any uncollected terms");
        checkState(formulas.size() == 1, "Expected a single completed formula to be ready for collection");

        return new Not(formulas.remove());
    }
}
