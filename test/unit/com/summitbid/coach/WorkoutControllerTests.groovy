package com.summitbid.coach



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(WorkoutController)
@Mock(Workout)
class WorkoutControllerTests {

    void testIndex() {
        controller.index()
        assert "/workout/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.workoutInstanceList.size() == 0
        assert model.workoutInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.workoutInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.workoutInstance != null
        assert view == '/workout/create'

        response.reset()

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/workout/show/1'
        assert controller.flash.message != null
        assert Workout.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/workout/list'


        def workout = new Workout()

        // TODO: populate domain properties

        assert workout.save() != null

        params.id = workout.id

        def model = controller.show()

        assert model.workoutInstance == workout
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/workout/list'


        def workout = new Workout()

        // TODO: populate valid domain properties

        assert workout.save() != null

        params.id = workout.id

        def model = controller.edit()

        assert model.workoutInstance == workout
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/workout/list'

        response.reset()


        def workout = new Workout()

        // TODO: populate valid domain properties

        assert workout.save() != null

        // test invalid parameters in update
        params.id = workout.id

        controller.update()

        assert view == "/workout/edit"
        assert model.workoutInstance != null

        workout.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/workout/show/$workout.id"
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/workout/list'

        response.reset()

        def workout = new Workout()

        // TODO: populate valid domain properties
        assert workout.save() != null
        assert Workout.count() == 1

        params.id = workout.id

        controller.delete()

        assert Workout.count() == 0
        assert Workout.get(workout.id) == null
        assert response.redirectedUrl == '/workout/list'
    }
}
