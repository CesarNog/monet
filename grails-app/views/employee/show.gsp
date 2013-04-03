

<%@ page import="com.cpqd.monet.employee.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'employee.label', default: 'Employee')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#show-employee" class="skip" tabindex="-1"><g:message
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
	<div id="show-employee"
		class="content scaffold-show" role="main">
		<h1>
			<g:message code="default.show.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
		</g:if>
		<ol class="property-list employee">
			
				<g:if test="${employeeInstance?.matriculation}">
				<li class="fieldcontain">
					<span id="matriculation-label" class="property-label"><g:message code="employee.matriculation.label" default="Matriculation" /></span>
					
						<span class="property-value" aria-labelledby="matriculation-label"><g:fieldValue bean="${employeeInstance}" field="matriculation"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="employee.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${employeeInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="employee.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${employeeInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.functions}">
				<li class="fieldcontain">
					<span id="functions-label" class="property-label"><g:message code="employee.functions.label" default="Functions" /></span>
					
						<span class="property-value" aria-labelledby="functions-label"><g:link controller="functions" action="show" id="${employeeInstance?.functions?.id}">${employeeInstance?.functions?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.cpf}">
				<li class="fieldcontain">
					<span id="cpf-label" class="property-label"><g:message code="employee.cpf.label" default="Cpf" /></span>
					
						<span class="property-value" aria-labelledby="cpf-label"><g:fieldValue bean="${employeeInstance}" field="cpf"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.contact}">
				<li class="fieldcontain">
					<span id="contact-label" class="property-label"><g:message code="employee.contact.label" default="Contact" /></span>
					
						<span class="property-value" aria-labelledby="contact-label"><g:fieldValue bean="${employeeInstance}" field="contact"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.startDate}">
				<li class="fieldcontain">
					<span id="startDate-label" class="property-label"><g:message code="employee.startDate.label" default="Start Date" /></span>
					
						<span class="property-value" aria-labelledby="startDate-label"><g:formatDate date="${employeeInstance?.startDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.endDate}">
				<li class="fieldcontain">
					<span id="endDate-label" class="property-label"><g:message code="employee.endDate.label" default="End Date" /></span>
					
						<span class="property-value" aria-labelledby="endDate-label"><g:formatDate date="${employeeInstance?.endDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.situation}">
				<li class="fieldcontain">
					<span id="situation-label" class="property-label"><g:message code="employee.situation.label" default="Situation" /></span>
					
						<span class="property-value" aria-labelledby="situation-label"><g:formatBoolean boolean="${employeeInstance?.situation}" /></span>
					
				</li>
				</g:if>
			
		</ol>
		<g:form>
			<fieldset class="buttons">
				<g:hiddenField name="id" value="${employeeInstance?.id}" />
				<g:link class="edit" action="edit" id="${employeeInstance?.id}">
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
