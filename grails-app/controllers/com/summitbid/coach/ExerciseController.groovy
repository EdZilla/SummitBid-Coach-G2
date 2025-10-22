package com.summitbid.coach

import org.springframework.dao.DataIntegrityViolationException

class ExerciseController {
	static navigation = true
	
    static scaffold = true

	def index() {
		redirect(action: 'list', params: params)
	}

	def list() {
		log.trace "Executing action: '$actionName' "
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[exerciseInstanceList: Exercise.list(params), exerciseInstanceTotal: Exercise.count()]
	}
	
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
