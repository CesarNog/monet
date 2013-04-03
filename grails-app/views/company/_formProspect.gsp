<%@ page import="com.cpqd.monet.company.Company"%>

<div class="fieldcontain">
	<label for="name"> 
	 <g:message code="company.name.label" default="Name" />: 
	 <span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="50" required=""	value="${companyInstance?.name}" />
</div>

<div class="fieldcontain">
	<label for="cnpj">
	 <g:message code="company.cnpj.label" default="Cnpj"/>:
	 <span class="required-indicator">*</span>
	</label>
	<g:textField name="cnpj" required="" value="${companyInstance?.cnpj}" />
	&nbsp;
</div>

<div class="fieldcontain">
	<label for="name"> 
	<span class="required-indicator">*</span>
	  <g:message code="contact.name.label" default="Contact Name" />:	  
	</label>
	<g:textField name="contactName" maxlength="50" required=""
		value="${companyInstance.contact?.name}" />
</div>

<div class="fieldcontain">
	<label for="contactPhone"> 
	  <g:message code="contact.phone.label" default="Contact Phone" />:
	</label>
	<g:textField name="contactPhone" maxlength="20"
		value="${companyInstance.contact?.phone}" />
</div>

<div class="fieldcontain">
	<label for="contactEmail">
	<span class="required-indicator">*</span> 
	  <g:message code="contact.email.label" default="Email" />:	  
	</label>
	<g:field type="email" 
			 name="contactEmail" 
			 maxlength="50" 
			 required=""
			 value="${companyInstance.contact?.email}" />
	&nbsp;
</div>