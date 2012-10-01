<%@ page import="hascstudy.Hospital" %>



<div class="fieldcontain ${hasErrors(bean: hospitalInstance, field: 'hospitalName', 'error')} ">
	<label for="hospitalName">
		<g:message code="hospital.hospitalName.label" default="Hospital Name" />
		
	</label>
	<g:textField name="hospitalName" value="${hospitalInstance?.hospitalName}"/>
</div>

