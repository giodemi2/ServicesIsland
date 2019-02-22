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
 * General abstract Strategy class
 */
public abstract class Strategy {

	/**
	 * Handle function
	 * @param request that represent the html protocol request
	 * @param response that represent the html protocol response
	 */
	public abstract void handle(
			HttpServletRequest request, 
			HttpServletResponse response
	) throws ServletException, IOException;
}
