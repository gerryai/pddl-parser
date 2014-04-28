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
package org.gerryai.planning.model.problem;

import com.google.common.testing.EqualsTester;
import org.gerryai.planning.model.logic.Formula;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class GoalTest {

    @Test
    public void getFormulaReturnsSameFormula() {
        Formula mockFormula = mock(Formula.class);
        Goal goal = new Goal(mockFormula);
        assertEquals(mockFormula, goal.getFormula());
    }

    @Test
    public void testEquals() {
        Formula mockFormulaA = mock(Formula.class);
        Formula mockFormulaB = mock(Formula.class);

        new EqualsTester()
                .addEqualityGroup(new Goal(mockFormulaA), new Goal(mockFormulaA))
                .addEqualityGroup(new Goal(mockFormulaB), new Goal(mockFormulaB))
                .testEquals();
    }
}
