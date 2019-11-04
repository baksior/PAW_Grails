package trello

class BootStrap {

	BoardDataService boardDataService

    def init = { servletContext ->
	
	log.info "Loading database..."
	
	boardDataService.save("Board 1")
	boardDataService.save("Board 2")
	
    }
    def destroy = {
    }
}
