package gr.uoa.di.pcomp.IncludingRESTAPITest.clients;


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
import org.glassfish.jersey.logging.LoggingFeature;

import gr.uoa.di.pcomp.IncludingRESTAPITest.postRequests.ReservationItemRequest;
import gr.uoa.di.pcomp.IncludingRESTAPITest.postRequests.ReservationRequest;


public class ReservationClient {

	protected static ClientConfig createClientConfig() {
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
		return config;
	}
	
	public void getReservation(String target, String path, String validFrom, String validUntil) {
		Client client = ClientBuilder.newClient(createClientConfig());
		String entity = client.target(target).path(path+"/"+validFrom+"/"+validUntil)
				.request(MediaType.APPLICATION_JSON).header("header", "true").get(String.class);
		System.out.println(entity);
	}
	
	public void saveReservation(String target, String path, String validFrom, String validUntil, String username, Integer testbedAreaId, List<ReservationItemRequest> reservationItems) {
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
	
	public void editReservation( String target, String path, Integer reservationId, String validFrom, String validUntil, String username, Integer testbedAreaId, List<ReservationItemRequest> reservationItems) {
		Client client = ClientBuilder.newClient(createClientConfig());
		WebTarget webTarget = client.target(target).path(path);
		ReservationRequest editedReservation = new ReservationRequest();
		editedReservation.setReservationId(reservationId);
		editedReservation.setUsername(username);
		editedReservation.setTestbedAreaId(testbedAreaId);
		editedReservation.setValidFrom(validFrom);
		editedReservation.setValidUntil(validUntil);
		editedReservation.setReservationItems(reservationItems);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(editedReservation, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	public void setReservationStatus(String target, String path, Integer reservationId, Integer statusId) {	
		Client client = ClientBuilder.newClient(createClientConfig());
		WebTarget webTarget = client.target(target).path(path+"/"+reservationId+"/"+statusId);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity( "", MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
	}
	
	public void deleteReservation(String target, String path, Integer reservationId) {	
		Client client = ClientBuilder.newClient(createClientConfig());
		WebTarget webTarget = client.target(target).path(path+"/"+reservationId);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.delete();
		System.out.println(response.getStatus());
	}
}
