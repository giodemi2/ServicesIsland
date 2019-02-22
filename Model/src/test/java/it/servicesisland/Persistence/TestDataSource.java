package it.servicesisland.Persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;

import org.junit.Test;

import it.servicesisland.Connection.handlers.ConnectionInfo;

/**
 * @author rodolfo
 * {@link DataSource} testing class
 */
public class TestDataSource {

	/**
	 * Testing instance
	 */
	DataSource dataSource;

	/**
	 * Constructor without parameters 
	 */
	public TestDataSource() {
		ConnectionInfo connectionInfo = new ConnectionInfo("DBInfo.json");
		dataSource = new DataSource(connectionInfo.getDBUrl(), connectionInfo.getDBUser(), connectionInfo.getDBPassword());
	}
	
	/**
	 * Test if Data Source work (using DBInfo.json)
	 */
	@Test
	public void testDataSourceConnection() {
		System.out.println("Test of DataSource connection");
		assertNotEquals(null, dataSource.getConnection());
	}
	
	/**
	 * Test if Data Source work (using DBInfo.json)
	 */
	@Test
	public void testDataSourceConnectionClosing() {
		System.out.println("Test of DataSource connection closing");
		try {
			assertEquals(false, dataSource.getConnection().isClosed());
			dataSource.getConnection().close();
			//assertEquals(true, dataSource.getConnection().isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
