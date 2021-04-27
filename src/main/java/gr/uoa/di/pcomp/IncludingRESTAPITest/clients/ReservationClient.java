package gr.uoa.di.pcomp.IncludingRESTAPITest.clients;


import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.logging.LoggingFeature;

import gr.uoa.di.pcomp.IncludingRESTAPITest.postRequests.ReservationItemRequest;
import gr.uoa.di.pcomp.IncludingRESTAPITest.postRequests.ReservationRequest;


public class ReservationClient {

	public static void main(String[] args) {
		String target = "http://outlander4.di.uoa.gr:8181";
		String getPath = "reservations";
		String savePath = "saveReservation";
		String setStatusPath = "setReservationStatus";
		String validFrom = "2021-03-18 13:00:00";
		String validUntil = "2021-03-18 13:55:00";
		String username = "test";
		Integer testbedAreaId = 1;
		Integer resourceId1 = 1;
		Integer resourceId2 = 2;
		Integer resourceId3 = 3;
		Integer reservationId = 2;
		Integer statusId = 3;
		//uncomment depending get save update delete
		//getReservation(target,getPpath,validFrom,validUntil);		
		//saveReservation(target,savePath,validFrom,validUntil,username,testbedAreaId, Arrays.asList(new ReservationItemRequest(resourceId1),new ReservationItemRequest(resourceId2),new ReservationItemRequest(resourceId3)));
		setReservationStatus(target,setStatusPath,reservationId,statusId);
	}

	protected static ClientConfig createClientConfig() {
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
		return config;
	}
	
	private static void getReservation(String target, String path, String validFrom, String validUntil) {
		Client client = ClientBuilder.newClient(createClientConfig());
		String entity = client.target(target).path(path+"/"+validFrom+"/"+validUntil)
				.request(MediaType.APPLICATION_JSON).header("header", "true").get(String.class);
		System.out.println(entity);
	}
	
	private static void saveReservation(String target, String path, String validFrom, String validUntil, String username, Integer testbedAreaId, List<ReservationItemRequest> reservationItems) {
		Client client = ClientBuilder.newClient(createClientConfig());
		WebTarget webTarget = client.target(target).path(path);
		ReservationRequest newReservation = new ReservationRequest();
		newReservation.setUsername(username);
		newReservation.setTestbedAreaId(testbedAreaId);
		newReservation.setValidFrom(validFrom);
		newReservation.setValidUntil(validUntil);
		newReservation.setReservationItems(reservationItems);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(newReservation, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	private static void setReservationStatus(String target, String path, Integer reservationId, Integer statusId) {
		
		Client client = ClientBuilder.newClient(createClientConfig());
		WebTarget webTarget = client.target(target).path(path+"/"+reservationId+"/"+statusId);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity( "", MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());

	}
}
