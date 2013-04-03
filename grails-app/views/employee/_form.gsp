<%@ page import="com.cpqd.monet.employee.Employee" %>



<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'matriculation', 'error')} required">
	<label for="matriculation">
		<g:message code="employee.matriculation.label" default="Matriculation" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="matriculation" required="" value="${employeeInstance?.matriculation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="employee.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="50" required="" value="${employeeInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="employee.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${employeeInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'functions', 'error')} required">
	<label for="functions">
		<g:message code="employee.functions.label" default="Functions" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="functions" name="functions.id" from="${com.cpqd.monet.functions.Functions.list()}" optionKey="id" required="" value="${employeeInstance?.functions?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'cpf', 'error')} required">
	<label for="cpf">
		<g:message code="employee.cpf.label" default="Cpf" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cpf" maxlength="30" required="" value="${employeeInstance?.cpf}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'contact', 'error')} required">
	<label for="contact">
		<g:message code="employee.contact.label" default="Contact" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="contact" maxlength="50" required="" value="${employeeInstance?.contact}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="employee.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="day"  value="${employeeInstance?.startDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'endDate', 'error')} required">
	<label for="endDate">
		<g:message code="employee.endDate.label" default="End Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="endDate" precision="day"  value="${employeeInstance?.endDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'situation', 'error')} ">
	<label for="situation">
		<g:message code="employee.situation.label" default="Situation" />
		
	</label>
	<g:checkBox name="situation" value="${employeeInstance?.situation}" />
</div>

