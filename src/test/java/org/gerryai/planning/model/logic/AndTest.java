package org.gerryai.planning.model.logic;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
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
                                .build())
                .addEqualityGroup(new And.Builder()
                                .and(mockFormulaA)
                                .and(mockFormulaB)
                                .build(),
                        new And.Builder()
                                .and(mockFormulaA)
                                .and(mockFormulaB)
                                .build())
                .addEqualityGroup(new And.Builder()
                                .and(mockFormulaB)
                                .and(mockFormulaA)
                                .build(),
                        new And.Builder()
                                .and(mockFormulaB)
                                .and(mockFormulaA)
                                .build())
                .testEquals();
    }
}
