package inscription.modele;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class InscriptionService {
	
	@PersistenceContext(unitName="inscriptionUnit")
	private EntityManager entityManager;
	
	public Inscription inscrire(String email, String motDePasse, String confirmationMotDePasse, boolean approbation) 
			throws InscriptionInvalideException {
		InscriptionInvalideException ex = new InscriptionInvalideException();
		
		if (email == null || ! email.contains("@")) {
			ex.addMessage("email", "L'email est invalide !");
		}
		if (motDePasse == null || motDePasse.length() < 8) {
			ex.addMessage("motDePasse", "Le mot de passe doit contenir au moins 8 caractères !");
		}
		if (!motDePasse.equals(confirmationMotDePasse)) {
			ex.addMessage("confirmationMotDePasse", "Les deux mots de passe ne sont pas identiques !");
		}
		if (! approbation) {
			ex.addMessage("approbation", "Vous devez accepter les conditions.");
		}
		if (ex.mustBeThrown()) {
			throw ex;
		}
		
		Inscription inscription = new Inscription(email, motDePasse);
		entityManager.persist(inscription);
		return inscription;
	}
	
}
