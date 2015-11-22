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

import org.gerryai.planning.model.logic.Assignment;
import org.gerryai.planning.parser.pddl.internal.logic.FormulaStash;
import org.gerryai.planning.parser.pddl.internal.logic.SymbolStash;
import org.gerryai.planning.parser.pddl.internal.logic.TermStash;

import static com.google.common.base.Preconditions.checkState;

/**
 * Formula builder for functions.
 */
public class AssignmentBuilder implements FormulaBuilder<Assignment> {

    @Override
    public Assignment build(final SymbolStash symbolStash, final TermStash termStash, final FormulaStash formulaStash) {
        checkState(formulaStash.size() == 2, "Expecting predicate formula with value to assign");
        checkState(!termStash.isEmpty(), "Expecting constant with operator");

        Assignment.Builder assignmentBuilder = new Assignment.Builder().operator(termStash.constant());
        assignmentBuilder.assignmentHead(formulaStash.removeAssignmentHead());
        assignmentBuilder.predicate(formulaStash.removePredicate());
        return assignmentBuilder.build();
    }
}
