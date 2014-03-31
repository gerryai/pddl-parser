package org.gerryai.pddl.parser.logic.builders;

import org.gerryai.pddl.model.logic.Equals;
import org.gerryai.pddl.parser.logic.FormulaStash;
import org.gerryai.pddl.parser.logic.SymbolStash;
import org.gerryai.pddl.parser.logic.TermStash;

import static com.google.common.base.Preconditions.checkState;

/**
 * Formula builder for conjunctive formulas.
 */
public class EqualsBuilder implements FormulaBuilder<Equals> {

    @Override
    public Equals build(final SymbolStash symbolStash, final TermStash termStash, final FormulaStash formulaStash) {
        checkState(symbolStash.isEmpty(), "Not expecting a symbol");
        checkState(termStash.size() == 2, "Expected two terms for collection");
        checkState(formulaStash.isEmpty(), "Expected no uncollected formulas");

        return new Equals.Builder()
                .left(termStash.remove())
                .right(termStash.remove())
                .build();
    }
}
