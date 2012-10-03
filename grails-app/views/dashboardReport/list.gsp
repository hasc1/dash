
<%@ page import="hascstudy.DashboardReport" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'dashboardReport.label', default: 'DashboardReport')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-dashboardReport" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-dashboardReport" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="actualValue" title="${message(code: 'dashboardReport.actualValue.label', default: 'Actual Value')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'dashboardReport.description.label', default: 'Description')}" />
					
						<th><g:message code="dashboardReport.graphType.label" default="Graph Type" /></th>
					
						<g:sortableColumn property="name" title="${message(code: 'dashboardReport.name.label', default: 'Name')}" />
					
						<th><g:message code="dashboardReport.reportCategory.label" default="Report Category" /></th>
					
						<g:sortableColumn property="status" title="${message(code: 'dashboardReport.status.label', default: 'Status')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${dashboardReportInstanceList}" status="i" var="dashboardReportInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${dashboardReportInstance.id}">${fieldValue(bean: dashboardReportInstance, field: "actualValue")}</g:link></td>
					
						<td>${fieldValue(bean: dashboardReportInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: dashboardReportInstance, field: "graphType")}</td>
					
						<td>${fieldValue(bean: dashboardReportInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: dashboardReportInstance, field: "reportCategory")}</td>
					
						<td>${fieldValue(bean: dashboardReportInstance, field: "status")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${dashboardReportInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
