package trello

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def springSecurityService

    def serviceMethod() {

    }

    User getCurrUser(){

        User u = springSecurityService.currentUser as User
        return u
    }
}
