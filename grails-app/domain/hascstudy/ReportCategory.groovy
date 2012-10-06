package hascstudy

class ReportCategory {

	Integer id
	String name
	String description

    static constraints = {
		name(blank: false)
		description(blank: false)
    }
    
    	  String toString(){
    return name
    }
}
