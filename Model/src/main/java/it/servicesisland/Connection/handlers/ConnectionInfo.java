/**
 * 
 */
package it.servicesisland.Connection.handlers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONObject;

/**
 * @author rodolfo
 * Connection info class.
 * It takes Db connections parameters by
 * JSON file in the resources
 */
public class ConnectionInfo {
	
	/**
	 * Attributes
	 */
	private String url, host, dbVendor, port, user, password;
	
	/**
	 * Content of JSON file
	 */
	private String fileContent;
	
	/**
	 * JSONObject instance
	 */
	private JSONObject object;
	

	/**
	 * Constructor with parameters
	 * @param path of JSON file
	 */
	public ConnectionInfo(String path){
		initFileContent(path);
		initJson();
	}

	/**
	 * Init Json Elements
	 */
	private void initJson() {
		object = new JSONObject(this.fileContent.trim());

		url = object.getString("url").toString();
		host = object.get("host").toString();
		dbVendor = object.get("DB_Vendor").toString();
		port = object.get("port").toString();
		user = object.get("user").toString();
		password = object.get("password").toString();
	}

	/**
	 * Init the fileContent
	 * @param path of JSON file
	 */
	private void initFileContent(String path) {
		this.fileContent="";
		try {
			Path p = Paths.get(getClass().getClassLoader().getResource(path).toURI());
			Files.lines(p).forEach((String l)-> {
				this.fileContent+=l;
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the host that we want to use
	 * @return the host
	 */
	public String getDBHost() {
		return host;
	}
	
	/**
	 * Get the DB_Vendor that we want to use
	 * @return the DB_Vendor
	 */
	public String getDBVendor() {
		return dbVendor;
	}
	
	/**
	 * Get the port that we want to use
	 * @return the port
	 */
	public String getDBPort() {
		return port;
	}
	
	/**
	 * Get the user that we want to use
	 * @return the user
	 */
	public String getDBUser() {
		return user;
	}
	
	/**
	 * Get the password that we want to use
	 * @return the user
	 */
	public String getDBPassword() {
		return password;
	}

	/**
	 * Get the url of db connection
	 * @return the url
	 */
	public String getDBUrl() {
		return url;
	}
	
	
}
