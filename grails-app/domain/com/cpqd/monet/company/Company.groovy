package com.cpqd.monet.company

import com.cpqd.monet.address.Address
import com.cpqd.monet.address.StreetTitle;
import com.cpqd.monet.address.StreetType;
import com.cpqd.monet.contact.Contact

/**
 * Simples objeto de dom�nio representando uma empresa.
 *
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 * @author Derick Hirata Ichimura (derick@cpqd.com.br)
 */
class Company {

	CompanyType companyType
	String cnpj
	String name
	String fantasyName
	String socialReason
	Long telephoneNumber
	String userPassword
	boolean prospect = true;

	static hasMany = [contact:Contact]
	
	Contact contact
	
	Address address
	
	// Valida��o de campos
	static constraints = {		
		cnpj blank:false, unique:true, matches:"([0-9]{2})[.. ]?([0-9]{3})[.. ]?([0-9]{3})[/. ]?([0-9]{4})[-. ]?([0-9]{2})"
		
		name size: 1..50, blank: false, nullable: true, maxSize:50

		companyType blank: false, nullable: false, maxSize:50

		fantasyName blank: false, nullable: true, maxSize:50

		socialReason blank: false, nullable: true, maxSize:50

		telephoneNumber matches: "([0-9]{4})[-. ]?([0-9]{4})", maxSize:50, blank: false, nullable: true		
	}
}
