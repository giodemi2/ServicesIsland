package it.servicesisland.Model;

import java.sql.Date;
import java.sql.Time;

/**
 * 
 * @author Tiziana
 *
 */

public class Prenotazione {

	private Time orario_prenotazione;
	private Date data_prenotazione;
	private int utente;
	private int servizio;
	
	
	/**
	 * Constructor without parameters
	 */
	public Prenotazione() {
		
		this.orario_prenotazione=null;
		this.data_prenotazione=null;
		this.servizio=0;
		this.utente=0;
	}
	
	/**
	 * Constructor with parameters
	 * @param orario
	 * @param giorno
	 * @param utente
	 * @param servizio
	 */
	public Prenotazione(Time orario, Date giorno, int utente, int servizio) {
		super();
		this.orario_prenotazione = orario;
		this.data_prenotazione = giorno;
		this.utente = utente;
		this.servizio = servizio;
	}
	
	/**
	 * 
	 * @return orario
	 */
	public Time getOrario_prenotazione() {
		return orario_prenotazione;
	}
	
	/**
	 * 
	 * @param the orario to be set
	 */
	public void setOrario_prenotazione(Time orario) {
		this.orario_prenotazione = orario;
	}
	
	/**
	 * 
	 * @return giorno
	 */
	public Date getData_prenotazione() {
		return data_prenotazione;
	}
	
	/**
	 * 
	 * @param giorno
	 */
	public void setData_prenotazione(Date giorno) {
		this.data_prenotazione= giorno;
	}
	
	/**
	 * 
	 * @return utente
	 */
	public int getUtente() {
		return utente;
	}
	
	/**
	 * 
	 * @param utente
	 */
	public void setUtente(int utente) {
		this.utente = utente;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getServizio() {
		return servizio;
	}
	
	/**
	 * 
	 * @param servizio
	 */
	public void setServizio(int servizio) {
		this.servizio = servizio;
	}
	
	
}
