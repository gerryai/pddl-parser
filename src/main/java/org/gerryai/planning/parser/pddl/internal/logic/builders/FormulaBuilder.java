package org.gerryai.planning.parser.pddl.internal.logic.builders;

import org.gerryai.planning.model.logic.Formula;
import org.gerryai.planning.parser.pddl.internal.logic.FormulaStash;
import org.gerryai.planning.parser.pddl.internal.logic.SymbolStash;
import org.gerryai.planning.parser.pddl.internal.logic.TermStash;

/**
 * Interface for a formula builder.
 * @param <T> the type of formula the builder will create
 */
public interface FormulaBuilder<T extends Formula> {

    /**
     * Build a formula of the specified type using the symbol, terms and formulas collected.
     * @param symbolStash the symbol stashed
     * @param termStash the terms collected
     * @param formulaStash the formulas collected
     * @return the completed formula
     */
    T build(final SymbolStash symbolStash, final TermStash termStash, final FormulaStash formulaStash);
}
