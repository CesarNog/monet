package com.cpqd.monet.license

import com.cpqd.monet.address.StreetTitle;
import com.cpqd.monet.address.StreetType;
import com.cpqd.monet.company.ComplementType

/**
 * Simples objeto de dom�nio representando uma empresa.
 *
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 */
class License {

	String locality

	StreetType streetType

	StreetTitle streetTitle

	String street

	Long streetNumber = 0L

	ComplementType complementType

	String complementDescription

	String neighborhood

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

		city blank: false, nullable: true, maxSize:50
	}
}
