/**
 * 
 */
package businesslogic.servlets.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Utente;

/**
 * @author rodolfo
 * User login strategy
 */
public class LoginStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String encriptedPassword = DigestUtils.sha256Hex(request.getParameter("txtPassword").toString());
		final String email = request.getParameter("txtEmail").toString();
		

		final Utente tempUtente = StandardDataSource
									.getInstance()
									.getUtenteDaoJDBC()
									.findByEmail(email);

		if(tempUtente.getPassword().equals(encriptedPassword)) {
			HttpSession loginSession = request.getSession(true);

			loginSession.setAttribute("email", email);
			loginSession.setAttribute("nome", tempUtente.getNome());
			loginSession.setAttribute("numero", tempUtente.getTelefono());
			loginSession.setAttribute("cognome", tempUtente.getCognome());
			loginSession.setAttribute("sesso", tempUtente.getSesso());
			loginSession.setAttribute("id", tempUtente.getCodice());

			if(tempUtente.isProfessionista()) {
				loginSession.setAttribute("professionist", "professionista");
				loginSession.setAttribute("codice_fiscale", tempUtente.getCodice_fiscale());
				loginSession.setAttribute("partita_iva", tempUtente.getPartita_iva());
				loginSession.setAttribute("professione", tempUtente.getProfessione());
				loginSession.setAttribute("settore", tempUtente.getSettore());
				loginSession.setAttribute("sede_legale", tempUtente.getSede_legale());
				loginSession.setAttribute("sede_fiscale", tempUtente.getSede_fiscale());
			}
			
			request.setAttribute("reportMessage", "Login andato a buon fine!");
			request.getRequestDispatcher("/report.jsp").forward(request, response);
		}
		else {
			request.setAttribute("reportMessage", "Credenziali errate");
			request.getRequestDispatcher("/report.jsp").forward(request, response);
		}
		
	}

}
