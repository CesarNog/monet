

<%@ page import="com.cpqd.monet.prospect.Prospect" %>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'prospect.label', default: 'Prospect')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#show-prospect" class="skip" tabindex="-1"><g:message
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
	<div id="show-prospect"
		class="content scaffold-show" role="main">
		<h1>
			<g:message code="prospect.show.title"/>
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
		</g:if>
		<ol class="property-list prospect">
			
				<g:if test="${prospectInstance?.cnpj}">
				<li class="fieldcontain">
					<span id="cnpj-label" class="property-label"><g:message code="prospect.cnpj.label" default="Cnpj" /></span>
					
						<span class="property-value" aria-labelledby="cnpj-label"><g:fieldValue bean="${prospectInstance}" field="cnpj"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${prospectInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="prospect.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${prospectInstance}" field="name"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${prospectInstance?.contact.name}">
					<li class="fieldcontain"><span id="contactName-label"
						class="property-label"><g:message
								code="contact.name.label" default="Contact Name" /></span> <span
						class="property-value" aria-labelledby="contactName-label">
							<g:fieldValue bean="${prospectInstance}" 
										  field="contact.name" /></span>
					</li>
				</g:if>
	
				<g:if test="${prospectInstance?.contact.phone}">
					<li class="fieldcontain"><span id="contactPhone-label"
						class="property-label"><g:message
								code="contact.phone.label" default="Contact Phone" /></span> <span
						class="property-value" aria-labelledby="contactPhone-label">
						<g:fieldValue bean="${prospectInstance}" field="contact.phone" /></span></li>
				</g:if>
	
				<g:if test="${prospectInstance?.contact.email}">
					<li class="fieldcontain"><span id="contactEmail-label"
						class="property-label"><g:message
								code="contact.email.label" default="Contact Email" /></span> <span
						class="property-value" aria-labelledby="contactEmail-label"><g:fieldValue
								bean="${prospectInstance}" field="contact.email" /></span></li>
				</g:if>			
		</ol>
		<g:form>
			<fieldset class="buttons">
				<g:hiddenField name="id" value="${prospectInstance?.id}" />
				<g:link class="edit" action="edit" id="${prospectInstance?.id}">
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
