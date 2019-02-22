/**
 * 
 */
package it.servicesisland.Connection.handlers;

import it.servicesisland.Persistence.DataSource;
import it.servicesisland.Persistence.MediatoreDaoJDBC;
import it.servicesisland.Persistence.NotificaDaoJDBC;
import it.servicesisland.Persistence.PrenotazioneDaoJDBC;
import it.servicesisland.Persistence.RecensioneDaoJDBC;
import it.servicesisland.Persistence.ServizioDaoJDBC;
import it.servicesisland.Persistence.UtenteDaoJDBC;

/**
 * @author rodolfo
 * Standard singleton data source
 */
public class StandardDataSource {
	
	/**
	 * Data source instance
	 */
	private static StandardDataSource instance;
	
	/**
	 * Default data source (Using {@link ConnectionInfo} 
	 * with DBInfo.json)
	 */
	private DataSource defaultDataSource;
	
	/**
	 * JDBC classes instances. 
	 * we add this classes in
	 * a singleton instance because,
	 * when we use it, we don't create everytime
	 * a new jdbc class.
	 * For example, the notifications system
	 * make a request every second.
	 * If the server allocate every second new
	 * jdbc instance there is waste of memory
	 */
	
	private MediatoreDaoJDBC mediatoreDaoJDBC;
	private NotificaDaoJDBC notificaDaoJDBC;
	private PrenotazioneDaoJDBC prenotazioneDaoJDBC;
	private RecensioneDaoJDBC recensioneDaoJDBC;
	private ServizioDaoJDBC servizioDaoJDBC;
	private UtenteDaoJDBC utenteDaoJDBC;
	
	
	/**
	 * Singleton empty constructor
	 */
	private StandardDataSource() {
		instance = null;
		
		final ConnectionInfo connectionInfo =  new ConnectionInfo("DBInfo.json");
		defaultDataSource = new DataSource(connectionInfo.getDBUrl(), connectionInfo.getDBUser(), connectionInfo.getDBPassword());
		
		mediatoreDaoJDBC = new MediatoreDaoJDBC(defaultDataSource);
		notificaDaoJDBC = new NotificaDaoJDBC(defaultDataSource);
		prenotazioneDaoJDBC = new PrenotazioneDaoJDBC(defaultDataSource);
		recensioneDaoJDBC =  new RecensioneDaoJDBC(defaultDataSource);
		servizioDaoJDBC = new ServizioDaoJDBC(defaultDataSource);
		utenteDaoJDBC = new UtenteDaoJDBC(defaultDataSource);
	}
	
	/**
	 * Get the default {@link DataSource}
	 * @return the default data source
	 */
	public DataSource getDefaultDataSource() {
		return defaultDataSource;
	}
	
	/**
	 * Get the SINGLE instance of class
	 * @return instance
	 */
	public static StandardDataSource getInstance() {
		if(instance == null) {
			instance = new StandardDataSource();
		}
		return instance;
	}

	/**
	 * @return the mediatoreDaoJDBC
	 */
	public MediatoreDaoJDBC getMediatoreDaoJDBC() {
		return mediatoreDaoJDBC;
	}

	/**
	 * @return the notificaDaoJDBC
	 */
	public NotificaDaoJDBC getNotificaDaoJDBC() {
		return notificaDaoJDBC;
	}

	/**
	 * @return the prenotazioneDaoJDBC
	 */
	public PrenotazioneDaoJDBC getPrenotazioneDaoJDBC() {
		return prenotazioneDaoJDBC;
	}

	/**
	 * @return the recensioneDaoJDBC
	 */
	public RecensioneDaoJDBC getRecensioneDaoJDBC() {
		return recensioneDaoJDBC;
	}

	/**
	 * @return the servizioDaoJDBC
	 */
	public ServizioDaoJDBC getServizioDaoJDBC() {
		return servizioDaoJDBC;
	}

	/**
	 * @return the utenteDaoJDBC
	 */
	public UtenteDaoJDBC getUtenteDaoJDBC() {
		return utenteDaoJDBC;
	}
	
	
	
	

}
