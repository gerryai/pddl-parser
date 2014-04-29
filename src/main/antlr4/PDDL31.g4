grammar PDDL31;
import PDDL31Logic;

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
    : {isAllowed(Requirement.TYPING)}? '(' ':types' typeDefList ')' {needed(Requirement.TYPING);}
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
    | {isAllowed(Requirement.TYPING)}? constantDefListOfType constantDefList {needed(Requirement.TYPING);}
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
    | {isAllowed(Requirement.TYPING)}? typedVariableListOfType typedVariableList {needed(Requirement.TYPING);}
    ;

typedVariableListOfNoType
    :variable*
    ;

typedVariableListOfType
    : variable+ '-' type
    ;

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
    | {isAllowed(Requirement.UNIVERSAL_PRECONDITIONS)}? '(' 'forall' '(' variable ')' preconditionGoalDescription ')' {needed(Requirement.UNIVERSAL_PRECONDITIONS);}
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
    | {isAllowed(Requirement.NEGATIVE_PRECONDITIONS)}? literalTerm {needed(Requirement.NEGATIVE_PRECONDITIONS);}
    | goalDescriptionAnd
//<GD> ::= :disjunctive−preconditions (or <GD>*)
//<GD> ::= :disjunctive−preconditions (not <GD>)
//<GD> ::= :disjunctive−preconditions (imply <GD> <GD>)
//<GD> ::= :existential−preconditions (exists (<typed list(variable)>) <GD> )
    | {isAllowed(Requirement.UNIVERSAL_PRECONDITIONS)}? '(' 'forall' '(' typedVariableList ')' goalDescription ')' {needed(Requirement.UNIVERSAL_PRECONDITIONS);}
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
    : {isAllowed(Requirement.CONDITIONAL_EFFECTS)}? forAllEffect {needed(Requirement.CONDITIONAL_EFFECTS);}
    | {isAllowed(Requirement.CONDITIONAL_EFFECTS)}? whenEffect {needed(Requirement.CONDITIONAL_EFFECTS);}
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


// PROBLEM

problem
    : '(' 'define' problemName
    problemDomain
    requireDef?
    objectDeclaration?
    init
    goal
    //[<constraints>]:constraints
    //[<metric-spec>]:numeric-fluents
    //[<length-spec>]
    ')'
    ;

problemName
    : '(' 'problem' NAME ')'
    ;

problemDomain
    : '(' ':domain' NAME ')'
    ;

objectDeclaration
    : '(' ':objects' objectDecList ')'
    ;

init
    : '(' ':init' initEl* ')'
    ;

initEl
    : literalConstant
//<init-el> ::=:timed−initial−literals (at <number> <literal(name)>)
//<init-el> ::=:numeric-fluents (= <basic-function-term> <number>)
//<init-el> ::=:object-fluents (= <basic-function-term> <name>)
//<basic-function-term> ::= <function-symbol>
//<basic-function-term> ::= (<function-symbol> <name>*)
    ;

goal
    : '(' ':goal' preconditionGoalDescription ')'
    ;

objectDecList
    : objectDecListOfNoType
    | {isAllowed(Requirement.TYPING)}? objectDecListOfType objectDecList {needed(Requirement.TYPING);}
    ;

objectDecListOfNoType
    : objectDec*
    ;

objectDecListOfType
    : objectDec+ '-' type
    ;

objectDec
    : NAME
    ;
