package com.summitbid.coach.func;

import geb.spock.GebReportingSpec
import geb.spock.GebSpec
import geb.Browser

import spock.lang.*

//import pages.*
import com.summitbid.coach.func.pages.MealListPage

@Stepwise
/**
 * 
 * @author eyoung2297k
 *
 */
class MealListSpec extends GebSpec {

	
	/**
	 * Assumes there are exercises
	 * @return
	 */
	def "List all Foods"() {
		//println "List all exercises"
		when:
		def browser = new Browser()
		//browser.setBaseUrl( "http://localhost:8080/coach/" )
		
		println "when go to MealListPage"

		to MealListPage
		
		then: 
		print "then "
		println "at MealListPage"

		at MealListPage
	}
}