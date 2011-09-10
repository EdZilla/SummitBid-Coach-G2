package com.summitbid.coach

class Food {

	String name
	String description
	NutritionData nutritionData
	
	
    static constraints = {
		
		name blank: false, unique: true
		description blank: true
		nutritionData nullable:false
    }
	
	String toString()
	{
		return "food: ${name}, ${description}"
	}
}
