package hascstudy

class User {
	Integer id
	String  userName
	String firstName
	String lastName
    String role
    Hospital hospital
	String password
	
	static constraints = {
		userName(unique: true, blank: false)
		password(password: true, blank: false)
		firstName()
		lastName()
		role(blank: false)
		hospital(blank: true)
	}
 
	String toString() {
       return userName
    }
}
