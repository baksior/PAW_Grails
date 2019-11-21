package trello

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')

        '/boards'(resources: 'board') {
            collection {
                '/columns'(controller: 'board', action: 'getColumns')
            }
        }

        '/users'(resources: 'user') {
            collection {
                '/boards'(controller: 'user', action: 'getBoards')
            }
            collection {
                '/auth'(controller: 'user', action: 'auth')
            }
        }

        '/columns'(resources: 'column') {
            collection {
                '/cards'(controller: 'column', action: 'getCards')
            }
        }

    }
}
