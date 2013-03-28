package com.cpqd.monet.address

import com.cpqd.monet.company.ComplementType
import com.cpqd.monet.address.StreetTitle
import com.cpqd.monet.address.StreetType

/**
 * Simples objeto de dom�nio representando uma empresa.
 *
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 */
class Address {

	String locality

	StreetType streetType

	StreetTitle streetTitle

	String street

	Long streetNumber = 0L

	ComplementType complementType

	String complementDescription

	String neighborhood
	
	String zipCode

	String city

	// Valida��o de campos
	static constraints = {

		locality blank: false, nullable: true, maxSize:50

		streetType blank: false, nullable: true
		streetTitle blank: false, nullable: true
		street blank: false, nullable: true

		streetNumber min: 0L, blank: false, nullable: true

		complementType blank: false, nullable: true
		complementDescription blank: false, nullable: true

		neighborhood blank: false, nullable: true, maxSize:50

		zipCode matches: "([0-9]{5})[-. ]?([0-9]{3})", blank: false, nullable: false, maxSize:9, required: true
		
		city blank: false, nullable: true, maxSize:50
	}
}