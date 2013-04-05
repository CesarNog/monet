package com.cpqd.monet.company

import com.cpqd.monet.address.Address
import com.cpqd.monet.prospect.Prospect

/**
 * Objeto domínio representando uma empresa.
 *
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 * @author Derick Hirata Ichimura (derick@cpqd.com.br)
 */
class Company extends Prospect{
	
	static hasOne = [address:Address]
	
	CompanyType companyType
	
	String fantasyName
	String socialReason		
	Long telephoneNumber
		
	// Validação de campos
	static constraints = {

		address nullable: true

		companyType blank: false, nullable: true, maxSize:50

		fantasyName blank: false, nullable: true, maxSize:50

		socialReason blank: false, nullable: true, maxSize:50
		
		telephoneNumber matches: "([0-9]{4})[-. ]?([0-9]{4})", maxSize:50, blank: false, nullable: true		
	}
}
