<%@ page import="com.cpqd.monet.prospect.Prospect" %>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'prospect.label', default: 'Prospect')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#list-prospect" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a>
			</li>
			<li><g:link class="create" action="create">
					<g:message code="prospect.create.label" />
				</g:link>
			</li>
		</ul>
	</div>
	<div id="list-prospect"
		class="content scaffold-list" role="main">
		<h1>
			<g:message code="prospect.list.label"/>
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
		</g:if>
		<table>
			<thead>
				<tr>					
						<g:sortableColumn property="cnpj" title="${message(code: 'prospect.cnpj.label', default: 'Cnpj')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'prospect.name.label', default: 'Name')}" />
						
						<g:sortableColumn property="contact.name" title="${message(code: 'contact.name.label', default: 'Name')}" />					
				</tr>
			</thead>
			<tbody>
				<g:each in="${prospectInstanceList}" status="i"
					var="prospectInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${prospectInstance.id}">${fieldValue(bean: prospectInstance, field: "cnpj")}</g:link></td>

						<td>${fieldValue(bean: prospectInstance, field: "name")}</td>

						<td>${fieldValue(bean: prospectInstance, field: "contact.name")}</td>

					</tr>
				</g:each>
			</tbody>
		</table>
		<div class="pagination">
			<g:paginate total="${prospectInstanceTotal}" />
		</div>
	</div>