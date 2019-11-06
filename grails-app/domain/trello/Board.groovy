package trello

import grails.rest.Resource

@Resource(uri = '/board')

class Board {

	String name

    static constraints = {
	
		name maxSize: 255
	
    }
}
