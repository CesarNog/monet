package com.cpqd.monet.functions

import com.cpqd.monet.employee.Employee

/**
 * Classe que contem as funções de cada funcionário
 * 
 * @author Derick H.I. Kaiser (derick@cpqd.com.br)
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 *
 */
class Functions {

	String description
	
	Date startDate
	
	Date endDate
	
	static belongsTo = Employee
	
    static constraints = {
		description blank:false, nullable:false, maxSize:30
		startDate blank:false, nullable:false
		
    }
}
