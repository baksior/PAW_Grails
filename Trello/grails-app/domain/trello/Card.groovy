package trello

import grails.rest.Resource

@Resource(uri = '/card')

class Card {

	String title
	String description
	Integer position
	String createdDate
	
	static belongsTo = [board: Board]

    static constraints = {
    }
}
