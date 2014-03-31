grammar PDDL31;

@header {
    package org.gerryai.pddl.parser.antlr;
}

@parser::members {
    public boolean equality = false;
    public boolean negativePreconditions = false;
}

domain
    : '(' 'define' domainName
    requireDef?
    constantsDef?
    predicatesDef?
    structureDef*
    ')'
    ;

domainName
    : '(' 'domain' NAME ')'
    ;

requireDef
    : '(' ':requirements' requireKey+ ')'
    ;

constantsDef
    : '(' ':constants' constantDef+ ')'
    ;

predicatesDef
    : '(' ':predicates' predicateDef+ ')'
    ;

structureDef
    : actionDef
    ;

constantDef
    : constant
    ;

predicateDef
    : ungroundPredicate
    ;

ungroundPredicate: '(' predicateName variable* ')';

predicateName: NAME;

actionDef
    : '(' ':action' actionSymbol
        actionParams
        actionDefBody ')'
    ;

actionSymbol: NAME;

actionParams
    : ':parameters' '(' variable+ ')'
    ;

actionDefBody
    : actionPrecondition? actionEffect?
    ;

actionPrecondition
    : (':precondition' (('(' ')') | preGD))
    ;

actionEffect
    : (':effect' (('(' ')') | effect))
    ;

preGD
    : prefGD
    | preGDAnd
    //| {universal−preconditions}? '(' 'forall' '(' variable ')' preGD ')'
    ;

preGDAnd
    : '(' 'and' preGD* ')'
    ;

prefGD
    : //:preferences (preference [<pref-name>] <GD>)
    // |
     goalDesc
    ;

goalDesc
    : atomicFormulaTerm
    | {negativePreconditions}? literalTerm //:negative−preconditions
    | goalDescAnd
//<GD> ::= :disjunctive−preconditions (or <GD>*)
//<GD> ::= :disjunctive−preconditions (not <GD>)
//<GD> ::= :disjunctive−preconditions (imply <GD> <GD>)
//<GD> ::= :existential−preconditions (exists (<typed list(variable)>) <GD> )
//<GD> ::= :universal−preconditions (forall (<typed list(variable)>) <GD> )
//<GD> ::= :numeric-fluents <f-comp>
    ;

goalDescAnd
    : '(' 'and' goalDesc* ')'
    ;

effect
    : cEffectAnd
    | cEffect
    ;

cEffectAnd
    : '(' 'and' cEffect* ')'
    ;

cEffect
    : //:conditional−effects (forall (<typed list (variable)>) <effect>)
    // | :conditional−effects (when <GD> <cond-effect>)
    // |
    pEffect
    ;

pEffect
    : negatedAtomicFormulaTerm
    | atomicFormulaTerm
    //<p-effect> ::=:numeric-fluents (<assign-op> <f-head> <f-exp>)
    //<p-effect> ::=:object-fluents (assign <function-term> <term>)
    //<p-effect> ::=:object-fluents (assign <function-term> undefined)
    ;

negatedAtomicFormulaTerm
    : '(' 'not' atomicFormulaTerm ')'
    ;

literalTerm
    : atomicFormulaTerm
    | negatedAtomicFormulaTerm
    ;

atomicFormulaTerm
    : predicate
    | {equality}? equality
    ;

predicate
    : '(' predicateName term* ')'
    ;

equality
    : '(' '=' term term ')'
    ;

term
    : constant
    | variable
    ;

constant
    : NAME
    ;

variable: '?' NAME;


requireKey
    : ':strips'   // Basic STRIPS-style adds and deletes
//    | ':typing' // Allow type names in declarations of variables
    | ':negative-preconditions' {negativePreconditions = true;} // Allow not in goal descriptions
//    | ':disjunctive-preconditions' // Allow or in goal descriptions
    | ':equality' {equality = true;} // Support = as built-in predicate
//    | ':existential-preconditions' // Allow exists in goal descriptions
//    | {universal−preconditions}? ':universal-preconditions' // Allow forall in goal descriptions
//    | ':quantified-preconditions' = :existential-preconditions
//+ :universal-preconditions
//    | ':conditional-effects' // Allow when in action effects
//    | ':fluents' = :numeric-fluents
//+ :object-fluents
//    | ':numeric-fluents' // Allow numeric function definitions and use of effects using assignment operators and arithmetic preconditions.
//:adl = :strips + :typing
//+ :negative-preconditions
//+ :disjunctive-preconditions
//+ :equality
//+ :quantified-preconditions
//+ :conditional-effects
//    | ':durative-actions' // Allows durative actions. Note that this does not imply :numeric-fluents.
//   | ':duration-inequalities' // Allows duration constraints in durative actions using inequalities.
//    | ':continuous-effects' // Allows durative actions to affect fluents continuously over the duration of the actions.
//    | ':derived-predicates' // Allows predicates whose truth value is defined by a formula
//    | ':timed-initial-literals' // Allows the initial state to specify literals that will become true at a specified time point. Implies :durative-actions
//    | ':preferences' // Allows use of preferences in action preconditions and goals.
//    | ':constraints' // Allows use of constraints fields in domain and problem files. These may contain modal operators supporting trajectory constraints.
//    | ':action-costs'
    ;

NAME: LETTER ANYCHAR*;
fragment LETTER: [a-zA-Z];
fragment ANYCHAR: LETTER | DIGIT | '-' | '_';
fragment NUMBER: DIGIT+ DECIMAL?;
fragment DIGIT:  [0-9];
fragment DECIMAL: '.' DIGIT+;

LINECOMMENT: (';'|'//') ~('\n'|'\r')* '\r'? '\n' -> skip;
WS: [ \n\t\r]+ -> skip;
