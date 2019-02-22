/**
 * 
 */
package businesslogic.utils;

import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Notifica;

/**
 * @author rodolfo
 * NotificationHandler class.
 * It handle us to create every time
 * a Notifica, and make it...
 */
public class NotificationHandler {
	
	public static void notificateToUser(long userId, String title, String content) {
		Notifica notifica = new Notifica(userId, title, content);
		StandardDataSource
				.getInstance()
				.getNotificaDaoJDBC()
				.save(notifica);
	}

}
