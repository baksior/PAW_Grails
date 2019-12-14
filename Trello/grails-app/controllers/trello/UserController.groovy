package trello


import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

class UserController extends RestfulController {
    static responseFormats = ['json', 'xml']
    static allowedMethods = [register: "POST"]

    UserController() {
        super(User)
    }

    def springSecurityService

    @Secured('permitAll')
    def register(){

        def u = User.findByUsername(request.JSON.username)
        if(u == null){
            def newUser = new User(request.JSON.username, request.JSON.password).save()
            def role = Role.findByAuthority('ROLE_USER')

            UserRole.create newUser, role

                UserRole.withTransaction { status ->
                    UserRole.withSession {
                        it.flush()
                        it.clear()
                    }
                }

            render "1"
        } else {

            render "0"

        }

    }

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
