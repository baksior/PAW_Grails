package trello


import grails.rest.*
import grails.converters.*

class UserController extends RestfulController {
    static responseFormats = ['json', 'xml']
    UserController() {
        super(User)
    }

    def getBoards(Integer id) {

        def u = User.get(id)

        render u.boards
    }

    UserDataService userDataService

    def auth(String username, String password){

        def u = userDataService.findByUsername(username)

        if(u != null && u.password == password){
            render u.id
        } else {
            render "-1"
        }
    }

}
