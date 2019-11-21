package trello

import grails.rest.Resource

@Resource(uri = '/card')

class Card {

    String description

    static belongsTo = [column: Column]

    static constraints = {
    }
}
