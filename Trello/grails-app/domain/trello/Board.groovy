package trello

class Board {

    String title
    String image

    static belongsTo = [user: User]

    static hasMany = [columns: Column]

    static mapping = {
        columns lazy: false
        autowire true
    }


    static constraints = {
        user nullable: true
    }

    def userService

    def beforeInsert() {

        User u = userService.getCurrUser()
        if (u != null) {
            this.user = u
        }

    }
}
