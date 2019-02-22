package it.servicesisland.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.servicesisland.Model.Notifica;
import it.servicesisland.Model.Servizio;

public class NotificaDaoJDBC {

	/**
	 * Instance of DataSource
	 */
	private DataSource dataSource;

	
	/**
	 * Constructor with parameters
	 * @param dataSource of connection
	 */
	public NotificaDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
		//dataSource=new DataSource("jdbc:postgresql://localhost:5432/services_island","postgres","postgres");
	}
	
	/**
	 * salva l'istanza di notifica
	 * @param n
	 */
	public void save(Notifica n) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			
			 
			String insert = "insert into notifica(utente, titolo, contenuto) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setLong(1, n.getUtente());
			statement.setString(2, n.getTitolo());
			statement.setString(3, n.getContenuto());
						
						
			statement.executeUpdate();
			
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch(SQLException excep) {
					excep.printStackTrace();
				}
			} 
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * restituisce le notifiche di un utente
	 * @param id
	 * @return
	 */
	public List<Notifica> findByUser(Long id){
		Connection connection = this.dataSource.getConnection();
		List<Notifica> notifiche= new ArrayList<Notifica>();
		try {
			PreparedStatement statement;
			String query = "select * from notifica where utente = ?";

			statement = connection.prepareStatement(query);
			statement.setLong(1,id);
			

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Notifica n= new Notifica();
				n.setCodice(result.getLong("codice"));
				n.setContenuto(result.getString("contenuto"));
				n.setTitolo(result.getString("titolo"));
				n.setUtente(result.getLong("utente"));
				notifiche.add(n);
			}
			
	}catch (SQLException e) {
		if (connection != null) {
			try {
				connection.rollback();
			} catch(SQLException excep) {
				excep.printStackTrace();
			}
		} 
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
		return notifiche;
}
	
}
