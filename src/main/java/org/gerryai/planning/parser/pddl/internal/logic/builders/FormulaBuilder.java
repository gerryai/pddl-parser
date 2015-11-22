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
     * @param operationStash the operator stashed
     * @param termStash the terms collected
     * @param formulaStash the formulas collected
     * @return the completed formula
     */
    T build(final SymbolStash symbolStash, final SymbolStash operationStash, final TermStash termStash,
            final FormulaStash formulaStash);
}
