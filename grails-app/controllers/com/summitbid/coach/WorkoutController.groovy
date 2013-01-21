package com.summitbid.coach

import org.springframework.dao.DataIntegrityViolationException

class WorkoutController {
	
	static navigation = true
	
    static scaffold = true
	
	def list() {
		log.trace "Executing action: '$actionName' "
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[workoutInstanceList: Workout.list(params), workoutInstanceTotal: Workout.count()]
	}
	
	def show = {
		log.trace("Executing action $actionName with params $params")
		def workoutInstance = Workout.get( params.id )
		log.debug"workout found : ${workoutInstance}"
		session.currentWorkout = workoutInstance;
		
		if(!workoutInstance) {
			flash.message = "Workout not found with id ${params.id}"
			redirect(action:list)
		}		
		else {
			log.debug"workout: ${workoutInstance}"
			return [ workoutInstance : workoutInstance ] 
		}
	}
	
	def edit() {
		log.trace("Executing action $actionName with params $params")
		
		def workoutInstance = Workout.get(params.id)
		
		if (!workoutInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'workout.label', default: 'workout'), params.id])
			redirect(action: "list")
			return
		}
		log.debug"workout: ${workoutInstance}"
		[workoutInstance: workoutInstance]
	}

	
	/**
	 * Not yet working. updated workout will not persist
	 */
	def addActivityTo = {
		log.trace("Executing action $actionName with params $params")
		log.trace("session: $session")
		log.trace("flash: $flash")
//		def exerciseRef;
		def workout = session.currentWorkout;
		def exercise = flash.activity;
//			
		if (workout && exercise)
		{
			log.debug("adding new exercise to workout");
			workout.addToExercises(exercise)
			log.debug("added new exercise to workout");
//			
//			// TODO: force errors somehow
			log.debug("about to save workout ${workout.id}...");
			if (!workout.hasErrors() && workout.save())
			{
				log.trace("workout: " + workout);
				flash.message = "Added exercise ${exercise.name} to workout ${workout.name}"
				redirect(action:show, id:workout.id)
			}
			else
			{
//				//flash.message = "ERROR: could not add request to AteRequestSequence ${Workout.name}, with id: ${Workout.id}: ERROR: ${Workout.errors.each { it }}"
				flash.message = "ERROR: could not add exercise to workout ${workout.name}, with id: ${workout.id}"
				log.trace("errors: " + workout.errors.each {it} )
				redirect(action:show, id:workout.id)
			}
		}
		else
		{
			flash.message = "ERROR: no current workout"
			redirect(action:list)
		}
	}
}
