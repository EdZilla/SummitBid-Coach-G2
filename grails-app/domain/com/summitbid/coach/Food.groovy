package com.summitbid.coach

class Food {

	String name
	String description
	NutritionData nutritionData
	
	
    static constraints = {
		name(nullable:false)
		description(nullable:true)
		nutritionData(nullable:true)
    }
	
	String toString()
	{
		return "food: ${name}, ${description}"
	}
}
