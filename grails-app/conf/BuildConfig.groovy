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
	

	def spockVersion = "0.7"
	//def gebVersion = "0.9.0-RC-1"
	def gebVersion = "0.9.2"
	def seleniumVersion = "2.26.0"

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
		
		// According to Marcin Erdmann, geb release candidate versions are only available from sonatype snapshot repo
		mavenRepo "https://oss.sonatype.org/content/repositories/snapshots/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        runtime 'mysql:mysql-connector-java:5.1.16'
		// apparently required by RESTClient. Not sure we need rest client. 
		// Maybe we should use rest-client-builder?
		test "org.codehaus.groovy.modules.http-builder:http-builder:0.6"

		test "org.gebish:geb-spock:$gebVersion"
		
		test "org.gebish:geb-junit4:$gebVersion"
		test "org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion"
		test "org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion"
    }

    plugins {
        //compile ":hibernate:$grailsVersion"
		runtime ":hibernate:$grailsVersion"
        build ":tomcat:$grailsVersion"

		runtime ":jquery:1.8.3"
		runtime ":resources:1.1.6"
		compile ":jquery-ui:1.8.24"
		compile ":spock:$spockVersion"
		compile ":geb:$gebVersion"
		compile ":database-migration:1.2.2"
		compile ":easyb:2.0.5"
		
		compile ":fixtures:1.2"
		compile ":build-test-data:2.0.3"
		
		compile ":shiro:1.1.4"
		compile ":navigation:1.3.2"
		
		//compile ":cloud-foundry:1.2.3"
		//compile ':cloud-foundry-ui:1.1'
		compile ":google-visualization:0.6"
		
		// experimental
		//runtime 'com.datomic:datomic-free:0.8.3551'
		
		// compile ":mongodb:1.3.0"
    }
}
