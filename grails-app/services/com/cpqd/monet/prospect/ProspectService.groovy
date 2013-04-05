package com.cpqd.monet.prospect

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
class ProspectService {

	def serviceMethod() {
	}
	
	// Salva uma empresa com todos os atributos
	Prospect saveProspect(params) {
		
		println params.prospect.name
		println params.prospect.cnpj 
		println params.prospect.contact.name 
		println params.prospect.contact.phone 
		println params.prospect.contact.email
				
		def prospectCreated = new Prospect(name: params.prospect.name, 
				   cnpj: params.prospect.cnpj,												 
				   contact: new Contact(name: params.prospect.contact.name, 
					   				    phone: params.prospect.contact.phone, 
										email: params.prospect.contact.email))
		
		println prospectCreated
		prospectCreated
	}
}
