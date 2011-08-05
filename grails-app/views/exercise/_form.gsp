<%@ page import="com.summitbid.coach.Exercise" %>



<div class="fieldcontain ${hasErrors(bean: exerciseInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="exercise.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${exerciseInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: exerciseInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="exercise.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${exerciseInstance?.description}"/>
</div>

