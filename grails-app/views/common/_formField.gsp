<div class="fieldcontain">
	<label for="${name + '.' +field}"> 
		<g:message code="${label}" />: 
			<span class="errors"> 
				<g:fieldError bean="${bean}" 
				              field="${field}" />
			</span>
	</label>
	<g:textField name="${name + '.' +field}"
			     value="${fieldValue(bean:bean, field:field)}" />
</div>