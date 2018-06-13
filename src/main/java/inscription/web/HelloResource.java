package inscription.web;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import inscription.modele.Inscription;

@Path("/hello")
public class HelloResource {
	
	private ServletContext servletContext;

	public HelloResource(@Context ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	@GET
	@Produces("application/json")
	public Inscription sayHello(@QueryParam("nom") String nom) {
		return new Inscription(nom, "azerty12345678");
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Inscription echo(Inscription inscription) {
		return inscription;
	}

}
