<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to HascStudy</title>

		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}
            
			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 1.5em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
		
	</head>
	<body>
	    <div class="nav" role="navigation">
			<ul>
			<g:if test="${userInstance != null}">
				<li><a class="home" href="#"><g:message code="Home" default="Home" /></a></li>
				<li><g:link class="list" controller="hospitalData" action="list"><g:message code="Hospital Data List" default="Hospital Data List" /></g:link></li>
				<li><g:link class="edit" controller="user" action="edit" id="${userInstance.id}"><g:message code="Edit Profile" args="[entityName]" default="Edit Profile" /></g:link></li>
				<li><a class="logout" href="${createLink(uri: '/user/logout')}"><g:message code="Logout" args="[entityName]" default="Logout" /></a></li>
		    </g:if>
			<g:else>
				<li><a class="home" href="${createLink(uri: '/index')}"><g:message code="Home" default="Home" /></a></li>
				<li><g:link class="login" controller="user" action="login"><g:message code="Login" default="Login" /></g:link></li>
				<li><g:link class="create" controller="user" action="create"><g:message code="Register" args="[entityName]" default="Register" /></g:link></li>
			</g:else>
			</ul>
		</div>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="page-body" role="main">
			<h1>Welcome to HascStudy</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:if test="${userInstance != null}">
			<p>Select an option using one of the links above.</p>
			</g:if>
			<g:else>
			<p>Please login or register using the links above.</p>
			</g:else>
			<p>Thank you for using HascStudy!</p>
		</div>
	</body>
</html>
