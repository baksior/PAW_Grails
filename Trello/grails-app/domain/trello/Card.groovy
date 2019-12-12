package trello


class Card {


    String description
    Boolean isArchived = false
    String attachment
    String[] labels


    static belongsTo = [column: Column]
    static hasMany = [comments: Comment]

    static constraints = {
        attachment nullable: true
    }
}
