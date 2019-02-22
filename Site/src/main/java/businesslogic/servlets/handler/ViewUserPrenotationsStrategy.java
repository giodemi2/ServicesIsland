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
 * Get the list of all prenotations
 * booked by an user
 */
public class ViewUserPrenotationsStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final long userId = Long.parseLong(request.getParameter("utente").toString());
		StandardDataSource
			.getInstance()
			.getPrenotazioneDaoJDBC()
			.findByUserId(userId)
			.forEach(i -> {
				try {
					final long day = i.getData_prenotazione().getDay();
					final long year = i.getData_prenotazione().getYear();
					final long month = i.getData_prenotazione().getMonth();
					response.getOutputStream().println(
							"<p>Prenotazione in data: " + day + "/" + month + "/" + year + "</p>"
					);
					response.getOutputStream().println(
							"<a href='ServicesHandler?op=deletePrenotation&user=" + i.getUtente() + "&service=" + i.getServizio() + "'>" + 
							"<i class=\"fas fa-trash-alt\"></i></a><br>" 
						
							
					);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		
	}

}
