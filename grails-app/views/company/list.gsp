<%@ page import="com.cpqd.monet.company.Company"%>

<div class="grid_10 prefix_1 suffix_1">

<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'company.label', default: 'Company')}" />
<title><g:message code="company.create.list.label" /></title>
	<a href="#list-company" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="create" action="create">
					<g:message code="company.create.label" />
				</g:link></li>
			<li><g:link class="create" action="createProspect">
					<g:message code="company.createProspect.label" />
				</g:link></li>
		</ul>
	</div>
	<h1 class="title">
		<g:message code="company.create.list.label" />
	</h1>
	<div id="list-company" class="content scaffold-list" role="main">
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<table>
			<thead>
				<tr>

					<g:sortableColumn property="cnpj"
						title="${message(code: 'company.cnpj.label', default: 'Cnpj')}" />

					<g:sortableColumn property="name"
						title="${message(code: 'company.name.label', default: 'Name')}" />

					<th><g:message code="company.companyType.label"
							default="Company Type" /></th>

					<g:sortableColumn property="fantasyName"
						title="${message(code: 'company.fantasyName.label', default: 'Fantasy Name')}" />

					<g:sortableColumn property="stateSubscription"
						title="${message(code: 'company.stateSubscription.label', default: 'State Subscription')}" />

					<g:sortableColumn property="municipalSubscription"
						title="${message(code: 'company.municipalSubscription.label', default: 'Municipal Subscription')}" />

					<g:sortableColumn property="zipCode"
						title="${message(code: 'company.zipCode.label', default: 'Zip code')}" />

					<g:sortableColumn property="zipCode"
						title="${message(code: 'company.uf.label', default: 'UF')}" />

				</tr>
			</thead>
			<tbody>
				<g:each in="${companyInstanceList}" status="i" var="companyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${companyInstance.id}">
								${fieldValue(bean: companyInstance, field: "cnpj")}
							</g:link></td>

						<td>
							${fieldValue(bean: companyInstance, field: "name")}
						</td>

						<td>
							${fieldValue(bean: companyInstance, field: "companyType.name")}
						</td>

						<td>
							${fieldValue(bean: companyInstance, field: "fantasyName")}
						</td>

						<td>
							${fieldValue(bean: companyInstance, field: "stateSubscription")}
						</td>

						<td>
							${fieldValue(bean: companyInstance, field: "municipalSubscription")}
						</td>

						<td>
							${fieldValue(bean: companyInstance, field: "zipCode")}
						</td>

						<td>
							${fieldValue(bean: companyInstance, field: "uf")}
						</td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</div>
	<div class="pagination">
		<g:paginate total="${companyInstanceTotal}" />
	</div>								
</div>