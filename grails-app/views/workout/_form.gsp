<%@ page import="com.summitbid.coach.Workout" %>



<div class="fieldcontain ${hasErrors(bean: workoutInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="workout.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${workoutInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: workoutInstance, field: 'exercises', 'error')} ">
	<label for="exercises">
		<g:message code="workout.exercises.label" default="Exercises" />
		
	</label>
	<g:select name="exercises" from="${com.summitbid.coach.Activity.list()}" multiple="multiple" optionKey="id" size="5" value="${workoutInstance?.exercises*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: workoutInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="workout.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${workoutInstance?.name}"/>
</div>

