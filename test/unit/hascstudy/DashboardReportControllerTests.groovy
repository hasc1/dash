package hascstudy



import org.junit.*
import grails.test.mixin.*

@TestFor(DashboardReportController)
@Mock(DashboardReport)
class DashboardReportControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/dashboardReport/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.dashboardReportInstanceList.size() == 0
        assert model.dashboardReportInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.dashboardReportInstance != null
    }

    void testSave() {
        controller.save()

        assert model.dashboardReportInstance != null
        assert view == '/dashboardReport/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/dashboardReport/show/1'
        assert controller.flash.message != null
        assert DashboardReport.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/dashboardReport/list'


        populateValidParams(params)
        def dashboardReport = new DashboardReport(params)

        assert dashboardReport.save() != null

        params.id = dashboardReport.id

        def model = controller.show()

        assert model.dashboardReportInstance == dashboardReport
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/dashboardReport/list'


        populateValidParams(params)
        def dashboardReport = new DashboardReport(params)

        assert dashboardReport.save() != null

        params.id = dashboardReport.id

        def model = controller.edit()

        assert model.dashboardReportInstance == dashboardReport
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/dashboardReport/list'

        response.reset()


        populateValidParams(params)
        def dashboardReport = new DashboardReport(params)

        assert dashboardReport.save() != null

        // test invalid parameters in update
        params.id = dashboardReport.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/dashboardReport/edit"
        assert model.dashboardReportInstance != null

        dashboardReport.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/dashboardReport/show/$dashboardReport.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        dashboardReport.clearErrors()

        populateValidParams(params)
        params.id = dashboardReport.id
        params.version = -1
        controller.update()

        assert view == "/dashboardReport/edit"
        assert model.dashboardReportInstance != null
        assert model.dashboardReportInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/dashboardReport/list'

        response.reset()

        populateValidParams(params)
        def dashboardReport = new DashboardReport(params)

        assert dashboardReport.save() != null
        assert DashboardReport.count() == 1

        params.id = dashboardReport.id

        controller.delete()

        assert DashboardReport.count() == 0
        assert DashboardReport.get(dashboardReport.id) == null
        assert response.redirectedUrl == '/dashboardReport/list'
    }
}
