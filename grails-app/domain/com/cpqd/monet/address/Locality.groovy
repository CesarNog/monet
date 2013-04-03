<<<<<<< HEAD
package com.cpqd.monet.address

import com.cpqd.monet.company.Company

/**
 * Classe que contem detalhes do endereço da Empresa
 *
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 * @author Derick H.I. Kaiser (derick@cpqd.com.br)
 */
class Locality {

	String name

	String stateSubscription
	
	String municipalSubscription
		
	static belongsTo = Address

	//Método construtor para que os valores dos atributos de Locality sejam persistidos
	Locality(name, stateSubscription, municipalSubscription){
		this.name = name
		this.stateSubscription = stateSubscription
		this.municipalSubscription = municipalSubscription
	}
	
	// Validacao de campos
	static constraints = {

		name blank: false, nullable: true, maxSize:50

		stateSubscription size: 1..20, blank: false, nullable: true, maxSize:50
		
		municipalSubscription size: 1..20, blank: false, nullable: true, maxSize:50
		
		}
}
=======
package com.cpqd.monet.address

import com.cpqd.monet.company.Company

/**
 * Simples objeto de dom�nio representando uma empresa.
 *
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 * @author Derick Hirata Ichimura (derick@cpqd.com.br)
 */
class Locality {

	String name

	String stateSubscription
	
	String municipalSubscription
		
	static belongsTo = Address

	//Método construtor para que os valores dos atributos de Locality sejam persistidos
	Locality(name, stateSubscription, municipalSubscription){
		this.name = name
		this.stateSubscription = stateSubscription
		this.municipalSubscription = municipalSubscription
	}
	
	// Validacao de campos
	static constraints = {

		name blank: false, nullable: true, maxSize:50

		stateSubscription size: 1..20, blank: false, nullable: true, maxSize:50
		
		municipalSubscription size: 1..20, blank: false, nullable: true, maxSize:50
		
		}
}
>>>>>>> ae5e50aea7b888f240cb3a8e24c811d56921379d
