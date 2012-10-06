package hascstudy

class GraphType {
	Integer id
	String name

    static constraints = {
		name(blank: false)
    }
    
    String toString(){
    return name
    }
}
