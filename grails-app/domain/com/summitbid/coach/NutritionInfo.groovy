package com.summitbid.coach

class NutritionInfo {
	Food food
	static belongsTo = Food;
	
	Integer calories
	Integer fat
	Integer weight // in grams or oz

    static constraints = {
		calories(nullable:true)
		fat(nullable:true)
		weight(nullable:true)
    }
}
