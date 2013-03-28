package com.cpqd.monet.address

import com.cpqd.monet.company.ComplementType
import com.cpqd.monet.address.StreetType

/**
 * Simples objeto de domínio representando uma empresa.
 *
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 */
class Locality {

	String stateSubscription
	
	String municipalSubscription
		
	String uf
	
	String locality

	String city

	// Validação de campos
	static constraints = {

		stateSubscription size: 1..20, blank: false, nullable: true, maxSize:50
		municipalSubscription size: 1..20, blank: false, nullable: true, maxSize:50
		uf blank: false, nullable: true, maxSize:50, required: true
		
		locality blank: false, nullable: true, maxSize:50

		city blank: false, nullable: true, maxSize:50
	}
}
