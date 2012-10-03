<%@ page import="hascstudy.GraphType" %>



<div class="fieldcontain ${hasErrors(bean: graphTypeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="graphType.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${graphTypeInstance?.name}"/>
</div>

