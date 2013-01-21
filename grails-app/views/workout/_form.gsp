<%@ page import="com.summitbid.coach.Workout" %>



<div class="fieldcontain ${hasErrors(bean: workoutInstance, field: 'uuid', 'error')} ">
	<label for="uuid">
		<g:message code="workout.uuid.label" default="Uuid" />
		
	</label>
	<g:textField name="uuid" maxlength="72" value="${workoutInstance?.uuid}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: workoutInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="workout.name.label" default="Name" />
		
	</label>
	<g:textArea name="name" cols="40" rows="5" maxlength="255" value="${workoutInstance?.name}"/>
</div>

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
	<g:select name="exercises" from="${com.summitbid.coach.Exercise.list()}" multiple="multiple" optionKey="id" size="5" value="${workoutInstance?.exercises*.id}" class="many-to-many"/>
</div>

