
<%@ page import="com.summitbid.coach.Exercise" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'exercise.label', default: 'Exercise')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-exercise" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-exercise" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list exercise">
			
				<g:if test="${exerciseInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="exercise.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${exerciseInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${exerciseInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="exercise.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${exerciseInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${exerciseInstance?.id}" />
					<g:link class="edit" action="edit" id="${exerciseInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					<span> | </span>
        				<g:link controller="workout" params="["exercise.id":exercise?.id]" action="addActivityTo" >Add this activity item to current workout orig</g:link> 
				
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
