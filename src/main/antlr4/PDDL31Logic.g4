grammar PDDL31Logic;
import PDDL31Requirements;

// Rules for types

primitiveType
    : NAME
    ;

eitherType
    : '(' 'either' primitiveType+ ')'
    ;

type
    : eitherType
    | primitiveType
    ;

// Rules for terms

term
    : constant
    | variable
    ;

constant
    : NAME
    ;

variable: '?' NAME;

// Rules for functions

functionName: NAME;

functionTerm
  : '(' functionName term* ')'
  ;

// Rules for predicates

predicateName: NAME;

predicateTerm
    : '(' predicateName term* ')'
    ;

predicateConstant
    : '(' predicateName constant* ')'
    ;

// Rules for formulas

negatedAtomicFormulaTerm
    : '(' 'not' atomicFormulaTerm ')'
    ;

negatedAtomicFormulaConstant
    : '(' 'not' atomicFormulaConstant ')'
    ;

literalTerm
    : atomicFormulaTerm
    | negatedAtomicFormulaTerm
    ;

literalConstant
    : atomicFormulaConstant
    | negatedAtomicFormulaConstant
    ;

atomicFormulaTerm
    : predicateTerm
    | {isAllowed(Requirement.EQUALITY)}? equalityTerm {needed(Requirement.EQUALITY);}
    ;

atomicFormulaConstant
    : predicateConstant
    | {isAllowed(Requirement.EQUALITY)}? equalityConstant {needed(Requirement.EQUALITY);}
    ;

assignmentFormulaTerm
    : '(' operator consequent antecedent ')'
    ;

operator
    : constant
    ;

antecedent
    : functionTerm
    ;

consequent
    : functionTerm
    ;

equalityTerm
    : '(' '=' term term ')'
    ;

equalityConstant
    : '(' '=' constant constant ')'
    ;
