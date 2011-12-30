import org.apache.shiro.crypto.hash.Sha256Hash
import com.summitbid.coach.Food

class BootStrap {

	def init = { servletContext ->

		def fixtureLoader

		environments { 
			
			production { println "environment is PRODUCTION" } 
				def user = new ShiroUser(username: "ed", passwordHash: new Sha256Hash("gr00vy").toHex())
				user.addToPermissions("*:*")
				user.save()
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

			def user = new ShiroUser(username: "ed", passwordHash: new Sha256Hash("gr00vy").toHex())
			user.addToPermissions("*:*")
			user.save()
		}
	}

	def destroy = {
	}
}