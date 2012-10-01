
<%@ page import="hascstudy.HospitalData" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'hospitalData.label', default: 'HospitalData')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-hospitalData" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-hospitalData" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="avaregeRoomTurnAroundAllPatients" title="${message(code: 'hospitalData.avaregeRoomTurnAroundAllPatients.label', default: 'Avarege Room Turn Around All Patients')}" />
					
						<g:sortableColumn property="avaregeRoomTurnAroundInPatients" title="${message(code: 'hospitalData.avaregeRoomTurnAroundInPatients.label', default: 'Avarege Room Turn Around In Patients')}" />
					
						<g:sortableColumn property="avaregeRoomTurnAroundOutPatients" title="${message(code: 'hospitalData.avaregeRoomTurnAroundOutPatients.label', default: 'Avarege Room Turn Around Out Patients')}" />
					
						<g:sortableColumn property="avaregeRoomTurnAroundPhysicians" title="${message(code: 'hospitalData.avaregeRoomTurnAroundPhysicians.label', default: 'Avarege Room Turn Around Physicians')}" />
					
						<g:sortableColumn property="avaregeRoomUtilizationInTotal" title="${message(code: 'hospitalData.avaregeRoomUtilizationInTotal.label', default: 'Avarege Room Utilization In Total')}" />
					
						<g:sortableColumn property="avaregeRoomUtilizationPrimeTime" title="${message(code: 'hospitalData.avaregeRoomUtilizationPrimeTime.label', default: 'Avarege Room Utilization Prime Time')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${hospitalDataInstanceList}" status="i" var="hospitalDataInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${hospitalDataInstance.id}">${fieldValue(bean: hospitalDataInstance, field: "avaregeRoomTurnAroundAllPatients")}</g:link></td>
					
						<td>${fieldValue(bean: hospitalDataInstance, field: "avaregeRoomTurnAroundInPatients")}</td>
					
						<td>${fieldValue(bean: hospitalDataInstance, field: "avaregeRoomTurnAroundOutPatients")}</td>
					
						<td>${fieldValue(bean: hospitalDataInstance, field: "avaregeRoomTurnAroundPhysicians")}</td>
					
						<td>${fieldValue(bean: hospitalDataInstance, field: "avaregeRoomUtilizationInTotal")}</td>
					
						<td>${fieldValue(bean: hospitalDataInstance, field: "avaregeRoomUtilizationPrimeTime")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${hospitalDataInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
