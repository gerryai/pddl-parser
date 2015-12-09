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

import org.gerryai.planning.model.logic.Not;
import org.gerryai.planning.parser.pddl.internal.logic.FormulaStash;
import org.gerryai.planning.parser.pddl.internal.logic.SymbolStash;
import org.gerryai.planning.parser.pddl.internal.logic.TermStash;

import static com.google.common.base.Preconditions.checkState;

/**
 * Formula builder for negations.
 */
public class NotBuilder implements FormulaBuilder<Not> {

    @Override
    public Not build(final SymbolStash symbolStash, final SymbolStash operatorStash, final TermStash termStash,
                     final FormulaStash formulas) {
        checkState(symbolStash.isEmpty(), "Not expecting a symbol");
        checkState(termStash.isEmpty(), "Not expecting any uncollected terms");
        checkState(formulas.size() == 1, "Expected a single completed formula to be ready for collection");

        return new Not(formulas.remove());
    }
}
