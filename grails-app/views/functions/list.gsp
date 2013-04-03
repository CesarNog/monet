

<%@ page import="com.cpqd.monet.functions.Functions" %>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'functions.label', default: 'Functions')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#list-functions" class="skip" tabindex="-1"><g:message
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
	<div id="list-functions"
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
					
						<g:sortableColumn property="description" title="${message(code: 'functions.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="startDate" title="${message(code: 'functions.startDate.label', default: 'Start Date')}" />
					
						<g:sortableColumn property="endDate" title="${message(code: 'functions.endDate.label', default: 'End Date')}" />
					
				</tr>
			</thead>
			<tbody>
				<g:each in="${functionsInstanceList}" status="i"
					var="functionsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
						<td><g:link action="show" id="${functionsInstance.id}">${fieldValue(bean: functionsInstance, field: "description")}</g:link></td>
					
						<td><g:formatDate date="${functionsInstance.startDate}" /></td>
					
						<td><g:formatDate date="${functionsInstance.endDate}" /></td>
					
					</tr>
				</g:each>
			</tbody>
		</table>
		<div class="pagination">
			<g:paginate total="${functionsInstanceTotal}" />
		</div>
	</div>
</body>
</html>
