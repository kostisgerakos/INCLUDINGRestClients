package gr.uoa.di.pcomp.IncludingRESTAPITest.clients;


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

import gr.uoa.di.pcomp.IncludingRESTAPITest.postRequests.ExperimentExecutionRequest;


public class ExperimentClient {


	protected static ClientConfig createClientConfig() {
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
		return config;
	}
	
	public void saveExperimentExecution(String target, String path, String startExecution , String endExecution,  Integer experimentStatus, Integer experimentId) {
		Client client = ClientBuilder.newClient(createClientConfig());
		WebTarget webTarget = client.target(target).path(path);
		ExperimentExecutionRequest newExperimentExecution = new ExperimentExecutionRequest();
		newExperimentExecution.setStartExecution(startExecution);
		newExperimentExecution.setEndExecution(endExecution);
		newExperimentExecution.setExperimentStatus(experimentStatus);
		newExperimentExecution.setExperimentId(experimentId);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(newExperimentExecution, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}

}
