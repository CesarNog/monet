package com.cpqd.monet.company

/**
 * Simples objeto de domínio representando uma empresa.
 *
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 */
class Company {

	//Tipo da empresa
	CompanyType companyType

	//CNPJ da empresa - Identificador único
	String cnpj

	//Nome da empresa
	String name

	String fantasyName
	String stateSubscription
	String municipalSubscription

	// CEP - formato NNNNN-NNN
	String zipCode

	// Estado
	String uf

	// Localidade
	String locality

	// Tipo do logradouro
	StreetType streetType

	// Titulo do logradouro
	StreetTitle streetTitle

	// Logradouro
	String street

	// Número da rua
	Long streetNumber = 0L

	// Tipo de Complemento
	ComplementType complementType

	// Descrição do Complemento
	String complementDescription

	// Bairro
	String neighborhood

	// Informações de contato

	//Nome do contato
	String contactName

	// Telefone do contato - formatos: NNNN-NNNN ou NNNNNNNN
	String contactPhone

	// E-mail do contato
	String contactEmail

	// Razão Social
	String socialReason

	// Cidade
	String city

	// Telefone - formatos: NNNN-NNNN ou NNNNNNNN
	Long telephoneNumber

	// Senha do usuario
	String userPassword
	
	// Se é de prospecção ou não
	boolean prospect = true;

	// Validação de campos
	static constraints = {		
		cnpj blank:false, unique:true, matches:"([0-9]{2})[.. ]?([0-9]{3})[.. ]?([0-9]{3})[/. ]?([0-9]{4})[-. ]?([0-9]{2})"
		
		name size: 1..50, blank: false, nullable: true, maxSize:50

		companyType blank: false, nullable: false, maxSize:50

		fantasyName blank: false, nullable: true, maxSize:50
		stateSubscription size: 1..20, blank: false, nullable: true, maxSize:50
		municipalSubscription size: 1..20, blank: false, nullable: true, maxSize:50
		zipCode matches: "([0-9]{5})[-. ]?([0-9]{3})", blank: false, nullable: false, maxSize:9, required: true
		uf blank: false, nullable: true, maxSize:50, required: true

		locality blank: false, nullable: true, maxSize:50

		streetType blank: false, nullable: true
		streetTitle blank: false, nullable: true
		street blank: false, nullable: true

		streetNumber min: 0L, blank: false, nullable: true

		// Complemento
		complementType blank: false, nullable: true
		complementDescription blank: false, nullable: true

		//Bairro
		neighborhood blank: false, nullable: true, maxSize:50

		// Informações de contato
		contactName size: 1..50, blank: false, nullable: true, maxSize:50
		contactPhone matches: "([0-9]{4})[-. ]?([0-9]{4})", maxSize:50, blank: false, nullable: true
		contactEmail blank: false, email: true, nullable: true

		// Razão Social
		socialReason blank: false, nullable: true, maxSize:50

		city blank: false, nullable: true, maxSize:50

		//Telefone		
		telephoneNumber matches: "([0-9]{4})[-. ]?([0-9]{4})", maxSize:50, blank: false, nullable: true

		//Senha
		userPassword blank: false, password: true, nullable: true
	}
}
