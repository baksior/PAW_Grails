package trello

import grails.rest.Resource

@Resource(uri = '/card_assignment')

class CardAssignment {

	Integer cardId
	Integer userId

    static constraints = {
    }
}
