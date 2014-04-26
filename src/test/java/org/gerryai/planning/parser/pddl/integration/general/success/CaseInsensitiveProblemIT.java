package org.gerryai.planning.parser.pddl.integration.general.success;

import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.domain.Action;
import org.gerryai.planning.model.problem.Goal;
import org.gerryai.planning.parser.pddl.integration.DomainSuccessTester;
import org.gerryai.planning.parser.pddl.integration.ProblemSuccessTester;
import org.junit.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.constant;
import static org.gerryai.planning.model.logic.FormulaBuilder.predicate;
import static org.gerryai.planning.model.logic.FormulaBuilder.type;
import static org.gerryai.planning.model.logic.FormulaBuilder.variable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that PDDL parsing is case insensitive.
 */
public class CaseInsensitiveProblemIT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/general/success/case-insensitive-problem.pddl";
    }

    @Test
    public void testProblemHasLowerCaseName() {
        assertEquals("test", problem.getName());
    }

    @Test
    public void testProblemHasLowerCaseDomainName() {
        assertEquals("test", problem.getDomainName());
    }

    @Test
    public void testProblemHasObjectTest1() {
        assertTrue("Problem contains the test object", problem.getObjects().asSet().contains(new ConstantDefinition("test1", type("testtype"))));
    }

    @Test
    public void testProblemHasObjectTest2() {
        assertTrue("Problem contains the test object", problem.getObjects().asSet().contains(new ConstantDefinition("test2", type("testtype1", "testtype2"))));
    }

    @Test
    public void testProblemHasGoal() {
        Goal goal = new Goal(predicate("test", constant("a"), constant("b")));
        assertEquals(goal, problem.getGoal());
    }
}
