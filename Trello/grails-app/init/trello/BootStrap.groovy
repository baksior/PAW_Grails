package trello

class BootStrap {

    BoardDataService boardDataService
    CardDataService cardDataService
    ColumnDataService columnDataService
    UserDataService userDataService


    def init = { servletContext ->

        Board board = new Board(title: "board1")
        Card card = new Card(description: "card1")
        Column column = new Column(title: "column1")
        Column column2 = new Column(title: "column2")
        Column column3 = new Column(title: "column3")
		Label label1 = new Label(title: "label1")
		card.addToLabels(label1)
		
        column.addToCards(card)

        board.addToColumns(column)
        board.addToColumns(column2)


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

        board2.addToColumns(column3)

       testUser.addToBoards(board2)

        userDataService.save(testUser)

        Board board3 = new Board(title: "board3")
        adminUser.addToBoards(board3)
        userDataService.save(adminUser)

        assert User.count() == 2
        assert Role.count() == 2
        assert UserRole.count() == 2


    }
    def destroy = {
    }
}
