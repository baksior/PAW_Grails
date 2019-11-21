package trello


import grails.rest.*
import grails.converters.*

class ColumnController extends RestfulController {
    static responseFormats = ['json', 'xml']
    ColumnController() {
        super(Column)
    }

    def getCards(Integer id) {

        def c = Column.get(id)

        render c.cards
    }

}
