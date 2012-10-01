package hascstudy



import org.junit.*
import grails.test.mixin.*

@TestFor(HospitalDataController)
@Mock(HospitalData)
class HospitalDataControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/hospitalData/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.hospitalDataInstanceList.size() == 0
        assert model.hospitalDataInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.hospitalDataInstance != null
    }

    void testSave() {
        controller.save()

        assert model.hospitalDataInstance != null
        assert view == '/hospitalData/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/hospitalData/show/1'
        assert controller.flash.message != null
        assert HospitalData.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/hospitalData/list'


        populateValidParams(params)
        def hospitalData = new HospitalData(params)

        assert hospitalData.save() != null

        params.id = hospitalData.id

        def model = controller.show()

        assert model.hospitalDataInstance == hospitalData
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/hospitalData/list'


        populateValidParams(params)
        def hospitalData = new HospitalData(params)

        assert hospitalData.save() != null

        params.id = hospitalData.id

        def model = controller.edit()

        assert model.hospitalDataInstance == hospitalData
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/hospitalData/list'

        response.reset()


        populateValidParams(params)
        def hospitalData = new HospitalData(params)

        assert hospitalData.save() != null

        // test invalid parameters in update
        params.id = hospitalData.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/hospitalData/edit"
        assert model.hospitalDataInstance != null

        hospitalData.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/hospitalData/show/$hospitalData.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        hospitalData.clearErrors()

        populateValidParams(params)
        params.id = hospitalData.id
        params.version = -1
        controller.update()

        assert view == "/hospitalData/edit"
        assert model.hospitalDataInstance != null
        assert model.hospitalDataInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/hospitalData/list'

        response.reset()

        populateValidParams(params)
        def hospitalData = new HospitalData(params)

        assert hospitalData.save() != null
        assert HospitalData.count() == 1

        params.id = hospitalData.id

        controller.delete()

        assert HospitalData.count() == 0
        assert HospitalData.get(hospitalData.id) == null
        assert response.redirectedUrl == '/hospitalData/list'
    }
}
