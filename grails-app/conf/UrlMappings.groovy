/**
 * Mapeamento de URL dos serviços para tratamento de Empresa
 *
 * @author Cesar Augusto Nogueira (caugusto@cpqd.com.br)
 * @author Derick Hirata Ichimura (derick@cpqd.com.br)
 */
class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{ constraints { // apply constraints here
			} }

		"/empresa" {
			controller = "company"
			action = "list"
		}

		
		"/empresa/adicionarEmpresa" {
			controller = "company"
			action = "create"
		}
		
		"/empresa/adicionarEmpresaProspeccao" {
			controller = "company"
			action = "createProspect"			
		}
		

		"/empresa/editar/$id?" {
			controller = "company"
			action = "edit"
		}
		
		"/empresa/editarProspeccao/$id?" {
			controller = "company"
			action = "editProspect"
		}
		
		
		"/empresa/detalhes/$id?" {
			controller = "company"
			action = "show"
		}

		"/empresa/detalhesProspeccao/$id?" {
			controller = "company"
			action = "showProspect"
		}
		

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
