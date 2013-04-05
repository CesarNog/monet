package com.cpqd.monet.contact

import com.cpqd.monet.prospect.Prospect

class Contact {	
	
	String name;
	String phone;
	String email;	

	static belongsTo = [prospect: Prospect]
			
    static constraints = {
		prospect: nullable: false
		email blank:false, maxSize:50, unique: true, email:true, nullable: true
		name blank:false, maxSize:50
		phone blank:false, maxSize:50, nullable:true				
    }
}
