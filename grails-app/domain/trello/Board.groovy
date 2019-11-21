package trello

import grails.rest.Resource

@Resource(uri = '/board')

class Board {

    String title
    String image

    static belongsTo = User

    static hasMany = [columns: Column, users: User]

    static mapping = {
        columns lazy: false
    }

    static constraints = {
    }
}
