package com.summitbid.coach
import grails.converters.*
import org.springframework.dao.DataIntegrityViolationException

class FoodController {
	static scaffold = true
	static navigation = true

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
		
		switch(request.method){
			case "POST":
			  println "Create\n"
			  break
			case "GET":
			  println "Retrieve\n"
			  break
			case "PUT":
			  println "Update\n"
			  break
			case "DELETE":
			  println "Delete\n"
			  break
		  }
		
		redirect(action: "list", params: params)
    }

    def list() {
		log.trace "Executing action: '$actionName' "
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [foodInstanceList: Food.list(params), foodInstanceTotal: Food.count()]
    }
	
	def listRest() {
		log.trace "Executing action: '$actionName' "
		println Food.list()
		def all = Food.list()
		render all as JSON
	}

    def create() {
		log.trace "Executing action: '$actionName'"
        [foodInstance: new Food(params)]
    }

    def save() {
		log.trace "Executing action: '$actionName' "
        def foodInstance = new Food(params)
		// add a nutrition data automatically
		foodInstance.nutritionData = new NutritionData(description:foodInstance.name,food:foodInstance);
		foodInstance.nutritionData.save()
		
        if (!foodInstance.save(flush: true)) {
            render(view: "create", model: [foodInstance: foodInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'food.label', default: 'Food'), foodInstance.id])
        redirect(action: "show", id: foodInstance.id)
    }

    def show() {
		log.trace "Executing action: '$actionName'"
        def foodInstance = Food.get(params.id)
		
        if (!foodInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'food.label', default: 'Food'), params.id])
            redirect(action: "list")
            return
        }

        [foodInstance: foodInstance]
    }
	
	def showRest() {
		log.trace "Executing action: '$actionName'"
		def foodInstance = Food.get(params.id)
		println foodInstance as JSON
		render foodInstance as JSON
	}
	
	def postRest() {
		log.trace "Executing action: '$actionName', params: '$params', request: '$request.method'"
		switch(request.method){
			case "POST":
//			  def airport = Food.foodFactory(params.name, null)
//			  if(airport.save()){
//				response.status = 201 // Created
//				render airport as XML
//			  }
//			  else{
//				response.status = 500 //Internal Server Error
//				render "Could not create new Airport due to errors:\n ${airport.errors}"
//			  }
			println Food.list()
			def all = Food.list()
			render all as JSON
			  break
		  }
	}

    def edit() {
        def foodInstance = Food.get(params.id)
        if (!foodInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'food.label', default: 'Food'), params.id])
            redirect(action: "list")
            return
        }

        [foodInstance: foodInstance]
    }

    def update() {
        def foodInstance = Food.get(params.id)
        if (!foodInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'food.label', default: 'Food'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (foodInstance.version > version) {
                foodInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'food.label', default: 'Food')] as Object[],
                          "Another user has updated this Food while you were editing")
                render(view: "edit", model: [foodInstance: foodInstance])
                return
            }
        }

        foodInstance.properties = params

        if (!foodInstance.save(flush: true)) {
            render(view: "edit", model: [foodInstance: foodInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'food.label', default: 'Food'), foodInstance.id])
        redirect(action: "show", id: foodInstance.id)
    }

    def delete() {
        def foodInstance = Food.get(params.id)
        if (!foodInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'food.label', default: 'Food'), params.id])
            redirect(action: "list")
            return
        }

        try {
            foodInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'food.label', default: 'Food'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'food.label', default: 'Food'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
