package com.summitbid.coach.func;

import geb.spock.GebReportingSpec

import spock.lang.*

//import pages.*
import com.summitbid.coach.func.pages.ExerciseListPage

@Stepwise
class ExerciseListSpec extends GebReportingSpec {
	
	String getBaseUrl() { "http://localhost:8080/coach/" }

	/**
	 * Assumes there are exercises
	 * @return
	 */
	def "List all Exercises"() {
		//println "List all exercises"
		when: 
		println "when go to ExerciseListPage"
		to ExerciseListPage
		
		then: 
		print "then "
		println "at ExerciseListPage"
		at ExerciseListPage
	}
}