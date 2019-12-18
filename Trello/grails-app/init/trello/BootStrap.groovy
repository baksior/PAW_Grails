package trello

class BootStrap {

    BoardDataService boardDataService
    CardDataService cardDataService
    ColumnDataService columnDataService
    UserDataService userDataService


    def init = { servletContext ->

        Board board = new Board(title: "board1")
        Card card = new Card(description: "card1", labels: ["test", "test1"])
        Column column = new Column(title: "column1")
        Label label = new Label(title: "label1")
        //card.addToLabels(label)

        column.addToCards(card)

        board.addToColumns(column)


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

        Board board2 = new Board(title: "board2")

       testUser.addToBoards(board2)

        userDataService.save(testUser)

        assert User.count() == 2
        assert Role.count() == 2
        assert UserRole.count() == 2


    }
    def destroy = {
    }
}
