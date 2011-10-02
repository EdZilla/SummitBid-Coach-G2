package com.summitbid.coach

class NutritionData {
	Food food
	String description = "description"
	Integer servingSize
	Integer calories
	Float gramsFat
	Float carbs
	Float protein 
	
	static belongsTo = [ food:Food ]
	
	
    static constraints = {
		food(nullable:false)
		description(nullable:false)
		servingSize(nullable:true)
		calories(nullable:true)
		gramsFat(nullable:true)
		carbs(nullable:true)
		protein(nullable:true)
		food(nullable:false)
    }
	
	String toString() {
		return "nutritionData: calories: ${calories}, gramsFat: ${gramsFat}, carbs: ${carbs}, protein: ${protein}"
	}
}
