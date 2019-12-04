package trello

import grails.gorm.services.Service

@Service(Column)
interface ColumnDataService {

    Column save(String title)
    Column save(Column column)



}