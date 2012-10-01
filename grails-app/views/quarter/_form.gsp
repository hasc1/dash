<%@ page import="hascstudy.Quarter" %>



<div class="fieldcontain ${hasErrors(bean: quarterInstance, field: 'quarter', 'error')} ">
	<label for="quarter">
		<g:message code="quarter.quarter.label" default="Quarter" />
		
	</label>
	<g:textField name="quarter" value="${quarterInstance?.quarter}"/>
</div>

