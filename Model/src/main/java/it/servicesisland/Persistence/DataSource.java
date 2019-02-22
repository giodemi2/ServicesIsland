/**
 * 
 */
package it.servicesisland.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author rodolfo
 * DataSource component of DAO
 */
public class DataSource {
	
	/**
	 * URL of database
	 */
	final private String dbURI;
	
	/**
	 * User name of database
	 */
	final private String userName;
	
	/**
	 * Password of database
	 */
	final private String userPassword;
	
	

	/**
	 * Create a datasource using parameters
	 * @param dbURI of database
	 * @param userName of database
	 * @param password of database
	 */
	public DataSource(String dbURI, String userName, String password) {
		this.dbURI=dbURI;
		this.userName=userName;
		this.userPassword=password;
	}

	/**
	 * Connect to database
	 * @return the instance of db connection
	 */
	public Connection getConnection() //throws PersistenceException
	{
		Connection connection = null;
		try {
		    connection = DriverManager.getConnection(dbURI, userName, userPassword);		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
