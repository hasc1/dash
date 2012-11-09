<%@ page import="hascstudy.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#edit-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<g:if test="${userInstance != null}">
					<li><g:link a class="home" controller="user" action="index" id="${userInstance.id}"><g:message code="Home" default="Home" /></g:link></li>
					<li><g:link class="list" controller="hospitalData" action="list"><g:message code="Hospital Data List" default="Hospital Data List" /></g:link></li>
					<li><a class="logout" href="${createLink(uri: '/user/logout')}"><g:message code="Logout" args="[entityName]" default="Logout" /></a></li>
			    </g:if>
				<g:else>
					<li><a class="home" href="${createLink(uri: '/')}"><g:message code="Home" default="Home" /></a></li>
					<li><g:link class="login" controller="user" action="login"><g:message code="Login" default="Login" /></g:link></li>
					<li><g:link class="create" controller="user" action="create"><g:message code="Register" args="[entityName]" default="Register" /></g:link></li>
				</g:else>
			</ul>
		</div>
		<div id="edit-user" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${userInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${userInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form method="post" >
				<g:hiddenField name="id" value="${userInstance?.id}" />
				<g:hiddenField name="version" value="${userInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" formnovalidate="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
