package com.summitbid.coach



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainUnitTestMixin} for usage instructions
 */
@TestFor(Food)
class FoodUnitTests {
	
	

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
		println "testConstraintsFood enter"
		println "This will test that the food requires a name field that is missing"
		def food = new Food()
		assert !food.validate()
		println "ERRORS START : " + food.errors["name"] + " : ERRORS END"
		//now show which of the constraints was violated
		// The assertions below show that both the name and nutritionData fields were not set
		assert null != food.errors["name"]
		assert null != food.errors["nutritionData"]
		println "testConstraintsFood exit"
	}
	
	void testConstraintsFoodNoNutritionData() {
		println "testConstraintsFoodNutritionData enter"
		def existingFood = new Food(name:"pizza", description: "good")
		assert existingFood
		assert !existingFood.validate()
		println "testConstraintsFoodNutritionData exit"
	}
	
	void testConstraintsNutritionDataNoFood() {
		println "testConstraintsNutritionNoFood enter"
		def existingFoodNutritionData = new NutritionData()
		mockForConstraintsTests(NutritionData, [existingFoodNutritionData])
		assert existingFoodNutritionData
		assert !existingFoodNutritionData.validate()
		
		println "testConstraintsNutritionNoFood exit"
	}
}
