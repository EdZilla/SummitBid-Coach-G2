package com.summitbid.coach

import static org.junit.Assert.*
import org.junit.*

class FoodTests {

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
//		fail "Implement me"
	}

	@Test
	void testFoodFactory() {
		def food = Food.foodFactory("burger", "greasy")
		assert food
		assert food.validate()
	}
}
