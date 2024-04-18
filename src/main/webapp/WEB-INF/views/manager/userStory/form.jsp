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
	<acme:input-textbox code="manager.userStory.form.label.title" path="title"/>
	<acme:input-textarea code="manager.userStory.form.label.description" path="description"/>
	<acme:input-integer code="manager.userStory.form.label.estimatedCost" path="estimatedCost"/>
	<acme:input-textarea code="manager.userStory.form.label.acceptanceCriteria" path="acceptanceCriteria"/>
	<acme:input-textbox code="manager.userStory.form.label.priority" path="priority"/>
	<acme:input-url code="manager.userStory.form.label.link" path="link"/>
	<acme:input-checkbox code="manager.userStory.form.label.published" path="published" readonly = "true"/>
	<acme:input-textbox code="manager.userStory.form.label.managerUsername" path="manager" readonly = "true"/>
</acme:form>
