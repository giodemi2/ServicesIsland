/**
 * 
 */
package businesslogic.servlets.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslogic.utils.NotificationHandler;
import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Servizio;

/**
 * @author rodolfo
 * This strategy approve a service
 * given the service code in a post request,
 * by mediatore python rest app
 */
public class ApproveServiceByServiceCodeStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final long serviceKey = Long.parseLong(request.getParameter("serviceCode").toString());
		
		StandardDataSource
			.getInstance()
			.getMediatoreDaoJDBC()
			.approve(serviceKey);
		
		final Servizio servizio = StandardDataSource
									.getInstance()
									.getServizioDaoJDBC()
									.findByPrimaryKey(serviceKey);
		
		NotificationHandler.notificateToUser(
				servizio.getProfessionista(), 
				"Servizio approvato!",
				"Il servizio " + servizio.getNome() + " è stato approvato!");
		
	}

}
