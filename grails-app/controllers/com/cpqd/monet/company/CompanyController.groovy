package com.cpqd.monet.company

import grails.converters.XML

import org.springframework.dao.DataIntegrityViolationException

import com.cpqd.monet.contact.Contact
import com.cpqd.monet.prospect.Prospect

/**
 * Objeto de controle representando uma empresa.
 *
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 * @author Derick Hirata Ichimura (derick@cpqd.com.br)
 */
class CompanyController {

	// M�todos permitidos
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	/**
	 *  Servi�o respons�vel por altera��es no dom�nio Empresa
	 */
	def companyService

	/** 
	 * P�gina inicial
	 * @return
	 */
	def index() {
		redirect(action: "list", params: params)
	}

	/**
	 * Action que chama a Lista das empresas
	 * @param max Maior n�mero de pagina��o
	 * @return
	 */
	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		[companyInstanceList: Company.list(params) + Prospect.list(), companyInstanceTotal: Company.count() + Prospect.count()]
	}

	/**
	 * Action que representa a cria��o das empresas	 * 
	 * @return
	 */
	def create() {
		log.info "Criando empresa..."
		println "Criando empresa..."

		render(view:"/company/create",  model: [companyInstance: new Company()])
	}

	/**
	 * Metodo que realizar parser de XML 
	 * @return
	 */
	def parseXML(){
		def stream = getClass().classLoader.getResourceAsStream("grails-app/conf/estados.xml")

		println stream

		return [data: XML.parse(stream)]
	}

	/**
	 * Action que salva uma empresa 
	 * @return
	 */
	def save() {

		log.info "Salvando empresa..."
		println "Salvando empresa..."

		def company = companyService.saveCompany(params);

		if (company.hasErrors()) {
			render(view: "create", model: [companyInstance: company])
			return
		}

		flash.message = message(code: 'default.created.message', args: [company.name])
		redirect(action: "show", id: company.id)
	}

	/**
	 * Action que mostra os detalhes de uma empresa
	 * @return
	 */
	def show = {
		log.info "Mostrando empresa..."
		println "Mostrando detalhes empresa..."

		withCompany { company ->
			[company:company]
		}
	}

	/**
	 * Action que mostra os detalhes de uma empresa
	 * @param id Identificador �nico de empresa
	 * @return
	 */
	def show(Long id) {
		log.info "Mostrando empresa com id " + id
		println "Mostrando detalhes empresa com id " + id

		def companyInstance = Company.get(id)
		if (!companyInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'company.label', default: 'Company'),
				id
			])
			redirect(action: "list")
			return
		}

		[companyInstance: companyInstance]
	}

	/**
	 * Action que edita as informa��es de uma determinada empresa
	 * @param id Identificador �nico de empresa
	 * @return
	 */
	def edit(Long id) {
		def companyInstance = Company.get(id)

		if (!companyInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'company.label', default: 'Company'),
				id
			])
			redirect(action: "list")
			return
		}

		[companyInstance: companyInstance]
		
	}

	/**
	 * Action que atualiza as informa��es de uma empresa
	 * @return
	 */
	def update = {
		withCompany { company ->
			company.properties = params
			if(company.validate() && company.save()) {
				redirect action:"show", id:company.id
			} else {
				render view:"edit", model:[company:company]
			}
		}
	}

	/**
	 * Action que edita as informa��es de uma determinada empresa
	 * @param id Identificador �nico de empresa
	 * @return
	 */
	def update(Long id, Long version) {

		log.info "Atualizando empresa com id " + id
		println "Atualizando empresa com id " + id

		println Company.get(id)

		def companyInstance = Company.get(id)

		println companyInstance

		if (!companyInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'company.label', default: 'Company'),
				id
			])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (companyInstance.version > version) {
				companyInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[
							message(code: 'company.label', default: 'Company')] as Object[],
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

		flash.message = message(code: 'default.updated.message', args: [
			message(code: 'company.label', default: 'Company'),
			companyInstance.id
		])
		redirect(action: "show", id: companyInstance.id)
	}

	/**
	 * Apaga uma empresa de prospec��o
	 * @param id Identificador �nico de empresa
	 * @return
	 */
	def deleteProspect(Long id) {
		def companyInstance = Company.get(id)
		if (!companyInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'company.label', default: 'Company'),
				id
			])
			redirect(action: "list")
			return
		}

		try {
			companyInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'company.label', default: 'Company'),
				id
			])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
				message(code: 'company.label', default: 'Company'),
				id
			])
			redirect(action: "show", id: id)
		}
	}
	
	/**
	 * Metodo closure que percorre as empresas
	 * @param id Identificador �nico de empresa
	 * @return
	 */
	private def withCompany(id="id", Closure c) {
		def company = Company.get(params[id])
		if(company) {
			c.call company
		} else {
			flash.message = message(code: 'company.notfound')
			redirect action:"list"
		}
	}
}
