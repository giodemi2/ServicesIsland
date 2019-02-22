/**
 * 
 */
package businesslogic.servlets.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.servicesisland.Connection.handlers.StandardDataSource;

/**
 * @author rodolfo
 * View all services booked by a
 * user given by user id
 */
public class ViewUserServicesStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final long userId = Long.parseLong(request.getParameter("utente").toString());
		
		StandardDataSource
			.getInstance()
			.getServizioDaoJDBC()
			.findByProfessionist(userId)
			.forEach(i -> {
				try {
					response.getOutputStream().println(
							"<p>Servizio: " + i.getNome() + "</p>"
					);
					response.getOutputStream().println(
							"<a href='ServicesHandler?op=deleteService&user="+ i.getProfessionista() + "&service=" + i.getCodice() + "'>" + 
							"<i class=\"fas fa-trash-alt\"></i></a><br>"
					);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
	}

}
