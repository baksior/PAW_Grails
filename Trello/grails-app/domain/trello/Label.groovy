package trello


class Label {

    String title

    static belongsTo = [card: Card]
	
	static constraints = {
    }

}
