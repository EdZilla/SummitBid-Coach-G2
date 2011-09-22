
<%@ page import="com.summitbid.coach.NutritionData" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'nutritionData.label', default: 'NutritionData')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-nutritionData" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-nutritionData" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="nutritionData.food.label" default="Food" /></th>
					
						<g:sortableColumn property="description" title="${message(code: 'nutritionData.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="servingSize" title="${message(code: 'nutritionData.servingSize.label', default: 'Serving Size')}" />
					
						<g:sortableColumn property="calories" title="${message(code: 'nutritionData.calories.label', default: 'Calories')}" />
					
						<g:sortableColumn property="gramsFat" title="${message(code: 'nutritionData.gramsFat.label', default: 'Grams Fat')}" />
					
						<g:sortableColumn property="carbs" title="${message(code: 'nutritionData.carbs.label', default: 'Carbs')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${nutritionDataInstanceList}" status="i" var="nutritionDataInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${nutritionDataInstance.id}">${fieldValue(bean: nutritionDataInstance, field: "food")}</g:link></td>
					
						<td>${fieldValue(bean: nutritionDataInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: nutritionDataInstance, field: "servingSize")}</td>
					
						<td>${fieldValue(bean: nutritionDataInstance, field: "calories")}</td>
					
						<td>${fieldValue(bean: nutritionDataInstance, field: "gramsFat")}</td>
					
						<td>${fieldValue(bean: nutritionDataInstance, field: "carbs")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${nutritionDataInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
