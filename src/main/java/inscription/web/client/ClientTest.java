package inscription.web.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class ClientTest {

	public static void main(String[] args) {
	    Client client = ClientBuilder.newClient();

	    WebTarget target = client.target("https://tools.ietf.org/rfc/rfc7230.txt");
	    String rfc = target.request().get(String.class);
	    
	    System.out.println(rfc);
	}

}
