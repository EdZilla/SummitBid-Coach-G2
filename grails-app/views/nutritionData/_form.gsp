<%@ page import="com.summitbid.coach.NutritionData" %>



<div class="fieldcontain ${hasErrors(bean: nutritionDataInstance, field: 'food', 'error')} required">
	<label for="food">
		<g:message code="nutritionData.food.label" default="Food" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="food" name="food.id" from="${com.summitbid.coach.Food.list()}" optionKey="id" required="" value="${nutritionDataInstance?.food?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: nutritionDataInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="nutritionData.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${nutritionDataInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: nutritionDataInstance, field: 'calories', 'error')} ">
	<label for="calories">
		<g:message code="nutritionData.calories.label" default="Calories" />
		
	</label>
	<g:field type="number" name="calories" value="${fieldValue(bean: nutritionDataInstance, field: 'calories')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: nutritionDataInstance, field: 'gramsFat', 'error')} ">
	<label for="gramsFat">
		<g:message code="nutritionData.gramsFat.label" default="Grams Fat" />
		
	</label>
	<g:field type="number" name="gramsFat" value="${fieldValue(bean: nutritionDataInstance, field: 'gramsFat')}"/>
</div>

