
(define (problem tasksProblemA)
	(:domain tasks)
	(:objects 
        Mark Toby Luke Phil - person
        TaskA TaskB TaskC - task) 
	(:init 
        (is_open TaskA)
        (is_open TaskB)
        (is_open TaskC)
        (is_available Mark)
        (is_available Toby)
        (is_available Luke)
        (is_available Phil)       
        (requires_skill TaskA expert)
        (requires_skill TaskB experient)
        (requires_skill TaskC practitioner)
        (has_skill Mark expert)
        (has_skill Toby experient)
        (has_skill Luke practitioner) 
        (has_skill Phil expert) 
        (= (requires_reward Mark) 50)
        (= (requires_reward Toby) 60)
        (= (requires_reward Luke) 70)
        (= (requires_reward Phil) 170)
        (= (total-cost) 0))
	(:goal 	
        (forall (?t - task) (is_done ?t)))

  (:metric minimize (total-cost))
)
