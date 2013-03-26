package com.cpqd.monet.company



import org.junit.*

import com.cpqd.monet.street.StreetType;

import grails.test.mixin.*

@TestFor(StreetTypeController)
@Mock(StreetType)
class StreetTypeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/streetType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.streetTypeInstanceList.size() == 0
        assert model.streetTypeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.streetTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.streetTypeInstance != null
        assert view == '/streetType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/streetType/show/1'
        assert controller.flash.message != null
        assert StreetType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/streetType/list'

        populateValidParams(params)
        def streetType = new StreetType(params)

        assert streetType.save() != null

        params.id = streetType.id

        def model = controller.show()

        assert model.streetTypeInstance == streetType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/streetType/list'

        populateValidParams(params)
        def streetType = new StreetType(params)

        assert streetType.save() != null

        params.id = streetType.id

        def model = controller.edit()

        assert model.streetTypeInstance == streetType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/streetType/list'

        response.reset()

        populateValidParams(params)
        def streetType = new StreetType(params)

        assert streetType.save() != null

        // test invalid parameters in update
        params.id = streetType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/streetType/edit"
        assert model.streetTypeInstance != null

        streetType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/streetType/show/$streetType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        streetType.clearErrors()

        populateValidParams(params)
        params.id = streetType.id
        params.version = -1
        controller.update()

        assert view == "/streetType/edit"
        assert model.streetTypeInstance != null
        assert model.streetTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/streetType/list'

        response.reset()

        populateValidParams(params)
        def streetType = new StreetType(params)

        assert streetType.save() != null
        assert StreetType.count() == 1

        params.id = streetType.id

        controller.delete()

        assert StreetType.count() == 0
        assert StreetType.get(streetType.id) == null
        assert response.redirectedUrl == '/streetType/list'
    }
}
