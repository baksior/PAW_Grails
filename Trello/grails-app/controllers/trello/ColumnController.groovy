package trello


import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured


class ColumnController extends RestfulController {
    static responseFormats = ['json', 'xml']
    ColumnController() {
        super(Column)
    }

    @Secured('ROLE_USER')
    def getCards(Integer id) {

        def c = Column.get(id)

        render c.cards.findAllWhere(isArchived: false)
    }

    @Secured('ROLE_USER')
    def getArchivedCards(Integer id) {

        def c = Column.get(id)

        render c.cards.findAllWhere(isArchived: true)
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
