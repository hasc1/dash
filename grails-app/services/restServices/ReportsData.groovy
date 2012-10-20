package restServices

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.*
import hascstudy.DashboardReport

class ReportData {

    def jsonList() {
    	def clientRequest = request.getHeader("accept")
  		def serverResponse = request.format
  		def requestMethod = request.method
  		println "Client: ${clientRequest}\nServer: ${serverResponse}\n  ${requestMethod}\n "  
  			println "processing json"
  		def dashboardReportList = DashboardReport.list([sort: 'actualValue'])
		def dashboardReportTempList = new ArrayList()
		for (a in dashboardReportList)
		{
			def dashboardReportListAttributes = new HashMap()
			def attributes = new HashMap()
			attributes.put("name",a.name)
			attributes.put("description",a.description)
			attributes.put("actualValue",a.actualValue)
			attributes.put("targetValue",a.targetValue)
			attributes.put("variance",a.variance)
			attributes.put("status",a.status)
			attributes.put("reportCategory",a.reportCategory.name)
			attributes.put("graphType",a.graphType.name)
			dashboardReportListAttributes.put("attributes",attributes)
			
			if (a.name =="Patient Arrival by Day" )
			{
				def reportMeasurements = new ArrayList()
				println "Processing reports : ${a.id}\n " 
				def c = Taglog.createCriteria() 
				
				def taglogs = c.list {
				projections {
					groupProperty("day")
					countDistinct("id")
				}
				}
				for (taglog in taglogs)
				{
					def reportMeasurementAttributes = new HashMap()
					
					reportMeasurementAttributes.put("xValue",taglog[0].toString())
					reportMeasurementAttributes.put("yValue",taglog[1].toString())
					reportMeasurementAttributes.put("criteria",a.name)
					reportMeasurements.add(reportMeasurementAttributes)
					println "count by day: ${taglog[0]},${taglog[1]} \n "
				}
				println "Adding.... ${taglogs} \n "
				attributes.put("reportMeasurements",reportMeasurements)
			}
			if (a.name =="Patient Arrival by Hour" )
			{
				def reportMeasurements = new ArrayList()
				println "Processing reports : ${a.id}\n " 
				def c = Taglog.createCriteria() 
				
				def taglogs = c.list {
				projections {
					groupProperty("hour")
					countDistinct("id")
				}
				}
				for (taglog in taglogs)
				{
					def reportMeasurementAttributes = new HashMap()
					
					reportMeasurementAttributes.put("xValue",taglog[0].toString())
					reportMeasurementAttributes.put("yValue",taglog[1].toString())
					reportMeasurementAttributes.put("criteria",a.name)
					reportMeasurements.add(reportMeasurementAttributes)
					println "count by hour: ${taglog[0]},${taglog[1]} \n "
				}
				println "Adding.... ${taglogs} \n "
				attributes.put("reportMeasurements",reportMeasurements)
			}
			
			if (a.name =="Satisfaction Rating" )
			{
				def reportMeasurements = new ArrayList()
				println "Processing reports : ${a.id}\n " 
				def c = Taglog.createCriteria() 
				
				def taglogs = c.list {
				projections {
					groupProperty("ratings")
					countDistinct("id")
				}
				}
				for (taglog in taglogs)
				{
					def reportMeasurementAttributes = new HashMap()
					
					reportMeasurementAttributes.put("xValue",taglog[0].toString())
					reportMeasurementAttributes.put("yValue",taglog[1].toString())
					reportMeasurementAttributes.put("criteria",a.name)
					reportMeasurements.add(reportMeasurementAttributes)
					println "count by hour: ${taglog[0]},${taglog[1]} \n "
				}
				println "Adding.... ${taglogs} \n "
				attributes.put("reportMeasurements",reportMeasurements)
			}
			
			
			if (a.name =="Overview" )
			{
				def reportMeasurements = new ArrayList()
				println "Processing reports : ${a.id}\n " 
				def c = Taglog.createCriteria() 
				
				def dashboardReportListForOverview = DashboardReport.list(params)
				for (report in dashboardReportListForOverview)
				{
					if (report.name != 'Overview')
					{
						def reportMeasurementAttributes = new HashMap()
						reportMeasurementAttributes.put("xValue",report.actualValue.toString())
						reportMeasurementAttributes.put("yValue",report.targetValue.toString())
						reportMeasurementAttributes.put("criteria",report.name)
						reportMeasurements.add(reportMeasurementAttributes)
						println "Overview: ${report.name} \n "
					}
				}
				attributes.put("reportMeasurements",reportMeasurements)
			}
			
			if (a.name =="ER Benchmarks"
				|| a.name == "Room Utilization"
				|| a.name == "OR Benchmarks"
				|| a.name == "Wait Times"
				|| a.name == "Patient Arrival by Hour"	
				|| a.name == "Satisfaction Rating"
				|| a.name == "Nursing Unit - Length of Stay"
				|| a.name == "Wait Times by Time of Day"
				|| a.name == "Utilization Performance"
				|| a.name == "Supplies"
				|| a.name == "Labor Productivity"
				|| a.name == "Ontime Starts"
			)
			{
				def reportMeasurements = new ArrayList()
				println "Processing reports : ${a.name}\n " 
				def c = Taglog.createCriteria() 
				
				def reportValues = ReportValues.list([sort: 'sequence'])
				for (report in reportValues)
				{
					if (report.dashboardReport.name == a.name)
					{
						def reportMeasurementAttributes = new HashMap()
						reportMeasurementAttributes.put("xValue",report.xValue.toString())
						reportMeasurementAttributes.put("yValue",report.yValue.toString())
						reportMeasurementAttributes.put("y1Value",report.y1Value.toString())
						reportMeasurementAttributes.put("y2Value",report.y2Value.toString())
						reportMeasurementAttributes.put("y3Value",report.y3Value.toString())
						reportMeasurementAttributes.put("y4Value",report.y4Value.toString())
						reportMeasurementAttributes.put("criteria",report.category) 
						reportMeasurements.add(reportMeasurementAttributes)
						println "Overview: ${report.dashboardReport.name} \n "
					}
				}
				attributes.put("reportMeasurements",reportMeasurements)
			}
			
			dashboardReportTempList.add(attributes)
			
		}
	
		def dashboardReportListOut = new HashMap()
		dashboardReportListOut.put("dashboardReports",dashboardReportTempList)
	
		println dashboardReportListOut.toString()
		println params
	
		println "${params.callback}(${dashboardReportListOut as JSON}); \n" 
		render "${params.callback}(${dashboardReportListOut as JSON});" 
  		


    }
}
