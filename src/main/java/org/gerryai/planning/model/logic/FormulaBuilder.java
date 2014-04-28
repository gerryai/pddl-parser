/*
 * Gerry AI - Open framework for automated planning
 * Copyright (c) 2014 David Edwards <david@more.fool.me.uk>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gerryai.planning.model.logic;

import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.domain.TypeDefinition;

/**
 * Utility class containing methods for building formulas.
 */
public class FormulaBuilder {

    /**
     * Private constructor to prevent misuse.
     */
    private FormulaBuilder() { }

    /**
     * Construct a type definition given a type name.
     * @param name the name
     * @return the type definition
     */
    public static TypeDefinition typeDefinition(final String name) {
        return new TypeDefinition(name);
    }

    /**
     * Construct a type definition from a name and a parent type.
     * @param name the name
     * @param parent the parent type
     * @return the type definition
     */
    public static TypeDefinition typeDefinition(final String name, final Type parent) {
        return new TypeDefinition(name, parent);
    }

    /**
     * Construct a constant definition given a name.
     * @param name the name
     * @return the constant definition
     */
    public static ConstantDefinition constantDefinition(final String name) {
        return new ConstantDefinition(name);
    }

    /**
     * Construct a constant definition from a name and a type.
     * @param name the name
     * @param parent the type
     * @return the constant definition
     */
    public static ConstantDefinition constantDefinition(final String name, final Type parent) {
        return new ConstantDefinition(name, parent);
    }

    /**
     * Construct a primitive type given a name.
     * @param name the name of the type
     * @return the type
     */
    public static PrimitiveType type(final String name) {
        return new PrimitiveType(name);
    }

    /**
     * Construct a list of possible types given an array of names.
     * @param names the type names
     * @return the wrapped list of names
     */
    public static EitherType type(final String... names) {
        return new EitherType(names);
    }
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
     * Construct a variable given a name and type.
     * @param name the name
     * @param type the type
     * @return the variable
     */
    public static Variable variable(final String name, final Type type) {
        return new Variable(name, type);
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

    /**
     * Begin constructing a condition formula.
     * @param condition the condition
     * @return a builder to complete the conditional
     */
    public static IfThen.If when(final Formula condition) {
        return new IfThen.If(condition);
    }

    /**
     * Construct a universal quantifier.
     * @param formula the formula
     * @param variables the list of variables
     * @return the "for all" formula
     */
    public static ForAll forAll(final Formula formula, final Variable... variables) {
        ForAll.Builder builder = new ForAll.Builder();
        for (Variable variable: variables) {
            builder = builder.variable(variable);
        }
        return builder.formula(formula).build();
    }
}
