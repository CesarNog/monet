package com.cpqd.monet.company

import com.cpqd.monet.address.Address
import com.cpqd.monet.address.StreetTitle;
import com.cpqd.monet.address.StreetType;
import com.cpqd.monet.contact.Contact

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
<<<<<<< HEAD
	String socialReason
=======
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
>>>>>>> refs/remotes/origin/master
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

<<<<<<< HEAD
		socialReason blank: false, nullable: true, maxSize:50

=======
		streetType blank: false, nullable: true
		streetTitle blank: false, nullable: true
		street blank: false, nullable: true

		streetNumber min: 0L, blank: false, nullable: true

		complementType blank: false, nullable: true
		complementDescription blank: false, nullable: true

		neighborhood blank: false, nullable: true, maxSize:50

		socialReason blank: false, nullable: true, maxSize:50

		city blank: false, nullable: true, maxSize:50

>>>>>>> refs/remotes/origin/master
		telephoneNumber matches: "([0-9]{4})[-. ]?([0-9]{4})", maxSize:50, blank: false, nullable: true		
	}
}
