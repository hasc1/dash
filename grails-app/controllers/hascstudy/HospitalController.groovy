package hascstudy

import org.springframework.dao.DataIntegrityViolationException

class HospitalController {

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
        [hospitalInstanceList: Hospital.list(params), hospitalInstanceTotal: Hospital.count()]
    }

    def create() {
        [hospitalInstance: new Hospital(params)]
    }

    def save() {
        def hospitalInstance = new Hospital(params)
        if (!hospitalInstance.save(flush: true)) {
            render(view: "create", model: [hospitalInstance: hospitalInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'hospital.label', default: 'Hospital'), hospitalInstance.id])
        redirect(action: "show", id: hospitalInstance.id)
    }

    def show() {
        def hospitalInstance = Hospital.get(params.id)
        if (!hospitalInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'hospital.label', default: 'Hospital'), params.id])
            redirect(action: "list")
            return
        }

        [hospitalInstance: hospitalInstance]
    }

    def edit() {
        def hospitalInstance = Hospital.get(params.id)
        if (!hospitalInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'hospital.label', default: 'Hospital'), params.id])
            redirect(action: "list")
            return
        }

        [hospitalInstance: hospitalInstance]
    }

    def update() {
        def hospitalInstance = Hospital.get(params.id)
        if (!hospitalInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'hospital.label', default: 'Hospital'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (hospitalInstance.version > version) {
                hospitalInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'hospital.label', default: 'Hospital')] as Object[],
                          "Another user has updated this Hospital while you were editing")
                render(view: "edit", model: [hospitalInstance: hospitalInstance])
                return
            }
        }

        hospitalInstance.properties = params

        if (!hospitalInstance.save(flush: true)) {
            render(view: "edit", model: [hospitalInstance: hospitalInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'hospital.label', default: 'Hospital'), hospitalInstance.id])
        redirect(action: "show", id: hospitalInstance.id)
    }

    def delete() {
        def hospitalInstance = Hospital.get(params.id)
        if (!hospitalInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'hospital.label', default: 'Hospital'), params.id])
            redirect(action: "list")
            return
        }

        try {
            hospitalInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'hospital.label', default: 'Hospital'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'hospital.label', default: 'Hospital'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
