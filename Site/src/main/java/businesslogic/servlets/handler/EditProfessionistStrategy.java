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
 * Edit professionist dates
 */
public class EditProfessionistStrategy extends Strategy {

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
				
		String newCodiceFiscale = request.getParameter("txtCodiceF")
				.equals(request.getSession().getAttribute("codice_fiscale")) 
				? request.getSession().getAttribute("codice_fiscale").toString()
				: request.getParameter("txtCodiceF").toString();
				
		String newPartitaIva = request.getParameter("txtPartitaIVA")
				.equals(request.getSession().getAttribute("partita_iva")) 
				? request.getSession().getAttribute("partita_iva").toString()
				: request.getParameter("txtPartitaIVA").toString();
		
		String newProfessione = request.getParameter("txtProfessione")
				.equals(request.getSession().getAttribute("professione")) 
				? request.getSession().getAttribute("professione").toString()
				: request.getParameter("txtProfessione").toString();
				
		String newSettore = request.getParameter("txtSettore")
				.equals(request.getSession().getAttribute("settore")) 
				? request.getSession().getAttribute("settore").toString()
				: request.getParameter("txtSettore").toString();
				
		String newSedeFiscale = request.getParameter("txtSedeFiscale")
				.equals(request.getSession().getAttribute("sede_fiscale")) 
				? request.getSession().getAttribute("sede_fiscale").toString()
				: request.getParameter("txtSedeFiscale").toString();
					
		String newSedeLegale = request.getParameter("txtSedeLegale")
				.equals(request.getSession().getAttribute("sede_legale")) 
				? request.getSession().getAttribute("sede_legale").toString()
				: request.getParameter("txtSedeLegale").toString();
		
		final Utente utente = new Utente(
				newNome, 
				newCognome,
				newSesso, 
				null, 
				null,
				Long.parseLong(newTelefono),
				newCodiceFiscale,
				newPartitaIva,
				newProfessione,
				newSettore,
				newSedeFiscale,
				newSedeLegale
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
