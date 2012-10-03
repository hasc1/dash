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
    }
    
    String toString(){
    	return description
    }
}
