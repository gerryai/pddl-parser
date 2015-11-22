grammar PDDL31Requirements;
import PDDL31Core;

@parser::members {
    private boolean enforceRequirements = true;
    private Set<Requirement> requirementsDeclared = new HashSet<Requirement>();
    private Set<Requirement> requirementsNeeded = new HashSet<Requirement>();

    private boolean isAllowed(Requirement requirement) {
        return requirementsDeclared.contains(requirement) || !enforceRequirements;
    }

    private void needed(Requirement requirement) {
        requirementsNeeded.add(requirement);
    }

    public Set<Requirement> getRequirementsNeeded() {
        return requirementsNeeded;
    }

    public boolean getEnforceRequirments() {
        return enforceRequirements;
    }

    public void setEnforceRequirments(boolean enforceRequirements) {
        this.enforceRequirements = enforceRequirements;
    }
}

requireKey
    : ':strips'   // Basic STRIPS-style adds and deletes
    | ':typing' {requirementsDeclared.add(Requirement.TYPING);} // Allow type names in declarations of variables
    | ':negative-preconditions' {requirementsDeclared.add(Requirement.NEGATIVE_PRECONDITIONS);} // Allow not in goal descriptions
//    | ':disjunctive-preconditions' // Allow or in goal descriptions
    | ':equality' {requirementsDeclared.add(Requirement.EQUALITY);} // Support = as built-in predicate
//    | ':existential-preconditions' // Allow exists in goal descriptions
    | ':universal-preconditions' {requirementsDeclared.add(Requirement.UNIVERSAL_PRECONDITIONS);} // Allow forall in goal descriptions
//    | ':quantified-preconditions' = :existential-preconditions
//+ :universal-preconditions
    | ':conditional-effects' {requirementsDeclared.add(Requirement.CONDITIONAL_EFFECTS);} // Allow when in action effects
//    | ':fluents' = :numeric-fluents
//+ :object-fluents
    | ':numeric-fluents' {requirementsDeclared.add(Requirement.NUMERIC_FLUENTS);} // Allow numeric function definitions and use of effects using assignment operators and arithmetic preconditions.
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
    | ':action-costs' {requirementsDeclared.add(Requirement.ACTION_COSTS);}
    ;
