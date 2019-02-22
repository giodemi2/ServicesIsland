/**
 * 
 */
package businesslogic.servlets.handler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslogic.servlets.ServicesHandler;
import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Servizio;

/**
 * @author rodolfo
 * Search operation strategy.
 * This operation is invoked by 
 * {@link ServicesHandler} servlet
 * to search contents
 */
public class SearchStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String searchKey = request.getParameter("txtSearch").toString();
		
		final ArrayList<Servizio> servizi = StandardDataSource
				.getInstance()
				.getServizioDaoJDBC()
				.findByDescrizione(searchKey);
		servizi.removeIf(s -> !s.isApprovato());

		if(servizi.isEmpty()) {
			request.setAttribute("result", null);
			request.getRequestDispatcher("user.jsp?page=search").forward(request, response);

		}
		else {
			request.setAttribute("result", servizi);
			request.getRequestDispatcher("user.jsp?page=search").forward(request, response);
		}
	}

}
