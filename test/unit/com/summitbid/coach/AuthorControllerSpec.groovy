package com.summitbid.coach

import spock.lang.*
import grails.plugin.spock.*

class AuthorControllerSpec extends ControllerSpec {

    def "text action"() {
		when: 
		controller.text()
		
		then: 
		mockResponse.contentAsString == "text"
    }
	
	def 'some redirect action'() { 
		when: 
		controller.someRedirect()
		
		then: 
		redirectArgs == [action: "someRedirect"] 
	}
		
	def 'bodyElementText action'() { 
		when: 
		xmlRequestContent = requestContent
		
		and: 
		controller.bodyElementText()
		
		then: 
		mockResponse.contentAsString == value
		
		where: 
		value << ['value', 'value'] 
		requestContent << ["<request><body>value</body></request>", { request { body('value') } }] 
	}
		
	def 'model action'() { 
		expect: 
		controller.model() == [a: '1'] 
	}
		
}
