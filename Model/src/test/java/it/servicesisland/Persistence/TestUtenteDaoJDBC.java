/**
 * 
 */
package it.servicesisland.Persistence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Utente;

/**
 * @author rodolfo
 * {@link UtenteDaoJDBC} testing class
 */
public class TestUtenteDaoJDBC {
	
	/**
	 * Testing instances
	 */
	Utente user;
	UtenteDaoJDBC userDao;

	/**
	 * Constructor without parameters
	 */
	public TestUtenteDaoJDBC() {
		user = new Utente("ippolito", "bruno", "F", "ippolito@prova.it", "prova", 333333333L);
		userDao = new UtenteDaoJDBC(StandardDataSource.getInstance().getDefaultDataSource());
	}
	
	/**
	 * Test the saving of an Utente
	 */
	@Test
	public void testUserSave() {
		System.out.println("Test of saving of Utente Dao JDBC");
		userDao.saveSimple(user);
		assertEquals(user.getCodice(), userDao.findByEmail("ippolito@prova.it").getCodice());
	}
	
}
