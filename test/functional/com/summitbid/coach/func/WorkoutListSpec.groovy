package com.summitbid.coach.func;

import geb.spock.GebReportingSpec
import geb.spock.GebSpec
import geb.Browser

import spock.lang.*

//import pages.*
import com.summitbid.coach.func.pages.WorkoutListPage

@Stepwise
/**
 * 
 * @author eyoung2297k
 *
 */
class WorkoutListSpec extends GebSpec {

	
	/**
	 * Assumes there are exercises
	 * @return
	 */
	def "List all Foods"() {
		//println "List all exercises"
		when:
		def browser = new Browser()
		//browser.setBaseUrl( "http://localhost:8080/coach/" )
		
		println "when go to WorkoutListPage"
		//browser.to FoodListPage
		to WorkoutListPage
		
		then: 
		print "then "
		println "at WorkoutListPage"
		//browser.at FoodListPage
		at WorkoutListPage
	}
}