import org.apache.shiro.crypto.hash.Sha256Hash
import com.summitbid.coach.Food
import grails.converters.JSON

class BootStrap {

	def init = { servletContext ->

		def fixtureLoader

		environments { 
			def user
			production { println "environment is PRODUCTION" } 
				def admin = ShiroUser.findByUsername('admin')
				
				String VCAP_SERVICES = System.getenv('VCAP_SERVICES')
				println "VCAP_SERVICES: ${System.getenv('VCAP_SERVICES')}\n"
//				def service = JSON.parse(VCAP_SERVICES).find { it.key.startsWith('mysql') }.value[0]
//				println """MySQL url: jdbc:mysql://$service.credentials.hostname:$service.credentials.port/$service.credentials.user: $service.credentials.user
//password: $service.credentials.password"""
				
				if (!admin) {
					user = new ShiroUser(username: "admin", passwordHash: new Sha256Hash("gr00vy").toHex())
					user.addToPermissions("*:*")
					user.save()
				}
				else {
					println "user ${admin.username} already exists"
				}
			}

			//		test { println "environment is TEST" } }
	
		development {
			println "environment is DEVELOPMENT"
			def myFood
			10.times {
				//println it
				myFood = Food.foodFactory("bagel-${it}", "einsteins")
				println myFood
			}
			println "Bootstrapped foods: " + Food.list()

			def admin = ShiroUser.findByUsername('admin')
				
				if (!admin) {
					user = new ShiroUser(username: "admin", passwordHash: new Sha256Hash("gr00vy").toHex())
					user.addToPermissions("*:*")
					user.save()
				}
				else {
					println "user ${admin.username} already exists"
				}
		}
	}

	def destroy = {
	}
}