package org.gerryai.pddl.parser.logic.builders;

import org.gerryai.pddl.model.logic.And;
import org.gerryai.pddl.model.logic.Formula;
import org.gerryai.pddl.parser.logic.FormulaStash;
import org.gerryai.pddl.parser.logic.SymbolStash;
import org.gerryai.pddl.parser.logic.TermStash;

import static com.google.common.base.Preconditions.checkState;

/**
 * Formula builder for conjunctive formulas.
 */
public class AndBuilder implements FormulaBuilder<And> {

    @Override
    public And build(final SymbolStash symbolStash, final TermStash termStash, final FormulaStash formulas) {
        checkState(symbolStash.isEmpty(), "Not expecting a symbol");
        checkState(termStash.isEmpty(), "Not expecting any uncollected terms");
        checkState(formulas.size() > 0, "Expected at least one completed formula to be ready for collection");

        And.Builder builder = new And.Builder();
        for (Formula formula: formulas.removeAll()) {
            builder = builder.and(formula);
        }
        return builder.build();
    }
}
