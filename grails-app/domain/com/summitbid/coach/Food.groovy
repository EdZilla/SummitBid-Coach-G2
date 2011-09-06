package com.summitbid.coach

class Food {

	String name
	String description
	NutritionInfo nutritionInfo
	
    static constraints = {
		name(nullable:false)
		description(nullable:true)
		nutritionInfo(nullable:false)
    }
}
