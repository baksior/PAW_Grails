package trello

import grails.rest.Resource

@Resource(uri = '/user')

class User {

	String name
	String emailAddress
	String firstName
	String lastName
	String password
	String createdDate
	
	static hasMany = [boards: Board]

    static constraints = {
    }
}
