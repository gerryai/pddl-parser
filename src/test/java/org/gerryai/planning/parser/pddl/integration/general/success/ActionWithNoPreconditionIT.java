package org.gerryai.planning.parser.pddl.integration.general.success;

import org.gerryai.planning.model.domain.Action;
import org.gerryai.planning.parser.pddl.integration.DomainSuccessTester;
import org.junit.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.predicate;
import static org.gerryai.planning.model.logic.FormulaBuilder.variable;
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
