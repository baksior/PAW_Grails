package trello

import grails.rest.Resource
import grails.plugin.springsecurity.annotation.Secured


@Secured('ROLE_USER')
@Resource(uri = '/api/comment')

class Comment {

    String attachment
    String commentAuthor
    String commentContent
    String commentDate


    static belongsTo = [card: Card]

    static constraints = {
        attachment nullable: true
    }
}
