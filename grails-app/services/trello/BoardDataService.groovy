package trello

import grails.gorm.services.Service

@Service(Board)
interface BoardDataService {

    Board save(String title)
    Board save(Board board)
}
