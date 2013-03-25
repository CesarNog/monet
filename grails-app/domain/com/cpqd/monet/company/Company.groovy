package com.cpqd.monet.company

class Company {
    
	//Informações da Empresa
	String companyName;
	String cnpj;
    String contactName;
	String contactPhone;
	String email;
	boolean prospect = true;


    static constraints = {	
    companyName blank:false, maxSize:50
	cnpj blank:false, unique:true, matches:"([0-9]{2})[.. ]?([0-9]{3})[.. ]?([0-9]{3})[/. ]?([0-9]{4})[-. ]?([0-9]{2})"
	contactName blank:false, maxSize:50
	contactPhone maxSize:20, blank:true
	email blank:false, unique:true, maxSize:50, email:true	
    }
}
