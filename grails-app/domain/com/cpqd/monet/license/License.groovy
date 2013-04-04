package com.cpqd.monet.license

import com.cpqd.monet.address.StreetTitle;
import com.cpqd.monet.address.StreetType;
import com.cpqd.monet.company.ComplementType

/**
 * Classe que controla a libera��o de Licen�a de Uso para uma empresa
 *
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 * @author Derick H.I. Kaiser (derick@cpqd.com.br)
 */
class License {

    LicenseType licenseType;
	
	String password;
	
	Date startDate;
	
	Date endDate;
	

	// Valida��o de campos
	static constraints = {

		password blank:false, nullable:false
		
		startDate blank:false, nullable:false
		
		endDate nullable:false
				
	}
}