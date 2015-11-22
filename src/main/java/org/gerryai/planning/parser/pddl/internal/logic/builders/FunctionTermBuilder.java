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

import org.gerryai.planning.model.logic.FunctionTerm;
import org.gerryai.planning.model.logic.Term;
import org.gerryai.planning.parser.pddl.internal.logic.FormulaStash;
import org.gerryai.planning.parser.pddl.internal.logic.SymbolStash;
import org.gerryai.planning.parser.pddl.internal.logic.TermStash;

/**
 * Formula builder for functions.
 */
public class FunctionTermBuilder implements FormulaBuilder<FunctionTerm> {

    @Override
    public FunctionTerm build(final SymbolStash symbolStash, final SymbolStash operatorStash,
                              final TermStash termStash, final FormulaStash formulaStash) {
        FunctionTerm.Builder functionTermBuilder = new FunctionTerm.Builder();
        if (!symbolStash.isEmpty()) {
            functionTermBuilder.name(symbolStash.pop());
        }
        for (Term term: termStash.terms()) {
            functionTermBuilder = functionTermBuilder.term(term);
        }
        return functionTermBuilder.build();
    }
}
