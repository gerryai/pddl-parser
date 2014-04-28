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

import java.util.Objects;

/**
 * Class representing an equality expression.
 */
public class Equals implements Formula {

    private Term left;
    private Term right;

    /**
     * Constructor.
     * @param builder the builder to build from
     */
    private Equals(final Builder builder) {
        this.left = builder.left;
        this.right = builder.right;
    }

    /**
     * Get the term on the left of the equality.
     * @return the term
     */
    public Term getLeft() {
        return left;
    }

    /**
     * Get the term on the right of the equality.
     * @return the term
     */
    public Term getRight() {
        return right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Equals other = (Equals) obj;
        return Objects.equals(this.left, other.left) && Objects.equals(this.right, other.right);
    }

    /**
     * Builder class for {@link org.gerryai.planning.model.logic.Equals}.
     */
    public static class Builder {
        private Term left;
        private Term right;

        /**
         * Set the term on the left of the equality.
         * @param left the term
         * @return an updated builder
         */
        public Builder left(final Term left) {
            this.left = left;
            return this;
        }

        /**
         * Set the term on the right of the equality.
         * @param right the term
         * @return an updated builder
         */
        public Builder right(final Term right) {
            this.right = right;
            return this;
        }

        /**
         * Build the finished equality expression.
         * @return the equality
         */
        public Equals build() {
            return new Equals(this);
        }
    }
}
