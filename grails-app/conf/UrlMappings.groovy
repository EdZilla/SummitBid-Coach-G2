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
		//"/rest/food/$id?"(controller:"food", action:"showRest")
		"/rest/food/postRest"(controller:"food", action:"postRest")
		
		"/rest/food/$id"(controller:"foodRest", parseRequest:true ){
			action = [GET:"show", PUT:"update", DELETE:"delete", POST:"save"]
		}
		
		"/rest/foodRest"(controller:"foodRest") {
			action = [GET:'list', POST: 'save']
		}
		
		"/rest/foodRest/$id"(controller:"foodRest") {
			action = [GET:'show', POST: 'update', DELETE: "delete"]
		}
	}
}
