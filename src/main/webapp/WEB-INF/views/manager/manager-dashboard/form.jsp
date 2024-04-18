<%--
- form.jsp
--%>

<%@page%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://acme-framework.org/"%>

<h2>
	<acme:message code="manager.dashboard.form.title.general-indicators"/>
</h2>

<table class="table table-sm">
	<tr>
		<th scope="row">
			<acme:message code="manager.dashboard.form.label.totalNumberMustUserStories"/>
		</th>
		<td>
			<acme:print value="${totalNumberMustUserStories}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="manager.dashboard.form.label.totalNumberShouldUserStories"/>
		</th>
		<td>
			<acme:print value="${totalNumberShouldUserStories}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="manager.dashboard.form.label.totalNumberCouldUserStories"/>
		</th>
		<td>
			<acme:print value="${totalNumberCouldUserStories}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="manager.dashboard.form.label.totalNumberWontUserStories"/>
		</th>
		<td>
			<acme:print value="${totalNumberWontUserStories}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="manager.dashboard.form.label.averageEstimatedCostUserStories"/>
		</th>
		<td>
			<acme:print value="${averageEstimatedCostUserStories}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="manager.dashboard.form.label.deviationEstimatedCostUserStories"/>
		</th>
		<td>
			<acme:print value="${deviationEstimatedCostUserStories}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="manager.dashboard.form.label.minimunEstimatedCostUserStories"/>
		</th>
		<td>
			<acme:print value="${minimunEstimatedCostUserStories}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="manager.dashboard.form.label.maximumEstimatedCostUserStories"/>
		</th>
		<td>
			<acme:print value="${maximumEstimatedCostUserStories}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="manager.dashboard.form.label.averageCostProjects"/>
		</th>
		<td>
			<acme:print value="${averageCostProjects}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="manager.dashboard.form.label.deviationCostProjects"/>
		</th>
		<td>
			<acme:print value="${deviationCostProjects}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="manager.dashboard.form.label.minimunCostProjects"/>
		</th>
		<td>
			<acme:print value="${minimunCostProjects}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="manager.dashboard.form.label.maximumCostProjects"/>
		</th>
		<td>
			<acme:print value="${maximumCostProjects}"/>
		</td>
	</tr>
</table>


<div>
	<canvas id="canvas"></canvas>
</div>

<acme:return/>

