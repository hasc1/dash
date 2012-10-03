package hascstudy



import org.junit.*
import grails.test.mixin.*

@TestFor(GraphTypeController)
@Mock(GraphType)
class GraphTypeControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/graphType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.graphTypeInstanceList.size() == 0
        assert model.graphTypeInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.graphTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.graphTypeInstance != null
        assert view == '/graphType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/graphType/show/1'
        assert controller.flash.message != null
        assert GraphType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/graphType/list'


        populateValidParams(params)
        def graphType = new GraphType(params)

        assert graphType.save() != null

        params.id = graphType.id

        def model = controller.show()

        assert model.graphTypeInstance == graphType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/graphType/list'


        populateValidParams(params)
        def graphType = new GraphType(params)

        assert graphType.save() != null

        params.id = graphType.id

        def model = controller.edit()

        assert model.graphTypeInstance == graphType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/graphType/list'

        response.reset()


        populateValidParams(params)
        def graphType = new GraphType(params)

        assert graphType.save() != null

        // test invalid parameters in update
        params.id = graphType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/graphType/edit"
        assert model.graphTypeInstance != null

        graphType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/graphType/show/$graphType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        graphType.clearErrors()

        populateValidParams(params)
        params.id = graphType.id
        params.version = -1
        controller.update()

        assert view == "/graphType/edit"
        assert model.graphTypeInstance != null
        assert model.graphTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/graphType/list'

        response.reset()

        populateValidParams(params)
        def graphType = new GraphType(params)

        assert graphType.save() != null
        assert GraphType.count() == 1

        params.id = graphType.id

        controller.delete()

        assert GraphType.count() == 0
        assert GraphType.get(graphType.id) == null
        assert response.redirectedUrl == '/graphType/list'
    }
}
