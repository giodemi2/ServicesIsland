/**
 * 
 */
package businesslogic.servlets.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Servizio;

/**
 * @author rodolfo
 * This Strategy sena an unapproved service
 * to the rest python application "Mediatore"
 * The mediatore can confirm or not
 * a service.
 * Is the first request in which mediatore
 * send his key to server and de server
 * make login and eponse with service
 * unapproved taked in the list of unapproved
 * services
 */
public class SendUnapprovedServiceToMediatoreStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String mediatorKey = request.getParameter("key").toString();
		
		if(StandardDataSource
				.getInstance()
				.getMediatoreDaoJDBC()
				.existMediatore(mediatorKey)) 
		{
			
			final List<Servizio> unapprovedServices = StandardDataSource
													  	.getInstance()
													  	.getServizioDaoJDBC()
													  	.findUnapproved();
			
			if(unapprovedServices.isEmpty())
				response.getOutputStream().print("NON ci sono servizi al momento");
			else {
				response.getOutputStream().println("CODICE SERVIZIO: " + unapprovedServices.get(0).getCodice());
				response.getOutputStream().println("NOME SERVIZIO: " + unapprovedServices.get(0).getNome());
				response.getOutputStream().println("DESCRIZIONE SERVIZIO: " + unapprovedServices.get(0).getDescrizione());
				response.getOutputStream().println("ALTRI DETTAGLI SERVIZIO: " + unapprovedServices.get(0).getAltri_dettagli());
			}
			
		}
		else {
			response.getOutputStream().print("error");
		}
		
	}

}
