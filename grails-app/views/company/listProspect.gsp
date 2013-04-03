
<%@ page import="com.cpqd.monet.company.Company"%>
<!DOCTYPE html>
<html>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'company.label', default: 'Company')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
	<a href="#list-company" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="create" action="create">
					<g:message code="default.new.label" args="[entityName]" />
				</g:link></li>
		</ul>
	</div>
	<div id="list-company" class="content scaffold-list" role="main">
		<h1>
			<g:message code="default.list.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<table>
			<thead>
				<tr>

					<g:sortableColumn property="companyName"
						title="${message(code: 'company.list.companyName.label', default: 'Company Name')}" />

					<g:sortableColumn property="cnpj"
						title="${message(code: 'company.list.cnpj.label', default: 'Cnpj')}" />

					<g:sortableColumn property="contactName"
						title="${message(code: 'company.list.contactName.label', default: 'Contact Name')}" />

					<g:sortableColumn property="contactPhone"
						title="${message(code: 'company.list.contactPhone.label', default: 'Contact Phone')}" />

					<g:sortableColumn property="email"
						title="${message(code: 'company.list.email.label', default: 'Email')}" />

				</tr>
			</thead>
			<tbody>
				<g:each in="${companyInstanceList}" status="i" var="companyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${companyInstance.id}">
								${fieldValue(bean: companyInstance, field: "name")}
							</g:link></td>

						<td>
							${fieldValue(bean: companyInstance, field: "cnpj")}
						</td>

						<td>
							${fieldValue(bean: companyInstance, field: "contact.name")}
						</td>

						<td>
							${fieldValue(bean: companyInstance, field: "contact.phone")}
						</td>

						<td>
							${fieldValue(bean: companyInstance, field: "contact.phone")}
						</td>

					</tr>
				</g:each>
			</tbody>
		</table>
		<div class="pagination">
			<g:paginate total="${companyInstanceTotal}" />
		</div>
	</div>
</html>
