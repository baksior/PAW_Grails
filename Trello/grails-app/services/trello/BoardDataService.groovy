package trello

import grails.gorm.services.Service

@Service(Board)
interface BoardDataService {
    Board save(String name)
}