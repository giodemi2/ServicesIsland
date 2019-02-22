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
 * Account delete strategy
 */
public class AccountDeleteStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String email = request.getSession().getAttribute("email").toString();
		
		StandardDataSource
			.getInstance()
			.getUtenteDaoJDBC()
			.delete(email);
		
		request.getSession().invalidate();
		response.getOutputStream().print("success");
		
	}

}
