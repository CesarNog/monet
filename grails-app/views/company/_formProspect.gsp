<%@ page import="com.cpqd.monet.company.Company" %>



<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'companyName', 'error')} required">
	<label for="companyName">
		<g:message code="company.include.companyName.label" default="Company Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="companyName" maxlength="50" required="" value="${companyInstance?.companyName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'cnpj', 'error')} required">
	<label for="cnpj">
		<g:message code="company.include.cnpj.label" default="Cnpj" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cnpj" pattern="${companyInstance.constraints.cnpj.matches}" required="" value="${companyInstance?.cnpj}"/>
    &nbsp;
	<g:message code="company.pattern.cnpj"/>
</div>

<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'contactName', 'error')} required">
	<label for="contactName">
		<g:message code="company.include.contactName.label" default="Contact Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="contactName" maxlength="50" required="" value="${companyInstance?.contactName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'contactPhone', 'error')} ">
	<label for="contactPhone">
		<g:message code="company.include.contactPhone.label" default="Contact Phone" />
	</label>
	<g:textField name="contactPhone" maxlength="20" pattern="${companyInstance.constraints.contactPhone.matches}" value="${companyInstance?.contactPhone}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="company.include.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" maxlength="50" required="" value="${companyInstance?.email}"/>
	&nbsp;
    <g:message code="company.pattern.email"/>
</div>
