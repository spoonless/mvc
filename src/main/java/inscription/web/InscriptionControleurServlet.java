	package inscription.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inscription.modele.Inscription;
import inscription.modele.InscriptionInvalideException;
import inscription.modele.InscriptionService;

@WebServlet("/inscription")
public class InscriptionControleurServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/inscription.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String motDePasse = req.getParameter("motDePasse");
		String confirmationMotDePasse = req.getParameter("confirmationMotDePasse");
		boolean approbation = Boolean.valueOf(req.getParameter("approbation"));
		try {
			InscriptionService inscriptionService = new InscriptionService();
			Inscription inscription = inscriptionService.inscrire(email, motDePasse, confirmationMotDePasse, approbation);
			req.setAttribute("inscription", inscription);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/validationInscription.jsp");
			rd.forward(req, resp);
		} catch (InscriptionInvalideException e) {
			req.setAttribute("errors", e.getMessages());
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/inscription.jsp");
			rd.forward(req, resp);
		}
	}
}
