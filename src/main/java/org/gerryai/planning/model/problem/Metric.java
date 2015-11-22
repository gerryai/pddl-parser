package org.gerryai.planning.model.problem;

import org.gerryai.planning.model.logic.Formula;

public class Metric {
    private final String name;
    private final Formula formula;

    private Metric(String name, Formula formula) {
        this.name = name;
        this.formula = formula;
    }

    public static class Builder {
        private String name;
        private Formula formula;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder formula(Formula formula) {
            this.formula = formula;
            return this;
        }

        public Metric build(){
            return new Metric(name, formula);
        }
    }

}
