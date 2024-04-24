<%--
- form.jsp
-
- Copyright (C) 2012-2024 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://acme-framework.org/"%>

<acme:form> 
	<acme:list-column code="sponsor.sponsorship.form.label.code" path="code"/>
	<acme:list-column code="sponsor.sponsorship.form.label.moment" path="moment"/>
	<acme:list-column code="sponsor.sponsorship.form.label.start" path="start"/>
	<acme:list-column code="sponsor.sponsorship.form.label.finish" path="finish"/>
	<acme:list-column code="sponsor.sponsorship.form.label.amount" path="amount"/>
	<acme:list-column code="sponsor.sponsorship.form.label.type" path="type"/>
	<acme:list-column code="sponsor.sponsorship.form.label.email" path="email"/>
	<acme:list-column code="sponsor.sponsorship.form.label.link" path="link"/>
	<acme:list-column code="sponsor.sponsorship.form.label.published" path="published"/>
	
	<jstl:choose>
		<jstl:when test="${_command == 'show' && published == true}">
			<acme:button code="sponsor.sponsorship.form.button.invoice" action="/sponsor/invoice/list?masterId=${id}"/>			
		</jstl:when>
		<jstl:when test="${acme:anyOf(_command, 'show|update|delete|publish') && published == false}">
		<acme:button code="sponsor.contract.form.button.progressLog" action="/sponsor/invoice/list?masterId=${id}"/>
			<acme:submit code="sponsor.sponsorship.form.button.update" action="/sponsor/sponsorship/update"/>
			<acme:submit code="sponsor.sponsorship.form.button.delete" action="/sponsor/sponsorship/delete"/>
			<acme:submit code="sponsor.sponsorship.form.button.publish" action="/sponsor/sponsorship/publish"/>
		</jstl:when>
		<jstl:when test="${_command == 'create'}">
			<acme:submit code="sponsor.sponsorship.list.button.create" action="/sponsor/sponsorship/create"/>
		</jstl:when>
	</jstl:choose>	
</acme:form>
