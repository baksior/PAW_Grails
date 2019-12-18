package trello

class BootStrap {

    BoardDataService boardDataService
    CardDataService cardDataService
    ColumnDataService columnDataService
    UserDataService userDataService


    def init = { servletContext ->

        Board board = new Board(title: "board1", image: "http://dawiq.lh.pl/Trellol//images/lolImg.jpg", state: "active")
        Card card = new Card(name: "card1", description: "card1 desc")
        Column column = new Column(title: "column1")
        Column column2 = new Column(title: "column2")
        Column column3 = new Column(title: "column3")
        Comment comment = new Comment(commentContent: "comment1", commentAuthor: "Dawiq")

        column.addToCards(card)

        board.addToColumns(column)
        board.addToColumns(column2)

        card.addToComments(comment)

        def adminRole = new Role('ROLE_ADMIN').save()
        def userRole = new Role('ROLE_USER').save()

        def testUser = new User('me', 'password').save()
        def adminUser = new User('admin', 'admin').save()


        UserRole.create testUser, userRole
        UserRole.create adminUser, adminRole

        UserRole.withTransaction { status ->
            UserRole.withSession {
                it.flush()
                it.clear()
            }
        }

        testUser.addToBoards(board)

        userDataService.save(testUser)

        Board board2 = new Board(title: "board2", image: "http://dawiq.lh.pl/Trellol//images/lolImg.jpg", state: "active")

        board2.addToColumns(column3)

       testUser.addToBoards(board2)

        userDataService.save(testUser)

        Board board3 = new Board(title: "board3", image: "http://dawiq.lh.pl/Trellol//images/lolImg.jpg", state: "active")
        adminUser.addToBoards(board3)
        userDataService.save(adminUser)

        assert User.count() == 2
        assert Role.count() == 2
        assert UserRole.count() == 2


    }
    def destroy = {
    }
}
