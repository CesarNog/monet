<%@ page import="com.cpqd.monet.company.Company"%>

<div class="grid_10 prefix_1 suffix_1">
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'company.label', default: 'Company')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
	<a href="#show-company" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="list" action="list">
					<g:message code="company.create.list.label" />
				</g:link></li>

			<li><g:link class="create" action="create">
					<g:message code="company.create.label" />
				</g:link></li>

		</ul>
	</div>
	<div id="show-company" class="content scaffold-show" role="main">
		<h1>
			<g:message code="company.show.title" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<ol class="property-list company">

			<g:if test="${companyInstance?.cnpj}">
				<li class="fieldcontain"><span id="cnpj-label"
					class="property-label"><g:message code="company.cnpj.label"
							default="Cnpj" /></span> <span class="property-value"
					aria-labelledby="cnpj-label"><g:fieldValue
							bean="${companyInstance}" field="cnpj" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.name}">
				<li class="fieldcontain"><span id="name-label"
					class="property-label"><g:message code="company.name.label"
							default="Name" /></span> <span class="property-value"
					aria-labelledby="name-label"><g:fieldValue
							bean="${companyInstance}" field="name" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.companyType}">
				<li class="fieldcontain"><span id="companyType-label"
					class="property-label"><g:message
							code="company.companyType.label" default="Company Type" /></span> <span
					class="property-value" aria-labelledby="companyType-label"><g:fieldValue
							bean="${companyInstance}" field="companyType.name" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.fantasyName}">
				<li class="fieldcontain"><span id="fantasyName-label"
					class="property-label"><g:message
							code="company.fantasyName.label" default="Fantasy Name" /></span> <span
					class="property-value" aria-labelledby="fantasyName-label"><g:fieldValue
							bean="${companyInstance}" field="fantasyName" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.stateSubscription}">
				<li class="fieldcontain"><span id="stateSubscription-label"
					class="property-label"><g:message
							code="company.stateSubscription.label"
							default="State Subscription" /></span> <span class="property-value"
					aria-labelledby="stateSubscription-label"><g:fieldValue
							bean="${companyInstance}" field="stateSubscription" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.municipalSubscription}">
				<li class="fieldcontain"><span id="municipalSubscription-label"
					class="property-label"><g:message
							code="company.municipalSubscription.label"
							default="Municipal Subscription" /></span> <span class="property-value"
					aria-labelledby="municipalSubscription-label"><g:fieldValue
							bean="${companyInstance}" field="municipalSubscription" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.zipCode}">
				<li class="fieldcontain"><span id="zipCode-label"
					class="property-label"><g:message
							code="company.zipCode.label" default="Zip Code" /></span> <span
					class="property-value" aria-labelledby="zipCode-label"><g:fieldValue
							bean="${companyInstance}" field="zipCode" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.uf}">
				<li class="fieldcontain"><span id="uf-label"
					class="property-label"><g:message code="company.uf.label"
							default="Uf" /></span> <span class="property-value"
					aria-labelledby="uf-label"><g:fieldValue
							bean="${companyInstance}" field="uf" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.locality}">
				<li class="fieldcontain"><span id="locality-label"
					class="property-label"><g:message
							code="company.locality.label" default="Locality" /></span> <span
					class="property-value" aria-labelledby="locality-label"><g:fieldValue
							bean="${companyInstance}" field="locality" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.streetType}">
				<li class="fieldcontain"><span id="streetType-label"
					class="property-label"><g:message
							code="company.streetType.label" default="Street Type" /></span> <span
					class="property-value" aria-labelledby="streetType-label"><g:fieldValue
							bean="${companyInstance}" field="streetType.name" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.streetTitle}">
				<li class="fieldcontain"><span id="streetTitle-label"
					class="property-label"><g:message
							code="company.streetTitle.label" default="Street Title" /></span> <span
					class="property-value" aria-labelledby="streetTitle-label"><g:fieldValue
							bean="${companyInstance}" field="streetTitle.name" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.street}">
				<li class="fieldcontain"><span id="street-label"
					class="property-label"><g:message
							code="company.street.label" default="Street" /></span> <span
					class="property-value" aria-labelledby="street-label"><g:fieldValue
							bean="${companyInstance}" field="street" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.streetNumber}">
				<li class="fieldcontain"><span id="streetNumber-label"
					class="property-label"><g:message
							code="company.streetNumber.label" default="Street Number" /></span> <span
					class="property-value" aria-labelledby="streetNumber-label"><g:fieldValue
							bean="${companyInstance}" field="streetNumber" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.complementType}">
				<li class="fieldcontain"><span id="complementType-label"
					class="property-label"><g:message
							code="company.complementType.label" default="Complement Type" /></span>

					<span class="property-value" aria-labelledby="complementType-label"><g:fieldValue
							bean="${companyInstance}" field="complementType.name" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.complementDescription}">
				<li class="fieldcontain"><span id="complementDescription-label"
					class="property-label"><g:message
							code="company.complementDescription.label"
							default="Complement Description" /></span> <span class="property-value"
					aria-labelledby="complementDescription-label"><g:fieldValue
							bean="${companyInstance}" field="complementDescription" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.neighborhood}">
				<li class="fieldcontain"><span id="neighborhood-label"
					class="property-label"><g:message
							code="company.neighborhood.label" default="Neighborhood" /></span> <span
					class="property-value" aria-labelledby="neighborhood-label"><g:fieldValue
							bean="${companyInstance}" field="neighborhood" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.contactName}">
				<li class="fieldcontain"><span id="contactName-label"
					class="property-label"><g:message
							code="company.contactName.label" default="Contact Name" /></span> <span
					class="property-value" aria-labelledby="contactName-label"><g:fieldValue
							bean="${companyInstance}" field="contactName" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.contactPhone}">
				<li class="fieldcontain"><span id="contactPhone-label"
					class="property-label"><g:message
							code="company.contactPhone.label" default="Contact Phone" /></span> <span
					class="property-value" aria-labelledby="contactPhone-label"><g:fieldValue
							bean="${companyInstance}" field="contactPhone" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.contactEmail}">
				<li class="fieldcontain"><span id="contactEmail-label"
					class="property-label"><g:message
							code="company.contactEmail.label" default="Contact Email" /></span> <span
					class="property-value" aria-labelledby="contactEmail-label"><g:fieldValue
							bean="${companyInstance}" field="contactEmail" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.socialReason}">
				<li class="fieldcontain"><span id="socialReason-label"
					class="property-label"><g:message
							code="company.socialReason.label" default="Social Reason" /></span> <span
					class="property-value" aria-labelledby="socialReason-label"><g:fieldValue
							bean="${companyInstance}" field="socialReason" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.city}">
				<li class="fieldcontain"><span id="city-label"
					class="property-label"><g:message code="company.city.label"
							default="City" /></span> <span class="property-value"
					aria-labelledby="city-label"><g:fieldValue
							bean="${companyInstance}" field="city" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.ddd}">
				<li class="fieldcontain"><span id="ddd-label"
					class="property-label"><g:message code="company.ddd.label"
							default="Ddd" /></span> <span class="property-value"
					aria-labelledby="ddd-label"><g:fieldValue
							bean="${companyInstance}" field="ddd" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.telephoneNumber}">
				<li class="fieldcontain"><span id="telephoneNumber-label"
					class="property-label"><g:message
							code="company.telephoneNumber.label" default="Telephone Number" /></span>

					<span class="property-value"
					aria-labelledby="telephoneNumber-label"><g:fieldValue
							bean="${companyInstance}" field="telephoneNumber" /></span></li>
			</g:if>

			<g:if test="${companyInstance?.userPassword}">
				<li class="fieldcontain"><span id="userPassword-label"
					class="property-label"><g:message
							code="company.userPassword.label" default="User Password" /></span> <span
					class="property-value" aria-labelledby="userPassword-label"><g:fieldValue
							bean="${companyInstance}" field="userPassword" /></span></li>
			</g:if>

		</ol>
		<g:form>
			<fieldset class="buttons">
				<g:hiddenField name="id" value="${companyInstance?.id}" />
				<g:link class="edit" action="edit" id="${companyInstance?.id}">
					<g:message code="default.button.edit.label" default="Edit" />
				</g:link>
			</fieldset>
		</g:form>
	</div>
</div>