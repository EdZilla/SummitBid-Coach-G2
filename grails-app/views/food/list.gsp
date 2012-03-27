
<%@ page import="com.summitbid.coach.Food" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'food.label', default: 'Food')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-food" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link elementId="Action_New_Food" class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-food" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'food.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'food.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="cost" title="${message(code: 'food.cost.label', default: 'Cost')}" />
					
						<th><g:message code="food.nutritionData.label" default="Nutrition Data" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${foodInstanceList}" status="i" var="foodInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${foodInstance.id}">${fieldValue(bean: foodInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: foodInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: foodInstance, field: "cost")}</td>
					
						<td>${fieldValue(bean: foodInstance, field: "nutritionData")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${foodInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
