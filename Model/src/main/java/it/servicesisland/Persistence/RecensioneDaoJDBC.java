package it.servicesisland.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.servicesisland.Model.Recensione;



public class RecensioneDaoJDBC {

	private DataSource dataSource;

	public RecensioneDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void save(Recensione recensione) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			
			 
			String insert = "insert into recensione(voto, commento, servizio, utente) values (?,?,?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, recensione.getVoto());
			
			
			statement.setString(2, recensione.getCommento());
			
			statement.setInt(3, recensione.getServizio());
			statement.setInt(4, recensione.getUtente());
						
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
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
	
	
	public Recensione findByUserService(Long usId, Long seId) {
		
		Connection connection = this.dataSource.getConnection();
		Recensione rec= new Recensione();
		try {
				 
			String query = "select * from recensione where servizio=? ad utente= ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, seId);
			statement.setLong(2, usId);
			
						
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				
				rec.setCodice(result.getLong("codice"));
				rec.setCommento(result.getString("commento"));
				rec.setServizio(result.getInt("servizio"));
				rec.setUtente(result.getInt("utente"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
		
		return rec;
	}
}
