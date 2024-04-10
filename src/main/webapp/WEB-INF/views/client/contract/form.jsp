<%--
- form.jsp
--%>

<%@page%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://acme-framework.org/"%>

<acme:form> 
	<acme:input-textbox code="client.contract.form.label.code" path="code"/>
	<acme:input-moment code="client.contract.form.label.instantiationMoment" path="instantiationMoment"/>	
	<acme:input-textbox code="client.contract.form.label.providerName" path="providerName"/>
	<acme:input-textbox code="client.contract.form.label.customerName" path="customerName"/>
	<acme:input-textbox code="client.contract.form.label.goals" path="goals"/>
	<acme:input-money code="client.contract.form.label.budget" path="budget" />

	<jstl:choose>	 
		<jstl:when test="${_command == 'show' && publish == true}">
		</jstl:when>	
	</jstl:choose>
</acme:form>
