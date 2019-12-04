package trello

import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured


class BoardController extends RestfulController {


    static responseFormats = ['json', 'xml']
    BoardController() {
        super(Board)
    }

    @Secured('ROLE_USER')
    def getColumns(Integer id) {

        def b = Board.get(id)

        render b.columns
    }

    @Secured('permitAll')
    @Override
    def index(Integer max) {
        super.index(max)
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
