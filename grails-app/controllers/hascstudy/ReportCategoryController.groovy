package hascstudy

import org.springframework.dao.DataIntegrityViolationException

class ReportCategoryController {

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
        [reportCategoryInstanceList: ReportCategory.list(params), reportCategoryInstanceTotal: ReportCategory.count()]
    }

    def create() {
        [reportCategoryInstance: new ReportCategory(params)]
    }

    def save() {
        def reportCategoryInstance = new ReportCategory(params)
        if (!reportCategoryInstance.save(flush: true)) {
            render(view: "create", model: [reportCategoryInstance: reportCategoryInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'reportCategory.label', default: 'ReportCategory'), reportCategoryInstance.id])
        redirect(action: "show", id: reportCategoryInstance.id)
    }

    def show() {
        def reportCategoryInstance = ReportCategory.get(params.id)
        if (!reportCategoryInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'reportCategory.label', default: 'ReportCategory'), params.id])
            redirect(action: "list")
            return
        }

        [reportCategoryInstance: reportCategoryInstance]
    }

    def edit() {
        def reportCategoryInstance = ReportCategory.get(params.id)
        if (!reportCategoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reportCategory.label', default: 'ReportCategory'), params.id])
            redirect(action: "list")
            return
        }

        [reportCategoryInstance: reportCategoryInstance]
    }

    def update() {
        def reportCategoryInstance = ReportCategory.get(params.id)
        if (!reportCategoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reportCategory.label', default: 'ReportCategory'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (reportCategoryInstance.version > version) {
                reportCategoryInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'reportCategory.label', default: 'ReportCategory')] as Object[],
                          "Another user has updated this ReportCategory while you were editing")
                render(view: "edit", model: [reportCategoryInstance: reportCategoryInstance])
                return
            }
        }

        reportCategoryInstance.properties = params

        if (!reportCategoryInstance.save(flush: true)) {
            render(view: "edit", model: [reportCategoryInstance: reportCategoryInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'reportCategory.label', default: 'ReportCategory'), reportCategoryInstance.id])
        redirect(action: "show", id: reportCategoryInstance.id)
    }

    def delete() {
        def reportCategoryInstance = ReportCategory.get(params.id)
        if (!reportCategoryInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'reportCategory.label', default: 'ReportCategory'), params.id])
            redirect(action: "list")
            return
        }

        try {
            reportCategoryInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'reportCategory.label', default: 'ReportCategory'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'reportCategory.label', default: 'ReportCategory'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
