class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        name samlsso: "/samlsso"{}
        name logoff: "/logout" {}

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
