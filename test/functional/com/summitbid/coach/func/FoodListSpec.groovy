package com.summitbid.coach.func;

import geb.spock.GebReportingSpec

import spock.lang.*

//import pages.*
import com.summitbid.coach.func.pages.FoodListPage

@Stepwise
class FoodListSpec extends GebReportingSpec {
	
	String getBaseUrl() { "http://localhost:8080/coach/" }

	/**
	 * Assumes there are exercises
	 * @return
	 */
	def "List all Foods"() {
		//println "List all exercises"
		when: 
		println "when go to FoodListPage"
		to FoodListPage
		
		then: 
		print "then "
		println "at FoodListPage"
		at FoodListPage
	}
}