package com.summitbid.coach

import org.springframework.dao.DataIntegrityViolationException

class MealController {
	static navigation = true
   static scaffold = true
   
   def showTime(){
	   render "The time is: ${new Date()}"
   }
   
   def show() {
	   log.trace "Executing action: '$actionName'"
	   def mealInstance = Meal.get(params.id)
	   session.currentMeal = mealInstance
	   
	   if (!mealInstance) {
		   flash.message = message(code: 'default.not.found.message', args: [message(code: 'meal.label', default: 'Meal'), params.id])
		   redirect(action: "list")
		   return
	   }

	   [mealInstance: mealInstance]	   
   }
   
   /**
	* Not yet working. updated meal will not persist
	*/
   def addFoodTo() {
	   log.trace("Executing action $actionName with params $params")
	   log.trace("session: $session")
	   log.trace("flash: $flash")
	   def newFood
	   def currentMeal = session.currentMeal;
	   def currentFood = flash.currentFood;
//		   
	   if (currentMeal && currentFood)
	   {
		   log.debug" Got both meal and food"
		   log.debug" current meal is: ${currentMeal}"
		   log.debug" current food is: ${currentFood}"
		   
		   currentMeal.addToFoods(currentFood)
		   
		   log.debug("adding new food to meal");

		   log.debug("added new food to meal: ${currentMeal.foods}");
//		   
//		   // TODO: force errors somehow
//		   log.debug("about to save meal ${meal.id}...");
		   if (!currentMeal.hasErrors() && currentMeal.save())
		   {
//			   log.trace("meal: " + meal);
			   flash.message = "Added food ${currentFood.name} to meal ${currentMeal.name}"
			   //redirect(action:show, id:currentMeal.id)
		   }
		   else
		   {
			   //flash.message = "ERROR: could not add request to AteRequestSequence ${meal.name}, with id: ${meal.id}: ERROR: ${meal.errors.each { it }}"
			   flash.message = "ERROR: could not add food to meal ${currentMeal.name}, with id: ${currentMeal.id}"
			   log.trace("errors: " + currentMeal.errors.each {it} )
			   redirect(action:show, id:currentMeal.id)
		   }
		   redirect(action:show, id:currentMeal.id)
		   //redirect( action:list )
	   }
	   else
	   {
		   log.debug "no current meal, or no current food"
		   if(currentFood)
		   		log.debug "food: ${currentFood}"
	   	   if(currentMeal)
			 log.debug "meal: ${currentMeal}"
		   flash.message = "ERROR: no current Meal, or current food"
		   redirect(action:list)
	   }
   }
   
}
