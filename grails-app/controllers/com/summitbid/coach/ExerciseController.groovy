package com.summitbid.coach

import org.springframework.dao.DataIntegrityViolationException

class ExerciseController {
	static navigation = true
	
    static scaffold = true
	
	def show() {
		log.trace "Executing action: '$actionName'"
		def exerciseInstance = Exercise.get(params.id)
		flash.activity = exerciseInstance;
		
		if (!exerciseInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'exercise.label', default: 'Exercise'), params.id])
			redirect(action: "list")
			return
		}
		
		[exerciseInstance: exerciseInstance]
	}
	
}
