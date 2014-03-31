package org.gerryai.pddl.model.logic;

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
     * Builder class for {@link org.gerryai.pddl.model.logic.Equals}.
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
