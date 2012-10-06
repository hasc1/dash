package hascstudy

class HospitalData {
	Integer id
	Hospital hospital
	Quarter quarter
	Integer numOrRooms
	Integer numOrRoomsDedicatedOrSpecialty
	Integer totalNumCases
	Integer numInpatientCases
	Integer numOutpatientCases
	Integer totalOrMinutesForInPatientCases
	Integer totalOrMinutesForOutPatientCases
	Integer totalOrMinutesForTotalCases
	String  primeTimeHours
	Integer numCasesStartedInPrimeTime
	String firstScheduleStartTime
	Integer numCasesStartedOnTime5Mins
	Integer numCasesStartedOnTimeHospStd
	Integer onTimeStartDefMinutes
	float sameDayCancellationRate
	float avaregeRoomUtilizationInTotal
	float avaregeRoomUtilizationPrimeTime
	float avaregeRoomTurnAroundPhysicians
	float avaregeRoomTurnAroundInPatients
	float avaregeRoomTurnAroundOutPatients
	float avaregeRoomTurnAroundAllPatients
	Integer totalWorkedHoursMainOr
	Integer overtimeHoursMainOr
	
	static constraints = {
		hospital()
		quarter()
		numOrRooms()
		numOrRoomsDedicatedOrSpecialty()
		totalNumCases()
		numInpatientCases()
		numOutpatientCases()
		totalOrMinutesForInPatientCases()
		totalOrMinutesForOutPatientCases()
		totalOrMinutesForTotalCases()
		primeTimeHours()
		numCasesStartedInPrimeTime()
		firstScheduleStartTime()
		numCasesStartedOnTime5Mins()
		numCasesStartedOnTimeHospStd()
		onTimeStartDefMinutes()
		sameDayCancellationRate()
		avaregeRoomUtilizationInTotal()
		avaregeRoomUtilizationPrimeTime()
		avaregeRoomTurnAroundPhysicians()
		avaregeRoomTurnAroundInPatients()
		avaregeRoomTurnAroundOutPatients()
		avaregeRoomTurnAroundAllPatients()
		totalWorkedHoursMainOr()
		overtimeHoursMainOr()
	}
    
    String toString(){
        return id
    }
}
