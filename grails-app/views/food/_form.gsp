<%@ page import="com.summitbid.coach.Food" %>



<div class="fieldcontain ${hasErrors(bean: foodInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="food.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${foodInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: foodInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="food.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${foodInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: foodInstance, field: 'cost', 'error')} ">
	<label for="cost">
		<g:message code="food.cost.label" default="Cost" />
		
	</label>
	<g:field type="number" name="cost" value="${fieldValue(bean: foodInstance, field: 'cost')}"/>
</div>

<%--<div class="fieldcontain ${hasErrors(bean: foodInstance, field: 'nutritionData', 'error')} required">--%>
<%--	<label for="nutritionData">--%>
<%--		<g:message code="food.nutritionData.label" default="Nutrition Data" />--%>
<%--		<span class="required-indicator">*</span>--%>
<%--	</label>--%>
<%--	<g:select id="nutritionData" name="nutritionData.id" from="${com.summitbid.coach.NutritionData.list()}" optionKey="id" required="" value="${foodInstance?.nutritionData?.id}" class="many-to-one"/>--%>
<%--</div>--%>

