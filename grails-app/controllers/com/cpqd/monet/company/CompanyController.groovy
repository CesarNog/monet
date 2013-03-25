package com.cpqd.monet.company

import org.springframework.dao.DataIntegrityViolationException

class CompanyController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def listProspect(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [companyInstanceList: Company.list(params), companyInstanceTotal: Company.count()]
    }

    def createProspect() {
        [companyInstance: new Company(params)]
		redirect(uri:'/createProspect.gsp')
    }

    def save() {
        def companyInstance = new Company(params)
        if (!companyInstance.save(flush: true)) {
            render(view: "createProspect", model: [companyInstance: companyInstance])
            return
        }
        if((companyInstance.contactPhone == null) || (companyInstance.contactPhone == "")){
		   companyInstance.contactPhone=" "		
		}
        flash.message = message(code: 'default.created.message', args: [companyInstance.companyName])
        redirect(action: "showProspect", id: companyInstance.id)
    }

    def showProspect(Long id) {
        def companyInstance = Company.get(id)
        if (!companyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), id])
            redirect(action: "listProspect")
            return
        }

        [companyInstance: companyInstance]
    }

    def editProspect(Long id) {
        def companyInstance = Company.get(id)
        if (!companyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), id])
            redirect(action: "listProspect")
            return
        }

        [companyInstance: companyInstance]
    }

    def update(Long id, Long version) {
        def companyInstance = Company.get(id)
        if (!companyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), id])
            redirect(action: "listProspect")
            return
        }

        if (version != null) {
            if (companyInstance.version > version) {
                companyInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'company.label', default: 'Company')] as Object[],
                          "Another user has updated this Company while you were editing")
                render(view: "edit", model: [companyInstance: companyInstance])
                return
            }
        }

        companyInstance.properties = params

        if (!companyInstance.save(flush: true)) {
            render(view: "edit", model: [companyInstance: companyInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'company.label', default: 'Company'), companyInstance.id])
        redirect(action: "show", id: companyInstance.id)
    }

    def delete(Long id) {
        def companyInstance = Company.get(id)
        if (!companyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), id])
            redirect(action: "list")
            return
        }

        try {
            companyInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'company.label', default: 'Company'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'company.label', default: 'Company'), id])
            redirect(action: "show", id: id)
        }
    }
}
