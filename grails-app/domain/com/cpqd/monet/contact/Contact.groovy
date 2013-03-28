package com.cpqd.monet.contact

import com.cpqd.monet.company.Company

class Contact {	
	
	String name;
	String phone;
	String email;	
	
	Contact(name, phone, email){
		this.name = name
		this.phone = phone
		this.email = email
	}

	static belongsTo = Company
			
    static constraints = {
		email blank:false, maxSize:50, unique: true, email:true, nullable: true
		name blank:false, maxSize:50
		phone blank:false, maxSize:50, nullable:true				
    }
}
