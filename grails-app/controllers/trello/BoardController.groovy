package trello


import grails.rest.*
import grails.converters.*

class BoardController extends RestfulController {
    static responseFormats = ['json', 'xml']
    BoardController() {
        super(Board)
    }

    def getColumns(Integer id) {

        def b = Board.get(id)

        render b.columns
    }

}
