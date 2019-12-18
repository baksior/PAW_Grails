package trello


import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured


class LabelController extends RestfulController {
    static responseFormats = ['json', 'xml']
    LabelController() {
        super(Label)
    }

    @Secured('permitAll')
    @Override
    def index(Integer max) {
        super.index(max)
    }

    @Secured('ROLE_USER')
    @Override
    def show() {
        super.show()
    }

    @Secured('ROLE_USER')
    @Override
    def save() {
        super.save()
    }

    @Secured('ROLE_USER')
    @Override
    def update() {
        super.update()
    }

    @Secured('ROLE_USER')
    @Override
    def delete() {
        super.delete()
    }
}
