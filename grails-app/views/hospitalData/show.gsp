
<%@ page import="hascstudy.HospitalData" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'hospitalData.label', default: 'HospitalData')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-hospitalData" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="home" controller="user" action="index" id="${userInstance.id}"><g:message code="default.home.label" default="Home" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="edit" controller="user" action="edit" id="${userInstance.id}"><g:message code="Edit Profile" default="Edit Profile" /></g:link></li>
				<li><a class="logout" href="${createLink(uri: '/user/logout')}"><g:message code="Logout"/></a></li>
			</ul>
		</div>
		<div id="show-hospitalData" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list hospitalData">
			
				<g:if test="${hospitalDataInstance?.avaregeRoomTurnAroundAllPatients}">
				<li class="fieldcontain">
					<span id="avaregeRoomTurnAroundAllPatients-label" class="property-label"><g:message code="hospitalData.avaregeRoomTurnAroundAllPatients.label" default="Avarege Room Turn Around All Patients" /></span>
					
						<span class="property-value" aria-labelledby="avaregeRoomTurnAroundAllPatients-label"><g:fieldValue bean="${hospitalDataInstance}" field="avaregeRoomTurnAroundAllPatients"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.avaregeRoomTurnAroundInPatients}">
				<li class="fieldcontain">
					<span id="avaregeRoomTurnAroundInPatients-label" class="property-label"><g:message code="hospitalData.avaregeRoomTurnAroundInPatients.label" default="Avarege Room Turn Around In Patients" /></span>
					
						<span class="property-value" aria-labelledby="avaregeRoomTurnAroundInPatients-label"><g:fieldValue bean="${hospitalDataInstance}" field="avaregeRoomTurnAroundInPatients"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.avaregeRoomTurnAroundOutPatients}">
				<li class="fieldcontain">
					<span id="avaregeRoomTurnAroundOutPatients-label" class="property-label"><g:message code="hospitalData.avaregeRoomTurnAroundOutPatients.label" default="Avarege Room Turn Around Out Patients" /></span>
					
						<span class="property-value" aria-labelledby="avaregeRoomTurnAroundOutPatients-label"><g:fieldValue bean="${hospitalDataInstance}" field="avaregeRoomTurnAroundOutPatients"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.avaregeRoomTurnAroundPhysicians}">
				<li class="fieldcontain">
					<span id="avaregeRoomTurnAroundPhysicians-label" class="property-label"><g:message code="hospitalData.avaregeRoomTurnAroundPhysicians.label" default="Avarege Room Turn Around Physicians" /></span>
					
						<span class="property-value" aria-labelledby="avaregeRoomTurnAroundPhysicians-label"><g:fieldValue bean="${hospitalDataInstance}" field="avaregeRoomTurnAroundPhysicians"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.avaregeRoomUtilizationInTotal}">
				<li class="fieldcontain">
					<span id="avaregeRoomUtilizationInTotal-label" class="property-label"><g:message code="hospitalData.avaregeRoomUtilizationInTotal.label" default="Avarege Room Utilization In Total" /></span>
					
						<span class="property-value" aria-labelledby="avaregeRoomUtilizationInTotal-label"><g:fieldValue bean="${hospitalDataInstance}" field="avaregeRoomUtilizationInTotal"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.avaregeRoomUtilizationPrimeTime}">
				<li class="fieldcontain">
					<span id="avaregeRoomUtilizationPrimeTime-label" class="property-label"><g:message code="hospitalData.avaregeRoomUtilizationPrimeTime.label" default="Avarege Room Utilization Prime Time" /></span>
					
						<span class="property-value" aria-labelledby="avaregeRoomUtilizationPrimeTime-label"><g:fieldValue bean="${hospitalDataInstance}" field="avaregeRoomUtilizationPrimeTime"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.firstScheduleStartTime}">
				<li class="fieldcontain">
					<span id="firstScheduleStartTime-label" class="property-label"><g:message code="hospitalData.firstScheduleStartTime.label" default="First Schedule Start Time" /></span>
					
						<span class="property-value" aria-labelledby="firstScheduleStartTime-label"><g:fieldValue bean="${hospitalDataInstance}" field="firstScheduleStartTime"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.hospital}">
				<li class="fieldcontain">
					<span id="hospital-label" class="property-label"><g:message code="hospitalData.hospital.label" default="Hospital" /></span>
					
						<span class="property-value" aria-labelledby="hospital-label"><g:link controller="hospital" action="show" id="${hospitalDataInstance?.hospital?.id}">${hospitalDataInstance?.hospital?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.numCasesStartedInPrimeTime}">
				<li class="fieldcontain">
					<span id="numCasesStartedInPrimeTime-label" class="property-label"><g:message code="hospitalData.numCasesStartedInPrimeTime.label" default="Num Cases Started In Prime Time" /></span>
					
						<span class="property-value" aria-labelledby="numCasesStartedInPrimeTime-label"><g:fieldValue bean="${hospitalDataInstance}" field="numCasesStartedInPrimeTime"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.numCasesStartedOnTime5Mins}">
				<li class="fieldcontain">
					<span id="numCasesStartedOnTime5Mins-label" class="property-label"><g:message code="hospitalData.numCasesStartedOnTime5Mins.label" default="Num Cases Started On Time5 Mins" /></span>
					
						<span class="property-value" aria-labelledby="numCasesStartedOnTime5Mins-label"><g:fieldValue bean="${hospitalDataInstance}" field="numCasesStartedOnTime5Mins"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.numCasesStartedOnTimeHospStd}">
				<li class="fieldcontain">
					<span id="numCasesStartedOnTimeHospStd-label" class="property-label"><g:message code="hospitalData.numCasesStartedOnTimeHospStd.label" default="Num Cases Started On Time Hosp Std" /></span>
					
						<span class="property-value" aria-labelledby="numCasesStartedOnTimeHospStd-label"><g:fieldValue bean="${hospitalDataInstance}" field="numCasesStartedOnTimeHospStd"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.numInpatientCases}">
				<li class="fieldcontain">
					<span id="numInpatientCases-label" class="property-label"><g:message code="hospitalData.numInpatientCases.label" default="Num Inpatient Cases" /></span>
					
						<span class="property-value" aria-labelledby="numInpatientCases-label"><g:fieldValue bean="${hospitalDataInstance}" field="numInpatientCases"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.numOrRooms}">
				<li class="fieldcontain">
					<span id="numOrRooms-label" class="property-label"><g:message code="hospitalData.numOrRooms.label" default="Num Or Rooms" /></span>
					
						<span class="property-value" aria-labelledby="numOrRooms-label"><g:fieldValue bean="${hospitalDataInstance}" field="numOrRooms"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.numOrRoomsDedicatedOrSpecialty}">
				<li class="fieldcontain">
					<span id="numOrRoomsDedicatedOrSpecialty-label" class="property-label"><g:message code="hospitalData.numOrRoomsDedicatedOrSpecialty.label" default="Num Or Rooms Dedicated Or Specialty" /></span>
					
						<span class="property-value" aria-labelledby="numOrRoomsDedicatedOrSpecialty-label"><g:fieldValue bean="${hospitalDataInstance}" field="numOrRoomsDedicatedOrSpecialty"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.numOutpatientCases}">
				<li class="fieldcontain">
					<span id="numOutpatientCases-label" class="property-label"><g:message code="hospitalData.numOutpatientCases.label" default="Num Outpatient Cases" /></span>
					
						<span class="property-value" aria-labelledby="numOutpatientCases-label"><g:fieldValue bean="${hospitalDataInstance}" field="numOutpatientCases"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.onTimeStartDefMinutes}">
				<li class="fieldcontain">
					<span id="onTimeStartDefMinutes-label" class="property-label"><g:message code="hospitalData.onTimeStartDefMinutes.label" default="On Time Start Def Minutes" /></span>
					
						<span class="property-value" aria-labelledby="onTimeStartDefMinutes-label"><g:fieldValue bean="${hospitalDataInstance}" field="onTimeStartDefMinutes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.overtimeHoursMainOr}">
				<li class="fieldcontain">
					<span id="overtimeHoursMainOr-label" class="property-label"><g:message code="hospitalData.overtimeHoursMainOr.label" default="Overtime Hours Main Or" /></span>
					
						<span class="property-value" aria-labelledby="overtimeHoursMainOr-label"><g:fieldValue bean="${hospitalDataInstance}" field="overtimeHoursMainOr"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.primeTimeHours}">
				<li class="fieldcontain">
					<span id="primeTimeHours-label" class="property-label"><g:message code="hospitalData.primeTimeHours.label" default="Prime Time Hours" /></span>
					
						<span class="property-value" aria-labelledby="primeTimeHours-label"><g:fieldValue bean="${hospitalDataInstance}" field="primeTimeHours"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.quarter}">
				<li class="fieldcontain">
					<span id="quarter-label" class="property-label"><g:message code="hospitalData.quarter.label" default="Quarter" /></span>
					
						<span class="property-value" aria-labelledby="quarter-label"><g:link controller="quarter" action="show" id="${hospitalDataInstance?.quarter?.id}">${hospitalDataInstance?.quarter?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.sameDayCancellationRate}">
				<li class="fieldcontain">
					<span id="sameDayCancellationRate-label" class="property-label"><g:message code="hospitalData.sameDayCancellationRate.label" default="Same Day Cancellation Rate" /></span>
					
						<span class="property-value" aria-labelledby="sameDayCancellationRate-label"><g:fieldValue bean="${hospitalDataInstance}" field="sameDayCancellationRate"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.totalNumCases}">
				<li class="fieldcontain">
					<span id="totalNumCases-label" class="property-label"><g:message code="hospitalData.totalNumCases.label" default="Total Num Cases" /></span>
					
						<span class="property-value" aria-labelledby="totalNumCases-label"><g:fieldValue bean="${hospitalDataInstance}" field="totalNumCases"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.totalOrMinutesForInPatientCases}">
				<li class="fieldcontain">
					<span id="totalOrMinutesForInPatientCases-label" class="property-label"><g:message code="hospitalData.totalOrMinutesForInPatientCases.label" default="Total Or Minutes For In Patient Cases" /></span>
					
						<span class="property-value" aria-labelledby="totalOrMinutesForInPatientCases-label"><g:fieldValue bean="${hospitalDataInstance}" field="totalOrMinutesForInPatientCases"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.totalOrMinutesForOutPatientCases}">
				<li class="fieldcontain">
					<span id="totalOrMinutesForOutPatientCases-label" class="property-label"><g:message code="hospitalData.totalOrMinutesForOutPatientCases.label" default="Total Or Minutes For Out Patient Cases" /></span>
					
						<span class="property-value" aria-labelledby="totalOrMinutesForOutPatientCases-label"><g:fieldValue bean="${hospitalDataInstance}" field="totalOrMinutesForOutPatientCases"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.totalOrMinutesForTotalCases}">
				<li class="fieldcontain">
					<span id="totalOrMinutesForTotalCases-label" class="property-label"><g:message code="hospitalData.totalOrMinutesForTotalCases.label" default="Total Or Minutes For Total Cases" /></span>
					
						<span class="property-value" aria-labelledby="totalOrMinutesForTotalCases-label"><g:fieldValue bean="${hospitalDataInstance}" field="totalOrMinutesForTotalCases"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hospitalDataInstance?.totalWorkedHoursMainOr}">
				<li class="fieldcontain">
					<span id="totalWorkedHoursMainOr-label" class="property-label"><g:message code="hospitalData.totalWorkedHoursMainOr.label" default="Total Worked Hours Main Or" /></span>
					
						<span class="property-value" aria-labelledby="totalWorkedHoursMainOr-label"><g:fieldValue bean="${hospitalDataInstance}" field="totalWorkedHoursMainOr"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${hospitalDataInstance?.id}" />
					<g:link class="edit" action="edit" id="${hospitalDataInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
