<%@ page import="com.cpqd.monet.prospect.Prospect" %>

<div class="fieldcontain ${hasErrors(bean: prospectInstance, field: 'cnpj', 'error')} required">
	<label for="cnpj">
		<span class="required-indicator">*</span>
		<g:message code="prospect.cnpj.label" default="Cnpj" />:		
	</label>
	<g:textField name="cnpj" 
				 required="" 
				 value="${prospectInstance?.cnpj}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: prospectInstance, field: 'name', 'error')} required">
	<label for="name">
		<span class="required-indicator">*</span>
		<g:message code="prospect.name.label" default="Name" />:		
	</label>
	<g:textField name="name" 
				 maxlength="50" 
				 required="" 
				 value="${prospectInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: prospectInstance, field: 'name', 'error')} required">
	<label for="prospect.contact.name">
	<span class="required-indicator">*</span>
	  <g:message code="contact.name.label" default="Contact Name" />:	  
	</label>
	<g:textField name="prospect.contact.name" 
				 maxlength="50" required=""
				 value="${prospectInstance?.contact?.name}" />
</div>

<div class="fieldcontain ${hasErrors(bean: prospectInstance, field: 'name', 'error')} required">
	<label for="prospect.contact.phone"> 
	  <g:message code="contact.phone.label" default="Contact Phone" />:
	</label>
	<g:textField name="prospect.contact.phone" 
				 maxlength="20"
		         value="${prospectInstance?.contact?.phone}" />
</div>

<div class="fieldcontain ${hasErrors(bean: prospectInstance, field: 'name', 'error')} required">
	<label for="prospect.contact.email">
	<span class="required-indicator">*</span> 
	  <g:message code="contact.name.label" default="Email" />:	  
	</label>
	<g:field type="email" 
			 name="prospect.contact.email" 
			 maxlength="50" 
			 required=""
			 value="${prospectInstance?.contact?.email}" />	
</div>

