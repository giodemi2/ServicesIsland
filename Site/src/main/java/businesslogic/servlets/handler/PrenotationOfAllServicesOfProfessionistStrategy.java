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
 * For each service offered,
 * this strategies return all prenotations
 */
public class PrenotationOfAllServicesOfProfessionistStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getOutputStream().println(
//				request.getSession().getAttribute("email").toString()
//				);
//		request.getSession().getAttribute("email").toString()
		
		final long userId = Long.parseLong(request.getParameter("utente").toString());

		StandardDataSource
			.getInstance()
			.getServizioDaoJDBC()
			.findByProfessionist(userId)
			// all services offered by profesisonist
			.forEach(i -> {
				StandardDataSource
					.getInstance()
					.getPrenotazioneDaoJDBC()
					.findByServiceId(i.getCodice())
					.forEach(j ->{
						try {
							final long day = j.getData_prenotazione().getDay();
							final long year = j.getData_prenotazione().getYear();
							final long month = j.getData_prenotazione().getMonth();
							response.getOutputStream().println(
									"<p>Prenotazione in data: " + day + "/" + month + "/" + year + "<br>Servizio: " + i.getNome() + "</p>"
							);
//							response.getOutputStream().println(
//									"<a href='ServicesHandler?op=deletePrenotation&user=" + i.getUtente() + "&service=" + i.getServizio() + "'>" + 
//									"<i class=\"fas fa-trash-alt\"></i></a><br>"
//							);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
			});
		
	}

}
