package gr.uoa.di.pcomp.ResilocRESTAPITest.clients;

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

import gr.uoa.di.pcomp.ResilocRESTAPITest.postRequests.LoginRequest;

public class LoginClient {

	protected static ClientConfig createClientConfig() {
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.INFO,
				LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
		return config;
	}

	public void loginUser(String target, String path, String username, String password, Boolean keepMeLoggedIn) {
		Client client = ClientBuilder.newClient(createClientConfig());
		WebTarget webTarget = client.target(target).path(path);
		LoginRequest newLoginRequest = new LoginRequest();
		newLoginRequest.setUsername(username);
		newLoginRequest.setPassword(password);
		newLoginRequest.setKeepMeLoggedIn(keepMeLoggedIn);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(newLoginRequest, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}

}
