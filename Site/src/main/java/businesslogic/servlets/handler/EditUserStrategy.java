/**
 * 
 */
package businesslogic.servlets.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Utente;

/**
 * @author rodolfo
 * Edit user dates
 */
public class EditUserStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newNome = request.getParameter("txtNome")
				.equals(request.getSession().getAttribute("nome")) 
				? request.getSession().getAttribute("nome").toString()
				: request.getParameter("txtNome").toString();
		
		String newCognome = request.getParameter("txtCognome")
				.equals(request.getSession().getAttribute("cognome")) 
				? request.getSession().getAttribute("cognome").toString()
				: request.getParameter("txtCognome").toString();	
				
		String newSesso = request.getParameter("sltSesso")
				.equals(request.getSession().getAttribute("email")) 
				? request.getSession().getAttribute("email").toString()
				: request.getParameter("sltSesso").toString();	
				
		String newTelefono = request.getParameter("txtNumeroTelefonico")
				.equals(request.getSession().getAttribute("numero")) 
				? request.getSession().getAttribute("numero").toString()
				: request.getParameter("txtNumeroTelefonico").toString();	
				
		final Utente utente = new Utente(
				newNome, 
				newCognome,
				newSesso, 
				null, 
				null,
				Long.parseLong(newTelefono),
				"",
				"",
				"",
				"",
				"",
				""
		);
		utente.setCodice(Long.parseLong(request.getSession().getAttribute("id").toString()));
				
		StandardDataSource
			.getInstance()
			.getUtenteDaoJDBC()
			.update(utente);
			
		HttpSession loginSession = request.getSession();
		loginSession.invalidate();
		request.setAttribute("reportMessage", "Modifica andata a buon fine, verrà effettuato il logout...");
		request.getRequestDispatcher("/report.jsp").forward(request, response);
	}

}
