package org.gerryai.pddl.parser.logic;

/**
 * Enumeration of the different types of formula the stack supports. Only used internally for stack management.
 */
enum FormulaType {
    PREDICATE,
    NOT,
    AND,
    OR,
    EQUALS
}
