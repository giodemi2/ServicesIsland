/**
 * 
 */
package it.servicesisland.Connection.handlers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author rodolfo
 * {@link ConnectionInfo} test class
 */
public class TestConnectionInfo {
	
	/**
	 * Testing instance
	 */
	private ConnectionInfo connectionInfo;
	
	/**
	 * Constructor without parameters
	 */
	public TestConnectionInfo() {
		connectionInfo = new ConnectionInfo("DBInfo-TEST.json");
	}
	
	/**
	 * Test if the parameter of JSON file are correct.
	 * Test is good if all parameters are "prova"
	 */
	@Test
	public void testConnectionParametersRead() {
		System.out.println("Test of ConnectionInfo");
		System.out.println(connectionInfo.getDBUrl());
		System.out.println(connectionInfo.getDBHost());
		System.out.println(connectionInfo.getDBPassword());
		System.out.println(connectionInfo.getDBPort());
		System.out.println(connectionInfo.getDBUser());
		System.out.println(connectionInfo.getDBVendor());
		
		assertEquals("prova", connectionInfo.getDBUrl());
		assertEquals("prova", connectionInfo.getDBHost());
		assertEquals("prova", connectionInfo.getDBPassword());
		assertEquals("prova", connectionInfo.getDBPort());
		assertEquals("prova", connectionInfo.getDBUser());
		assertEquals("prova", connectionInfo.getDBVendor());
	}

}
