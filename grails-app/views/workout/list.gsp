
<%@ page import="com.summitbid.coach.Workout" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'workout.label', default: 'Workout')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-workout" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-workout" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'workout.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'workout.name.label', default: 'Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${workoutInstanceList}" status="i" var="workoutInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${workoutInstance.id}">${fieldValue(bean: workoutInstance, field: "description")}</g:link></td>
					
						<td>${fieldValue(bean: workoutInstance, field: "name")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${workoutInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
