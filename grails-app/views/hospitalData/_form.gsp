<%@ page import="hascstudy.HospitalData" %>



<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'avaregeRoomTurnAroundAllPatients', 'error')} required">
	<label for="avaregeRoomTurnAroundAllPatients">
		<g:message code="hospitalData.avaregeRoomTurnAroundAllPatients.label" default="Avarege Room Turn Around All Patients" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="avaregeRoomTurnAroundAllPatients" step="any" required="" value="${hospitalDataInstance.avaregeRoomTurnAroundAllPatients}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'avaregeRoomTurnAroundInPatients', 'error')} required">
	<label for="avaregeRoomTurnAroundInPatients">
		<g:message code="hospitalData.avaregeRoomTurnAroundInPatients.label" default="Avarege Room Turn Around In Patients" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="avaregeRoomTurnAroundInPatients" step="any" required="" value="${hospitalDataInstance.avaregeRoomTurnAroundInPatients}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'avaregeRoomTurnAroundOutPatients', 'error')} required">
	<label for="avaregeRoomTurnAroundOutPatients">
		<g:message code="hospitalData.avaregeRoomTurnAroundOutPatients.label" default="Avarege Room Turn Around Out Patients" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="avaregeRoomTurnAroundOutPatients" step="any" required="" value="${hospitalDataInstance.avaregeRoomTurnAroundOutPatients}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'avaregeRoomTurnAroundPhysicians', 'error')} required">
	<label for="avaregeRoomTurnAroundPhysicians">
		<g:message code="hospitalData.avaregeRoomTurnAroundPhysicians.label" default="Avarege Room Turn Around Physicians" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="avaregeRoomTurnAroundPhysicians" step="any" required="" value="${hospitalDataInstance.avaregeRoomTurnAroundPhysicians}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'avaregeRoomUtilizationInTotal', 'error')} required">
	<label for="avaregeRoomUtilizationInTotal">
		<g:message code="hospitalData.avaregeRoomUtilizationInTotal.label" default="Avarege Room Utilization In Total" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="avaregeRoomUtilizationInTotal" step="any" required="" value="${hospitalDataInstance.avaregeRoomUtilizationInTotal}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'avaregeRoomUtilizationPrimeTime', 'error')} required">
	<label for="avaregeRoomUtilizationPrimeTime">
		<g:message code="hospitalData.avaregeRoomUtilizationPrimeTime.label" default="Avarege Room Utilization Prime Time" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="avaregeRoomUtilizationPrimeTime" step="any" required="" value="${hospitalDataInstance.avaregeRoomUtilizationPrimeTime}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'firstScheduleStartTime', 'error')} ">
	<label for="firstScheduleStartTime">
		<g:message code="hospitalData.firstScheduleStartTime.label" default="First Schedule Start Time" />
		
	</label>
	<g:textField name="firstScheduleStartTime" value="${hospitalDataInstance?.firstScheduleStartTime}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'hospital', 'error')} required">
	<label for="hospital">
		<g:message code="hospitalData.hospital.label" default="Hospital" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="hospital" name="hospital.id" from="${hascstudy.Hospital.list()}" optionKey="id" required="" value="${hospitalDataInstance?.hospital?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'numCasesStartedInPrimeTime', 'error')} required">
	<label for="numCasesStartedInPrimeTime">
		<g:message code="hospitalData.numCasesStartedInPrimeTime.label" default="Num Cases Started In Prime Time" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="numCasesStartedInPrimeTime" required="" value="${hospitalDataInstance.numCasesStartedInPrimeTime}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'numCasesStartedOnTime5Mins', 'error')} required">
	<label for="numCasesStartedOnTime5Mins">
		<g:message code="hospitalData.numCasesStartedOnTime5Mins.label" default="Num Cases Started On Time5 Mins" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="numCasesStartedOnTime5Mins" required="" value="${hospitalDataInstance.numCasesStartedOnTime5Mins}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'numCasesStartedOnTimeHospStd', 'error')} required">
	<label for="numCasesStartedOnTimeHospStd">
		<g:message code="hospitalData.numCasesStartedOnTimeHospStd.label" default="Num Cases Started On Time Hosp Std" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="numCasesStartedOnTimeHospStd" required="" value="${hospitalDataInstance.numCasesStartedOnTimeHospStd}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'numInpatientCases', 'error')} required">
	<label for="numInpatientCases">
		<g:message code="hospitalData.numInpatientCases.label" default="Num Inpatient Cases" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="numInpatientCases" required="" value="${hospitalDataInstance.numInpatientCases}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'numOrRooms', 'error')} required">
	<label for="numOrRooms">
		<g:message code="hospitalData.numOrRooms.label" default="Num Or Rooms" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="numOrRooms" required="" value="${hospitalDataInstance.numOrRooms}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'numOrRoomsDedicatedOrSpecialty', 'error')} required">
	<label for="numOrRoomsDedicatedOrSpecialty">
		<g:message code="hospitalData.numOrRoomsDedicatedOrSpecialty.label" default="Num Or Rooms Dedicated Or Specialty" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="numOrRoomsDedicatedOrSpecialty" required="" value="${hospitalDataInstance.numOrRoomsDedicatedOrSpecialty}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'numOutpatientCases', 'error')} required">
	<label for="numOutpatientCases">
		<g:message code="hospitalData.numOutpatientCases.label" default="Num Outpatient Cases" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="numOutpatientCases" required="" value="${hospitalDataInstance.numOutpatientCases}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'onTimeStartDefMinutes', 'error')} required">
	<label for="onTimeStartDefMinutes">
		<g:message code="hospitalData.onTimeStartDefMinutes.label" default="On Time Start Def Minutes" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="onTimeStartDefMinutes" required="" value="${hospitalDataInstance.onTimeStartDefMinutes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'overtimeHoursMainOr', 'error')} required">
	<label for="overtimeHoursMainOr">
		<g:message code="hospitalData.overtimeHoursMainOr.label" default="Overtime Hours Main Or" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="overtimeHoursMainOr" required="" value="${hospitalDataInstance.overtimeHoursMainOr}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'primeTimeHours', 'error')} ">
	<label for="primeTimeHours">
		<g:message code="hospitalData.primeTimeHours.label" default="Prime Time Hours" />
		
	</label>
	<g:textField name="primeTimeHours" value="${hospitalDataInstance?.primeTimeHours}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'quarter', 'error')} required">
	<label for="quarter">
		<g:message code="hospitalData.quarter.label" default="Quarter" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="quarter" name="quarter.id" from="${hascstudy.Quarter.list()}" optionKey="id" required="" value="${hospitalDataInstance?.quarter?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'sameDayCancellationRate', 'error')} required">
	<label for="sameDayCancellationRate">
		<g:message code="hospitalData.sameDayCancellationRate.label" default="Same Day Cancellation Rate" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="sameDayCancellationRate" step="any" required="" value="${hospitalDataInstance.sameDayCancellationRate}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'totalNumCases', 'error')} required">
	<label for="totalNumCases">
		<g:message code="hospitalData.totalNumCases.label" default="Total Num Cases" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="totalNumCases" required="" value="${hospitalDataInstance.totalNumCases}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'totalOrMinutesForInPatientCases', 'error')} required">
	<label for="totalOrMinutesForInPatientCases">
		<g:message code="hospitalData.totalOrMinutesForInPatientCases.label" default="Total Or Minutes For In Patient Cases" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="totalOrMinutesForInPatientCases" required="" value="${hospitalDataInstance.totalOrMinutesForInPatientCases}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'totalOrMinutesForOutPatientCases', 'error')} required">
	<label for="totalOrMinutesForOutPatientCases">
		<g:message code="hospitalData.totalOrMinutesForOutPatientCases.label" default="Total Or Minutes For Out Patient Cases" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="totalOrMinutesForOutPatientCases" required="" value="${hospitalDataInstance.totalOrMinutesForOutPatientCases}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'totalOrMinutesForTotalCases', 'error')} required">
	<label for="totalOrMinutesForTotalCases">
		<g:message code="hospitalData.totalOrMinutesForTotalCases.label" default="Total Or Minutes For Total Cases" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="totalOrMinutesForTotalCases" required="" value="${hospitalDataInstance.totalOrMinutesForTotalCases}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hospitalDataInstance, field: 'totalWorkedHoursMainOr', 'error')} required">
	<label for="totalWorkedHoursMainOr">
		<g:message code="hospitalData.totalWorkedHoursMainOr.label" default="Total Worked Hours Main Or" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="totalWorkedHoursMainOr" required="" value="${hospitalDataInstance.totalWorkedHoursMainOr}"/>
</div>

