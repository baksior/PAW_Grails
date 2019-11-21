package trello

class BootStrap {

    BoardDataService boardDataService
    CardDataService cardDataService
    ColumnDataService columnDataService
    UserDataService userDataService


    def init = { servletContext ->

        Board board = new Board(title: "board1", image: "http://dawiq.lh.pl/Trellol//images/lolImg.jpg")
        Card card = new Card(description: "card1")
        Column column = new Column(title: "column1")
        User user = new User(username: "user1", password: "user1")

        column.addToCards(card)

        board.addToColumns(column)

        user.addToBoards(board)

        userDataService.save(user)

        Board board2 = new Board(title: "board2", image: "http://dawiq.lh.pl/Trellol//images/lolImg.jpg")

        user.addToBoards(board2)

        userDataService.save(user)

    }
    def destroy = {
    }
}
