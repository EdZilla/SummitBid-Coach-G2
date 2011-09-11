
<%@ page import="com.summitbid.coach.Meal" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'meal.label', default: 'Meal')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-meal" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-meal" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'meal.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'meal.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="cost" title="${message(code: 'meal.cost.label', default: 'Cost')}" />
					
						<g:sortableColumn property="date" title="${message(code: 'meal.date.label', default: 'Date')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${mealInstanceList}" status="i" var="mealInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${mealInstance.id}">${fieldValue(bean: mealInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: mealInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: mealInstance, field: "cost")}</td>
					
						<td><g:formatDate date="${mealInstance.date}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${mealInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
