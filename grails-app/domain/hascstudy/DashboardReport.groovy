package hascstudy

class DashboardReport {
	Integer id
	String name
	String description
	float actualValue
	float targetValue
	float variance
	String status
	String statusCode
	ReportCategory reportCategory
	GraphType graphType


    static constraints = {
		name(blank: false)
		description(blank: false)
		actualValue(blank: false)
		targetValue(blank: false)
		variance()
		status()
		statusCode()
		reportCategory(blank: false)
		graphType(blank: false)
    }
    
    String toString(){
    	return description
    }
}
