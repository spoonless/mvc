package inscription.web;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import inscription.modele.InscriptionInvalideException;

@Provider
public class InscriptionInvalideExceptionMapper implements ExceptionMapper<InscriptionInvalideException> {

	@Override
	public Response toResponse(InscriptionInvalideException exception) {
		return Response.status(400).type("application/json").entity(exception.getMessages()).build();
	}

}
