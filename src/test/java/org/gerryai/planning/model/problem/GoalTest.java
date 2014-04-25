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
