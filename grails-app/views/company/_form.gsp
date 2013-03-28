<<<<<<< HEAD
<%@ page import="com.cpqd.monet.company.Company"%>

<div class="fieldcontain">
	<label for="companyType"> <span class="required-indicator">*</span>
		<g:message code="company.companyType.label" default="Company Type" />:
	</label>
	<g:select id="companyType" name="companyType.id"
		from="${com.cpqd.monet.company.CompanyType.list()}" optionKey="id"
		optionValue="name" required="true"
		value="${companyInstance?.companyType?.id}" class="many-to-one" />
</div>

<div class="fieldcontain">
	<label for="cnpj"> <span class="required-indicator">*</span> <g:message
			code="company.cnpj.label" default="Cnpj" />:
	</label>
	<g:field type="text" name="cnpj" maxlength="20" required=""
		value="${companyInstance?.cnpj}" autofocus="true" readonly="${companyInstance?.cnpj != null}"/>
</div>

<div class="fieldcontain">
	<label for="name"> <span class="required-indicator">*</span> <g:message
			code="company.name.label" default="Name" />:
	</label>
	<g:textField name="name" maxlength="50" required="" value="${companyInstance?.name}" readonly="${companyInstance?.name} != null"/>
</div>

<div class="fieldcontain">
	<label for="fantasyName"> <span class="required-indicator">*</span>
		<g:message code="company.fantasyName.label" default="Fantasy Name" />:
	</label>
	<g:textField name="fantasyName" maxlength="50"
		value="${companyInstance?.fantasyName}" />
</div>

<div class="fieldcontain">
	<label for="stateSubscription"> <span
		class="required-indicator">*</span> <g:message
			code="company.stateSubscription.label" default="State Subscription" />:
	</label>
	<g:textField name="stateSubscription" maxlength="20"
		value="${companyInstance?.stateSubscription}" />
</div>

<div class="fieldcontain">
	<label for="municipalSubscription"> <span
		class="required-indicator">*</span> <g:message
			code="company.municipalSubscription.label"
			default="Municipal Subscription" />:
	</label>
	<g:textField name="municipalSubscription" maxlength="20"
		value="${companyInstance?.municipalSubscription}" />
</div>

<div class="fieldcontain">
	<label for="zipCode"> <span class="required-indicator">*</span>
		<g:message code="company.zipCode.label" default="Zip Code" />:
	</label>
	<g:textField name="zipCode" maxlength="9" required="true"
		value="${companyInstance?.zipCode}" />
</div>

<div
	class="fieldcontain ${hasErrors(bean: companyInstance, field: 'uf', 'error')} required">
	<label for="uf"> <span class="required-indicator">*</span> <g:message
			code="company.uf.label" default="Uf" />:
	</label>
	<g:textField name="uf" maxlength="50" required="true"
		value="${companyInstance?.uf}" />
</div>

<div
	class="fieldcontain ${hasErrors(bean: companyInstance, field: 'locality', 'error')} required">
	<label for="locality"> <span class="required-indicator">*</span>
		<g:message code="company.locality.label" default="Locality" />:
	</label>
	<g:textField name="locality" maxlength="50"
		value="${companyInstance?.locality}" />
</div>

<div
	class="fieldcontain ${hasErrors(bean: companyInstance, field: 'streetType', 'error')} ">
	<label for="streetType"> <g:message
			code="company.streetType.label" default="Street Type" />:

	</label>
	<g:select id="streetType" name="streetType.id"
		from="${com.cpqd.monet.street.StreetType.list()}" optionKey="id"
		optionValue="name" value="${companyInstance?.streetType?.id}"
		class="many-to-one" noSelection="['null': '']" />
</div>

<div
	class="fieldcontain">
	<label for="streetTitle"> <span class="required-indicator">*</span>
		<g:message code="company.streetTitle.label" default="Street Title" />:
	</label>
	<g:select id="streetTitle" name="streetTitle.id"
		from="${com.cpqd.monet.street.StreetTitle.list()}" optionKey="id"
		optionValue="name" value="${companyInstance?.streetTitle?.id}"
		class="many-to-one" noSelection="['null': '']" />
</div>

<div
	class="fieldcontain">
	<label for="street"> <g:message code="company.street.label"
			default="Street" />:
	</label>
	<g:textField name="street" value="${companyInstance?.street}" />
</div>

<div
	class="fieldcontain">
	<label for="streetNumber"> <span class="required-indicator">*</span>
		<g:message code="company.streetNumber.label" default="Street Number" />:
	</label>
	<g:field name="streetNumber" required="true" type="number" min="0"
		value="${companyInstance?.streetNumber}" />
</div>

<div
	class="fieldcontain">
	<label for="complementType"> <span class="required-indicator">*</span>
		<g:message code="company.complementType.label"
			default="Complement Type" />:
	</label>
	<g:select id="complementType" name="complementType.id"
		from="${com.cpqd.monet.company.ComplementType.list()}" optionKey="id"
		optionValue="name" value="${companyInstance?.complementType?.id}"
		class="many-to-one" noSelection="['null': '']" />
