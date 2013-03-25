package com.cpqd.monet.company

/**
 * Classe que representa o servi�o respons�vel pelo tratamento de a��es com a entidade dom�nio Empresa
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
		//company.save()
		company
	}
	
	// Cria uma empresa de prospec��o (com menos atributos)
	Company createCompanyProspect(params) {
		params.company?.prospect = true;
		def company = new Company(name: params.company?.name, cnpj: params.company?.cnpj, prospect: params.company?.prospect, contactName: params.contactPhone?.cnpj, contactPhone: params.contactPhone?.cnpj)
		company.save()
		company
	}
	
}
