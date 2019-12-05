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

        '/api/board'(resources: 'board') {
            collection {
                '/columns'(resources: 'board', action: 'getColumns')
            }
        }

        '/api/user'(resources: 'user') {
            collection {
                '/boards'(controller: 'user', action: 'getBoards')
            }
        }

        '/api/column'(resources: 'column') {
            collection {
                '/cards'(controller: 'column', action: 'getCards')
                '/arch-cards'(controller: 'column', action: 'getArchivedCards')
            }
        }

        '/api/card'(resources: 'card') {
            collection {
                '/comments'(controller: 'card', action: 'getComments')
                '/archived'(controller: 'card', action: 'getArchivedCards')
            }
        }

    }
}
