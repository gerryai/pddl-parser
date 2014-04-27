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
