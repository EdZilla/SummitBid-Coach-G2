package com.summitbid.coach

class Food {

	String name
	String description
	Float cost;
	NutritionData nutritionData
	
	
    static constraints = {
		name blank: false, unique: true
		description blank: true
		cost(nullable:true)
		nutritionData nullable:false
    }
	
	String toString()
	{
		return "Food: ${name}, ${description}"
	}

	/**
	 * Convenience method to handle chicken/egg nature of food/nutritionData	
	 * @param name
	 * @param description
	 * @return food
	 */
	static def foodFactory( String name, String description ) {
		def food = new Food(name:name, description:description)
		food.nutritionData = new NutritionData(food:food)
		assert food.nutritionData.validate()
		food.nutritionData.save()
		assert food.validate()
		food.save()
		return food
	}
}
