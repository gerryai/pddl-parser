package org.gerryai.pddl.parser.logic.builders;

import org.gerryai.pddl.model.logic.Predicate;
import org.gerryai.pddl.model.logic.Term;
import org.gerryai.pddl.parser.logic.FormulaStash;
import org.gerryai.pddl.parser.logic.SymbolStash;
import org.gerryai.pddl.parser.logic.TermStash;

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
