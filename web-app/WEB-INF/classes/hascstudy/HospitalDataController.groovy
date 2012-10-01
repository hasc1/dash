package hascstudy

import org.springframework.dao.DataIntegrityViolationException

class HospitalDataController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [hospitalDataInstanceList: HospitalData.list(params), hospitalDataInstanceTotal: HospitalData.count()]
    }

    def create() {
        [hospitalDataInstance: new HospitalData(params)]
    }

    def save() {
        def hospitalDataInstance = new HospitalData(params)
        if (!hospitalDataInstance.save(flush: true)) {
            render(view: "create", model: [hospitalDataInstance: hospitalDataInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'hospitalData.label', default: 'HospitalData'), hospitalDataInstance.id])
        redirect(action: "show", id: hospitalDataInstance.id)
    }

    def show() {
        def hospitalDataInstance = HospitalData.get(params.id)
        if (!hospitalDataInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'hospitalData.label', default: 'HospitalData'), params.id])
            redirect(action: "list")
            return
        }

        [hospitalDataInstance: hospitalDataInstance]
    }

    def edit() {
        def hospitalDataInstance = HospitalData.get(params.id)
        if (!hospitalDataInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'hospitalData.label', default: 'HospitalData'), params.id])
            redirect(action: "list")
            return
        }

        [hospitalDataInstance: hospitalDataInstance]
    }

    def update() {
        def hospitalDataInstance = HospitalData.get(params.id)
        if (!hospitalDataInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'hospitalData.label', default: 'HospitalData'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (hospitalDataInstance.version > version) {
                hospitalDataInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'hospitalData.label', default: 'HospitalData')] as Object[],
                          "Another user has updated this HospitalData while you were editing")
                render(view: "edit", model: [hospitalDataInstance: hospitalDataInstance])
                return
            }
        }

        hospitalDataInstance.properties = params

        if (!hospitalDataInstance.save(flush: true)) {
            render(view: "edit", model: [hospitalDataInstance: hospitalDataInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'hospitalData.label', default: 'HospitalData'), hospitalDataInstance.id])
        redirect(action: "show", id: hospitalDataInstance.id)
    }

    def delete() {
        def hospitalDataInstance = HospitalData.get(params.id)
        if (!hospitalDataInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'hospitalData.label', default: 'HospitalData'), params.id])
            redirect(action: "list")
            return
        }

        try {
            hospitalDataInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'hospitalData.label', default: 'HospitalData'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'hospitalData.label', default: 'HospitalData'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
