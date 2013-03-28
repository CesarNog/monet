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

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
