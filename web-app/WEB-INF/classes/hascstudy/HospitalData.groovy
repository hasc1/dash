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
 }

    
    String toString(){
    return id
    }
}
