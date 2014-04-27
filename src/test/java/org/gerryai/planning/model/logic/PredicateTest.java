package org.gerryai.planning.model.logic;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.gerryai.planning.model.logic.FormulaBuilder.variable;
import static org.junit.Assert.assertEquals;

public class PredicateTest {

    @Test
    public void getPredicateNameReturnsSameName() {
        Predicate predicate = new Predicate.Builder()
                .name("test")
                .build();
        assertEquals("test", predicate.getName());
    }

    @Test
    public void getVariablesReturnsSameVariables() {
        List<Term> terms = new ArrayList<>(2);
        terms.add(variable("a"));
        terms.add(variable("b"));
        Predicate predicate = new Predicate.Builder()
                .name("test")
                .variable("a")
                .variable("b")
                .build();
        assertEquals(terms, predicate.getTerms());
    }

    @Test
    public void testEquals() {
        new EqualsTester()
                .addEqualityGroup(
                        new Predicate.Builder()
                                .name("test")
                                .build(),
                        new Predicate.Builder()
                                .name("test")
                                .build())
                .addEqualityGroup(new Predicate.Builder()
                                .name("different")
                                .build(),
                        new Predicate.Builder()
                                .name("different")
                                .build())
                .addEqualityGroup(new Predicate.Builder()
                                .name("test")
                                .variable("a")
                                .build(),
                        new Predicate.Builder()
                                .name("test")
                                .variable("a")
                                .build())
                .addEqualityGroup(new Predicate.Builder()
                                .name("different")
                                .variable("a")
                                .build(),
                        new Predicate.Builder()
                                .name("different")
                                .variable("a")
                                .build())
                .addEqualityGroup(new Predicate.Builder()
                                .name("test")
                                .variable("a")
                                .variable("b")
                                .build(),
                        new Predicate.Builder()
                                .name("test")
                                .variable("a")
                                .variable("b")
                                .build())
                .addEqualityGroup(new Predicate.Builder()
                                .name("test")
                                .variable("b")
                                .variable("a")
                                .build(),
                        new Predicate.Builder()
                                .name("test")
                                .variable("b")
                                .variable("a")
                                .build()
                )
                .testEquals();
    }
}
