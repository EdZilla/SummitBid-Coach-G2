<%@ page import="com.summitbid.coach.Food" %>



<div class="fieldcontain ${hasErrors(bean: foodInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="food.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${foodInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: foodInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="food.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${foodInstance?.description}"/>
</div>

