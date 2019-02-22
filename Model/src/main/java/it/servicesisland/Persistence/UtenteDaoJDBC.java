package it.servicesisland.Persistence;
//package it.privately.persistance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.servicesisland.Model.Prenotazione;
import it.servicesisland.Model.Servizio;
import it.servicesisland.Model.Utente;



/**
 * @author tiziana
 * Utente jdbc dao class
 */
public class UtenteDaoJDBC {
	
	/**
	 * Instance of DataSource
	 */
	private DataSource dataSource;

	/**
	 * Constructor with parameters
	 * @param dataSource of connection
	 */
	public UtenteDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
		//dataSource=new DataSource("jdbc:postgresql://localhost:5432/services_island","postgres","postgres");
	}
	
	/**
	 * Add new simple user in the database
	 * @param utente to add
	 */
	public void saveSimple(Utente utente){
		Connection connection = this.dataSource.getConnection();
		try {
			
			
			String insert = "insert into utente(nome, cognome, sesso,email, password, professionista, telefono) values (?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, utente.getNome());
			statement.setString(2, utente.getCognome());
			statement.setString(3, utente.getSesso());
			statement.setString(4, utente.getEmail());
			statement.setString(5, utente.getPassword());
			statement.setBoolean(6, false);
			statement.setLong(7, utente.getTelefono());
					
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
				} catch(SQLException excep) {
					//throw new PersistenceException(e.getMessage());
				}
			} 
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
			//	throw new PersistenceException(e.getMessage());
			}
		}
	}
	
	/**
	 * Add new professionista in the database
	 * @param utente to add
	 */
	public void saveProfessionista(Utente utente){
		Connection connection = this.dataSource.getConnection();
		try {
			
			
			String insert = "insert into utente(nome, cognome, sesso,email, password, professionista, telefono,"
					+ "codice_fiscale, partita_iva, professione, settore, sede_fiscale, sede_legale) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, utente.getNome());
			statement.setString(2, utente.getCognome());
			statement.setString(3, utente.getSesso());
			statement.setString(4, utente.getEmail());
			statement.setString(5, utente.getPassword());
			statement.setBoolean(6, true);
			statement.setLong(7, utente.getTelefono());
			statement.setString(8, utente.getCodice_fiscale());
			statement.setString(9, utente.getPartita_iva());
			statement.setString(10, utente.getProfessione());
			statement.setString(11, utente.getSettore());
			statement.setString(12, utente.getSede_fiscale());
			statement.setString(13, utente.getSede_legale());
					
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
				} catch(SQLException excep) {
					//throw new PersistenceException(e.getMessage());
				}
			} 
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
			//	throw new PersistenceException(e.getMessage());
			}
		}
	}
	
	/**
	 * Fine an Utente by his email
	 * @param email of user to fine
	 * @return Utente which has the same email
	 */
	public Utente findByEmail(String email) {
		Connection connection = this.dataSource.getConnection();
		Utente utente = null;
		
		try {
			PreparedStatement statement;
			String query = "select * from utente where email = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new Utente();
				utente.setCodice(result.getLong("codice"));				
				utente.setNome(result.getString("nome"));
				utente.setCognome(result.getString("cognome"));
				utente.setSesso(result.getString("sesso"));
				utente.setEmail(result.getString("email"));
				utente.setPassword(result.getString("password"));
				utente.setProfessionista(result.getBoolean("professionista"));
				utente.setTelefono(result.getLong("telefono"));
				utente.setCodice_fiscale(result.getString("codice_fiscale"));
				utente.setPartita_iva(result.getString("partita_iva"));
				utente.setProfessione(result.getString("professione"));
				utente.setSettore(result.getString("settore"));
				utente.setSede_fiscale(result.getString("sede_fiscale"));
				utente.setSede_legale(result.getString("sede_legale"));
				
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
		return utente;
	}
	
	/**
	 * Get all services of a professionists
	 * @param email of professionist user
	 * @return {@link List} of services offered by Utente which has the same email
	 * @deprecated è buggato!
	 */
	public List<Servizio> findAllServices(String email) {
		Connection connection = this.dataSource.getConnection();
		List<Servizio> servizi = new ArrayList<>();
		try {			
			Servizio servizio;
			PreparedStatement statement;
			String query = "select servizio.codice as codice"
					+ " from utente inner join servizio on utente.codice=servizio.professionista"
					+ " where utente.email= ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			
			ServizioDaoJDBC servizioDao= new ServizioDaoJDBC(this.dataSource);
			while (result.next()) {
				
				servizio= servizioDao.findByPrimaryKey(result.getLong("codice"));
				servizi.add(servizio);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return servizi;
	}
	
	/**
	 * it in TODO phase
	 * @return average rating of all services
	 */
	public double averageRating(String email) {
		Connection connection = this.dataSource.getConnection();
		Utente us=findByEmail(email);
		double avg=0.0;
		try {
			PreparedStatement statement;
			String query = "select avg(voto) as media"
					+ " from recensione inner join servizio on servizio.codice=recensione.servizio"
					+ " where servizio.professionista= ?";
			
			statement = connection.prepareStatement(query);
			statement.setLong(1, us.getCodice());
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				avg=result.getDouble("media");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return avg;
	}
	
	/**
	 * TODO
	 * @param email
	 * @param seId
	 * @return
	 */
	public double averageRatingService(String email, Long seId) {
		return seId;
		
	}
	
	public void delete(String email) {
		Connection connection = this.dataSource.getConnection();
		Utente us=findByEmail(email);
		try {
			
			ServizioDaoJDBC ser= new ServizioDaoJDBC(this.dataSource);
			List<Servizio> servizi = this.findAllServices(email);
			for(Servizio s: servizi){
				ser.delete(s.getCodice());
			}
			
			PreparedStatement statement;
			String query = "delete from utente where codice = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, us.getCodice());
			statement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public List<Prenotazione> findAllPrenotazioni(String email){ 
		
		Connection connection = this.dataSource.getConnection();
		
		List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
		
		try {			
			
			PreparedStatement statement;
			String query = "select prenotazione.utente as utente, prenotazione.servizio as servizio"
					+ ", prenotazione.orario_prenotazione as orario, prenotazione.data_prenotazione as data"
					+ " from utente inner join servizio on utente.codice=servizio.professionista "
					+ "inner join prenotazione on prenotazione.servizio=servizio.codice"
					+ " where utente.email= ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			
			
			while (result.next()) {
				Prenotazione p= new Prenotazione();
				p.setServizio(result.getInt("servizio"));
				p.setUtente(result.getInt("utente"));
				p.setData_prenotazione(result.getDate("data"));
				p.setOrario_prenotazione(result.getTime("orario"));
				prenotazioni.add(p);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return prenotazioni;
	}
	
	/**
	 * Update a user
	 * @param u user to update
	 */
	public void update(Utente u) {
		
		Connection connection = this.dataSource.getConnection();
		
		try {
			PreparedStatement statement;
			String query = "update utente set nome= ?, cognome=?,"
					+ " sesso=?,"
					+ "telefono=?, codice_fiscale=?, partita_iva=?,"
					+ "professione=?, settore=?, sede_fiscale=?,"
					+ "sede_legale=? where codice = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, u.getNome());
			statement.setString(2, u.getCognome());
			statement.setString(3, u.getSesso());
			statement.setLong(4, u.getTelefono());
			statement.setString(5, u.getCodice_fiscale());
			statement.setString(6, u.getPartita_iva());
			statement.setString(7, u.getProfessione());
			statement.setString(8, u.getSettore());
			statement.setString(9, u.getSede_fiscale());
			statement.setString(10, u.getSede_legale());
			statement.setLong(11, u.getCodice());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
