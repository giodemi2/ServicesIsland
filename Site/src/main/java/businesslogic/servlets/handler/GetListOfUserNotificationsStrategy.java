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
 * get the list of all notifications
 * given a user id
 */
public class GetListOfUserNotificationsStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final long userId = Long.parseLong(request.getSession().getAttribute("id").toString());
		StandardDataSource
			.getInstance()
			.getNotificaDaoJDBC()
			.findByUser(userId)
			.forEach(i -> {
				try {
					response.getOutputStream().print("<li class='dropdown-item'><strong>" + i.getTitolo() + "</strong><br>" + i.getContenuto() + "<li>");
					response.getOutputStream().print("<div class='dropdown-divider'></div>");

				} catch (IOException e) {
					e.printStackTrace();
				}
			});
	}

}
