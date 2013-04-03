

<%@ page import="com.cpqd.monet.license.License" %>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'license.label', default: 'License')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#list-license" class="skip" tabindex="-1"><g:message
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
	<div id="list-license"
		class="content scaffold-list" role="main">
		<h1>
			<g:message code="default.list.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
		</g:if>
		<table>
			<thead>
				<tr>
					
						<g:sortableColumn property="password" title="${message(code: 'license.password.label', default: 'Password')}" />
					
						<g:sortableColumn property="startDate" title="${message(code: 'license.startDate.label', default: 'Start Date')}" />
					
						<g:sortableColumn property="endDate" title="${message(code: 'license.endDate.label', default: 'End Date')}" />
					
						<th><g:message code="license.licenseType.label" default="License Type" /></th>
					
				</tr>
			</thead>
			<tbody>
				<g:each in="${licenseInstanceList}" status="i"
					var="licenseInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
						<td><g:link action="show" id="${licenseInstance.id}">${fieldValue(bean: licenseInstance, field: "password")}</g:link></td>
					
						<td><g:formatDate date="${licenseInstance.startDate}" /></td>
					
						<td><g:formatDate date="${licenseInstance.endDate}" /></td>
					
						<td>${fieldValue(bean: licenseInstance, field: "licenseType")}</td>
					
					</tr>
				</g:each>
			</tbody>
		</table>
		<div class="pagination">
			<g:paginate total="${licenseInstanceTotal}" />
		</div>
	</div>
</body>
</html>
