package trello

import grails.rest.Resource

@Resource(uri = '/board')

class Board {

	String name
	String description
	String createdDate
	Integer  userId
	
	static hasMany = [cards: Card]

    static constraints = {
	
		name maxSize: 255
	
    }
}
