(define (domain test)
(:requirements :strips)
(:predicates (testing ?x))

(:action test
  :parameters  (?x)
  :precondition (testing ?x)
  :effect ()))
