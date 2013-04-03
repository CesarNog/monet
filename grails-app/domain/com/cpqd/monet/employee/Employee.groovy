package com.cpqd.monet.employee

import com.cpqd.monet.functions.Functions

/**
 * Classe que contem as funcionários da Empresa	
 * 
 * @author Derick H.I. Kaiser(derick@cpqd.com.br)
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 *  03/04/2013
 */
class Employee {

	String matriculation
	String name
	String email
	boolean situation = true
	Functions functions
	String cpf
	String contact
	Date startDate
	Date endDate
	
    static constraints = {
		matriculation blank:false, nullable:false, unique:true
		name blank:false, nullable:false, maxSize:50
		email blank:false, nullable:false, email:true
		functions nullable:false
		cpf blank:false, nullable:false, matches:"", maxSize:30
		contact blank:false, nullable:false, maxSize:50
		startDate blank:false, nullable:false
		endDate blank:false, nullable:false
		
    }
}