</div>

<div
	class="fieldcontain">
	<label for="complementDescription"> <g:message
			code="company.complementDescription.label"
			default="Complement Description" />:
	</label>
	<g:textField name="complementDescription"
		value="${companyInstance?.complementDescription}" />
</div>

<div
	class="fieldcontain">
	<label for="neighborhood"> <span class="required-indicator">*</span>
		<g:message code="company.neighborhood.label" default="Neighborhood" />:
	</label>
	<g:textField name="neighborhood" required="true" maxlength="50"
		value="${companyInstance?.neighborhood}" />
</div>

<div
	class="fieldcontain">
	<label for="contactName"> <span class="required-indicator">*</span>
		<g:message code="company.contact.name.label" default="Contact Name" />:
	</label>
	<g:textField name="contactName" maxlength="50" required="true"
		value="${companyInstance?.contact?.name}" />
</div>

<div
	class="fieldcontain">
	<label for="contactPhone"> <g:message
			code="company.contact.phone.label" required="true"
			default="Contact Phone" />:
	</label>
	<g:textField name="contactPhone" maxlength="12"
		value="${companyInstance?.contact?.phone}" />
</div>

<div
	class="fieldcontain">
	<label for="contactEmail"> <g:message
			code="company.contact.email.label" default="Contact Email" />:

	</label>
	<g:field type="email" name="contactEmail"
		value="${companyInstance?.contact?.email}" readonly="${companyInstance?.contact?.email} != null" />
</div>

<div
	class="fieldcontain">
	<label for="socialReason"> <g:message
			code="company.socialReason.label" default="Social Reason" />:

	</label>
	<g:textField name="socialReason" maxlength="50"
		value="${companyInstance?.socialReason}" />
</div>

<div
	class="fieldcontain">
	<label for="city"> <g:message code="company.city.label"
			default="City" />:

	</label>
	<g:textField name="city" maxlength="50"
		value="${companyInstance?.city}" />
</div>

<div
	class="fieldcontain">
	<label for="telephoneNumber"> <g:message
			code="company.telephoneNumber.label" default="Telephone Number" />:
	</label>
	<g:field name="telephoneNumber" maxlength="20" type="number"
		value="${companyInstance?.telephoneNumber}" />
</div>

<div
	class="fieldcontain">
	<label for="userPassword"> <g:message
			code="company.userPassword.label" default="User Password" />:

	</label>
	<g:field type="password" name="userPassword"
		value="${companyInstance?.userPassword}" />
</div>

=======
<%@ page import="com.cpqd.monet.company.Company"%>

<div class="fieldcontain">
	<label for="companyType"> <span class="required-indicator">*</span>
		<g:message code="company.companyType.label" default="Company Type" />:
	</label>
	<g:select id="companyType" name="companyType.id"
		from="${com.cpqd.monet.company.CompanyType.list()}" optionKey="id"
		optionValue="name" required="true"
		value="${companyInstance?.companyType?.id}" class="many-to-one" />
</div>

<div class="fieldcontain">
	<label for="cnpj"> <span class="required-indicator">*</span> <g:message
			code="company.cnpj.label" default="Cnpj" />:
	</label>
	<g:field type="text" name="cnpj" maxlength="20" required=""
		value="${companyInstance?.cnpj}" autofocus="true" readonly="${companyInstance?.cnpj != null}"/>
</div>

<div class="fieldcontain">
	<label for="name"> <span class="required-indicator">*</span> <g:message
			code="company.name.label" default="Name" />:
	</label>
	<g:textField name="name" maxlength="50" required="" value="${companyInstance?.name}" readonly="${companyInstance?.name} != null"/>
</div>

<div class="fieldcontain">
	<label for="fantasyName"> <span class="required-indicator">*</span>
		<g:message code="company.fantasyName.label" default="Fantasy Name" />:
	</label>
	<g:textField name="fantasyName" maxlength="50"
		value="${companyInstance?.fantasyName}" />
</div>

<div class="fieldcontain">
	<label for="stateSubscription"> <span
		class="required-indicator">*</span> <g:message
			code="company.stateSubscription.label" default="State Subscription" />:
	</label>
	<g:textField name="stateSubscription" maxlength="20"
		value="${companyInstance?.stateSubscription}" />
</div>

<div class="fieldcontain">
	<label for="municipalSubscription"> <span
		class="required-indicator">*</span> <g:message
			code="company.municipalSubscription.label"
			default="Municipal Subscription" />:
	</label>
	<g:textField name="municipalSubscription" maxlength="20"
		value="${companyInstance?.municipalSubscription}" />
</div>

<div class="fieldcontain">
	<label for="zipCode"> <span class="required-indicator">*</span>
		<g:message code="company.zipCode.label" default="Zip Code" />:
	</label>
	<g:textField name="zipCode" maxlength="9" required="true"
		value="${companyInstance?.zipCode}" />
</div>

