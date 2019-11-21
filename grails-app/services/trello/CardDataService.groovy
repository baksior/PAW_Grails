package trello

import grails.gorm.services.Service

@Service(Card)
interface CardDataService {

    Card save(String description)
    Card save(Card card)



}