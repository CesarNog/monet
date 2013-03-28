package com.cpqd.monet.prospect

import org.springframework.dao.DataIntegrityViolationException

import com.cpqd.monet.address.Address
import com.cpqd.monet.company.Company

class ProspectController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	/**
	 *  Serviço responsável por alterações no domínio Empresa
	 */
	def prospectService

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [prospectInstanceList: Prospect.list(params), prospectInstanceTotal: Prospect.count()]
    }

    def create() {
		log.info "Criando empresa..."
		println "Criando empresa prospeccao..."
        [prospectInstance: new Prospect(params)]
    }

    def save() {
		log.info "Salvando empresa prospecção..."
		println "Mostrando empresa prospecção..."
		
        def prospectInstance = prospectService.saveProspect(params)
        if (!prospectInstance.save(flush: true)) {
            render(view: "create", model: [prospectInstance: prospectInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'prospect.label', default: 'Prospect'), prospectInstance.id])
        redirect(action: "show", id: prospectInstance.id)
    }

    def show(Long id) {
        def prospectInstance = Prospect.get(id)
        if (!prospectInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'prospect.label', default: 'Prospect'), id])
            redirect(action: "list")
            return
        }

        [prospectInstance: prospectInstance]
    }

    def edit(Long id) {
        def prospectInstance = Prospect.get(id)
		
		def companyInstance = new Company(cnpj: prospectInstance.cnpj, 
										  name: prospectInstance.name, 
										  contact: prospectInstance.contact, 
										  address: new Address().save())

		println companyInstance
		
        if (!companyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'prospect.label', default: 'Prospect'), id])
            redirect(action: "list")
            return
        }

        [companyInstance: companyInstance]
    }

    def update(Long id, Long version) {
        def prospectInstance = Prospect.get(id)
        if (!prospectInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'prospect.label', default: 'Prospect'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (prospectInstance.version > version) {
                prospectInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'prospect.label', default: 'Prospect')] as Object[],
                          "Another user has updated this Prospect while you were editing")
                render(view: "edit", model: [prospectInstance: prospectInstance])
                return
            }
        }

        prospectInstance.properties = params

        if (!prospectInstance.save(flush: true)) {
            render(view: "edit", model: [prospectInstance: prospectInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'prospect.label', default: 'Prospect'), prospectInstance.id])
        redirect(action: "show", id: prospectInstance.id)
    }

    def delete(Long id) {
        def prospectInstance = Prospect.get(id)
        if (!prospectInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'prospect.label', default: 'Prospect'), id])
            redirect(action: "list")
            return
        }

        try {
            prospectInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'prospect.label', default: 'Prospect'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'prospect.label', default: 'Prospect'), id])
            redirect(action: "show", id: id)
        }
    }
}
