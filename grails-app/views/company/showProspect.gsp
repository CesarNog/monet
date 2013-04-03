<%@ page import="com.cpqd.monet.company.Company"%>
<!DOCTYPE html>
<html>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'company.label', default: 'Company')}" />
<<<<<<< HEAD
<title><g:message code="default.show.title.label"
		args="[entityName]" /></title>
	<a href="#show-company" class="skip" tabindex="-1"><g:message
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
	<div id="show-company" class="content scaffold-show" role="main">
		<h1>
			<g:message code="default.show.label"
				args="[companyInstance.name]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<ol class="property-list company">

			<g:if test="${companyInstance?.name}">
				<li class="fieldcontain"><span id="companyName-label"
					class="property-label"><g:message
							code="company.name.label" default="Company Name" />:</span>

					<span class="property-value" aria-labelledby="companyName-label"><g:fieldValue
							bean="${companyInstance}" field="name" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.cnpj}">
				<li class="fieldcontain"><span id="cnpj-label"
					class="property-label"><g:message
							code="company.cnpj.label" default="Cnpj" />:</span> <span
					class="property-value" aria-labelledby="cnpj-label"><g:fieldValue
							bean="${companyInstance}" field="cnpj" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.contact?.name}">
				<li class="fieldcontain"><span id="contactName-label"
					class="property-label"><g:message
							code="company.show.contactName.label" default="Contact Name" />:</span>

					<span class="property-value" aria-labelledby="contactName-label"><g:fieldValue
							bean="${companyInstance?.contact}" field="name" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.contact?.phone}">
				<li class="fieldcontain"><span id="contactPhone-label"
					class="property-label"><g:message
							code="company.show.contactPhone.label" default="Contact Phone" /></span>

					<span class="property-value" aria-labelledby="contactPhone-label"><g:fieldValue
							bean="${companyInstance?.contact}" field="phone" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.contact?.email}">
				<li class="fieldcontain"><span id="email-label"
					class="property-label"><g:message
							code="company.show.email.label" default="Email" />:</span> <span
					class="property-value" aria-labelledby="email-label"><g:fieldValue
							bean="${companyInstance?.contact}" field="email" /></span></li>
			</g:if>

		</ol>
		<g:form>
			<fieldset class="buttons">
				<g:hiddenField name="id" value="${companyInstance?.id}" />
				<g:link class="edit" action="editProspect" id="${companyInstance?.id}">
					<g:message code="default.button.edit.label" default="Edit" />
				</g:link>
				<g:actionSubmit class="delete" action="delete"
					value="${message(code: 'default.button.delete.label', default: 'Delete')}"
					onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
			</fieldset>
		</g:form>
	</div>
=======
<title><g:message code="company.show.title.label"
		args="[companyInstance.name]" /></title>
<a href="#show-company" class="skip" tabindex="-1"><g:message
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
<div id="show-company" class="content scaffold-show" role="main">
	<h1>
		<g:message code="company.show.title.label" args="[companyInstance.name]" />
	</h1>
	<g:if test="${flash.message}">
		<div class="message" role="status">
			${flash.message}
		</div>
	</g:if>
	<ol class="property-list company">

		<g:if test="${companyInstance?.name}">
			<li class="fieldcontain"><span id="companyName-label"
				class="property-label"><g:message code="company.name.label"
						default="Company Name" />:</span> <span class="property-value"
				aria-labelledby="companyName-label"><g:fieldValue
						bean="${companyInstance}" field="name" /></span></li>
		</g:if>

		<g:if test="${companyInstance?.cnpj}">
			<li class="fieldcontain"><span id="cnpj-label"
				class="property-label"><g:message code="company.cnpj.label"
						default="Cnpj" />:</span> <span class="property-value"
				aria-labelledby="cnpj-label"><g:fieldValue
						bean="${companyInstance}" field="cnpj" /></span></li>
		</g:if>

		<g:if test="${companyInstance?.contact?.name}">
			<li class="fieldcontain"><span id="contactName-label"
				class="property-label"><g:message code="contact.name.label"
						default="Contact Name" />:</span> <span class="property-value"
				aria-labelledby="contactName-label"><g:fieldValue
						bean="${companyInstance?.contact}" field="name" /></span></li>
		</g:if>

		<g:if test="${companyInstance?.contact?.phone}">
			<li class="fieldcontain"><span id="contactPhone-label"
				class="property-label"><g:message code="contact.phone.label"
						default="Contact Phone" />:</span> <span class="property-value"
				aria-labelledby="contactPhone-label"><g:fieldValue
						bean="${companyInstance?.contact}" field="phone" /></span></li>
		</g:if>

		<g:if test="${companyInstance?.contact?.email}">
			<li class="fieldcontain"><span id="email-label"
				class="property-label"><g:message code="contact.email.label"
						default="Email" />:</span> <span class="property-value"
				aria-labelledby="email-label"> <g:fieldValue
						bean="${companyInstance?.contact}" field="email" />
			</span></li>
		</g:if>

	</ol>
	<g:form>
		<fieldset class="buttons">
			<g:hiddenField name="id" value="${companyInstance?.id}" />
			<g:link class="edit" action="editProspect"
				id="${companyInstance?.id}">
				<g:message code="default.button.edit.label" default="Edit" />
			</g:link>
			<g:actionSubmit class="delete" action="delete"
				value="${message(code: 'default.button.delete.label', default: 'Delete')}"
				onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
		</fieldset>
	</g:form>
</div>
>>>>>>> 0c84f424854bf0bfa77b19c98f0edf52e7fa9d9c
</html>
