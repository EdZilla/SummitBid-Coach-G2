package com.summitbid.coach

import static org.junit.Assert.*
import org.junit.*

class MealTests {
	
	def fixtureLoader
	
    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testSomething() {
		def burger = Food.foodFactory("cheesburger", "greasy")
		def fries = Food.foodFactory("fries", "greasy")
		def omelet = Food.foodFactory("omelet", "yummy")
		
		def fixture = fixtureLoader.load {
			assert burger.validate()
			assert fries.validate()
			assert omelet.validate()
			breakfast(Meal, name:"sunday breakfast", date: new Date(), foods: [omelet] )
			dinner(Meal, name: "greasy burger", date: new Date(), foods: [burger, fries] )
		}
		
		assert burger in fixture.dinner.foods 
		println "dinner: ${fixture.dinner.name}, ${fixture.dinner.foods}"
    }
}
