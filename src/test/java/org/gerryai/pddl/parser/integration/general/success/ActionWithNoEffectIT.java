package org.gerryai.pddl.parser.integration.general.success;

import org.gerryai.pddl.model.domain.Action;
import org.gerryai.pddl.parser.integration.DomainSuccessTester;
import org.junit.Test;

import static org.gerryai.pddl.model.logic.FormulaBuilder.predicate;
import static org.gerryai.pddl.model.logic.FormulaBuilder.variable;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that actions with no effect are parsed correctly.
 */
public class ActionWithNoEffectIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/general/success/action-with-no-effect.pddl";
    }

    @Test
    public void testDomainHasActionTest() {
        Action testing = new Action.Builder()
                .name("test")
                .parameter("x")
                .precondition(
                        predicate("testing", variable("x"))
                )
                .effect()
                .build();
        assertTrue("Domain contains the test action", domain.getActions().asSet().contains(testing));
    }
}
