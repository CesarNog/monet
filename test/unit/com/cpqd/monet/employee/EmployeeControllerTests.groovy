package com.cpqd.monet.employee



import org.junit.*
import grails.test.mixin.*

@TestFor(EmployeeController)
@Mock(Employee)
class EmployeeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/employee/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.employeeInstanceList.size() == 0
        assert model.employeeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.employeeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.employeeInstance != null
        assert view == '/employee/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/employee/show/1'
        assert controller.flash.message != null
        assert Employee.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/employee/list'

        populateValidParams(params)
        def employee = new Employee(params)

        assert employee.save() != null

        params.id = employee.id

        def model = controller.show()

        assert model.employeeInstance == employee
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/employee/list'

        populateValidParams(params)
        def employee = new Employee(params)

        assert employee.save() != null

        params.id = employee.id

        def model = controller.edit()

        assert model.employeeInstance == employee
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/employee/list'

        response.reset()

        populateValidParams(params)
        def employee = new Employee(params)

        assert employee.save() != null

        // test invalid parameters in update
        params.id = employee.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/employee/edit"
        assert model.employeeInstance != null

        employee.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/employee/show/$employee.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        employee.clearErrors()

        populateValidParams(params)
        params.id = employee.id
        params.version = -1
        controller.update()

        assert view == "/employee/edit"
        assert model.employeeInstance != null
        assert model.employeeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/employee/list'

        response.reset()

        populateValidParams(params)
        def employee = new Employee(params)

        assert employee.save() != null
        assert Employee.count() == 1

        params.id = employee.id

        controller.delete()

        assert Employee.count() == 0
        assert Employee.get(employee.id) == null
        assert response.redirectedUrl == '/employee/list'
    }
}
