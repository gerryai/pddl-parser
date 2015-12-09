(define (domain tasks)
  (:requirements :strips :typing :numeric-fluents :action-costs)
  (:types person task skill)
  (:constants
    expert experient practitioner - skill)
  (:functions
    (requires_reward ?p - person) - number
    (total-cost) - number)

  (:predicates
    (is_open ?t - task)
    (is_done ?t - task)
    (is_available ?p - person)
    (assigned ?t - task ?p - person)
    (requires_skill ?t - task ?s - skill)
    (has_skill ?p - person ?s - skill)
    (matches ?p - person ?t - task))

  (:action find
    :parameters(?p ?t ?s)
    :precondition
      (and (is_open ?t) (is_available ?p) (requires_skill ?t ?s) (has_skill ?p ?s))
    :effect  
      (matches ?p ?t)
  )

  (:action allocate
    :parameters (?p ?t)
    :precondition 
      (matches ?p ?t)
    :effect  
      (and (not (is_open ?t)) (not (is_available ?p)) (assigned ?t ?p))
  )

  (:action resolve
    :parameters (?p ?t)
    :precondition
      (assigned ?t ?p)
    :effect
      (and (is_done ?t) (is_available ?p) (increase (total-cost)(requires_reward ?p)))
  )
)
