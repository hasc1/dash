package hascstudy

class ReportCategory {

	Integer id
	String name
	String description

    static constraints = {
		name(blank: false)
		description()
    }
    
    	  String toString(){
    return name
    }
}
