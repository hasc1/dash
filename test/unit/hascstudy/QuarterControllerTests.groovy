package hascstudy



import org.junit.*
import grails.test.mixin.*

@TestFor(QuarterController)
@Mock(Quarter)
class QuarterControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/quarter/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.quarterInstanceList.size() == 0
        assert model.quarterInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.quarterInstance != null
    }

    void testSave() {
        controller.save()

        assert model.quarterInstance != null
        assert view == '/quarter/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/quarter/show/1'
        assert controller.flash.message != null
        assert Quarter.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/quarter/list'


        populateValidParams(params)
        def quarter = new Quarter(params)

        assert quarter.save() != null

        params.id = quarter.id

        def model = controller.show()

        assert model.quarterInstance == quarter
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/quarter/list'


        populateValidParams(params)
        def quarter = new Quarter(params)

        assert quarter.save() != null

        params.id = quarter.id

        def model = controller.edit()

        assert model.quarterInstance == quarter
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/quarter/list'

        response.reset()


        populateValidParams(params)
        def quarter = new Quarter(params)

        assert quarter.save() != null

        // test invalid parameters in update
        params.id = quarter.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/quarter/edit"
        assert model.quarterInstance != null

        quarter.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/quarter/show/$quarter.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        quarter.clearErrors()

        populateValidParams(params)
        params.id = quarter.id
        params.version = -1
        controller.update()

        assert view == "/quarter/edit"
        assert model.quarterInstance != null
        assert model.quarterInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/quarter/list'

        response.reset()

        populateValidParams(params)
        def quarter = new Quarter(params)

        assert quarter.save() != null
        assert Quarter.count() == 1

        params.id = quarter.id

        controller.delete()

        assert Quarter.count() == 0
        assert Quarter.get(quarter.id) == null
        assert response.redirectedUrl == '/quarter/list'
    }
}
