package com.cpqd.monet.company

import com.cpqd.monet.contact.Contact

/**
 * Classe m�e de Company, que tem como objetivo diferenciar uma Empresa "Vers�o Gratuita", de uma Empresa 
 * "Contratada" pelo servi�o
 * @author Derick H.I. Kaiser(derick@cpqd.com.br)
 *
 */
class Prospect{
	
	String cnpj
	
	String name
	
	Contact contact
	
    static constraints = {
		
		cnpj blank: false, unique:true, nullable:false
				
		name size: 1..50, blank: false, nullable: false, maxSize:50
		
    }
}
