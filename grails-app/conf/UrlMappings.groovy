class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
               "/company/" {
                       controller = "company"
                       action = "listProspect"
               }
			   
			    "/company/list" {
                       controller = "company"
                       action = "listProspect"
               }
               
               "/company/create" {
                       controller = "company"
                       action = "createProspect"
               }
                              
               "/company/edit/$id?" {
                       controller = "company"
                       action = "editProspect"
               }
			   
			   "/company/show/$id?" {
                       controller = "company"
                       action = "showProspect"
               }

               "/"(view:"/index")
               "500"(view:'/error')
       }
}
