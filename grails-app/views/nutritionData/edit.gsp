<%@ page import="com.summitbid.coach.NutritionData" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'nutritionData.label', default: 'NutritionData')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
		
 		<script src="http://platform.fatsecret.com/js?key=006ffa526d1542ef88cbc79733770fe3"></script>
		
	</head>
	<body>
		<a href="#edit-nutritionData" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="edit-nutritionData" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${nutritionDataInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${nutritionDataInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form method="post" >
				<g:hiddenField name="id" value="${nutritionDataInstance?.id}" />
				<g:hiddenField name="version" value="${nutritionDataInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" formnovalidate="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
		
		<div id="my_container" class="fatsecret_container" >
		<script>
			fatsecret.setContainer("my_container");
			fatsecret.setCanvas("home");
		</script>
		</div>
		
	</body>
</html>
