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
import it.servicesisland.Model.Servizio;

/**
 * @author rodolfo
 * Add new service strategy.
 * It is used when a professionist 
 * add a new service
 */
public class AddNewServiceStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final Servizio servizio = new Servizio(null, 
				Double.parseDouble(request.getParameter("txtPrezzo")), 
				Time.valueOf(request.getParameter("txtOrarioInizio")), 
				Date.valueOf(request.getParameter("txtDataInizio")), 
				Time.valueOf(request.getParameter("txtOrarioFine")), 
				Date.valueOf(request.getParameter("txtDataFine")), 
				request.getParameter("txtDescrizione").toString(), 
				request.getParameter("txtNomeServizio").toString(), 
				Time.valueOf(request.getParameter("txtTempoMedio")), 
				false, 
				Integer.parseInt(request.getSession().getAttribute("id").toString()), 
				request.getParameter("txtAltriDettagli").toString());
		
		StandardDataSource
				.getInstance()
				.getServizioDaoJDBC()
				.save(servizio);
		
		NotificationHandler
				.notificateToUser(
						Long.parseLong(request.getSession().getAttribute("id").toString()), 
						"Richiesta inserimento servizio!", 
						"Servizio " + servizio.getNome() + " in fase di approvazione...");
		
		request.setAttribute("reportMessage", "Inserimento servizio andato a buon fine!");
		request.getRequestDispatcher("/report.jsp").forward(request, response);
		
	}

}
