package com.cpqd.monet.company

import com.cpqd.monet.address.Address
import com.cpqd.monet.contact.Contact
import com.cpqd.monet.street.StreetTitle
import com.cpqd.monet.street.StreetType

/**
 * Simples objeto de domínio representando uma empresa.
 *
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 * @author Derick Hirata Ichimura (derick@cpqd.com.br)
 */
class Company {

	CompanyType companyType
	String cnpj
	String name
	String fantasyName
	String stateSubscription
	String municipalSubscription
	String zipCode
	String uf
	String locality
	StreetType streetType
	StreetTitle streetTitle
	String street
	Long streetNumber = 0L
	ComplementType complementType
	String complementDescription
	String neighborhood
	String socialReason
	String city
	Long telephoneNumber
	String userPassword
	boolean prospect = true;

	static hasMany = [contact:Contact]
	
	Contact contact
	
	Address address
	
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

		complementType blank: false, nullable: true
		complementDescription blank: false, nullable: true

		neighborhood blank: false, nullable: true, maxSize:50

		socialReason blank: false, nullable: true, maxSize:50

		city blank: false, nullable: true, maxSize:50

		telephoneNumber matches: "([0-9]{4})[-. ]?([0-9]{4})", maxSize:50, blank: false, nullable: true		
	}
}
