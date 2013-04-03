package com.cpqd.monet.contact

/**
 * Classe que contem a parte de Contato da Empresa
 * 
 *  @author Derick H.I. Kaiser(derick@cpqd.com.br)
 *  @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 *
 */
import com.cpqd.monet.company.Company

class Contact {

	String name;
	String phone;
	String email;
	
	static belongsTo = Company
			
    static constraints = {
		email blank:false, maxSize:50, unique: true, email:true, nullable: true
		name blank:false, maxSize:50
		phone blank:false, maxSize:50, nullable:true				
    }
}
