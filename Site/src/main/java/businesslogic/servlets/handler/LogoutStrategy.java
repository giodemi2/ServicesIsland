/**
 * 
 */
package businesslogic.servlets.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author rodolfo
 * User logout strategy
 */
public class LogoutStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession loginSession = request.getSession();
		loginSession.invalidate();
		
		request.setAttribute("reportMessage", "Logout andato a buon fine!");
		request.getRequestDispatcher("/report.jsp").forward(request, response);
	}

}
