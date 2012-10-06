package hascstudy

import org.springframework.dao.DataIntegrityViolationException

class QuarterController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def beforeInterceptor = [action:this.&auth]
	
 	def auth() {
		if(!session.user) {
			redirect(controller:"User", action:"login")
			return false
		}
	}

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [quarterInstanceList: Quarter.list(params), quarterInstanceTotal: Quarter.count()]
    }

    def create() {
        [quarterInstance: new Quarter(params)]
    }

    def save() {
        def quarterInstance = new Quarter(params)
        if (!quarterInstance.save(flush: true)) {
            render(view: "create", model: [quarterInstance: quarterInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'quarter.label', default: 'Quarter'), quarterInstance.id])
        redirect(action: "show", id: quarterInstance.id)
    }

    def show() {
        def quarterInstance = Quarter.get(params.id)
        if (!quarterInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'quarter.label', default: 'Quarter'), params.id])
            redirect(action: "list")
            return
        }

        [quarterInstance: quarterInstance]
    }

    def edit() {
        def quarterInstance = Quarter.get(params.id)
        if (!quarterInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'quarter.label', default: 'Quarter'), params.id])
            redirect(action: "list")
            return
        }

        [quarterInstance: quarterInstance]
    }

    def update() {
        def quarterInstance = Quarter.get(params.id)
        if (!quarterInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'quarter.label', default: 'Quarter'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (quarterInstance.version > version) {
                quarterInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'quarter.label', default: 'Quarter')] as Object[],
                          "Another user has updated this Quarter while you were editing")
                render(view: "edit", model: [quarterInstance: quarterInstance])
                return
            }
        }

        quarterInstance.properties = params

        if (!quarterInstance.save(flush: true)) {
            render(view: "edit", model: [quarterInstance: quarterInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'quarter.label', default: 'Quarter'), quarterInstance.id])
        redirect(action: "show", id: quarterInstance.id)
    }

    def delete() {
        def quarterInstance = Quarter.get(params.id)
        if (!quarterInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'quarter.label', default: 'Quarter'), params.id])
            redirect(action: "list")
            return
        }

        try {
            quarterInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'quarter.label', default: 'Quarter'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'quarter.label', default: 'Quarter'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
