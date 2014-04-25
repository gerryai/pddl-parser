package org.gerryai.planning.parser.pddl.internal.logic;

/**
 * Enumeration of the different types of formula the stack supports. Only used internally for stack management.
 */
enum FormulaType {
    PREDICATE,
    NOT,
    AND,
    OR,
    EQUALS,
    IF_THEN,
    FOR_ALL
}
