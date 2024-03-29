package trello


class Card {

    String name
    String description
    Boolean isArchived = false
    String attachment


    static belongsTo = [column: Column]
    static hasMany = [comments: Comment]

    static constraints = {
        attachment nullable: true
    }
}
