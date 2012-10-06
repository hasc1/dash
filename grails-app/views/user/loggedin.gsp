<%@ page import="hascstudy.User" %>
<!doctype html>
 <html>
     <head>
         <meta name="layout" content="main">
         <g:set var="entityName" value="HascStudy Login" />
         <title><g:message code="HascStudy Login" args="[entityName]" /></title>
     </head>
     <body>
         <a href="#create-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
         <div class="nav" role="navigation">
             <ul>
                 <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                 <li><g:link class="logout" action="logout"><g:message code="Logout" args="[entityName]" /></g:link></li>
             </ul>
         </div>
         <div id="create-user" class="content scaffold-create" role="main">
             <h1><g:message code="Welcome ${session.user}!" args="[entityName]" /></h1>
             <div class="message" role="status">You are now logged in. Use the links on the top to navigate the site!</div>
         </div>
     </body>
 </html>