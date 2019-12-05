package trello


import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

class UserController extends RestfulController {
    static responseFormats = ['json', 'xml']
    UserController() {
        super(User)
    }

    def springSecurityService

    @Secured('ROLE_USER')
    def getBoards() {

        User u = springSecurityService.currentUser as User

        render u.boards
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

}
