package trello

import grails.rest.Resource

@Resource(uri = '/board')

class Board {

    String title

    static belongsTo = User

    static hasMany = [columns: Column, users: User]

    static mapping = {
        columns lazy: false
    }

    static constraints = {
    }
}
