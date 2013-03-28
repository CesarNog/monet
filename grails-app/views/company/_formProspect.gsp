<%@ page import="com.cpqd.monet.company.Company"%>

<div
	class="fieldcontain">
	<label for="name"> <g:message
			code="company.include.companyName.label" default="Name" /> <span
		class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="50" required=""
		value="${companyInstance?.name}" />
</div>

<div
	class="fieldcontain">
	<label for="cnpj"> <g:message code="company.include.cnpj.label"
			default="Cnpj" /> <span class="required-indicator">*</span>
	</label>
	<g:textField name="cnpj"
		required=""
		value="${companyInstance?.cnpj}" />
	&nbsp;	
</div>

<div
	class="fieldcontain">
	<label for="contactName"> <g:message
			code="company.include.contactName.label" default="Contact Name" /> <span
		class="required-indicator">*</span>
	</label>
	<g:textField name="contactName" maxlength="50" required=""
		value="${companyInstance?.contactName}" />
</div>

<div
	class="fieldcontain">
	<label for="contactPhone"> <g:message
			code="company.include.contactPhone.label" default="Contact Phone" />
	</label>
	<g:textField name="contactPhone" maxlength="20"		
		value="${companyInstance?.contactPhone}" />
</div>

<div
	class="fieldcontain">
	<label for="contactEmail"> <g:message
			code="company.include.email.label" default="Email" /> <span
		class="required-indicator">*</span>
	</label>
	<g:field type="email" name="contactEmail" maxlength="50" required=""
		value="${companyInstance?.contactEmail}" />
	&nbsp;	
</div>
