<%@ page import="hascstudy.ReportCategory" %>



<div class="fieldcontain ${hasErrors(bean: reportCategoryInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="reportCategory.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${reportCategoryInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reportCategoryInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="reportCategory.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${reportCategoryInstance?.name}"/>
</div>

