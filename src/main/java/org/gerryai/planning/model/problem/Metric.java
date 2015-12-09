package org.gerryai.planning.model.problem;

import org.gerryai.planning.model.logic.Formula;

/**
 * Represents a metric to evaluate a plan.
 */
public class Metric {
    private final String name;
    private final Formula formula;

    /**
     * Builds a metric.
     *
     * @param name    name of the metric
     * @param formula name of the formula
     */
    private Metric(final String name, final Formula formula) {
        this.name = name;
        this.formula = formula;
    }

    /**
     * Get the name of the metric.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the formula of the metric.
     * @return the formula
     */
    public Formula getFormula() {
        return formula;
    }

    /**
     * Builder of metrics.
     */
    public static class Builder {
        private String name;
        private Formula formula;

        /**
         * Sets the name.
         *
         * @param name of the metric
         * @return an updated builder
         */
        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the formula.
         *
         * @param formula of the metric
         * @return an updated builder
         */
        public Builder formula(final Formula formula) {
            this.formula = formula;
            return this;
        }

        /**
         * Build a metric.
         *
         * @return a new immutable metric
         */
        public Metric build() {
            return new Metric(name, formula);
        }
    }

}
