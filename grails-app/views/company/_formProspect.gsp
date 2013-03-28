<%@ page import="com.cpqd.monet.company.Company"%>

<div class="fieldcontain">
	<label for="name">
	 <span class="required-indicator">*</span> 
	 <g:message code="company.name.label" default="Name" />:	 
	</label>
	<g:textField name="company.name" maxlength="50" required=""	value="${companyInstance?.name}" />
</div>

<div class="fieldcontain">
	<label for="company.cnpj.label">
	 <span class="required-indicator">*</span>
	 <g:message code="company.cnpj.label" default="Cnpj"/>:	 
	</label>
	<g:textField name="company.cnpj" required="" value="${companyInstance?.cnpj}" />
	&nbsp;
</div>

<div class="fieldcontain">
	<label for="company.contact.name">
	<span class="required-indicator">*</span>
	  <g:message code="contact.name.label" default="Contact Name" />:	  
	</label>
	<g:textField name="company.contact.name" maxlength="50" required=""
		value="${companyInstance.contact?.name}" />
</div>

<div class="fieldcontain">
	<label for="company.contact.phone"> 
	  <g:message code="contact.phone.label" default="Contact Phone" />:
	</label>
	<g:textField name="company.contact.phone" maxlength="20"
		value="${companyInstance.contact?.phone}" />
</div>

<div class="fieldcontain">
	<label for="company.contact.email">
	<span class="required-indicator">*</span> 
	  <g:message code="contact.email.label" default="Email" />:	  
	</label>
	<g:field type="email" 
			 name="company.contact.email" 
			 maxlength="50" 
			 required=""
			 value="${companyInstance.contact?.email}" />
	&nbsp;
</div>