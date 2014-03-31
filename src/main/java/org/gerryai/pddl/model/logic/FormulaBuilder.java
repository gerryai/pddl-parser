package org.gerryai.pddl.model.logic;

/**
 * Utility class containing methods for building formulas.
 */
public class FormulaBuilder {

    /**
     * Private constructor to prevent misuse.
     */
    private FormulaBuilder() { }

    /**
     * Construct a constant given a name.
     * @param name the name
     * @return the constant
     */
    public static Constant constant(final String name) {
        return new Constant(name);
    }

    /**
     * Construct a variable given a name.
     * @param name the name
     * @return the variable
     */
    public static Variable variable(final String name) {
        return new Variable(name);
    }

    /**
     * Construct a conjunctive formula from a list of sub-formulas.
     * @param formulas the formulas
     * @return the new formula
     */
    public static And and(final Formula... formulas) {
        And.Builder builder = new And.Builder();
        for (Formula formula: formulas) {
            builder = builder.and(formula);
        }
        return builder.build();
    }

    /**
     * Construct a disjunctive formula from a list of sub-formulas.
     * @param formulas the formulas
     * @return the new formula
     */
    public static Or or(final Formula... formulas) {
        Or.Builder builder = new Or.Builder();
        for (Formula formula: formulas) {
            builder = builder.or(formula);
        }
        return builder.build();
    }

    /**
     * Construct a negation from a sub-formula.
     * @param formula the formula to negate
     * @return the new formula
     */
    public static Not not(final Formula formula) {
        return new Not(formula);
    }

    /**
     * Construct a predicate from a list of terms.
     * @param name the name of the predicate
     * @param terms the terms of the predicate
     * @return the predicate
     */
    public static Predicate predicate(final String name, final Term... terms) {
        Predicate.Builder builder = new Predicate.Builder().name(name);
        for (Term term: terms) {
            builder = builder.term(term);
        }
        return builder.build();
    }

    /**
     * Construct an equality formula from two terms.
     * @param left the term on the left of the equality
     * @param right the term on the right of the equality
     * @return the equality formula
     */
    public static Equals equality(final Term left, final Term right) {
        return new Equals.Builder()
                .left(left)
                .right(right)
                .build();
    }
}
