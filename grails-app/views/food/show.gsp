
<%@ page import="com.summitbid.coach.Food" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'food.label', default: 'Food')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-food" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-food" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list food">
			
				<g:if test="${foodInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="food.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${foodInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${foodInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="food.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${foodInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${foodInstance?.nutritionData}">
				<li class="fieldcontain">
					<span id="nutritionData-label" class="property-label"><g:message code="food.nutritionData.label" default="Nutrition Data" /></span>
					
						<span class="property-value" aria-labelledby="nutritionData-label"><g:link controller="nutritionData" action="show" id="${foodInstance?.nutritionData?.id}">${foodInstance?.nutritionData?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${foodInstance?.id}" />
					<g:link class="edit" action="edit" id="${foodInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:link controller="meal" class="edit" action="edit" >Add this food to a meal</g:link>
					
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
