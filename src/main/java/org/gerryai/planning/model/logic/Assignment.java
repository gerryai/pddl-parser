package org.gerryai.planning.model.logic;

import com.sun.tools.internal.jxc.ap.Const;

public class Assignment implements AtomicFormula {

    private final Constant operator; // TODO this is not an operator
    private final AssignmentHead assignmentHead;
    private final Predicate predicate; // TODO this is not a predicate, is a function call

    public Assignment(Constant operator, AssignmentHead assignmentHead, Predicate predicate) {
        this.operator = operator;
        this.assignmentHead = assignmentHead;
        this.predicate = predicate;
    }

    public static class Builder {
        private Constant operator;
        private AssignmentHead assignmentHead;
        private Predicate predicate;

        public Builder operator(Constant operator){
            this.operator = operator;
            return this;
        }

        public Builder assignmentHead(AssignmentHead assignmentHead){
            this.assignmentHead = assignmentHead;
            return this;
        }

        public Builder predicate(Predicate predicate) {
            this.predicate = predicate;
            return this;
        }

        public Assignment build() {
            return new Assignment(operator, assignmentHead, predicate);
        }
    }
}
