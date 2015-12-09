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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *Represents a function term.
 */
public class FunctionTerm implements AtomicFormula {

    private String name;
    private List<Term> terms;

    /**
     * Constructor.
     * @param name the name of the function term
     * @param terms the terms for this function term
     */
    private FunctionTerm(final String name, final List<Term> terms) {
        this.name = name;
        this.terms = terms;
    }

    /**
     * Get the name of the function term.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Get a list of terms used by this function term.
     * @return the terms
     */
    public List<Term> getTerms() {
        return Collections.unmodifiableList(terms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, terms);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final FunctionTerm other = (FunctionTerm) obj;
        return Objects.equals(this.name, other.name) && Objects.equals(this.terms, other.terms);
    }

    /**
     * Builder class for {@link FunctionTerm}.
     */
    public static class Builder {
        private String name;
        private List<Term> terms;

        /**
         * Constructor.
         */
        public Builder() {
            terms = new ArrayList<>(0);
        }

        /**
         * Set the name of the function term to be built.
         * @param name the name
         * @return an updated builder
         */
        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        /**
         * Add a new variable to the list of terms to be used by this function term.
         * @param name the name of the variable
         * @return an updated builder
         */
        public Builder variable(final String name) {
            terms.add(new Variable(name));
            return this;
        }

        /**
         * Add a new variable to the list of terms to be used by this function term.
         * @param name the name of the variable
         * @param type the type of the variable
         * @return an updated builder
         */
        public Builder variable(final String name, final Type type) {
            terms.add(new Variable(name, type));
            return this;
        }

        /**
         * Add a new variable to the list of terms to be used by this function term.
         * @param variable the variable to add
         * @return an updated builder
         */
        public Builder variable(final Variable variable) {
            terms.add(variable);
            return this;
        }

        /**
         * Add a term to the list to be used by the function term.
         * @param term the term to add
         * @return an updated builder
         */
        public Builder term(final Term term) {
            terms.add(term);
            return this;
        }

        /**
         * Build the finished function term.
         * @return the function term
         */
        public FunctionTerm build() {
            return new FunctionTerm(name, terms);
        }
    }
}