<div
	class="fieldcontain ${hasErrors(bean: companyInstance, field: 'uf', 'error')} required">
	<label for="uf"> <span class="required-indicator">*</span> <g:message
			code="company.uf.label" default="Uf" />:
	</label>
	<g:textField name="uf" maxlength="50" required="true"
		value="${companyInstance?.uf}" />
</div>

<div
	class="fieldcontain ${hasErrors(bean: companyInstance, field: 'locality', 'error')} required">
	<label for="locality"> <span class="required-indicator">*</span>
		<g:message code="company.locality.label" default="Locality" />:
	</label>
	<g:textField name="locality" maxlength="50"
		value="${companyInstance?.locality}" />
</div>

<div
	class="fieldcontain ${hasErrors(bean: companyInstance, field: 'streetType', 'error')} ">
	<label for="streetType"> <g:message
			code="company.streetType.label" default="Street Type" />:

	</label>
	<g:select id="streetType" name="streetType.id"
		from="${com.cpqd.monet.address.StreetType.list()}" optionKey="id"
		optionValue="name" value="${companyInstance?.streetType?.id}"
		class="many-to-one" noSelection="['null': '']" />
</div>

<div
	class="fieldcontain">
	<label for="streetTitle"> <span class="required-indicator">*</span>
		<g:message code="company.streetTitle.label" default="Street Title" />:
	</label>
	<g:select id="streetTitle" name="streetTitle.id"
		from="${com.cpqd.monet.address.StreetTitle.list()}" optionKey="id"
		optionValue="name" value="${companyInstance?.streetTitle?.id}"
		class="many-to-one" noSelection="['null': '']" />
</div>

<div
	class="fieldcontain">
	<label for="street"> <g:message code="company.street.label"
			default="Street" />:
	</label>
	<g:textField name="street" value="${companyInstance?.street}" />
</div>

<div
	class="fieldcontain">
	<label for="streetNumber"> <span class="required-indicator">*</span>
		<g:message code="company.streetNumber.label" default="Street Number" />:
	</label>
	<g:field name="streetNumber" required="true" type="number" min="0"
		value="${companyInstance?.streetNumber}" />
</div>

<div
	class="fieldcontain">
	<label for="complementType"> <span class="required-indicator">*</span>
		<g:message code="company.complementType.label"
			default="Complement Type" />:
	</label>
	<g:select id="complementType" name="complementType.id"
		from="${com.cpqd.monet.company.ComplementType.list()}" optionKey="id"
		optionValue="name" value="${companyInstance?.complementType?.id}"
		class="many-to-one" noSelection="['null': '']" />
</div>

<div
	class="fieldcontain">
	<label for="complementDescription"> <g:message
			code="company.complementDescription.label"
			default="Complement Description" />:
	</label>
	<g:textField name="complementDescription"
		value="${companyInstance?.complementDescription}" />
</div>

<div
	class="fieldcontain">
	<label for="neighborhood"> <span class="required-indicator">*</span>
		<g:message code="company.neighborhood.label" default="Neighborhood" />:
	</label>
	<g:textField name="neighborhood" required="true" maxlength="50"
		value="${companyInstance?.neighborhood}" />
</div>

<div
	class="fieldcontain">
	<label for="contactName"> <span class="required-indicator">*</span>
		<g:message code="company.contact.name.label" default="Contact Name" />:
	</label>
	<g:textField name="contactName" maxlength="50" required="true"
		value="${companyInstance?.contact?.name}" />
</div>

<div
	class="fieldcontain">
	<label for="contactPhone"> <g:message
			code="company.contact.phone.label" required="true"
			default="Contact Phone" />:
	</label>
	<g:textField name="contactPhone" maxlength="12"
		value="${companyInstance?.contact?.phone}" />
</div>

<div
	class="fieldcontain">
	<label for="contactEmail"> <g:message
			code="company.contact.email.label" default="Contact Email" />:

	</label>
	<g:field type="email" name="contactEmail"
		value="${companyInstance?.contact?.email}" readonly="${companyInstance?.contact?.email} != null" />
</div>

<div
	class="fieldcontain">
	<label for="socialReason"> <g:message
			code="company.socialReason.label" default="Social Reason" />:

	</label>
	<g:textField name="socialReason" maxlength="50"
		value="${companyInstance?.socialReason}" />
</div>

<div
	class="fieldcontain">
	<label for="city"> <g:message code="company.city.label"
			default="City" />:

	</label>
	<g:textField name="city" maxlength="50"
		value="${companyInstance?.city}" />
</div>

<div
	class="fieldcontain">
	<label for="telephoneNumber"> <g:message
			code="company.telephoneNumber.label" default="Telephone Number" />:
	</label>
	<g:field name="telephoneNumber" maxlength="20" type="number"
		value="${companyInstance?.telephoneNumber}" />
</div>

<div
	class="fieldcontain">
	<label for="userPassword"> <g:message
			code="company.userPassword.label" default="User Password" />:

	</label>
	<g:field type="password" name="userPassword"
		value="${companyInstance?.userPassword}" />
</div>

>>>>>>> refs/remotes/origin/master
