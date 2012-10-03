package hascstudy

import org.springframework.dao.DataIntegrityViolationException

class DashboardReportController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [dashboardReportInstanceList: DashboardReport.list(params), dashboardReportInstanceTotal: DashboardReport.count()]
    }

    def create() {
        [dashboardReportInstance: new DashboardReport(params)]
    }

    def save() {
        def dashboardReportInstance = new DashboardReport(params)
        if (!dashboardReportInstance.save(flush: true)) {
            render(view: "create", model: [dashboardReportInstance: dashboardReportInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'dashboardReport.label', default: 'DashboardReport'), dashboardReportInstance.id])
        redirect(action: "show", id: dashboardReportInstance.id)
    }

    def show() {
        def dashboardReportInstance = DashboardReport.get(params.id)
        if (!dashboardReportInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'dashboardReport.label', default: 'DashboardReport'), params.id])
            redirect(action: "list")
            return
        }

        [dashboardReportInstance: dashboardReportInstance]
    }

    def edit() {
        def dashboardReportInstance = DashboardReport.get(params.id)
        if (!dashboardReportInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'dashboardReport.label', default: 'DashboardReport'), params.id])
            redirect(action: "list")
            return
        }

        [dashboardReportInstance: dashboardReportInstance]
    }

    def update() {
        def dashboardReportInstance = DashboardReport.get(params.id)
        if (!dashboardReportInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'dashboardReport.label', default: 'DashboardReport'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (dashboardReportInstance.version > version) {
                dashboardReportInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'dashboardReport.label', default: 'DashboardReport')] as Object[],
                          "Another user has updated this DashboardReport while you were editing")
                render(view: "edit", model: [dashboardReportInstance: dashboardReportInstance])
                return
            }
        }

        dashboardReportInstance.properties = params

        if (!dashboardReportInstance.save(flush: true)) {
            render(view: "edit", model: [dashboardReportInstance: dashboardReportInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'dashboardReport.label', default: 'DashboardReport'), dashboardReportInstance.id])
        redirect(action: "show", id: dashboardReportInstance.id)
    }

    def delete() {
        def dashboardReportInstance = DashboardReport.get(params.id)
        if (!dashboardReportInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'dashboardReport.label', default: 'DashboardReport'), params.id])
            redirect(action: "list")
            return
        }

        try {
            dashboardReportInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'dashboardReport.label', default: 'DashboardReport'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'dashboardReport.label', default: 'DashboardReport'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
