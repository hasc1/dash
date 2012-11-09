class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		"/v1/rest/reports"(controller:"reportsData",action:"jsonList")
		"/"(view:"/index")
		"500"(view:'/error')
		//"register"(view:"/user/create")
	}
}
