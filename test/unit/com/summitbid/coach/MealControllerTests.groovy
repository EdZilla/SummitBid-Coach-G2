package com.summitbid.coach



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(MealController)
@Mock(Meal)
class MealControllerTests {

    void testIndex() {
        controller.index()
        assert "/meal/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.mealInstanceList.size() == 0
        assert model.mealInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.mealInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.mealInstance != null
        assert view == '/meal/create'

        response.reset()

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/meal/show/1'
        assert controller.flash.message != null
        assert Meal.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/meal/list'


        def meal = new Meal()

        // TODO: populate domain properties

        assert meal.save() != null

        params.id = meal.id

        def model = controller.show()

        assert model.mealInstance == meal
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/meal/list'


        def meal = new Meal()

        // TODO: populate valid domain properties

        assert meal.save() != null

        params.id = meal.id

        def model = controller.edit()

        assert model.mealInstance == meal
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/meal/list'

        response.reset()


        def meal = new Meal()

        // TODO: populate valid domain properties

        assert meal.save() != null

        // test invalid parameters in update
        params.id = meal.id

        controller.update()

        assert view == "/meal/edit"
        assert model.mealInstance != null

        meal.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/meal/show/$meal.id"
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/meal/list'

        response.reset()

        def meal = new Meal()

        // TODO: populate valid domain properties
        assert meal.save() != null
        assert Meal.count() == 1

        params.id = meal.id

        controller.delete()

        assert Meal.count() == 0
        assert Meal.get(meal.id) == null
        assert response.redirectedUrl == '/meal/list'
    }
}
