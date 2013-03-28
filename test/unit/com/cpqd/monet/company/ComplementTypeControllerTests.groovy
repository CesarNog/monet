package com.cpqd.monet.company



import org.junit.*
import grails.test.mixin.*

@TestFor(ComplementTypeController)
@Mock(ComplementType)
class ComplementTypeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/complementType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.complementTypeInstanceList.size() == 0
        assert model.complementTypeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.complementTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.complementTypeInstance != null
        assert view == '/complementType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/complementType/show/1'
        assert controller.flash.message != null
        assert ComplementType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/complementType/list'

        populateValidParams(params)
        def complementType = new ComplementType(params)

        assert complementType.save() != null

        params.id = complementType.id

        def model = controller.show()

        assert model.complementTypeInstance == complementType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/complementType/list'

        populateValidParams(params)
        def complementType = new ComplementType(params)

        assert complementType.save() != null

        params.id = complementType.id

        def model = controller.edit()

        assert model.complementTypeInstance == complementType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/complementType/list'

        response.reset()

        populateValidParams(params)
        def complementType = new ComplementType(params)

        assert complementType.save() != null

        // test invalid parameters in update
        params.id = complementType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/complementType/edit"
        assert model.complementTypeInstance != null

        complementType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/complementType/show/$complementType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        complementType.clearErrors()

        populateValidParams(params)
        params.id = complementType.id
        params.version = -1
        controller.update()

        assert view == "/complementType/edit"
        assert model.complementTypeInstance != null
        assert model.complementTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/complementType/list'

        response.reset()

        populateValidParams(params)
        def complementType = new ComplementType(params)

        assert complementType.save() != null
        assert ComplementType.count() == 1

        params.id = complementType.id

        controller.delete()

        assert ComplementType.count() == 0
        assert ComplementType.get(complementType.id) == null
        assert response.redirectedUrl == '/complementType/list'
    }
}
