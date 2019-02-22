/**
 * 
 */
package businesslogic.servlets.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author rodolfo
 * Servlet Handler general class.
 * Servlet handler use Strategy design pattern.
 * ServletHandler has a {@link Strategy}
 * to do differents operations.
 */
public class ServletHandler {
	
	/**
	 * Handle function
	 * @param strategy to use
	 * @param request request that represent the html protocol request
	 * @param response that represent the html protocol response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void handle(
					Strategy strategy, 
					HttpServletRequest request, 
					HttpServletResponse response) throws ServletException, IOException {
		strategy.handle(request, response);
	}
}
