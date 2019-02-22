package businesslogic.servlets.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslogic.utils.NotificationHandler;
import it.servicesisland.Connection.handlers.StandardDataSource;

/**
 * @author rodolfo
 * Delete a service offered by a 
 * professionist
 */
public class DeleteServiceOfProfessionistStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final long service = Long.parseLong(request.getParameter("service").toString());
		final long user = Long.parseLong(request.getParameter("user").toString());
		
		StandardDataSource
		.getInstance()
		.getServizioDaoJDBC()
		.delete(service);
	
		NotificationHandler.notificateToUser(
				user, 
				"Servizio eliminato", 
				"Servizio con id: " + service + " rimosso");
		
		request.setAttribute("reportMessage", "Servizio eliminato con successo!");
		request.getRequestDispatcher("/report.jsp").forward(request, response);
			
	}

}
