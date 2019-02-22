package it.servicesisland.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.servicesisland.Model.*;

/**
 * @author tiziana
 * Servizio jdbc dao class
 */
public class ServizioDaoJDBC {

	/**
	 * Instance of DataSource
	 */
	private DataSource dataSource;

	/**
	 * Constructor with parameters
	 * @param dataSource of connection
	 */
	public ServizioDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
		//dataSource=new DataSource("jdbc:postgresql://localhost:5432/services_island","postgres","postgres");
	}
	
	/**
	 * Add new service in the database
	 * @param servizio to save
	 */
	
	public void cambiaPrezzo() {
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "update servizio set prezzo=100";
			statement = connection.prepareStatement(query);
			
			statement.executeUpdate();
			
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
	public void save(Servizio servizio) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			
			 
			String insert = "insert into servizio(prezzo, orario_inizio, orario_fine, data_inizio, data_fine, descrizione, nome, approvato, professionista) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setDouble(1, servizio.getPrezzo());
			statement.setTime(2, servizio.getOrario_inizio());
			statement.setTime(3, servizio.getOrario_fine());
			statement.setDate(4, servizio.getData_inizio());
			statement.setDate(5, servizio.getData_fine());
			statement.setString(6, servizio.getDescrizione());
			statement.setString(7, servizio.getNome());
			statement.setBoolean(8, servizio.isApprovato());
			statement.setInt(9, servizio.getProfessionista());

						
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
	
	/**
	 * Find the Servizio by primary key
	 * @param id of service
	 * @return the Servizio which has a primary key id
	 */
	public Servizio findByPrimaryKey(Long id) {
		Connection connection = this.dataSource.getConnection();
		Servizio servizio = null;
		try {
			PreparedStatement statement;
			String query = "select * from servizio where codice = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				servizio = new Servizio();
				servizio.setCodice(result.getLong("codice"));
				servizio.setNome(result.getString("nome"));
				servizio.setPrezzo(result.getDouble("prezzo"));
				servizio.setApprovato(result.getBoolean("approvato"));
				servizio.setDescrizione(result.getString("descrizione"));
				servizio.setData_inizio(result.getDate("data_inizio"));
				servizio.setData_fine(result.getDate("data_fine"));
				servizio.setOrario_inizio(result.getTime("orario_inizio"));
				servizio.setOrario_fine(result.getTime("orario_fine"));
				servizio.setProfessionista(result.getInt("professionista"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return servizio;
	}
	
	
	/**
	 * Find the Servizio by descrizione
	 * @param chiaveRicerca of service
	 * @return thelists of Servizio which have a descrizione like to descrizione
	 */
	public ArrayList<Servizio> findByDescrizione(String chiaveRicerca) {
		ArrayList<Servizio> servizi = new ArrayList<>();

		Connection connection = this.dataSource.getConnection();
//		Servizio servizio = null;
		try {
			PreparedStatement statement;
			String query = "select * from servizio where descrizione like ? or nome like ?";

			statement = connection.prepareStatement(query);
			statement.setString(1, "%" + chiaveRicerca + "%");
			statement.setString(2, "%" + chiaveRicerca + "%");

			ResultSet result = statement.executeQuery();
			

			while (result.next()) {
				Servizio servizio = new Servizio();
				
				servizio.setCodice(result.getLong("codice"));				
				servizio.setPrezzo(result.getDouble("prezzo"));
				servizio.setApprovato(result.getBoolean("approvato"));
				servizio.setDescrizione(result.getString("descrizione"));
				servizio.setNome(result.getString("nome"));
				servizio.setData_inizio(result.getDate("data_inizio"));
				servizio.setData_fine(result.getDate("data_fine"));
				servizio.setOrario_inizio(result.getTime("orario_inizio"));
				servizio.setOrario_fine(result.getTime("orario_fine"));
				servizio.setProfessionista(result.getInt("professionista"));
				
				servizi.add(servizio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return servizi;
	}
	
	
	
	/**
	 * Find the Servizio by the professionist
	 * @param userId of profesisonist
	 * @return thelists of Servizio which have a userId like to userId
	 */
	public ArrayList<Servizio> findByProfessionist(long userId) {
		ArrayList<Servizio> servizi = new ArrayList<>();

		Connection connection = this.dataSource.getConnection();
//		Servizio servizio = null;
		try {
			PreparedStatement statement;
			String query = "select * from servizio where professionista = ?";

			statement = connection.prepareStatement(query);
			statement.setLong(1, userId);

			ResultSet result = statement.executeQuery();
			

			while (result.next()) {
				Servizio servizio = new Servizio();
				
				servizio.setCodice(result.getLong("codice"));				
				servizio.setPrezzo(result.getDouble("prezzo"));
				servizio.setApprovato(result.getBoolean("approvato"));
				servizio.setDescrizione(result.getString("descrizione"));
				servizio.setNome(result.getString("nome"));
				servizio.setData_inizio(result.getDate("data_inizio"));
				servizio.setData_fine(result.getDate("data_fine"));
				servizio.setOrario_inizio(result.getTime("orario_inizio"));
				servizio.setOrario_fine(result.getTime("orario_fine"));
				servizio.setProfessionista(result.getInt("professionista"));
				
				servizi.add(servizio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return servizi;
	}
	
	
	
/**
 * Delete a given instance of Servizio, finding it by primary key	
 * @param id
 */
public void delete(Long id) {
		
		Connection connection = this.dataSource.getConnection();
		try {			
		PrenotazioneDaoJDBC pre= new PrenotazioneDaoJDBC(this.dataSource);
		pre.delete(id);
		PreparedStatement statement;
		String query = "delete from servizio where codice = ?";
		statement = connection.prepareStatement(query);
		statement.setLong(1, id);
		statement.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

public List<Servizio> findUnapproved(){
	
	List<Servizio> servizi= new ArrayList<Servizio>();
	Connection connection = this.dataSource.getConnection();
	try {
	PreparedStatement statement;
	String query = "select * from servizio where approvato = false";
	statement = connection.prepareStatement(query);
	
	ResultSet result= statement.executeQuery();
	while (result.next()) {
		Servizio s= new Servizio();
		s.setCodice(result.getLong("codice"));
		s.setPrezzo(result.getDouble("prezzo"));
		s.setApprovato(result.getBoolean("approvato"));
		s.setDescrizione(result.getString("descrizione"));
		s.setNome(result.getString("nome"));
		s.setData_inizio(result.getDate("data_inizio"));
		s.setData_fine(result.getDate("data_fine"));
		s.setOrario_inizio(result.getTime("orario_inizio"));
		s.setOrario_fine(result.getTime("orario_fine"));
		s.setProfessionista(result.getInt("professionista"));
		
		servizi.add(s);
		
	}
	
	
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return servizi;
}
}
