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

<div class="fieldcontain ${hasErrors(bean: nutritionDataInstance, field: 'servingSize', 'error')} ">
	<label for="servingSize">
		<g:message code="nutritionData.servingSize.label" default="Serving Size" />
		
	</label>
	<g:field type="number" name="servingSize" value="${fieldValue(bean: nutritionDataInstance, field: 'servingSize')}"/>
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

<div class="fieldcontain ${hasErrors(bean: nutritionDataInstance, field: 'carbs', 'error')} ">
	<label for="carbs">
		<g:message code="nutritionData.carbs.label" default="Carbs" />
		
	</label>
	<g:field type="number" name="carbs" value="${fieldValue(bean: nutritionDataInstance, field: 'carbs')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: nutritionDataInstance, field: 'protein', 'error')} ">
	<label for="protein">
		<g:message code="nutritionData.protein.label" default="grams Protein" />
		
	</label>
	<g:field type="number" name="protein" value="${fieldValue(bean: nutritionDataInstance, field: 'protein')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: nutritionDataInstance, field: 'sodium', 'error')} ">
	<label for="sodium">
		<g:message code="nutritionData.sodium.label" default="grams Sodium" />
		
	</label>
	<g:field type="number" name="Sodium" value="${fieldValue(bean: nutritionDataInstance, field: 'sodium')}"/>
</div>
