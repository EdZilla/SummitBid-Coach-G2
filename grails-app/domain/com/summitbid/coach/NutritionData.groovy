package com.summitbid.coach

class NutritionData {
	Food food
	String description = "description"
	Integer calories
	Integer gramsFat
	
    static constraints = {
		food(nullable:false)
		description(nullable:false)
		calories(nullable:true)
		gramsFat(nullable:true)
		food(nullable:false)
    }
	
	String toString() {
		return "nutritionData: food: ${food}"
	}
}
