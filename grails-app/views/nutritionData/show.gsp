
<%@ page import="com.summitbid.coach.NutritionData" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'nutritionData.label', default: 'NutritionData')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-nutritionData" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-nutritionData" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list nutritionData">
			
				<g:if test="${nutritionDataInstance?.food}">
				<li class="fieldcontain">
					<span id="food-label" class="property-label"><g:message code="nutritionData.food.label" default="Food" /></span>
					
						<span class="property-value" aria-labelledby="food-label"><g:link controller="food" action="show" id="${nutritionDataInstance?.food?.id}">${nutritionDataInstance?.food?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${nutritionDataInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="nutritionData.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${nutritionDataInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${nutritionDataInstance?.calories}">
				<li class="fieldcontain">
					<span id="calories-label" class="property-label"><g:message code="nutritionData.calories.label" default="Calories" /></span>
					
						<span class="property-value" aria-labelledby="calories-label"><g:fieldValue bean="${nutritionDataInstance}" field="calories"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${nutritionDataInstance?.gramsFat}">
				<li class="fieldcontain">
					<span id="gramsFat-label" class="property-label"><g:message code="nutritionData.gramsFat.label" default="Grams Fat" /></span>
					
						<span class="property-value" aria-labelledby="gramsFat-label"><g:fieldValue bean="${nutritionDataInstance}" field="gramsFat"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${nutritionDataInstance?.id}" />
					<g:link class="edit" action="edit" id="${nutritionDataInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
