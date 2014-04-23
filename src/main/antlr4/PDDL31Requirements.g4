grammar PDDL31Requirements;
import PDDL31Core;

@parser::members {
    public boolean equality = false;
    public boolean typing = false;
    public boolean negativePreconditions = false;
    public boolean universalPreconditions = false;
    public boolean conditionalEffects = false;
}

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
