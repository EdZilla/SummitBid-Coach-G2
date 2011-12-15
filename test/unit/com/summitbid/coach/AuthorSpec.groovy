package com.summitbid.coach

import spock.lang.*
import grails.plugin.spock.*

/**
 * 
 * @author eyoung2297k
 * NOTE: This originally extended grails.plugin.spock.UnitSpec, but it errored out
 * because the mockDomain defined in the testing mixin clashed with the spock plugin UnitSpec.
 * According to LD the way to best handle it is to extend spock.lang.Specification.
 *
 * CASE 1: extend spock.lang.Specification. and run with grails test-app :spock
 * the following doesn't result in a test failure, but it's an error: 
 *  Error 2011-12-14 17:18:00,290 [Thread-17] ERROR plugins.DefaultGrailsPlugin  - 
 *  Error configuration scaffolding: Error creating bean with name 'scaffoldedActionMap': Singleton bean creation not allowed while the singletons of this factory are in destruction (Do not request a bean from a BeanFactory in a destroy method implementation!)
 *  Message: Error creating bean with name 'scaffoldedActionMap': Singleton bean creation not allowed while the singletons of this factory are in destruction (Do not request a bean from a BeanFactory in a destroy method implementation!)
 *  
 *  CASE 2: extend spock.lang.Specification. and run with grails test-app :spock
 *  Thi time it fails with: 
 *  No signature of method: com.summitbid.coach.AuthorSpec.mockDomain() is applicable for argument types: (java.lang.Class) values: [class com.summitbid.coach.Author]
 * 
 * CASE 3: extend grails.plugin.spock.UnitSpec. and run with grails test-app :spock
 * Tests pass on laptop, passes on build server.
 * 
 * CASE 4: extend grails.plugin.spock.UnitSpec. and run with grails test-app -unit 
 * fails with 
 * Error Compilation error compiling [unit] tests: startup failed:
 * /Users/eyoung2297k/development/src/SummitBid-Coach-G2/test/unit/com/summitbid/coach/AuthorSpec.groovy: -1: The return type of java.lang.Object mockDomain(java.lang.Class, java.util.List) in com.summitbid.coach.AuthorSpec is incompatible with void mockDomain(java.lang.Class, java.util.List) in grails.plugin.spock.UnitSpec
 * . At [-1:-1]  @ line -1, column -1.
 * 1 error
 * 
 * CASE 5: extend spock.lang.Specification and run with grails test-app -unit 
 * Tests pass
 * 
 * 
 */
class AuthorSpec extends spock.lang.Specification {
//class AuthorSpec extends grails.plugin.spock.UnitSpec {

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
