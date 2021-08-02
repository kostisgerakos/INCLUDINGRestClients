package gr.uoa.di.pcomp.ResilocRESTAPITest.postRequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "username", "password", "keepMeLoggedIn" })
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginRequest {

	@JsonProperty("username")
	public String username;
	@JsonProperty("password")
	public String password;
	@JsonProperty("keepMeLoggedIn")
	public boolean keepMeLoggedIn;

}