import grails.util.GrailsUtil
import hascstudy.DashboardReport
import hascstudy.GraphType
import hascstudy.ReportCategory
import hascstudy.Hospital
import hascstudy.Quarter
import hascstudy.HospitalData
import hascstudy.User

class BootStrap {

    def init = { servletContext ->
		switch(GrailsUtil.environment){
			case "development":

		User.executeUpdate('delete from User')
		HospitalData.executeUpdate('delete from HospitalData')
		DashboardReport.executeUpdate('delete from DashboardReport')
		GraphType.executeUpdate('delete from GraphType')
		ReportCategory.executeUpdate('delete from ReportCategory')
		Hospital.executeUpdate('delete from Hospital')
		Quarter.executeUpdate('delete from Quarter')
		
    	if (!hascstudy.Hospital.count()) 
    	{
    	def hospital = new hascstudy.Hospital(hospitalName:"Hospital1")
        hospital.save()
        hospital = new hascstudy.Hospital(hospitalName:"Hospital2")
        hospital.save()
        hospital = new hascstudy.Hospital(hospitalName:"Hospital3")
        hospital.save()
        hospital = new hascstudy.Hospital(hospitalName:"Hospital4")
        hospital.save()
        hospital = new hascstudy.Hospital(hospitalName:"Hospital5")
        hospital.save()
        }
        
        //if (!hascstudy.Quarter.count()) 
    	//{
		def quarter = new hascstudy.Quarter(quarter:"Quarter1")
        quarter.save()

        quarter = new hascstudy.Quarter(quarter:"Quarter2")
        quarter.save()

        quarter = new hascstudy.Quarter(quarter:"Quarter3")
        quarter.save()
		
		
		def graphtype = new hascstudy.GraphType(name:"Pie")
		graphtype.save()

		graphtype = new hascstudy.GraphType(name:"Bar")
		graphtype.save()

		graphtype = new hascstudy.GraphType(name:"Line")
		graphtype.save()

		graphtype = new hascstudy.GraphType(name:"Radar")
		graphtype.save()

		graphtype = new hascstudy.GraphType(name:"RadarLine")
		graphtype.save()

		def reportCategory = new hascstudy.ReportCategory(name:"HASC Study",description:"HASC Study")
		reportCategory.save()

		reportCategory = new hascstudy.ReportCategory(name:"Operational Analytics",description:"Operational Analytics")
		reportCategory.save()

		reportCategory = new hascstudy.ReportCategory(name:"Industry Benchmarks",description:"Industry Benchmarks")
		reportCategory.save()

		reportCategory = new hascstudy.ReportCategory(name:"Patient Flow",description:"Patient Flow")
		reportCategory.save()

		reportCategory = new hascstudy.ReportCategory(name:"Track Assets",description:"Track Assets")
		reportCategory.save()

		reportCategory = new hascstudy.ReportCategory(name:"Score Collaborative",description:"Score Collaborative")
		reportCategory.save()

		def dashboardReport = new hascstudy.DashboardReport(
			name:"OR Usage",
			description:"OR Usage",
			actualValue:1,
			targetValue:0,
			variance:1,
			status:"Ok",
			statusCode:"Ok",)
		def ReportCategory reportCategoryLookup = ReportCategory.findByName("HASC Study")
		def GraphType graphTypeLookup = GraphType.findByName("Bar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Wait Times",
			description:"Wait Times",
			actualValue:2,
			targetValue:0,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("HASC Study")
		graphTypeLookup = GraphType.findByName("Bar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Wait Times",
			description:"Wait Times",
			actualValue:2,
			targetValue:0,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("HASC Study")
		graphTypeLookup = GraphType.findByName("Bar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Nursing Unit - Length of Stay",
			description:"Nursing Unit - Length of Stay",
			actualValue:6,
			targetValue:0,
			variance:0,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("Industry Benchmarks")
		graphTypeLookup = GraphType.findByName("Pie")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Operational Analysis Overview",
			description:"Operational Analysis Overview",
			actualValue:10,
			targetValue:80,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("Operational Analytics")
		graphTypeLookup = GraphType.findByName("Radar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Patient Arrival by Hour",
			description:"Patient Arrival by Hour",
			actualValue:11,
			targetValue:80,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("Operational Analytics")
		graphTypeLookup = GraphType.findByName("Bar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Patient Arrival by Day",
			description:"Patient Arrival by Day",
			actualValue:12,
			targetValue:80,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("Operational Analytics")
		graphTypeLookup = GraphType.findByName("Bar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Avg time to procedure",
			description:"Avg time to procedure",
			actualValue:13,
			targetValue:0,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("Operational Analytics")
		graphTypeLookup = GraphType.findByName("Bar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Avg Time in Procedure",
			description:"Avg Time in Procedure",
			actualValue:14,
			targetValue:0,
			variance:2,
			status:"Warning",
			statusCode:"Warning",)
		reportCategoryLookup = ReportCategory.findByName("Operational Analytics")
		graphTypeLookup = GraphType.findByName("Bar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"ER Benchmarks",
			description:"ER Benchmarks",
			actualValue:50,
			targetValue:0,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("Industry Benchmarks")
		graphTypeLookup = GraphType.findByName("Radar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"OR Benchmarks",
			description:"OR Benchmarks",
			actualValue:51,
			targetValue:0,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("Industry Benchmarks")
		graphTypeLookup = GraphType.findByName("Radar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Satisfaction Rating Benchmarks",
			description:"Satisfaction Rating Benchmarks",
			actualValue:52,
			targetValue:0,
			variance:2,
			status:"Warning",
			statusCode:"Warning",)
		reportCategoryLookup = ReportCategory.findByName("Industry Benchmarks")
		graphTypeLookup = GraphType.findByName("Bar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Wait Times by Time of Day",
			description:"Wait Times by Time of Day",
			actualValue:60,
			targetValue:0,
			variance:2,
			status:"Warning",
			statusCode:"Warning",)
		reportCategoryLookup = ReportCategory.findByName("Patient Flow")
		graphTypeLookup = GraphType.findByName("Line")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"OR Status",
			description:"OR Status",
			actualValue:61,
			targetValue:0,
			variance:2,
			status:"Warning",
			statusCode:"Warning",)
		reportCategoryLookup = ReportCategory.findByName("Patient Flow")
		graphTypeLookup = GraphType.findByName("Bar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Location Patient Flow",
			description:"Location Patient Flow",
			actualValue:62,
			targetValue:0,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("Patient Flow")
		graphTypeLookup = GraphType.findByName("Bar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Patient Queue",
			description:"Patient Queue",
			actualValue:63,
			targetValue:0,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("Patient Flow")
		graphTypeLookup = GraphType.findByName("Bar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Asset Locator",
			description:"Asset Locator",
			actualValue:70,
			targetValue:0,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("Track Assets")
		graphTypeLookup = GraphType.findByName("Bar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Asset Locator - Map",
			description:"Asset Locator - Map",
			actualValue:71,
			targetValue:0,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("Track Assets")
		graphTypeLookup = GraphType.findByName("Bar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Peer Comparisons",
			description:"Peer Comparisons",
			actualValue:80,
			targetValue:0,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("Score Collaborative")
		graphTypeLookup = GraphType.findByName("Radar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Utilization Performance",
			description:"Utilization Performance",
			actualValue:81,
			targetValue:0,
			variance:2,
			status:"Warning",
			statusCode:"Warning",)
		reportCategoryLookup = ReportCategory.findByName("Score Collaborative")
		graphTypeLookup = GraphType.findByName("Radar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Supplies",
			description:"Supplies",
			actualValue:82,
			targetValue:0,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("Score Collaborative")
		graphTypeLookup = GraphType.findByName("Bar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Labor Productivity",
			description:"Labor Productivity",
			actualValue:83,
			targetValue:0,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("Score Collaborative")
		graphTypeLookup = GraphType.findByName("Radar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Room Utilization",
			description:"Room Utilization",
			actualValue:84,
			targetValue:0,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("Score Collaborative")
		graphTypeLookup = GraphType.findByName("Bar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Turnaround Times",
			description:"Turnaround Times",
			actualValue:85,
			targetValue:0,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("Score Collaborative")
		graphTypeLookup = GraphType.findByName("Bar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Utilization by Room",
			description:"Utilization by Room",
			actualValue:86,
			targetValue:0,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("Operational Analytics")
		graphTypeLookup = GraphType.findByName("Bar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()

		dashboardReport = new hascstudy.DashboardReport(
			name:"Ontime Starts",
			description:"Ontime Starts",
			actualValue:87,
			targetValue:0,
			variance:2,
			status:"Ok",
			statusCode:"Ok",)
		reportCategoryLookup = ReportCategory.findByName("Score Collaborative")
		graphTypeLookup = GraphType.findByName("Bar")
		dashboardReport.reportCategory = reportCategoryLookup
		dashboardReport.graphType = graphTypeLookup
		dashboardReport.save()



		def admin = new hascstudy.User(
			userName:"admin",
			password:"password",
			firstName:"Administrator",
			lastName:"Admin",
			role:"admin")
			def Hospital hospitalLookup = Hospital.findByHospitalName("Hospital1")
			admin.hospital = hospitalLookup
			admin.save()
		
		def jdoe = new hascstudy.User(
			userName:"johndoe",
			password:"password",
			firstName:"John",
			lastName:"Doe",
			role:"Doctor")
				jdoe.hospital = hospitalLookup
				jdoe.save()
		
		def jsmith = new hascstudy.User(
		userName:"janedoe",
			password:"password",
			firstName:"Jane",
			lastName:"Doe",
			role:"Doctor")
			
		jsmith.hospital = hospitalLookup
		jsmith.save()
		
		break
		
		case "production":
		break
		
		
		       // }
	}
	}
    def destroy = {
    }
}
