<%--
- menu.jsp
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
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" uri="http://acme-framework.org/"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-davvarmun" action="https://www.autodoc.es/"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-davguifer" action="https://ev.us.es/ultra/course"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-luigirsan1" action="https://www.youtube.com/watch?v=xvFZjo5PgG0&ab_channel=Duran"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-alevarmun1" action="https://motos.coches.net/"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-rafmolgar2" action="https://play.pokemonshowdown.com/"/>
		</acme:menu-option>


		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.list.claim" action="/any/claim/list-service"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.populate-initial" action="/administrator/system/populate-initial"/>
			<acme:menu-suboption code="master.menu.administrator.populate-sample" action="/administrator/system/populate-sample"/>			
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shut-down" action="/administrator/system/shut-down"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.list.banner" action="/administrator/banner/list-service"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.sponsor" access="hasRole('Sponsor')">
			<acme:menu-suboption code="master.menu.sponsor.list.sponsorship" action="/sponsor/sponsorship/list-service"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.sponsor.list.invoice" action="/sponsor/invoice/list-service"/>
    	</acme:menu-option>
		
		<acme:menu-option code="master.menu.client" access="hasRole('Client')">
			<acme:menu-suboption code="master.menu.client.dashboard" action="/client/client-dashboard/show"/>
			<acme:menu-suboption code="master.menu.client.list" action="/client/contract/list-service"/>
    </acme:menu-option>

		<acme:menu-option code="master.menu.manager" access="hasRole('Manager')">
			<acme:menu-suboption code="master.menu.manager.list.project" action="/manager/project/list-mine"/>
			<acme:menu-suboption code="master.menu.manager.dashboard" action="/manager/manager-dashboard/show"/>
			<acme:menu-suboption code="master.menu.manager.my-userStories" action="/manager/user-story/list-mine"/>	
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.developer" access="hasRole('Developer')">
			<acme:menu-suboption code="master.menu.developer.list.trainingModule" action="/developer/trainingModule/list-mine"/>
		</acme:menu-option>
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/anonymous/system/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create" access="!hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update" access="hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create" access="!hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update" access="hasRole('Consumer')"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/authenticated/system/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>
<!-- Añade el banner en la parte de arriba del menu -->
<%-- Comprueba si el banner esta disponible (preguntar lo de las fechas como lo tengo en el bloc de notas) --%>
<jstl:if test="${banner != null}"> 
    <div style="padding: 10px; background-color: #f0f0f0; text-align: center;">
        <a href="${banner.linkTarget}" target="_blank">
            <img src="${banner.linkPicture}" alt="${banner.slogan}" style="max-width: 100%; height: auto;"/>
        </a>
    </div>
</jstl:if>

