/**
 * 
 */
package businesslogic.servlets.handler;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslogic.utils.NotificationHandler;
import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Prenotazione;

/**
 * @author rodolfo
 * Make a prenotation of a service given
 * giorno, data, utente and servizio
 */
public class MakeServicePrenotationStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final Prenotazione prenotazione = new Prenotazione(
				Time.valueOf(request.getParameter("orario").toString()), 
				Date.valueOf(request.getParameter("giorno").toString()), 
				Integer.parseInt(request.getParameter("utente").toString()), 
				Integer.parseInt(request.getParameter("servizio").toString())
		);
		
		StandardDataSource
			.getInstance()
			.getPrenotazioneDaoJDBC()
			.save(prenotazione);

		response.getOutputStream().print("success");
//			
//			// TODO Date and time control
		
		NotificationHandler.notificateToUser(
				Integer.parseInt(request.getParameter("utente").toString()), 
				"Prenotazione effettuata", 
				"Hai appena prenotato il servizio con id " + request.getParameter("servizio").toString());
	}

}
