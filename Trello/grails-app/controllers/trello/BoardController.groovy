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
    def getColumns() {

        def b = Board.get(params.id)


            render b.columns as JSON


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
