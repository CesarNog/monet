<<<<<<< HEAD
package com.cpqd.monet.company

import com.cpqd.monet.address.Address
import com.cpqd.monet.address.Locality
import com.cpqd.monet.contact.Contact

/**
 * Simples objeto de domínio representando uma empresa.
 *
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 * @author Derick H.I. Kaiser (derick@cpqd.com.br)
 */
class Company extends Prospect{
	
	Address address
	
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
=======
package com.cpqd.monet.company

import com.cpqd.monet.address.Address
import com.cpqd.monet.address.Locality
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
	String socialReason
		
	Long telephoneNumber
	
	boolean prospect = true;	

	static hasMany = [contact: Contact, address: Address, locality: Locality]
	
	Contact contact
	
	Address address
	
	Locality locality	
	
	// Validação de campos
	static constraints = {		
		
		cnpj blank: false, unique:true
				
		address nullable: true
		
		contact nullable: true
		
		locality nullable: true		
		
		name size: 1..50, blank: false, nullable: true, maxSize:50

		companyType blank: false, nullable: true, maxSize:50

		fantasyName blank: false, nullable: true, maxSize:50

		socialReason blank: false, nullable: true, maxSize:50
		
		telephoneNumber matches: "([0-9]{4})[-. ]?([0-9]{4})", maxSize:50, blank: false, nullable: true		
	}
}
>>>>>>> 0c84f424854bf0bfa77b19c98f0edf52e7fa9d9c
