package hascstudy

class Quarter {
	Integer id
	String  quarter

	static constraints = {
		quarter(blank: false)
	}
    
    String toString(){
    return quarter
    }
}
