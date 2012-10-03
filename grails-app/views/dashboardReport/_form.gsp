<%@ page import="hascstudy.DashboardReport" %>



<div class="fieldcontain ${hasErrors(bean: dashboardReportInstance, field: 'actualValue', 'error')} required">
	<label for="actualValue">
		<g:message code="dashboardReport.actualValue.label" default="Actual Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="actualValue" step="any" required="" value="${dashboardReportInstance.actualValue}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dashboardReportInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="dashboardReport.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${dashboardReportInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dashboardReportInstance, field: 'graphType', 'error')} required">
	<label for="graphType">
		<g:message code="dashboardReport.graphType.label" default="Graph Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="graphType" name="graphType.id" from="${hascstudy.GraphType.list()}" optionKey="id" required="" value="${dashboardReportInstance?.graphType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dashboardReportInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="dashboardReport.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${dashboardReportInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dashboardReportInstance, field: 'reportCategory', 'error')} required">
	<label for="reportCategory">
		<g:message code="dashboardReport.reportCategory.label" default="Report Category" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="reportCategory" name="reportCategory.id" from="${hascstudy.ReportCategory.list()}" optionKey="id" required="" value="${dashboardReportInstance?.reportCategory?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dashboardReportInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="dashboardReport.status.label" default="Status" />
		
	</label>
	<g:textField name="status" value="${dashboardReportInstance?.status}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dashboardReportInstance, field: 'statusCode', 'error')} ">
	<label for="statusCode">
		<g:message code="dashboardReport.statusCode.label" default="Status Code" />
		
	</label>
	<g:textField name="statusCode" value="${dashboardReportInstance?.statusCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dashboardReportInstance, field: 'targetValue', 'error')} required">
	<label for="targetValue">
		<g:message code="dashboardReport.targetValue.label" default="Target Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="targetValue" step="any" required="" value="${dashboardReportInstance.targetValue}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dashboardReportInstance, field: 'variance', 'error')} required">
	<label for="variance">
		<g:message code="dashboardReport.variance.label" default="Variance" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="variance" step="any" required="" value="${dashboardReportInstance.variance}"/>
</div>

