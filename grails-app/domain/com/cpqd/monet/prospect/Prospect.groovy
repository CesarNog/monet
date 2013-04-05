package com.cpqd.monet.prospect

import com.cpqd.monet.contact.Contact

/**
 * Classe mãe de Company, que tem como objetivo diferenciar uma Empresa "Versão Gratuita", de uma Empresa 
 * "Contratada" pelo serviço
 * @author Derick H.I. Kaiser(derick@cpqd.com.br)
 *
 */
class Prospect{

	String cnpj

	String name

	static hasOne = [contact: Contact]

	static constraints = {
		contact nullable: true
		cnpj blank: false, unique:true, nullable:false
		name size: 1..50, blank: false, nullable: false, maxSize:50
	}
}
