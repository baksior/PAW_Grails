package trello


class Card {


    String description
    Boolean isArchived = false
    String attachment


    static belongsTo = [column: Column]
    static hasMany = [comments: Comment, labels: Label]

    static constraints = {
        attachment nullable: true
    }
}
