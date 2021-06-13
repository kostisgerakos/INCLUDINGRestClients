package gr.uoa.di.pcomp.IncludingRESTAPITest.clients;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

import gr.uoa.di.pcomp.IncludingRESTAPITest.postRequests.ReservationItemRequest;

public class APITest {
	public static void main(String[] args) {
		String target = "http://localhost:8181";
		
		ReservationClient reservationClient = new ReservationClient();
		
		String getPathReservation = "reservations";
		String savePathReservation = "saveReservation";
		String setStatusPathReservation = "setReservationStatus";
		String deletePathReservation = "deleteReservation";
		String editPathReservation = "editReservation";

		String validFrom = "2021-06-20 15:00:00";
		String validUntil = "2021-06-20 15:55:00";
		
		String username = "test";
		
		Integer testbedAreaId = 1;
		
		Integer resourceId1 = 1;
		Integer resourceId2 = 2;
		Integer resourceId3 = 3;
		
		Integer reservationId = 2;
	
		Integer statusId = 3;
		//uncomment depending get save update delete
		//reservationClient.getReservation(target,getPathReservation,validFrom,validUntil);		
		//reservationClient.saveReservation(target,savePathReservation,validFrom,validUntil,username,testbedAreaId, Arrays.asList(new ReservationItemRequest(resourceId1),new ReservationItemRequest(resourceId2),new ReservationItemRequest(resourceId3)));
		//reservationClient.setReservationStatus(target,setStatusPathReservation,reservationId,statusId);
		//reservationClient.deleteReservation(target,deletePathReservation,reservationId);
		//reservationClient.editReservation(target,editPathReservation,reservationId,validFrom,validUntil,username,testbedAreaId, Arrays.asList(new ReservationItemRequest(resourceId1),new ReservationItemRequest(resourceId2),new ReservationItemRequest(resourceId3)));

		ExperimentClient experimentClient = new ExperimentClient();
		
		String saveExperimentExecutionReservation = "saveExperimentExecution";

		
		String startExecution = "2021-06-20 11:00:50";
		String endExecution= "2021-06-20 11:58:50";
		Integer experimentStatus = 2;
		Integer experimentId = 1; 
		
		experimentClient.saveExperimentExecution(target, saveExperimentExecutionReservation, startExecution, endExecution, experimentStatus, experimentId);
	}
}
