grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.war.file = "target/coach.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
	
	def gebVersion = "0.6.1"
	def seleniumVersion = "2.0rc3"

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // uncomment these to enable remote dependency resolution from public Maven repositories
        mavenCentral()
        //mavenLocal()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        runtime 'mysql:mysql-connector-java:5.1.16'
		test "org.codehaus.groovy.modules.http-builder:http-builder:0.5.1"		
		test "org.codehaus.geb:geb-spock:$gebVersion"
		
		test "org.codehaus.geb:geb-junit4:0.6.1"
		test 'org.seleniumhq.selenium:selenium-firefox-driver:2.0rc3'
		test 'org.seleniumhq.selenium:selenium-chrome-driver:2.0rc3'
		test 'org.seleniumhq.selenium:selenium-htmlunit-driver:2.0rc3'		
		
    }

    plugins {
        compile ":hibernate:$grailsVersion"
        compile ":jquery:1.6.1.1"
        compile ":resources:1.0.2"

        build ":tomcat:$grailsVersion"
		
		test ":spock:0.6-SNAPSHOT"
		//test ":spock:0.5-groovy-1.8"
		test ":geb:$gebVersion"
		
		
    }
}
