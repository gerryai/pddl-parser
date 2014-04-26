package org.gerryai.planning.model.logic;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class NotTest {

    @Test
    public void getFormulaReturnsSameFormula() {
        Formula mockFormula = mock(Formula.class);
        Not not = new Not(mockFormula);
        assertEquals(mockFormula, not.getFormula());
    }

    @Test
    public void testEquals() {
        Formula mockFormulaA = mock(Formula.class);
        Formula mockFormulaB = mock(Formula.class);

        new EqualsTester()
                .addEqualityGroup(new Not(mockFormulaA), new Not(mockFormulaA))
                .addEqualityGroup(new Not(mockFormulaB), new Not(mockFormulaB))
                .testEquals();
    }
}
