import org.apache.shiro.crypto.hash.Sha256Hash
import com.summitbid.coach.Food

class BootStrap {

	def init = { servletContext ->

		def fixtureLoader

		environments { 
			def user
			production { println "environment is PRODUCTION" } 
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