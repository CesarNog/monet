import com.cpqd.monet.address.StreetTitle;
import com.cpqd.monet.address.StreetType;
import com.cpqd.monet.company.Company
import com.cpqd.monet.company.CompanyType
import com.cpqd.monet.company.ComplementType

class BootStrap {
	
	def init = {
		for (String type in ['Matriz', 'Filial']) {
			new CompanyType(name: type).save(failOnError: true)
		}
		
		for (String type in ['AVENIDA', 'RODOVIA', 'RUA']) {
			new StreetType(name: type).save(failOnError: true)
		}
		
		for (String type in ['AVENIDA', 'RODOVIA', 'RUA']) {
			new StreetTitle(name: type).save(failOnError: true)
		}
		
		for (String type in ['AVENIDA', 'RODOVIA', 'RUA']) {
			new ComplementType(name: type).save(failOnError: true)
		}
	}

    def destroy = {
		
    }
}
