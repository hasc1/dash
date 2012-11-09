package tutorapp
import hascstudy.DashboardReport

class ReportValues {
	Integer id
	float sequence
	String xValue
	float yValue
	float y1Value
	float y2Value
	float y3Value
	float y4Value
	float y5Value
	float y6Value
	DashboardReport dashboardReport
	String category
	String graphType

	static constraints = {
     category(nullable:true)
     graphType(nullable:true)
 }

    
    String toString(){
    return name
    }
}
