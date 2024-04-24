<%--
- list.jsp
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

<acme:list>
	<acme:list-column code="manager.userStory.list.label.title" path="title"/>
	<acme:list-column code="manager.userStory.list.label.estimatedCost" path="estimatedCost"/>
	<acme:list-column code="manager.userStory.list.label.priority" path="priority"/>
	<acme:list-column code="manager.userStory.list.label.published" path="published"/>
</acme:list>
<%--	
<acme:button code="manager.userStory.list.button.create" action="/manager/userStory/create"/>

 <jstl:if test="${showAdd}">
	<acme:button code="manager.userStory.list.button.add" action="/manager/associated-with/create?projectId=${projectId}"/>
	<acme:button code="manager.userStory.list.button.remove" action="/manager/associated-with/delete?projectId=${projectId}"/>
</jstl:if>--%>

