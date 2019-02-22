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
 * Simple User registration strategy
 */
public class UserRegistrationStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final Utente utente = new Utente(
				request.getParameter("txtNome").toString(), 
				request.getParameter("txtCognome").toString(),
				request.getParameter("sltSesso").toString(), 
				request.getParameter("txtEmail").toString(), 
				request.getParameter("txtPassword").toString(),  
				Long.parseLong(request.getParameter("txtNumeroTelefonico").toString()));
		
		try {
			utente.setPassword(DigestUtils.sha256Hex(utente.getPassword()));
			StandardDataSource
				.getInstance()
				.getUtenteDaoJDBC()
				.saveSimple(utente);
				
			
			doLogin(utente.getEmail(), utente.getPassword(), request, response);

			
			request.setAttribute("reportMessage", "Registrazione andata a buon fine!");
			request.getRequestDispatcher("/report.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("reportMessage", "Errore nella registrazione utente");
			request.getRequestDispatcher("/report.jsp").forward(request, response);
		}
		
	}
	
	
	private void doLogin(String email, String encriptedPassword, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		}
		else {
			request.setAttribute("reportMessage", "Imposibile loggarsi con il nuovo utente");
			request.getRequestDispatcher("/report.jsp").forward(request, response);
		}
	}

}
