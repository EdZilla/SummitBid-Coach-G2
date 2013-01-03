package com.summitbid.coach

import org.springframework.dao.DataIntegrityViolationException

class MealController {
	static navigation = true
   static scaffold = true
   
   def showTime(){
	   render "The time is: ${new Date()}"
   }
   
   
}
