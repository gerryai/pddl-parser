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

public class OrTest {

    private Formula mockFormulaA = mock(Formula.class);
    private Formula mockFormulaB = mock(Formula.class);
    private Formula mockFormulaC = mock(Formula.class);

    @Test
    public void asListReturnsNoFormulas() {
        List<Formula> formulas = new ArrayList<>(0);
        Or or = new Or.Builder()
                .build();
        assertEquals(formulas, or.asList());
    }

    @Test
    public void asListReturnsSingleFormula() {
        List<Formula> formulas = new ArrayList<>(1);
        formulas.add(mockFormulaA);
        Or or = new Or.Builder()
                .or(mockFormulaA)
                .build();
        assertEquals(formulas, or.asList());
    }

    @Test
    public void asListReturnsMultipleFormulas() {
        List<Formula> formulas = new ArrayList<>(3);
        formulas.add(mockFormulaA);
        formulas.add(mockFormulaB);
        formulas.add(mockFormulaC);
        Or or = new Or.Builder()
                .or(mockFormulaA)
                .or(mockFormulaB)
                .or(mockFormulaC)
                .build();
        assertEquals(formulas, or.asList());
    }

    @Test
    public void testEquals() {
        new EqualsTester()
                .addEqualityGroup(
                        new Or.Builder()
                                .or(mockFormulaA)
                                .build(),
                        new Or.Builder()
                                .or(mockFormulaA)
                                .build())
                .addEqualityGroup(new Or.Builder()
                                .or(mockFormulaB)
                                .build(),
                        new Or.Builder()
                                .or(mockFormulaB)
                                .build()
                )
                .addEqualityGroup(new Or.Builder()
                                .or(mockFormulaA)
                                .or(mockFormulaB)
                                .build(),
                        new Or.Builder()
                                .or(mockFormulaA)
                                .or(mockFormulaB)
                                .build()
                )
                .addEqualityGroup(new Or.Builder()
                                .or(mockFormulaB)
                                .or(mockFormulaA)
                                .build(),
                        new Or.Builder()
                                .or(mockFormulaB)
                                .or(mockFormulaA)
                                .build()
                )
                .testEquals();
    }
}
