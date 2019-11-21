package trello

import grails.rest.Resource

@Resource(uri = '/column')

class Column {

    String title

    static hasMany = [cards: Card]

    static belongsTo = [board: Board]

    static constraints = {
    }
}
