package com.cpqd.monet.license

import com.cpqd.monet.address.StreetTitle;
import com.cpqd.monet.address.StreetType;
import com.cpqd.monet.company.ComplementType

/**
 * Simples objeto de dom�nio representando uma empresa.
 *
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 * @author Derick Hirata Ichimura (derick@cpqd.com.br) 
 */
class License {

    LicenseType licenseType;
	
	String password;
	
	Date startDate;
	
	Date endDate;
	

	// Valida��o de campos
	static constraints = {

		password blank:false, nullable:false
				
	}
}
