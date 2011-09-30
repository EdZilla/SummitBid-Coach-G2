class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
		
		"/rest/food"(controller:"food", action:"listRest")
		"/rest/food/$id?"(controller:"food", action:"showRest")
		"/rest/food/postRest"(controller:"food", action:"postRest")
	}
}
