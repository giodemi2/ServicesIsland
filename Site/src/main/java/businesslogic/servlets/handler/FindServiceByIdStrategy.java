/**
 * 
 */
package businesslogic.servlets.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Servizio;

/**
 * @author rodolfo
 * Find service by id strategy,
 * is used when after {@link SearchStrategy}
 * (after a research) we click on a service
 * to view info of this service
 */
public class FindServiceByIdStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final long serviceKey = Long.parseLong(request.getParameter("serviceId").toString());
		final Servizio servizio = StandardDataSource
				.getInstance()
				.getServizioDaoJDBC()
				.findByPrimaryKey(serviceKey);
		request.setAttribute("result", servizio);
		request.getRequestDispatcher("user.jsp?page=serviceInfo").forward(request, response);
		
	}

}
