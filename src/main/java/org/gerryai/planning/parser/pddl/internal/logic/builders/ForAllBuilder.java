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

import org.gerryai.planning.model.logic.ForAll;
import org.gerryai.planning.model.logic.Variable;
import org.gerryai.planning.parser.pddl.internal.logic.FormulaStash;
import org.gerryai.planning.parser.pddl.internal.logic.SymbolStash;
import org.gerryai.planning.parser.pddl.internal.logic.TermStash;

import static com.google.common.base.Preconditions.checkState;

/**
 * Formula builder for universal quantifiers.
 */
public class ForAllBuilder implements FormulaBuilder<ForAll> {

    @Override
    public ForAll build(final SymbolStash symbolStash, final SymbolStash operatorStash, final TermStash termStash,
                        final FormulaStash formulaStash) {
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
