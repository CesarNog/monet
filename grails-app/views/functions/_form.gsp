<%@ page import="com.cpqd.monet.functions.Functions" %>



<div class="fieldcontain ${hasErrors(bean: functionsInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="functions.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" maxlength="30" required="" value="${functionsInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: functionsInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="functions.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="day"  value="${functionsInstance?.startDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: functionsInstance, field: 'endDate', 'error')} required">
	<label for="endDate">
		<g:message code="functions.endDate.label" default="End Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="endDate" precision="day"  value="${functionsInstance?.endDate}"  />
</div>

