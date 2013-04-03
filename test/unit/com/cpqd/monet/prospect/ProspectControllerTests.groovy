package com.cpqd.monet.prospect



import org.junit.*
import grails.test.mixin.*

@TestFor(ProspectController)
@Mock(Prospect)
class ProspectControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/prospect/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.prospectInstanceList.size() == 0
        assert model.prospectInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.prospectInstance != null
    }

    void testSave() {
        controller.save()

        assert model.prospectInstance != null
        assert view == '/prospect/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/prospect/show/1'
        assert controller.flash.message != null
        assert Prospect.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/prospect/list'

        populateValidParams(params)
        def prospect = new Prospect(params)

        assert prospect.save() != null

        params.id = prospect.id

        def model = controller.show()

        assert model.prospectInstance == prospect
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/prospect/list'

        populateValidParams(params)
        def prospect = new Prospect(params)

        assert prospect.save() != null

        params.id = prospect.id

        def model = controller.edit()

        assert model.prospectInstance == prospect
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/prospect/list'

        response.reset()

        populateValidParams(params)
        def prospect = new Prospect(params)

        assert prospect.save() != null

        // test invalid parameters in update
        params.id = prospect.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/prospect/edit"
        assert model.prospectInstance != null

        prospect.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/prospect/show/$prospect.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        prospect.clearErrors()

        populateValidParams(params)
        params.id = prospect.id
        params.version = -1
        controller.update()

        assert view == "/prospect/edit"
        assert model.prospectInstance != null
        assert model.prospectInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/prospect/list'

        response.reset()

        populateValidParams(params)
        def prospect = new Prospect(params)

        assert prospect.save() != null
        assert Prospect.count() == 1

        params.id = prospect.id

        controller.delete()

        assert Prospect.count() == 0
        assert Prospect.get(prospect.id) == null
        assert response.redirectedUrl == '/prospect/list'
    }
}
