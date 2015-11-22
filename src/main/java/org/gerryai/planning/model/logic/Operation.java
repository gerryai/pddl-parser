package org.gerryai.planning.model.logic;

public class Operation implements Formula {

    private final Constant operator; // TODO this is not a constant, is an operator
    private final FunctionTerm consequent; // TODO this is a function term, consequent
    private final FunctionTerm antecedent; // TODO this is a function term, antecedent

    public Operation(Constant operator, FunctionTerm consequent, FunctionTerm antecedent) {
        this.operator = operator;
        this.consequent = consequent;
        this.antecedent = antecedent;
    }

    public static class Builder {
        private Constant operator;
        private FunctionTerm consequent;
        private FunctionTerm antecedent;

        public Builder operator(Constant operator){
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
