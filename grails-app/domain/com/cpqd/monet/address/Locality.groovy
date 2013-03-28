package com.cpqd.monet.address

import com.cpqd.monet.company.Company

/**
 * Simples objeto de dom�nio representando uma empresa.
 *
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 */
class Locality {

	String locality

	String stateSubscription
	
	String municipalSubscription
	
	String uf
	
	String city
	
	static belongsTo = Company

	// Validacao de campos
	static constraints = {

		locality blank: false, nullable: true, maxSize:50

		stateSubscription size: 1..20, blank: false, nullable: true, maxSize:50
		
		municipalSubscription size: 1..20, blank: false, nullable: true, maxSize:50
		
        uf blank: false, nullable: true, maxSize:50, required: true
		
		city blank: false, nullable: true, maxSize:50
	}
}
