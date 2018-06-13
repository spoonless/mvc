package inscription.web;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import inscription.modele.Inscription;
import inscription.modele.InscriptionInvalideException;
import inscription.modele.InscriptionService;

@Path("/inscription")
public class InscriptionResource {

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response creer(Inscription inscription, @Context UriInfo uriInfo)
			throws InscriptionInvalideException, URISyntaxException {
		InscriptionService service = new InscriptionService();
		Inscription inscriptionValidee = service.inscrire(inscription.getEmail(), inscription.getMotDePasse(),
				inscription.getMotDePasse(), true);

		URI uri = uriInfo.getRequestUriBuilder().path(inscriptionValidee.getEmail()).build();
		return Response.created(uri).entity(inscriptionValidee).build();
	}
	
	@DELETE
	@Path("/{email}")
	public void supprimer(@PathParam("email") String email) {
		// TODO 
	}

}
