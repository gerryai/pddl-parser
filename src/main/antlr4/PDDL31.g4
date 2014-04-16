grammar PDDL31;

@header {
    package org.gerryai.pddl.parser.antlr;
}

@parser::members {
    public boolean equality = false;
    public boolean typing = false;
    public boolean negativePreconditions = false;
    public boolean universalPreconditions = false;
    public boolean conditionalEffects = false;
}

domain
    : '(' 'define' domainName
    requireDef?
    typesDef?
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

typesDef
    : {typing}? '(' ':types' typeDefList ')'
    ;

typeDefList
    : typeDefListOfNoType
    | typeDefListOfType typeDefList
    ;

typeDefListOfNoType
    : typeDef*
    ;

typeDefListOfType
    : typeDef+ '-' type
    ;

typeDef
    : NAME
    ;

primitiveType
    : NAME
    //| 'object' // TODO: Remove this to ensure objects are picked up by the NAME rule.
    ;

eitherType
    : '(' 'either' primitiveType+ ')'
    ;

type
    : eitherType
    | primitiveType
    ;

constantsDef
    : '(' ':constants' constantDefList ')'
    ;

predicatesDef
    : '(' ':predicates' predicateDef+ ')'
    ;

structureDef
    : actionDef
    ;

constantDefList
    : constantDefListOfNoType
    | {typing}? constantDefListOfType constantDefList
    ;

constantDefListOfNoType
    : constantDef*
    ;

constantDefListOfType
    : constantDef+ '-' type
    ;

constantDef
    : NAME
    ;

predicateDef
    : ungroundPredicate
    ;

ungroundPredicate: '(' predicateName typedVariableList ')';

typedVariableList
    : typedVariableListOfNoType
    | {typing}? typedVariableListOfType typedVariableList
    ;

typedVariableListOfNoType
    :variable*
    ;

typedVariableListOfType
    : variable+ '-' type
    ;

predicateName: NAME;

actionDef
    : '(' ':action' actionSymbol
        actionParams
        actionDefBody ')'
    ;

actionSymbol: NAME;

actionParams
    : ':parameters' '(' typedVariableList ')'
    ;

actionDefBody
    : actionPrecondition? actionEffect?
    ;

actionPrecondition
    : (':precondition' (('(' ')') | preconditionGoalDescription))
    ;

actionEffect
    : (':effect' (('(' ')') | effect))
    ;

preconditionGoalDescription
    : preferencesGoalDescription
    | preconditionGoalDescriptionAnd
    | {universalPreconditions}? '(' 'forall' '(' variable ')' preconditionGoalDescription ')'
    ;

preconditionGoalDescriptionAnd
    : '(' 'and' preconditionGoalDescription* ')'
    ;

preferencesGoalDescription
    : //:preferences (preference [<pref-name>] <GD>)
    // |
     goalDescription
    ;

goalDescription
    : atomicFormulaTerm
    | {negativePreconditions}? literalTerm
    | goalDescriptionAnd
//<GD> ::= :disjunctive−preconditions (or <GD>*)
//<GD> ::= :disjunctive−preconditions (not <GD>)
//<GD> ::= :disjunctive−preconditions (imply <GD> <GD>)
//<GD> ::= :existential−preconditions (exists (<typed list(variable)>) <GD> )
    | {universalPreconditions}? '(' 'forall' '(' typedVariableList ')' goalDescription ')'
//<GD> ::= :numeric-fluents <f-comp>
    ;

goalDescriptionAnd
    : '(' 'and' goalDescription* ')'
    ;

effect
    : cEffectAnd
    | cEffect
    ;

cEffectAnd
    : '(' 'and' cEffect* ')'
    ;

cEffect
    : {conditionalEffects}? forAllEffect
    | {conditionalEffects}? whenEffect
    | pEffect
    ;

forAllEffect
    : '(' 'forall' '(' typedVariableList ')' effect ')'
    ;

whenEffect
    : '(' 'when' goalDescription condEffect ')'
    ;

pEffect
    : negatedAtomicFormulaTerm
    | atomicFormulaTerm
    //<p-effect> ::=:numeric-fluents (<assign-op> <f-head> <f-exp>)
    //<p-effect> ::=:object-fluents (assign <function-term> <term>)
    //<p-effect> ::=:object-fluents (assign <function-term> undefined)
    ;

condEffect
    : condEffectAnd
    | pEffect
    ;

condEffectAnd
    : '(' 'and' pEffect* ')'
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
    | ':typing' {typing = true;} // Allow type names in declarations of variables
    | ':negative-preconditions' {negativePreconditions = true;} // Allow not in goal descriptions
//    | ':disjunctive-preconditions' // Allow or in goal descriptions
    | ':equality' {equality = true;} // Support = as built-in predicate
//    | ':existential-preconditions' // Allow exists in goal descriptions
    | ':universal-preconditions' {universalPreconditions = true;} // Allow forall in goal descriptions
//    | ':quantified-preconditions' = :existential-preconditions
//+ :universal-preconditions
    | ':conditional-effects' {conditionalEffects = true;} // Allow when in action effects
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
