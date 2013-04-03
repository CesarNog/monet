<<<<<<< HEAD
<<<<<<< HEAD
package com.cpqd.monet.company

import com.cpqd.monet.address.Address
import com.cpqd.monet.address.Locality
import com.cpqd.monet.contact.Contact


/**
 * Classe que representa o serviço responsável pelo tratamento de ações com a entidade domínio Empresa
 *
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 * @author Derick Hirata Ichimura (derick@cpqd.com.br)
 */
class CompanyService {

	def serviceMethod() {
	}

	// Cria uma empresa com todos os atributos
	Company createCompany(params) {
		if(params.company?.prospect != null) {
			params.company?.prospect = false;
		}

		def company = new Company(params)
		company
	}

	// Cria uma empresa de prospecção (com menos atributos)
	Company createCompanyProspect(params) {
		params.company?.prospect = true;
		def company = new Company(name: params.company?.name, cnpj: params.company?.cnpj, prospect: true, contact: Contact.get(params.company?.contact?.id))
		company
	}

	// Salva uma empresa com todos os atributos
	Company saveCompanyProspect(params) {

		if(params.company?.prospect != null) {
			params.company?.prospect = false;
		}
		
		println "Id do contato: " + params.company?.contact?.id
		
		println "CNPJ: " + params.company?.cnpj

		def companyProspectCreated = new Company(name: params.company?.name, cnpj: params.company?.cnpj, prospect: params.company?.prospect, contact: Contact.load(params.company?.contact?.id))

		companyProspectCreated.save()
		companyProspectCreated
	}

	// Salva uma empresa com todos os atributos
	Company saveCompany(params) {
		
		println "Parametros:" + params

		if(params.company?.prospect != null) {
			params.company?.prospect = false;
		}

		def companyCreatedInstance = new Company(
				cnpj: params.company?.cnpj,
				fantasyname: params.company?.fantasyname,
				socialReason: params.company?.socialReason,
				telephoneNumber: params.company?.telephoneNumber,				
				name: params.company?.name,
				address: new Address(params.company?.address),
				locality: new Locality(params.company?.locality),
				contact: new Contact(params.company?.contact),
				companyType: CompanyType.get(params.company?.companyType?.id))

		companyCreatedInstance.save()
		companyCreatedInstance
	}

}
=======
package com.cpqd.monet.company

import com.cpqd.monet.address.Address
import com.cpqd.monet.address.Locality
import com.cpqd.monet.contact.Contact


/**
 * Classe que representa o serviço responsável pelo tratamento de ações com a entidade domínio Empresa
 *
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 * @author Derick Hirata Ichimura (derick@cpqd.com.br)
 */
class CompanyService {

	def serviceMethod() {
	}

	// Cria uma empresa com todos os atributos
	Company createCompany(params) {
		if(params.company?.prospect != null) {
			params.company?.prospect = false;
		}

		def company = new Company(params)
		company
	}

	// Cria uma empresa de prospecção (com menos atributos)
	Company createCompanyProspect(params) {
		params.company?.prospect = true;
		println "Id do contato: " + params.company?.contact
		def company = new Company(params)
		company
	}

	// Salva uma empresa com todos os atributos
	Company saveCompanyProspect(params) {

		println "Contato: " + params.company?.contact		

		def companyProspectCreated = new Company(name: params.company?.name, 
												 cnpj: params.company?.cnpj, 
												 prospect: false, 
												 contact: new Contact(params.company?.contact?.name, params.company?.contact?.phone, params.company?.contact?.email).save())

		//companyProspectCreated.save(flush:true)
		companyProspectCreated
	}

	// Salva uma empresa com todos os atributos
	Company saveCompany(params) {
		
		println "Parametros:" + params

		if(params.company?.prospect != null) {
			params.company?.prospect = false;
		}

		def companyCreatedInstance = new Company(
				cnpj: params.company?.cnpj,
				fantasyname: params.company?.fantasyname,
				socialReason: params.company?.socialReason,
				telephoneNumber: params.company?.telephoneNumber,
				name: params.company?.name,
				address: new Address(params.company?.address),
				locality: new Locality(params.company?.locality),
				contact: new Contact(params.company?.contact).save(),
				companyType: CompanyType.get(params.company?.companyType?.id).save())

		companyCreatedInstance.save()
		companyCreatedInstance
	}

}
>>>>>>> 0c84f424854bf0bfa77b19c98f0edf52e7fa9d9c
=======
package com.cpqd.monet.company

import com.cpqd.monet.address.Address
import com.cpqd.monet.address.Locality
import com.cpqd.monet.contact.Contact
import com.cpqd.monet.prospect.Prospect


/**
 * Classe que representa o serviço responsável pelo tratamento de ações com a entidade domínio Empresa
 *
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 * @author Derick Hirata Ichimura (derick@cpqd.com.br)
 */
class CompanyService {

	def serviceMethod() {
	}

	// Cria uma empresa com todos os atributos
	Company createCompany(params) {
		if(params.company?.prospect != null) {
			params.company?.prospect = false;
		}

		def company = new Company(params)
		company
	}

	// Cria uma empresa de prospecção (com menos atributos)
	Prospect createCompanyProspect(params) {
		
		println params
		
		params.company?.prospect = true;		
		
		def prospect = new Prospect(params)
		prospect
	}

	// Salva uma empresa com todos os atributos
	Prospect saveCompanyProspect(params) {

		println "Contato: " + params.company?.contact		

		def prospectCreated = new Prospect(name: params.company?.name, 
												 cnpj: params.company?.cnpj,												 
												 contact: new Contact(params.company?.contact?.name, 
													 				  params.company?.contact?.phone, 
																	  params.company?.contact?.email).save()).save()

		//companyProspectCreated.save(flush:true)
		prospectCreated
	}

	// Salva uma empresa com todos os atributos
	Company saveCompany(params) {
		
		println "Parametros:" + params

		if(params.company?.prospect != null) {
			params.company?.prospect = false;
		}
		
		println "CompanyType ID:" + params?.companyType?.id
		
		println "cnpj:" + params?.cnpj

		def companyCreatedInstance = new Company(
				cnpj: params?.cnpj,
				fantasyname: params.company?.fantasyname,
				socialReason: params.company?.socialReason,
				telephoneNumber: params.company?.telephoneNumber,
				name: params.company?.name,
				address: new Address(params.company?.address),
				locality: new Locality(params.company?.locality),
				contact: new Contact(params.company?.contact).save(),
				companyType: CompanyType.get(params.companyType?.id))
				
		companyCreatedInstance.save()
		
		println companyCreatedInstance
		
		companyCreatedInstance
	}

}
>>>>>>> ae5e50aea7b888f240cb3a8e24c811d56921379d
