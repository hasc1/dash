package hascstudy

import org.springframework.dao.DataIntegrityViolationException

class GraphTypeController {

	def beforeInterceptor = [action:this.&auth]
	
 	def auth() {
		if(!session.user) {
			redirect(controller:"User", action:"login")
			return false
		}
	}

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [graphTypeInstanceList: GraphType.list(params), graphTypeInstanceTotal: GraphType.count()]
    }

    def create() {
        [graphTypeInstance: new GraphType(params)]
    }

    def save() {
        def graphTypeInstance = new GraphType(params)
        if (!graphTypeInstance.save(flush: true)) {
            render(view: "create", model: [graphTypeInstance: graphTypeInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'graphType.label', default: 'GraphType'), graphTypeInstance.id])
        redirect(action: "show", id: graphTypeInstance.id)
    }

    def show() {
        def graphTypeInstance = GraphType.get(params.id)
        if (!graphTypeInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'graphType.label', default: 'GraphType'), params.id])
            redirect(action: "list")
            return
        }

        [graphTypeInstance: graphTypeInstance]
    }

    def edit() {
        def graphTypeInstance = GraphType.get(params.id)
        if (!graphTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'graphType.label', default: 'GraphType'), params.id])
            redirect(action: "list")
            return
        }

        [graphTypeInstance: graphTypeInstance]
    }

    def update() {
        def graphTypeInstance = GraphType.get(params.id)
        if (!graphTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'graphType.label', default: 'GraphType'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (graphTypeInstance.version > version) {
                graphTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'graphType.label', default: 'GraphType')] as Object[],
                          "Another user has updated this GraphType while you were editing")
                render(view: "edit", model: [graphTypeInstance: graphTypeInstance])
                return
            }
        }

        graphTypeInstance.properties = params

        if (!graphTypeInstance.save(flush: true)) {
            render(view: "edit", model: [graphTypeInstance: graphTypeInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'graphType.label', default: 'GraphType'), graphTypeInstance.id])
        redirect(action: "show", id: graphTypeInstance.id)
    }

    def delete() {
        def graphTypeInstance = GraphType.get(params.id)
        if (!graphTypeInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'graphType.label', default: 'GraphType'), params.id])
            redirect(action: "list")
            return
        }

        try {
            graphTypeInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'graphType.label', default: 'GraphType'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'graphType.label', default: 'GraphType'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
