<div class="fieldcontain">
	<label for="${name + '.' +field}"> 
		<g:message code="${label}" />: 
			<span class="errors"> 
				<g:fieldError bean="${bean}" 
				              field="${field}" />
			</span>
	</label>
	<g:select id="${id}" name="${name + '.' +field}"
		from="${fromSelect}" optionKey="id"
		optionValue="name" required="true"
		value="${fieldValue(bean:bean, field:field?.id)}" class="many-to-one" />			     
</div>