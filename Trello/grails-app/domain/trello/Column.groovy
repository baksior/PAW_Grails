package trello

class Column {

    String title

    static hasMany = [cards: Card]

    static belongsTo = [board: Board]

    static constraints = {
    }
}
