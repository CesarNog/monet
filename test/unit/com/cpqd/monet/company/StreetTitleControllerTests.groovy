package com.cpqd.monet.company



import org.junit.*

import com.cpqd.monet.address.StreetTitle;

import grails.test.mixin.*

@TestFor(StreetTitleController)
@Mock(StreetTitle)
class StreetTitleControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/streetTitle/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.streetTitleInstanceList.size() == 0
        assert model.streetTitleInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.streetTitleInstance != null
    }

    void testSave() {
        controller.save()

        assert model.streetTitleInstance != null
        assert view == '/streetTitle/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/streetTitle/show/1'
        assert controller.flash.message != null
        assert StreetTitle.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/streetTitle/list'

        populateValidParams(params)
        def streetTitle = new StreetTitle(params)

        assert streetTitle.save() != null

        params.id = streetTitle.id

        def model = controller.show()

        assert model.streetTitleInstance == streetTitle
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/streetTitle/list'

        populateValidParams(params)
        def streetTitle = new StreetTitle(params)

        assert streetTitle.save() != null

        params.id = streetTitle.id

        def model = controller.edit()

        assert model.streetTitleInstance == streetTitle
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/streetTitle/list'

        response.reset()

        populateValidParams(params)
        def streetTitle = new StreetTitle(params)

        assert streetTitle.save() != null

        // test invalid parameters in update
        params.id = streetTitle.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/streetTitle/edit"
        assert model.streetTitleInstance != null

        streetTitle.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/streetTitle/show/$streetTitle.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        streetTitle.clearErrors()

        populateValidParams(params)
        params.id = streetTitle.id
        params.version = -1
        controller.update()

        assert view == "/streetTitle/edit"
        assert model.streetTitleInstance != null
        assert model.streetTitleInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/streetTitle/list'

        response.reset()

        populateValidParams(params)
        def streetTitle = new StreetTitle(params)

        assert streetTitle.save() != null
        assert StreetTitle.count() == 1

        params.id = streetTitle.id

        controller.delete()

        assert StreetTitle.count() == 0
        assert StreetTitle.get(streetTitle.id) == null
        assert response.redirectedUrl == '/streetTitle/list'
    }
}
