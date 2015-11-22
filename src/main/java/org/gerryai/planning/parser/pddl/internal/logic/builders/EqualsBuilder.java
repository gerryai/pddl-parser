/*
 * Gerry AI - Open framework for automated planning
 * Copyright (c) 2014 David Edwards <david@more.fool.me.uk>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gerryai.planning.parser.pddl.internal.logic.builders;

import org.gerryai.planning.model.logic.Equals;
import org.gerryai.planning.parser.pddl.internal.logic.FormulaStash;
import org.gerryai.planning.parser.pddl.internal.logic.SymbolStash;
import org.gerryai.planning.parser.pddl.internal.logic.TermStash;

import static com.google.common.base.Preconditions.checkState;

/**
 * Formula builder for conjunctive formulas.
 */
public class EqualsBuilder implements FormulaBuilder<Equals> {

    @Override
    public Equals build(final SymbolStash symbolStash, final SymbolStash operatorStash, final TermStash termStash,
                        final FormulaStash formulaStash) {
        checkState(symbolStash.isEmpty(), "Not expecting a symbol");
        checkState(termStash.size() == 2, "Expected two terms for collection");
        checkState(formulaStash.isEmpty(), "Expected no uncollected formulas");

        return new Equals.Builder()
            .left(termStash.remove())
            .right(termStash.remove())
            .build();
    }
}
