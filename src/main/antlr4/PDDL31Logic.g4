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
    | number
    ;

constant
    : NAME
    ;

number
    : NUMBER
    ;

variable: '?' NAME;

// Rules for functions

functionName: NAME;

functionTerm
  : '(' functionName term* ')'
  | number
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

operation
    : '(' operator consequent antecedent? ')'
    ;

operator
    : NAME
    | BASICOPERATOR
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
