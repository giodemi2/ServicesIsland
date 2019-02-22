/**
 * 
 */
package businesslogic.servlets.handler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Servizio;

/**
 * @author rodolfo
 * Get statistic values operation
 */
public class GetStatisticsStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final long userId = Long.parseLong(request.getParameter("utente").toString());

		// all services offered by profesisonist
		int servicesCount = 0;
		int prenotationsCount = 0;
		
		ArrayList<Servizio> servizi = StandardDataSource
											.getInstance()
											.getServizioDaoJDBC()
											.findByProfessionist(userId);

		servicesCount = servizi.size();
		for(Servizio i : servizi)
			prenotationsCount += StandardDataSource
									.getInstance()
									.getPrenotazioneDaoJDBC()
									.findByServiceId(i.getCodice()).size();
		
		response.getOutputStream().print("" + servicesCount + "," + prenotationsCount + "," + "0");
	}

}
