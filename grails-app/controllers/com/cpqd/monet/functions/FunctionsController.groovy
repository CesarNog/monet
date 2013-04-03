package com.cpqd.monet.functions

import org.springframework.dao.DataIntegrityViolationException

class FunctionsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [functionsInstanceList: Functions.list(params), functionsInstanceTotal: Functions.count()]
    }

    def create() {
        [functionsInstance: new Functions(params)]
    }

    def save() {
        def functionsInstance = new Functions(params)
        if (!functionsInstance.save(flush: true)) {
            render(view: "create", model: [functionsInstance: functionsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'functions.label', default: 'Functions'), functionsInstance.id])
        redirect(action: "show", id: functionsInstance.id)
    }

    def show(Long id) {
        def functionsInstance = Functions.get(id)
        if (!functionsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'functions.label', default: 'Functions'), id])
            redirect(action: "list")
            return
        }

        [functionsInstance: functionsInstance]
    }

    def edit(Long id) {
        def functionsInstance = Functions.get(id)
        if (!functionsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'functions.label', default: 'Functions'), id])
            redirect(action: "list")
            return
        }

        [functionsInstance: functionsInstance]
    }

    def update(Long id, Long version) {
        def functionsInstance = Functions.get(id)
        if (!functionsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'functions.label', default: 'Functions'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (functionsInstance.version > version) {
                functionsInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'functions.label', default: 'Functions')] as Object[],
                          "Another user has updated this Functions while you were editing")
                render(view: "edit", model: [functionsInstance: functionsInstance])
                return
            }
        }

        functionsInstance.properties = params

        if (!functionsInstance.save(flush: true)) {
            render(view: "edit", model: [functionsInstance: functionsInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'functions.label', default: 'Functions'), functionsInstance.id])
        redirect(action: "show", id: functionsInstance.id)
    }

    def delete(Long id) {
        def functionsInstance = Functions.get(id)
        if (!functionsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'functions.label', default: 'Functions'), id])
            redirect(action: "list")
            return
        }

        try {
            functionsInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'functions.label', default: 'Functions'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'functions.label', default: 'Functions'), id])
            redirect(action: "show", id: id)
        }
    }
}
