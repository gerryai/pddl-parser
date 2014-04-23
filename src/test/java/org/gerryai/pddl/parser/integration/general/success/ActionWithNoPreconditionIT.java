package org.gerryai.pddl.parser.integration.general.success;

import org.gerryai.pddl.model.domain.Action;
import org.gerryai.pddl.parser.integration.DomainSuccessTester;
import org.junit.Test;

import static org.gerryai.pddl.model.logic.FormulaBuilder.predicate;
import static org.gerryai.pddl.model.logic.FormulaBuilder.variable;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that actions with no precondition are parsed correctly.
 */
public class ActionWithNoPreconditionIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/general/success/action-with-no-precondition.pddl";
    }

    @Test
    public void testDomainHasActionTest() {
        Action testing = new Action.Builder()
                .name("test")
                .parameter("x")
                .precondition()
                .effect(
                        predicate("testing", variable("x"))
                )
                .build();
        assertTrue("Domain contains the test action", domain.getActions().asSet().contains(testing));
    }
}
