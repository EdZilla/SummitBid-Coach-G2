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
	
	//def gebVersion = "0.6.1"
	def gebVersion = "0.6.3"
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
		
		test "org.codehaus.geb:geb-junit4:0.6.3"
		test 'org.seleniumhq.selenium:selenium-firefox-driver:2.0rc3'
		test 'org.seleniumhq.selenium:selenium-chrome-driver:2.0rc3'
		//test 'org.seleniumhq.selenium:selenium-htmlunit-driver:2.0rc3'		
		
    }

    plugins {
        compile ":hibernate:$grailsVersion"
        build ":tomcat:$grailsVersion"

		compile ":svn:1.0.2"  // do I need this? 
		
		runtime ":jquery:1.7.1"
		runtime ":resources:1.1.6"
		compile ":spock:0.6"
		//test ":spock:0.5-groovy-1.8"
		compile ":geb:$gebVersion"
		compile ":database-migration:1.0"
		compile ":code-coverage:1.2.5"
		compile ":easyb:2.0.5"
		compile ":fixtures:1.1"
		compile ":shiro:1.1.3"
		compile ":navigation:1.3.2"
		compile ":jquery-ui:1.8.15"
		
    }
}
