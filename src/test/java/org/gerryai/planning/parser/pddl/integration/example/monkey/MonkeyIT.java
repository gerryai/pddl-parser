package org.gerryai.planning.parser.pddl.integration.example.monkey;

import org.gerryai.planning.model.domain.Action;
import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.logic.Predicate;
import org.gerryai.planning.parser.pddl.integration.DomainSuccessTester;
import org.junit.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.and;
import static org.gerryai.planning.model.logic.FormulaBuilder.constant;
import static org.gerryai.planning.model.logic.FormulaBuilder.constantDefinition;
import static org.gerryai.planning.model.logic.FormulaBuilder.not;
import static org.gerryai.planning.model.logic.FormulaBuilder.predicate;
import static org.gerryai.planning.model.logic.FormulaBuilder.variable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test to check that the Monkey example files are parsed correctly.
 */
public class MonkeyIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/example/monkey/monkey.pddl";
    }

    @Test
    public void monkeyDomainHasCorrectName() {
        assertEquals("monkey", domain.getName());
    }

    @Test
    public void monkeyDomainHasOneRequirement() {
        assertEquals(1, domain.getRequirements().asSet().size());
    }

    @Test
    public void monkeyDomainHasStripsRequirement() {
        assertTrue(domain.getRequirements().asSet().contains(Requirement.STRIPS));
    }

    @Test
    public void monkeyDomainHasSixConstants() {
        assertEquals(6, domain.getConstants().asSet().size());
    }

    @Test
    public void monkeyDomainHasConstantMonkey() {
        assertTrue(domain.getConstants().asSet().contains(constantDefinition("monkey")));
    }

    @Test
    public void monkeyDomainHasConstantBox() {
        assertTrue(domain.getConstants().asSet().contains(constantDefinition("box")));
    }

    @Test
    public void monkeyDomainHasConstantKnife() {
        assertTrue(domain.getConstants().asSet().contains(constantDefinition("knife")));
    }

    @Test
    public void monkeyDomainHasConstantBananas() {
        assertTrue(domain.getConstants().asSet().contains(constantDefinition("bananas")));
    }

    @Test
    public void monkeyDomainHasConstantGlass() {
        assertTrue(domain.getConstants().asSet().contains(constantDefinition("glass")));
    }

    @Test
    public void monkeyDomainHasConstantWaterFountain() {
        assertTrue(domain.getConstants().asSet().contains(constantDefinition("waterfountain")));
    }

    @Test
    public void monkeyDomainHasEightPredicates() {
        assertEquals(8, domain.getPredicates().asSet().size());
    }

    @Test
    public void monkeyDomainHasPredicateLocation() {
        Predicate location = new Predicate.Builder()
                .name("location")
                .variable("x")
                .build();
        assertTrue("Domain contains the (location ?x) predicate", domain.getPredicates().asSet().contains(location));
    }

    @Test
    public void monkeyDomainHasPredicateOnFloor() {
        Predicate onFloor = new Predicate.Builder()
                .name("on-floor")
                .build();
        assertTrue("Domain contains the (on-floor) predicate", domain.getPredicates().asSet().contains(onFloor));
    }

    @Test
    public void monkeyDomainHasPredicateAt() {
        Predicate at = new Predicate.Builder()
                .name("at")
                .variable("m")
                .variable("x")
                .build();
        assertTrue("Domain contains the (at ?m ?x) predicate", domain.getPredicates().asSet().contains(at));
    }

    @Test
    public void monkeyDomainHasPredicateHasKnife() {
        Predicate hasKnife = new Predicate.Builder()
                .name("hasknife")
                .build();
        assertTrue("Domain contains the (hasknife) predicate", domain.getPredicates().asSet().contains(hasKnife));
    }

    @Test
    public void monkeyDomainHasPredicateOnBox() {
        Predicate onbox = new Predicate.Builder()
                .name("onbox")
                .variable("x")
                .build();
        assertTrue("Domain contains the (onbox ?x) predicate", domain.getPredicates().asSet().contains(onbox));
    }

    @Test
    public void monkeyDomainHasPredicateHasBananas() {
        Predicate hasBananas = new Predicate.Builder()
                .name("hasbananas")
                .build();
        assertTrue("Domain contains the (hasbananas) predicate", domain.getPredicates().asSet().contains(hasBananas));
    }

    @Test
    public void monkeyDomainHasPredicateHasGlass() {
        Predicate hasGlass = new Predicate.Builder()
                .name("hasglass")
                .build();
        assertTrue("Domain contains the (hasglass) predicate", domain.getPredicates().asSet().contains(hasGlass));
    }

    @Test
    public void monkeyDomainHasPredicateHasWater() {
        Predicate hasWater = new Predicate.Builder()
                .name("haswater")
                .build();
        assertTrue("Domain contains the (haswater) predicate", domain.getPredicates().asSet().contains(hasWater));
    }

    @Test
    public void monkeyDomainHasSevenActions() {
        assertEquals(7, domain.getActions().asSet().size());
    }

    @Test
    public void monkeyDomainHasActionGoTo() {
        Action goTo = new Action.Builder()
                .name("go-to")
                .parameter("x")
                .parameter("y")
                .precondition(
                        and(
                                predicate("location", variable("x")),
                                predicate("location", variable("y")),
                                predicate("on-floor"),
                                predicate("at", constant("monkey"), variable("y")))
                )
                .effect(
                        and(
                                predicate("at", constant("monkey"), variable("x")),
                                not(predicate("at", constant("monkey"), variable("y"))))
                )
                .build();
        assertTrue("Domain contains the GO-TO action", domain.getActions().asSet().contains(goTo));
    }

    @Test
    public void monkeyDomainHasActionClimb() {
        Action climb = new Action.Builder()
                .name("climb")
                .parameter("x")
                .precondition(
                        and(
                                predicate("location", variable("x")),
                                predicate("at", constant("box"), variable("x")),
                                predicate("at", constant("monkey"), variable("x")))
                )
                .effect(
                        and(
                                predicate("onbox", variable("x")),
                                not(predicate("on-floor")))
                )
                .build();
        assertTrue("Domain contains the CLIMB action", domain.getActions().asSet().contains(climb));
    }

    @Test
    public void monkeyDomainHasActionPushBox() {
        Action pushBox = new Action.Builder()
                .name("push-box")
                .parameter("x")
                .parameter("y")
                .precondition(
                        and(
                                predicate("location", variable("x")),
                                predicate("location", variable("y")),
                                predicate("at", constant("box"), variable("y")),
                                predicate("at", constant("monkey"), variable("y")),
                                predicate("on-floor"))
                )
                .effect(
                        and(
                                predicate("at", constant("monkey"), variable("x")),
                                not(predicate("at", constant("monkey"), variable("y"))),
                                predicate("at", constant("box"), variable("x")),
                                not(predicate("at", constant("box"), variable("y"))))
                )
                .build();
        assertTrue("Domain contains the PUSH-BOX action", domain.getActions().asSet().contains(pushBox));
    }

    @Test
    public void monkeyDomainHasActionGetKnife() {
        Action getKnife = new Action.Builder()
                .name("get-knife")
                .parameter("y")
                .precondition(
                        and(
                                predicate("location", variable("y")),
                                predicate("at", constant("knife"), variable("y")),
                                predicate("at", constant("monkey"), variable("y")))
                )
                .effect(
                        and(
                                predicate("hasknife"),
                                not(predicate("at", constant("knife"), variable("y"))))
                )
                .build();
        assertTrue("Domain contains the GET-KNIFE action", domain.getActions().asSet().contains(getKnife));
    }

    @Test
    public void monkeyDomainHasActionGrabBananas() {
        Action grabBananas = new Action.Builder()
                .name("grab-bananas")
                .parameter("y")
                .precondition(
                        and(
                                predicate("location", variable("y")),
                                predicate("hasknife"),
                                predicate("at", constant("bananas"), variable("y")),
                                predicate("onbox", variable("y")))
                )
                .effect(
                        predicate("hasbananas")
                )
                .build();
        assertTrue("Domain contains the GRAB-BANANAS action", domain.getActions().asSet().contains(grabBananas));
    }

    @Test
    public void monkeyDomainHasActionPickGlass() {
        Action pickGlass = new Action.Builder()
                .name("pickglass")
                .parameter("y")
                .precondition(
                        and(
                                predicate("location", variable("y")),
                                predicate("at", constant("glass"), variable("y")),
                                predicate("at", constant("monkey"), variable("y")))
                )
                .effect(
                        and(
                                predicate("hasglass"),
                                not(predicate("at", constant("glass"), variable("y"))))
                )
                .build();
        assertTrue("Domain contains the PICKGLASS action", domain.getActions().asSet().contains(pickGlass));
    }

    @Test
    public void monkeyDomainHasActionGetWater() {
        Action getWater = new Action.Builder()
                .name("getwater")
                .parameter("y")
                .precondition(
                        and(
                                predicate("location", variable("y")),
                                predicate("hasglass"),
                                predicate("at", constant("waterfountain"), variable("y")),
                                predicate("at", constant("monkey"), variable("y")),
                                predicate("onbox", variable("y")))
                )
                .effect(
                        predicate("haswater")
                )
                .build();
        assertTrue("Domain contains the GETWATER action", domain.getActions().asSet().contains(getWater));
    }
}
