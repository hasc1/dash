package hascstudy

import org.springframework.dao.DataIntegrityViolationException

class UserController {

	def login = {}
	
   def authenticate = {
		def user = User.findByUserNameAndPassword(params.userName, params.password)
		if(user){
			session["user"] = user
			flash.message = "Hello ${user.firstName}!"
			//redirect(controller: "HospitalData", action: "list")
			render(view: "loggedin", model: [userInstance: user])
		}  else{
		flash.message = "Sorry, ${params.userName}. Please try again."
		redirect(action:"login")
		}
	}
   
   def loggedin(long id) {
	   def user = User.get(id)
	   render(view: "loggedin", model: [userInstance: user])
	   //redirect(action:"loggedin")
   }
	
   def logout = {
		flash.message = "Goodbye ${session.user.firstName}"
		session["user"] = null
		redirect(action:"login")
	}
   
   static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
		if (session.user)
			redirect(action: "show")
		else
        	redirect(action: "login")
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [userInstanceList: User.list(params), userInstanceTotal: User.count()]
    }

    def create() {
        [userInstance: new User(params)]
		//redirect(action: 'login')
    }

    def save() {
        def userInstance = new User(params)
        if (!userInstance.save(flush: true)) {
            render(view: "create", model: [userInstance: userInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
		redirect(action: "login")
		//redirect(action: "show", id: userInstance.id)
    }

    def show(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        [userInstance: userInstance]
    }

    def edit(Long id) {
	//def edit() {
        def userInstance = User.get(id)
		//def userInstance2 = session["user"]
        if (!userInstance) {
            flash.message = message(code: 'You are not logged in', args: [message(code: 'user.label', default: 'User')])
            redirect(action: "login")
            return
        }

        [userInstance: userInstance]
		render(view: "edit2", model: [userInstance: userInstance])
    }

    def update(Long id, Long version) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (userInstance.version > version) {
                userInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'user.label', default: 'User')] as Object[],
                          "Another user has updated this User while you were editing")
                render(view: "edit", model: [userInstance: userInstance])
                return
            }
        }

        userInstance.properties = params

        if (!userInstance.save(flush: true)) {
            render(view: "edit", model: [userInstance: userInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(action: "show", id: userInstance.id)
    }

    def delete(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "login")
            return
        }

        try {
            userInstance.delete(flush: true)
			session["user"] = null
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "login")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "show", id: id)
        }
    }
}
