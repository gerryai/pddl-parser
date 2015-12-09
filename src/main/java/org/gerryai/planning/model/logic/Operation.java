package org.gerryai.planning.model.logic;

import java.util.Objects;

/**
 * Represents an operation formula.
 */
public class Operation implements Formula {

    private final String operator;
    private final FunctionTerm consequent;
    private final FunctionTerm antecedent;

    /**
     * Build an Operation.
     *
     * @param operator   the name of the operator
     * @param consequent the consequent
     * @param antecedent the antecedent
     */
    private Operation(final String operator, final FunctionTerm consequent, final FunctionTerm antecedent) {
        this.operator = operator;
        this.consequent = consequent;
        this.antecedent = antecedent;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Operation)) {
            return false;
        }
        Operation that = (Operation) obj;
        return Objects.equals(this.operator, that.operator)
            && Objects.equals(this.consequent, that.consequent)
            && Objects.equals(this.antecedent, that.antecedent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator, consequent, antecedent);
    }

    /**
     * Return the operator for this operation.
     *
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Returns the consequent for this operation.
     *
     * @return the consequent
     */
    public FunctionTerm getConsequent() {
        return consequent;
    }

    /**
     * Return the antecedent for this operation.
     *
     * @return the antecedent
     */
    public FunctionTerm getAntecedent() {
        return antecedent;
    }

    /**
     * A builder for immutable operations.
     */
    public static class Builder {
        private String operator;
        private FunctionTerm consequent;
        private FunctionTerm antecedent;

        /**
         * Sets the operator.
         *
         * @param operator the operator
         * @return the Builder
         */
        public Builder operator(final String operator) {
            this.operator = operator;
            return this;
        }

        /**
         * Sets the consequent.
         *
         * @param consequent the consequent
         * @return the Builder
         */
        public Builder consequent(final FunctionTerm consequent) {
            this.consequent = consequent;
            return this;
        }

        /**
         * Sets the antecedent.
         *
         * @param antecedent the antecedent
         * @return the Builder
         */
        public Builder antecedent(final FunctionTerm antecedent) {
            this.antecedent = antecedent;
            return this;
        }

        /**
         * Build a new operation.
         *
         * @return a new immutable operation with the values from this build
         */
        public Operation build() {
            return new Operation(operator, consequent, antecedent);
        }
    }
}
