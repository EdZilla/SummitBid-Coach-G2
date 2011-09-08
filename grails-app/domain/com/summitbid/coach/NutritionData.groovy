package com.summitbid.coach

class NutritionData {
	Food food
	String description = "description"
	Integer calories
	Integer gramsFat
	
    static constraints = {
		calories(nullable:true)
		gramsFat(nullable:true)
		food(nullable:true)
    }
}
