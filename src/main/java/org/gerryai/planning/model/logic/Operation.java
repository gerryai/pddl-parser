package org.gerryai.planning.model.logic;

public class Operation implements Formula {

    private final String operator;
    private final FunctionTerm consequent;
    private final FunctionTerm antecedent;

    public Operation(String operator, FunctionTerm consequent, FunctionTerm antecedent) {
        this.operator = operator;
        this.consequent = consequent;
        this.antecedent = antecedent;
    }

    public static class Builder {
        private String operator;
        private FunctionTerm consequent;
        private FunctionTerm antecedent;

        public Builder operator(String operator){
            this.operator = operator;
            return this;
        }

        public Builder consequent(FunctionTerm consequent){
            this.consequent = consequent;
            return this;
        }

        public Builder antecedent(FunctionTerm antecedent) {
            this.antecedent = antecedent;
            return this;
        }

        public Operation build() {
            return new Operation(operator, consequent, antecedent);
        }
    }
}
