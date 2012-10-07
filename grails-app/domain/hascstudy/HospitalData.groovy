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
		numOrRooms(nullable:true)
		numOrRoomsDedicatedOrSpecialty(nullable:true)
		totalNumCases(nullable:true)
		numInpatientCases(nullable:true)
		numOutpatientCases(nullable:true)
		totalOrMinutesForInPatientCases(nullable:true)
		totalOrMinutesForOutPatientCases(nullable:true)
		totalOrMinutesForTotalCases(nullable:true)
		primeTimeHours(nullable:true)
		numCasesStartedInPrimeTime(nullable:true)
		firstScheduleStartTime(nullable:true)
		numCasesStartedOnTime5Mins(nullable:true)
		numCasesStartedOnTimeHospStd(nullable:true)
		onTimeStartDefMinutes(nullable:true)
		sameDayCancellationRate(nullable:true)
		avaregeRoomUtilizationInTotal(nullable:true)
		avaregeRoomUtilizationPrimeTime(nullable:true)
		avaregeRoomTurnAroundPhysicians(nullable:true)
		avaregeRoomTurnAroundInPatients(nullable:true)
		avaregeRoomTurnAroundOutPatients(nullable:true)
		avaregeRoomTurnAroundAllPatients(nullable:true)
		totalWorkedHoursMainOr(nullable:true)
		overtimeHoursMainOr(nullable:true)
	}
    
    String toString(){
        return id
    }
}
