

<%@ page import="com.cpqd.monet.license.License" %>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'license.label', default: 'License')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#show-license" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="list" action="list">
					<g:message code="default.list.label" args="[entityName]" />
				</g:link></li>
			<li><g:link class="create" action="create">
					<g:message code="default.new.label" args="[entityName]" />
				</g:link></li>
		</ul>
	</div>
	<div id="show-license"
		class="content scaffold-show" role="main">
		<h1>
			<g:message code="default.show.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
		</g:if>
		<ol class="property-list license">
			
				<g:if test="${licenseInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="license.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${licenseInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${licenseInstance?.startDate}">
				<li class="fieldcontain">
					<span id="startDate-label" class="property-label"><g:message code="license.startDate.label" default="Start Date" /></span>
					
						<span class="property-value" aria-labelledby="startDate-label"><g:formatDate date="${licenseInstance?.startDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${licenseInstance?.endDate}">
				<li class="fieldcontain">
					<span id="endDate-label" class="property-label"><g:message code="license.endDate.label" default="End Date" /></span>
					
						<span class="property-value" aria-labelledby="endDate-label"><g:formatDate date="${licenseInstance?.endDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${licenseInstance?.licenseType}">
				<li class="fieldcontain">
					<span id="licenseType-label" class="property-label"><g:message code="license.licenseType.label" default="License Type" /></span>
					
						<span class="property-value" aria-labelledby="licenseType-label"><g:link controller="licenseType" action="show" id="${licenseInstance?.licenseType?.id}">${licenseInstance?.licenseType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
		</ol>
		<g:form>
			<fieldset class="buttons">
				<g:hiddenField name="id" value="${licenseInstance?.id}" />
				<g:link class="edit" action="edit" id="${licenseInstance?.id}">
					<g:message code="default.button.edit.label" default="Edit" />
				</g:link>
				<g:actionSubmit class="delete" action="delete"
					value="${message(code: 'default.button.delete.label', default: 'Delete')}"
					onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
			</fieldset>
		</g:form>
	</div>
</body>
</html>
