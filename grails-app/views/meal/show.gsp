
<%@ page import="com.summitbid.coach.Meal" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'meal.label', default: 'Meal')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-meal" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-meal" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list meal">
			
				<g:if test="${mealInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="meal.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${mealInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mealInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="meal.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${mealInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mealInstance?.foods}">
				<li class="fieldcontain">
					<span id="foods-label" class="property-label"><g:message code="meal.foods.label" default="Foods" /></span>
					
						<g:each in="${mealInstance.foods}" var="f">
						<span class="property-value" aria-labelledby="foods-label"><g:link controller="food" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${mealInstance?.id}" />
					<g:link class="edit" action="edit" id="${mealInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
