package com.summitbid.coach

import org.springframework.dao.DataIntegrityViolationException

class FoodController {
	static scaffold = true
	static navigation = true

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
		log.trace "Executing action: '$actionName' "
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [foodInstanceList: Food.list(params), foodInstanceTotal: Food.count()]
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
