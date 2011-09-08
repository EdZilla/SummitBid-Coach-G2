<%@ page import="com.summitbid.coach.Meal" %>



<div class="fieldcontain ${hasErrors(bean: mealInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="meal.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${mealInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mealInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="meal.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${mealInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mealInstance, field: 'foods', 'error')} ">
	<label for="foods">
		<g:message code="meal.foods.label" default="Foods" />
		
	</label>
	<g:select name="foods" from="${com.summitbid.coach.Food.list()}" multiple="multiple" optionKey="id" size="5" value="${mealInstance?.foods*.id}" class="many-to-many"/>
</div>

