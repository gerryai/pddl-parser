(define (domain fail)
(:requirements :strips :negative-preconditions)
(:predicates (testing ?x))

(:action test
  :parameters  (?x ?y)
  :precondition (not (= ?x ?y))
  :effect (testing ?x)))
