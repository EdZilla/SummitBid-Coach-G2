package com.summitbid.coach

import spock.lang.*
import grails.plugin.spock.*

class AuthorSpec extends UnitSpec {

    def "feature method"() {
		setup: 
		mockDomain(Author)
		
		when: 
		println "Howdy Spock!"
		new Author(name: name).save()
		
		then: 
		Author.findByName("Ed") != null
		
		where: 
		name = "Ed"

    }
}
