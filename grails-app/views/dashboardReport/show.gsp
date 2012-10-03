
<%@ page import="hascstudy.DashboardReport" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'dashboardReport.label', default: 'DashboardReport')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-dashboardReport" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-dashboardReport" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list dashboardReport">
			
				<g:if test="${dashboardReportInstance?.actualValue}">
				<li class="fieldcontain">
					<span id="actualValue-label" class="property-label"><g:message code="dashboardReport.actualValue.label" default="Actual Value" /></span>
					
						<span class="property-value" aria-labelledby="actualValue-label"><g:fieldValue bean="${dashboardReportInstance}" field="actualValue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dashboardReportInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="dashboardReport.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${dashboardReportInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dashboardReportInstance?.graphType}">
				<li class="fieldcontain">
					<span id="graphType-label" class="property-label"><g:message code="dashboardReport.graphType.label" default="Graph Type" /></span>
					
						<span class="property-value" aria-labelledby="graphType-label"><g:link controller="graphType" action="show" id="${dashboardReportInstance?.graphType?.id}">${dashboardReportInstance?.graphType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${dashboardReportInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="dashboardReport.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${dashboardReportInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dashboardReportInstance?.reportCategory}">
				<li class="fieldcontain">
					<span id="reportCategory-label" class="property-label"><g:message code="dashboardReport.reportCategory.label" default="Report Category" /></span>
					
						<span class="property-value" aria-labelledby="reportCategory-label"><g:link controller="reportCategory" action="show" id="${dashboardReportInstance?.reportCategory?.id}">${dashboardReportInstance?.reportCategory?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${dashboardReportInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="dashboardReport.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${dashboardReportInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dashboardReportInstance?.statusCode}">
				<li class="fieldcontain">
					<span id="statusCode-label" class="property-label"><g:message code="dashboardReport.statusCode.label" default="Status Code" /></span>
					
						<span class="property-value" aria-labelledby="statusCode-label"><g:fieldValue bean="${dashboardReportInstance}" field="statusCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dashboardReportInstance?.targetValue}">
				<li class="fieldcontain">
					<span id="targetValue-label" class="property-label"><g:message code="dashboardReport.targetValue.label" default="Target Value" /></span>
					
						<span class="property-value" aria-labelledby="targetValue-label"><g:fieldValue bean="${dashboardReportInstance}" field="targetValue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dashboardReportInstance?.variance}">
				<li class="fieldcontain">
					<span id="variance-label" class="property-label"><g:message code="dashboardReport.variance.label" default="Variance" /></span>
					
						<span class="property-value" aria-labelledby="variance-label"><g:fieldValue bean="${dashboardReportInstance}" field="variance"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${dashboardReportInstance?.id}" />
					<g:link class="edit" action="edit" id="${dashboardReportInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
