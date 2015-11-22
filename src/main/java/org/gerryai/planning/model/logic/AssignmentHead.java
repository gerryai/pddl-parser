package org.gerryai.planning.model.logic;

public class AssignmentHead implements AtomicFormula {
    private final String functionName;

    public AssignmentHead(String functionName) {
        this.functionName = functionName;
    }

    public static class Builder {
        private String functionName;

        public Builder functionName(String functionName){
            this.functionName = functionName;
            return this;
        }

        public AssignmentHead build() {
            return new AssignmentHead(functionName);
        }
    }
}
