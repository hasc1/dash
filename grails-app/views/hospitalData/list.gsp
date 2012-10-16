
<%@ page import="hascstudy.HospitalData" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'hospitalData.label', default: 'HospitalData')}" />
		<g:set var="userEntity" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-hospitalData" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="home" controller="user" action="loggedin" id="${userInstance.id}"><g:message code="default.home.label" default="Home" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="edit" controller="user" action="edit" id="${userInstance.id}"><g:message code="Edit Profile" default="Edit Profile" /></g:link></li>
				<li><a class="logout" href="${createLink(uri: '/user/logout')}"><g:message code="Logout"/></a></li>
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
					
						<g:sortableColumn property="quarter" title="${message(code: 'hospitalData.quarter.label', default: 'Quarter')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${hospitalDataInstanceList}" status="i" var="hospitalDataInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${hospitalDataInstance.id}">${fieldValue(bean: hospitalDataInstance, field: "quarter")}</g:link></td>
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
