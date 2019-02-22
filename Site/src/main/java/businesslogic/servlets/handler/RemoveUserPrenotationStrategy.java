package businesslogic.servlets.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslogic.utils.NotificationHandler;
import it.servicesisland.Connection.handlers.StandardDataSource;

/**
 * @author rodolfo
 * Remove user prenotation strategy,
 * It is used when a user remove his
 * prenotation.
 */
public class RemoveUserPrenotationStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final long user = Long.parseLong(request.getParameter("user").toString());
		final long service = Long.parseLong(request.getParameter("service").toString());

		StandardDataSource
			.getInstance()
			.getPrenotazioneDaoJDBC()
			.delete(user, service);
		
		NotificationHandler.notificateToUser(
				user, 
				"Prenotazione eliminata", 
				"Prenotazione del servizio con id: " + service + " rimossa");
		
		request.setAttribute("reportMessage", "Prenotazione eliminata con successo!");
		request.getRequestDispatcher("/report.jsp").forward(request, response);
	}

}
