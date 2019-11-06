package trello

import grails.rest.Resource

@Resource(uri = '/board_member')

class BoardMember {

	Integer boardId
	Integer userId


    static constraints = {
    }
}
