package trello

import grails.rest.Resource

@Resource(uri = '/user')

class User {

    String username
    String password

    static hasMany = [boards: Board]

    static constraints = {
    }
}
