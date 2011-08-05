package com.summitbid.coach



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(FoodController)
@Mock(Food)
class FoodControllerTests {

    void testIndex() {
        controller.index()
        assert "/food/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.foodInstanceList.size() == 0
        assert model.foodInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.foodInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.foodInstance != null
        assert view == '/food/create'

        response.reset()

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/food/show/1'
        assert controller.flash.message != null
        assert Food.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/food/list'


        def food = new Food()

        // TODO: populate domain properties

        assert food.save() != null

        params.id = food.id

        def model = controller.show()

        assert model.foodInstance == food
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/food/list'


        def food = new Food()

        // TODO: populate valid domain properties

        assert food.save() != null

        params.id = food.id

        def model = controller.edit()

        assert model.foodInstance == food
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/food/list'

        response.reset()


        def food = new Food()

        // TODO: populate valid domain properties

        assert food.save() != null

        // test invalid parameters in update
        params.id = food.id

        controller.update()

        assert view == "/food/edit"
        assert model.foodInstance != null

        food.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/food/show/$food.id"
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/food/list'

        response.reset()

        def food = new Food()

        // TODO: populate valid domain properties
        assert food.save() != null
        assert Food.count() == 1

        params.id = food.id

        controller.delete()

        assert Food.count() == 0
        assert Food.get(food.id) == null
        assert response.redirectedUrl == '/food/list'
    }
}
