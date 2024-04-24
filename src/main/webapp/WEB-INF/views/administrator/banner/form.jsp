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
<<<<<<< HEAD
	<acme:input-moment code="administrator.banner.form.label.instantiationUpdateMoment" path="instantiationUpdateMoment"/>
			<acme:input-moment code="administrator.banner.form.label.displayStart" path="displayStart"/>
			<acme:input-moment code="administrator.banner.form.label.displayFinish" path="displayFinish"/>
			<acme:input-url code="administrator.banner.form.label.linkPicture" path="Picture"/>
			<acme:input-textbox code="administrator.banner.form.label.slogan" path="slogan"/>
			<acme:input-url code="administrator.banner.form.label.link" path="link"/>
			<acme:submit code="administrator.banner.form.button.delete" action="/administrator/banner/delete"/>
=======
	<acme:list-column code="administrator.banner.form.label.instantiationUpdateMoment" path="instantiationUpdateMoment"/>
	<acme:list-column code="administrator.banner.form.label.displayStart" path="displayStart"/>
	<acme:list-column code="administrator.banner.form.label.displayFinish" path="displayFinish"/>
	<acme:list-column code="administrator.banner.form.label.linkPicture" path="linkPicture"/>
	<acme:list-column code="administrator.banner.form.label.slogan" path="slogan"/>
	<acme:list-column code="administrator.banner.form.label.link" path="link"/>
	<acme:list-column code="administrator.banner.form.label.linkTarget" path="linkTarget"/>	
>>>>>>> refs/remotes/origin/main
</acme:form>
