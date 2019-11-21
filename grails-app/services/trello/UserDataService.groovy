package trello

import grails.gorm.services.Service

@Service(User)
interface UserDataService {

    User save(String username, String password)
    User save(User user)
    User findByUsername(String username)



}