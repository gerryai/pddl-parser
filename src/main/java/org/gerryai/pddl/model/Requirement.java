package org.gerryai.pddl.model;

/**
 * Class encapsulating an individual planner feature required by a domain specification.
 */
public enum Requirement {
    STRIPS,
    NEGATIVE_PRECONDITIONS,
    EQUALITY,
    TYPING,
    UNIVERSAL_PRECONDITIONS,
    CONDITIONAL_EFFECTS
}
