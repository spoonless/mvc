package inscription.web;

import org.junit.Assert;
import org.junit.Test;

import inscription.modele.Inscription;
import inscription.modele.InscriptionService;

public class InscriptionServiceTest {
	
	@Test
	public void testInscriptionService_QuandUneInscriptionEstValide_AlorsRetourneUneInscription() throws Exception {
		InscriptionService service = new InscriptionService();
		
		Inscription inscription = service.inscrire("email@email.com", "012346578", "012346578", true);
		
		Assert.assertNotNull(inscription);
	}

}
