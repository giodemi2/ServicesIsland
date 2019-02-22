package it.servicesisland.Persistence;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.sql.Time;

import org.junit.Test;

import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Servizio;

/**
 * @author rodolfo
 * {@link ServizioDaoJDBC} testing class
 */
public class TestServizioDaoJDBC {
	/**
	 * Testing instances
	 */
	Servizio service;
	ServizioDaoJDBC serviceDao;

	/**
	 * Constructor without parameters
	 */
	public TestServizioDaoJDBC() {
		service = new Servizio(1L, 10.0, new Time(0), new Date(0),new Time(0), new Date(0),"Servizio di prova", "try service", new Time(0), false, 4, ""); // 4 professionist foreign key exists!
		serviceDao = new ServizioDaoJDBC(StandardDataSource.getInstance().getDefaultDataSource());
	}
	
	/**
	 * Test the saving of an Utente
	 */
	@Test
	public void testServizioSave() {
		System.out.println("Test of saving of Servizio Dao JDBC");
		serviceDao.save(service);
		assertEquals(service.getCodice(), serviceDao.findByPrimaryKey(1L).getCodice());
	}
}
