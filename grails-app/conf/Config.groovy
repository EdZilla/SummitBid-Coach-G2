import org.apache.log4j.ConsoleAppender
import org.apache.log4j.PatternLayout

// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.views.javascript.library="jquery"

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format

// This must be set to true for content negotiation to work
// Set the accept header and the withFormat closure will work
grails.mime.use.accept.header = true
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text/plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']


// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// not yet using this
grails.gorm.default.constraints = {
	myShared(nullable: true)
}

// tomcat plugin JNDI config for localhost development
grails.naming.entries = ['jdbc/coachDBDataSource': [
	type: "javax.sql.DataSource", //required
		auth: "Container", // optional
		description: "Data source for Coach...", //optional
		//properties for particular type of resource
	//url: "jdbc:mysql://chimps-lb-04.cable.comcast.com:3306/chimps?autoReconnect=true",
	url: "jdbc:mysql://localhost:3306/coach?autoReconnect=true",
	username: "coach",
	password: "coach",
	driverClassName: "com.mysql.jdbc.Driver",
	maxActive: "100", //and so on
	maxIdle: "4"
   ]
]

// set per-environment serverURL stem for creating absolute links
environments {
    development {
		println "Environment is DEVELOPMENT"
        grails.logging.jul.usebridge = true
		
    }
	test {
		println "Environment is TEST"
		//grails.dbconsole.enabled = true
		//grails.logging.jul.usebridge = false
		 
	}
    production {
		println "Environment is PRODUCTION"
		grails.dbconsole.enabled = true
        grails.logging.jul.usebridge = false
        //grails.serverURL = "http://www.changeme.com"
		//grails.serverURL = "http://coach.summitbid.com"		
    }
}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}
	
		def logLayoutPattern = new PatternLayout("%d [%t] %-5p %c %x - %m%n")
		
		appenders {
			//file name: 'file', file: '/opt/data/logs/coachg2/coachg2.log'
			//file name: 'file', file: '/var/lib/tomcat7/logs/coachg2.log'
			//file name: 'file', file: 'coachg2.log'
			//file name: 'stacktrace', file: '/opt/data/logs/coachg2/coachg2stacktrace.log'
			//file name: 'stacktrace', file: '/var/lib/tomcat7/logs/coachg2stacktrace.log'
			//file name: 'stacktrace', file: 'coachg2stacktrace.log'
			new ConsoleAppender(name: "console",
				layout: logLayoutPattern)
		}

		root   {
		   error  'file', 'stdout'
		   additivity = true
		}

		// Set level for all application artefacts
		  // info "grails.app"
		  // Set for a specific controller
		all "grails.app.controllers"
		all "grails.app.domain"
		all "grails.app.service"

    error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
           'org.codehaus.groovy.grails.web.pages', //  GSP
           'org.codehaus.groovy.grails.web.sitemesh', //  layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping', // URL mapping
           'org.codehaus.groovy.grails.commons', // core / classloading
           'org.codehaus.groovy.grails.plugins', // plugins
           'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'

    warn   'org.mortbay.log'
}

// Uncomment and edit the following lines to start using Grails encoding & escaping improvements

/* remove this line 
// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside null
                scriptlet = 'none' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        filteringCodecForContentType {
            //'text/html' = 'html'
        }
    }
}
remove this line */
