(define (domain fail)
(:requirements :strips)
(:predicates (testing ?x))

(:action test
  :parameters  (?x)
  :precondition ()
  :effect (testing ?x)))
