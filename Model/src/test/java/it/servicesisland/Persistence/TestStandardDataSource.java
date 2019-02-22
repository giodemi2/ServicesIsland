/**
 * 
 */
package it.servicesisland.Persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;

import org.junit.Test;

import it.servicesisland.Connection.handlers.StandardDataSource;

/**
 * @author rodolfo
 * {@link StandardDataSource} testing class
 */
public class TestStandardDataSource {
	/**
	 * Test if Standard Data Source work (using DBInfo.json)
	 */
	@Test
	public void testDataSourceConnection() {
		System.out.println("Test of StandardDataSource connection");
		assertNotEquals(null, StandardDataSource.getInstance().getDefaultDataSource());
	}
	
	/**
	 * Test if Standard Data Source work (using DBInfo.json)
	 */
	@Test
	public void testDataSourceConnectionClosing() {
		System.out.println("Test of StandardDataSource connection closing");
		try {
			assertEquals(false, StandardDataSource.getInstance().getDefaultDataSource().getConnection().isClosed());
			StandardDataSource.getInstance().getDefaultDataSource().getConnection().close();
			//assertEquals(true, StandardDataSource.getInstance().getDefaultDataSource().getConnection().isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
