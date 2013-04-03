package com.cpqd.monet.functions



import org.junit.*
import grails.test.mixin.*

@TestFor(FunctionsController)
@Mock(Functions)
class FunctionsControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/functions/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.functionsInstanceList.size() == 0
        assert model.functionsInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.functionsInstance != null
    }

    void testSave() {
        controller.save()

        assert model.functionsInstance != null
        assert view == '/functions/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/functions/show/1'
        assert controller.flash.message != null
        assert Functions.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/functions/list'

        populateValidParams(params)
        def functions = new Functions(params)

        assert functions.save() != null

        params.id = functions.id

        def model = controller.show()

        assert model.functionsInstance == functions
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/functions/list'

        populateValidParams(params)
        def functions = new Functions(params)

        assert functions.save() != null

        params.id = functions.id

        def model = controller.edit()

        assert model.functionsInstance == functions
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/functions/list'

        response.reset()

        populateValidParams(params)
        def functions = new Functions(params)

        assert functions.save() != null

        // test invalid parameters in update
        params.id = functions.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/functions/edit"
        assert model.functionsInstance != null

        functions.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/functions/show/$functions.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        functions.clearErrors()

        populateValidParams(params)
        params.id = functions.id
        params.version = -1
        controller.update()

        assert view == "/functions/edit"
        assert model.functionsInstance != null
        assert model.functionsInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/functions/list'

        response.reset()

        populateValidParams(params)
        def functions = new Functions(params)

        assert functions.save() != null
        assert Functions.count() == 1

        params.id = functions.id

        controller.delete()

        assert Functions.count() == 0
        assert Functions.get(functions.id) == null
        assert response.redirectedUrl == '/functions/list'
    }
}
