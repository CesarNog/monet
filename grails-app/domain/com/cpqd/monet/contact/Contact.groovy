package com.cpqd.monet.contact

import com.cpqd.monet.company.Company

class Contact {

	String name;
	String phone;
	String email;
	
	static belongsTo = [company:Company]
	
    static constraints = {
		name blank:false, maxSize:50
		phone blank:false, maxSize:50, nullable:true
		email blank:false, maxSize:50, unique: true, email:true
		
    }
}
