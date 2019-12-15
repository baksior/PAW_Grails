package trello


import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured


class CardController extends RestfulController {
    static responseFormats = ['json', 'xml']
    CardController() {
        super(Card)
    }

    @Secured('permitAll')
    @Override
    def index(Integer max) {
        super.index(max)
    }

    @Secured('ROLE_USER')
    def getComments() {

        def c = Card.get(params.id)

        render c.comments as JSON
    }

    @Secured('ROLE_USER')
    def getArchivedCards(){

        def c = Card.get(params.id)

        render c.findAllWhere(isArchived: true) as JSON

    }

    @Secured('ROLE_USER')
    @Override
    def show() {
        super.show()
    }

    @Secured('ROLE_USER')
    @Override
    def save() {
        super.save()
    }

    @Secured('ROLE_USER')
    @Override
    def update() {
        super.update()
    }

    @Secured('ROLE_USER')
    @Override
    def delete() {
        super.delete()
    }
}
