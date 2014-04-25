package org.gerryai.planning.parser.pddl.internal.logic.builders;

import org.gerryai.planning.model.logic.Predicate;
import org.gerryai.planning.model.logic.Term;
import org.gerryai.planning.parser.pddl.internal.logic.FormulaStash;
import org.gerryai.planning.parser.pddl.internal.logic.SymbolStash;
import org.gerryai.planning.parser.pddl.internal.logic.TermStash;

import static com.google.common.base.Preconditions.checkState;

/**
 * Formula builder for predicates.
 */
public class PredicateBuilder implements FormulaBuilder<Predicate> {

    @Override
    public Predicate build(final SymbolStash symbolStash, final TermStash termStash, final FormulaStash formulaStash) {
        checkState(!symbolStash.isEmpty(), "Cannot build a predicate without a symbol");
        checkState(formulaStash.isEmpty(), "Not expecting any uncollected formulas");

        Predicate.Builder predicateBuilder = new Predicate.Builder().name(symbolStash.pop());
        for (Term term: termStash.terms()) {
            predicateBuilder = predicateBuilder.term(term);
        }
        return predicateBuilder.build();
    }
}
