package com.summitbid.coach

class Food {

	String name
	String description
	NutritionData nutritionData
	
	
    static constraints = {
		name(nullable:false)
		description(nullable:true)
		//nutritionData(nullable:false)
    }
	
	String toString()
	{
		return "food: ${name}, ${description}"
	}
}
