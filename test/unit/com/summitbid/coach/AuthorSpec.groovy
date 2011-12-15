package com.summitbid.coach

import spock.lang.*
import grails.plugin.spock.*

/**
 * 
 * @author eyoung2297k
 * NOTE: This originally extended grails.plugin.spock.UnitSpec, but it errored out
 * because the mockDomain defined in the testing mixin clashed with the spock plugin UnitSpec.
 * According to LD the way to best handle it is to extend spock.lang.Specification.
 */
//class AuthorSpec extends spock.lang.Specification {
class AuthorSpec extends grails.plugin.spock.UnitSpec {

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
