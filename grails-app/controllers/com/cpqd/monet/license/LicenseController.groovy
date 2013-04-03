package com.cpqd.monet.license

import org.springframework.dao.DataIntegrityViolationException

class LicenseController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [licenseInstanceList: License.list(params), licenseInstanceTotal: License.count()]
    }

    def create() {
        [licenseInstance: new License(params)]
    }

    def save() {
        def licenseInstance = new License(params)
        if (!licenseInstance.save(flush: true)) {
            render(view: "create", model: [licenseInstance: licenseInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'license.label', default: 'License'), licenseInstance.id])
        redirect(action: "show", id: licenseInstance.id)
    }

    def show(Long id) {
        def licenseInstance = License.get(id)
        if (!licenseInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'license.label', default: 'License'), id])
            redirect(action: "list")
            return
        }

        [licenseInstance: licenseInstance]
    }

    def edit(Long id) {
        def licenseInstance = License.get(id)
        if (!licenseInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'license.label', default: 'License'), id])
            redirect(action: "list")
            return
        }

        [licenseInstance: licenseInstance]
    }

    def update(Long id, Long version) {
        def licenseInstance = License.get(id)
        if (!licenseInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'license.label', default: 'License'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (licenseInstance.version > version) {
                licenseInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'license.label', default: 'License')] as Object[],
                          "Another user has updated this License while you were editing")
                render(view: "edit", model: [licenseInstance: licenseInstance])
                return
            }
        }

        licenseInstance.properties = params

        if (!licenseInstance.save(flush: true)) {
            render(view: "edit", model: [licenseInstance: licenseInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'license.label', default: 'License'), licenseInstance.id])
        redirect(action: "show", id: licenseInstance.id)
    }

    def delete(Long id) {
        def licenseInstance = License.get(id)
        if (!licenseInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'license.label', default: 'License'), id])
            redirect(action: "list")
            return
        }

        try {
            licenseInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'license.label', default: 'License'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'license.label', default: 'License'), id])
            redirect(action: "show", id: id)
        }
    }
}
