package hascstudy



import org.junit.*
import grails.test.mixin.*

@TestFor(ReportCategoryController)
@Mock(ReportCategory)
class ReportCategoryControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/reportCategory/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.reportCategoryInstanceList.size() == 0
        assert model.reportCategoryInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.reportCategoryInstance != null
    }

    void testSave() {
        controller.save()

        assert model.reportCategoryInstance != null
        assert view == '/reportCategory/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/reportCategory/show/1'
        assert controller.flash.message != null
        assert ReportCategory.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/reportCategory/list'


        populateValidParams(params)
        def reportCategory = new ReportCategory(params)

        assert reportCategory.save() != null

        params.id = reportCategory.id

        def model = controller.show()

        assert model.reportCategoryInstance == reportCategory
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/reportCategory/list'


        populateValidParams(params)
        def reportCategory = new ReportCategory(params)

        assert reportCategory.save() != null

        params.id = reportCategory.id

        def model = controller.edit()

        assert model.reportCategoryInstance == reportCategory
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/reportCategory/list'

        response.reset()


        populateValidParams(params)
        def reportCategory = new ReportCategory(params)

        assert reportCategory.save() != null

        // test invalid parameters in update
        params.id = reportCategory.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/reportCategory/edit"
        assert model.reportCategoryInstance != null

        reportCategory.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/reportCategory/show/$reportCategory.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        reportCategory.clearErrors()

        populateValidParams(params)
        params.id = reportCategory.id
        params.version = -1
        controller.update()

        assert view == "/reportCategory/edit"
        assert model.reportCategoryInstance != null
        assert model.reportCategoryInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/reportCategory/list'

        response.reset()

        populateValidParams(params)
        def reportCategory = new ReportCategory(params)

        assert reportCategory.save() != null
        assert ReportCategory.count() == 1

        params.id = reportCategory.id

        controller.delete()

        assert ReportCategory.count() == 0
        assert ReportCategory.get(reportCategory.id) == null
        assert response.redirectedUrl == '/reportCategory/list'
    }
}
