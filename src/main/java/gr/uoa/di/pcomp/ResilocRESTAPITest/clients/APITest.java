package gr.uoa.di.pcomp.ResilocRESTAPITest.clients;

public class APITest {
	public static void main(String[] args) {
		
		LoginClient loginClient = new LoginClient();

		String target = "http://localhost.di.uoa.gr";	
		String path = "login";
		String username = "username";
		String password = "password";
		Boolean keepMeLoggedIn = true;

		loginClient.loginUser(target, path, username, password, keepMeLoggedIn);
		
	}
}
