<%--
- form.jsp
--%>

<%@page%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://acme-framework.org/"%>

<h2>
	<acme:message code="client.dashboard.form.title.general-indicators"/>
</h2>

<table class="table table-sm">
	<tr>
		<th scope="row">
			<acme:message code="client.dashboard.form.label.percentage-Of-Total-Number-Completeness-25"/>
		</th>
		<td>
			<acme:print value="${percentageOfTotalNumberCompleteness25}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="client.dashboard.form.label.percentage-Of-Total-Number-Completeness-25-At-50"/>
		</th>
		<td>
			<acme:print value="${percentageOfTotalNumberCompleteness25At50}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="client.dashboard.form.label.percentage-Of-Total-Number-Completeness-50-at-75"/>
		</th>
		<td>
			<acme:print value="${percentageOfTotalNumberCompleteness50at75}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="client.dashboard.form.label.percentage-Of-Total-Number-Completeness-More-75"/>
		</th>
		<td>
			<acme:print value="${percentageOfTotalNumberCompletenessMore75}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="client.dashboard.form.label.average-Budget-Of-Contract"/>
		</th>
		<td>
			<acme:print value="${averageBudgetOfContract}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="client.dashboard.form.label.deviation-Budget-Of-Contract"/>
		</th>
		<td>
			<acme:print value="${deviationBudgetOfContract}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="client.dashboard.form.label.minimum-Budget-Of-Contract"/>
		</th>
		<td>
			<acme:print value="${minimumBudgetOfContract}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="client.dashboard.form.label.maximum-Budget-Of-Contract"/>
		</th>
		<td>
			<acme:print value="${maximumBudgetOfContract}"/>
		</td>
	</tr>
</table>


<div>
	<canvas id="canvas"></canvas>
</div>

<acme:return/>

