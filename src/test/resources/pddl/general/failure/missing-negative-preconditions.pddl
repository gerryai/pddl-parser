(define (domain fail)
(:requirements :strips)
(:predicates (testing ?x))

(:action test
  :parameters  (?x)
  :precondition (not (testing ?x))
  :effect (testing ?x)))
