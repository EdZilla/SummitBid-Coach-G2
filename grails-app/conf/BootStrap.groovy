import org.apache.shiro.crypto.hash.Sha256Hash
import com.summitbid.coach.Food
import com.summitbid.coach.Exercise
import com.summitbid.coach.Meal
import com.summitbid.coach.Workout
import com.summitbid.coach.Activity

import grails.converters.JSON

class BootStrap {

	def init = { servletContext ->

		def fixtureLoader

		environments {
			def user

			production {
				println "BOOTSTRAP: environment PRODUCTION"
				def admin = ShiroUser.findByUsername('admin')

				String VCAP_SERVICES = System.getenv('VCAP_SERVICES')
				println "VCAP_SERVICES: ${System.getenv('VCAP_SERVICES')}\n"
				def service = JSON.parse(VCAP_SERVICES).find { it.key.startsWith('mysql') }.value[0]
				println """MySQL url: jdbc:mysql://$service.credentials.hostname:$service.credentials.port:$service.credentials.name
						   user: $service.credentials.user
						   password: $service.credentials.password"""


				if (!admin) {
					user = new ShiroUser(username: "admin", passwordHash: new Sha256Hash("gr00vy").toHex())
					user.addToPermissions("*:*")
					user.save()
				}
				else {
					println "user ${admin.username} already exists"
				}
			}


			development {
				println "BOOTSTRAP environment:  DEVELOPMENT"

				bootStrappedDomains()

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

			test {
				println "BOOTSTRAP environment: TEST"
				bootStrappedDomains()
			}
		}
	}

	def destroy = {
	}

	/**
	 * Create a few test domains
	 * @return
	 */
	def bootStrappedDomains() {
		println "bootStrappedDomains: "
		def myFood
		100.times {
			//println it
			myFood = Food.foodFactory("bagel-${it}", "einsteins")
			println myFood
		}
		println "Bootstrapped foods: " + Food.list()

		50.times {  def myMeal = new Meal(name:"meal-" + it, date: new Date()).validateAndSave()  }

		def meals = Meal.getAll()
		meals.each { it.addToFoods(Food.get(1)) }
		println "Bootstrapped Meals: " + Meal.list()


		100.times {
			def myExercise = new Exercise(name:"ex-" + it, description:"do it!")
			myExercise.save()
		}
		println "Bootstrapped Exercises: " + Exercise.list()

		50.times  {
			def myWorkouts = new Workout(name:"Monday Wkout", date: new Date() ).validateAndSave()
		}

		def workouts = Workout.getAll()
		workouts.each { it.addToExercises( Exercise.get(1)) }
	}
}