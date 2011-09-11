package com.summitbid.coach



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainUnitTestMixin} for usage instructions
 */
@TestFor(Food)
class FoodTests {
	
	

    void testConstraints() {
		println "testConstraints enter"
		
		def existingFood = new Food(name:"pizza", description: "good", nutritionData:new NutritionData())
		
		assert existingFood.validate()
		mockForConstraintsTests(NutritionData, [existingFood.nutritionData])
		existingFood.nutritionData.food = existingFood
		assert existingFood.nutritionData
		assert existingFood.nutritionData.validate()
		
		println existingFood
		println existingFood.nutritionData
		
		println "testConstraints exit"
		
    }
	
	void testConstraintsFood() {
		def food = new Food()
		assert !food.validate()
		println "ERRORS: " + food.errors["name"] + " : END"
		//now show which of the constraints was violated
		assert null != food.errors["name"]
		assert null != food.errors["nutritionData"]
		
	}
	
	void testConstraintsFoodNoNutritionData() {
		def existingFood = new Food(name:"pizza", description: "good")
		assert existingFood
		assert !existingFood.validate()
		
	}
	
	void testConstraintsNutritionDataNoFood() {
		def existingFoodNutritionData = new NutritionData()
		mockForConstraintsTests(NutritionData, [existingFoodNutritionData])
		assert existingFoodNutritionData
		assert !existingFoodNutritionData.validate()
		
		//println existingFoodNutritionData
		
	}
}
