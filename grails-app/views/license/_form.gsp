<%@ page import="com.cpqd.monet.license.License" %>



<div class="fieldcontain ${hasErrors(bean: licenseInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="license.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${licenseInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: licenseInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="license.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="day"  value="${licenseInstance?.startDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: licenseInstance, field: 'endDate', 'error')} required">
	<label for="endDate">
		<g:message code="license.endDate.label" default="End Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="endDate" precision="day"  value="${licenseInstance?.endDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: licenseInstance, field: 'licenseType', 'error')} required">
	<label for="licenseType">
		<g:message code="license.licenseType.label" default="License Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="licenseType" name="licenseType.id" from="${com.cpqd.monet.license.LicenseType.list()}" optionKey="id" required="" value="${licenseInstance?.licenseType?.id}" class="many-to-one"/>
</div>

