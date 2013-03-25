package com.cpqd.monet.company



import org.junit.*
import grails.test.mixin.*

@TestFor(CompanyTypeController)
@Mock(CompanyType)
class CompanyTypeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/companyType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.companyTypeInstanceList.size() == 0
        assert model.companyTypeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.companyTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.companyTypeInstance != null
        assert view == '/companyType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/companyType/show/1'
        assert controller.flash.message != null
        assert CompanyType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/companyType/list'

        populateValidParams(params)
        def companyType = new CompanyType(params)

        assert companyType.save() != null

        params.id = companyType.id

        def model = controller.show()

        assert model.companyTypeInstance == companyType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/companyType/list'

        populateValidParams(params)
        def companyType = new CompanyType(params)

        assert companyType.save() != null

        params.id = companyType.id

        def model = controller.edit()

        assert model.companyTypeInstance == companyType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/companyType/list'

        response.reset()

        populateValidParams(params)
        def companyType = new CompanyType(params)

        assert companyType.save() != null

        // test invalid parameters in update
        params.id = companyType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/companyType/edit"
        assert model.companyTypeInstance != null

        companyType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/companyType/show/$companyType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        companyType.clearErrors()

        populateValidParams(params)
        params.id = companyType.id
        params.version = -1
        controller.update()

        assert view == "/companyType/edit"
        assert model.companyTypeInstance != null
        assert model.companyTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/companyType/list'

        response.reset()

        populateValidParams(params)
        def companyType = new CompanyType(params)

        assert companyType.save() != null
        assert CompanyType.count() == 1

        params.id = companyType.id

        controller.delete()

        assert CompanyType.count() == 0
        assert CompanyType.get(companyType.id) == null
        assert response.redirectedUrl == '/companyType/list'
    }
}
