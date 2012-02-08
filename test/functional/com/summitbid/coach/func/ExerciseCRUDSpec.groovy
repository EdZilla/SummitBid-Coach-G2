package com.summitbid.coach.func;

import geb.spock.GebReportingSpec
import geb.spock.GebSpec

import spock.lang.*

import pages.*

//@Stepwise
class ExerciseCRUDSpec extends GebSpec {

def "there are no Exercises"() {
	when:
	println "no exercises have been loaded yet"
	then: 
	println "the list will be empty"

}


}