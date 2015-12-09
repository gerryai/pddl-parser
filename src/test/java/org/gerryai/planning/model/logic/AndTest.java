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
package org.gerryai.planning.model.logic;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class AndTest {

    private Formula mockFormulaA = mock(Formula.class);
    private Formula mockFormulaB = mock(Formula.class);
    private Formula mockFormulaC = mock(Formula.class);

    @Test
    public void asListReturnsNoFormulas() {
        List<Formula> formulas = new ArrayList<>(0);
        And and = new And.Builder()
                .build();
        assertEquals(formulas, and.asList());
    }

    @Test
    public void asListReturnsSingleFormula() {
        List<Formula> formulas = new ArrayList<>(1);
        formulas.add(mockFormulaA);
        And and = new And.Builder()
                .and(mockFormulaA)
                .build();
        assertEquals(formulas, and.asList());
    }

    @Test
    public void asListReturnsMultipleFormulas() {
        List<Formula> formulas = new ArrayList<>(3);
        formulas.add(mockFormulaA);
        formulas.add(mockFormulaB);
        formulas.add(mockFormulaC);
        And and = new And.Builder()
                .and(mockFormulaA)
                .and(mockFormulaB)
                .and(mockFormulaC)
                .build();
        assertEquals(formulas, and.asList());
    }

    @Test
    public void testEquals() {
        new EqualsTester()
                .addEqualityGroup(
                        new And.Builder()
                                .and(mockFormulaA)
                                .build(),
                        new And.Builder()
                                .and(mockFormulaA)
                                .build())
                .addEqualityGroup(new And.Builder()
                                .and(mockFormulaB)
                                .build(),
                        new And.Builder()
                                .and(mockFormulaB)
                                .build()
                )
                .addEqualityGroup(new And.Builder()
                                .and(mockFormulaA)
                                .and(mockFormulaB)
                                .build(),
                        new And.Builder()
                                .and(mockFormulaA)
                                .and(mockFormulaB)
                                .build()
                )
                .addEqualityGroup(new And.Builder()
                                .and(mockFormulaB)
                                .and(mockFormulaA)
                                .build(),
                        new And.Builder()
                                .and(mockFormulaB)
                                .and(mockFormulaA)
                                .build()
                )
                .testEquals();
    }
}
