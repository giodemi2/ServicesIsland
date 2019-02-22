package it.servicesisland.Model;

/**
 * 
 * @author Tiziana
 *
 */
public class Recensione {

	private Long codice;
	private int voto;
	private String commento;
	private int servizio;
	private int utente;
	
	
	/**
	 * constructor with parameters
	 * @param voto
	 * @param commento
	 * @param servizio
	 * @param utente
	 */
	public Recensione(int voto, String commento, int servizio, int utente) {
		super();
		this.voto = voto;
		this.commento = commento;
		this.servizio = servizio;
		this.utente=utente;
	}

	/**
	 * default constructor
	 */
	public Recensione() {
		this.voto =0;
		this.commento = null;
		this.servizio = 0;
		this.utente=0;
	}
	
	/**
	 * gets the primary key
	 * @return codice
	 */
	public Long getCodice() {
		return codice;
	}
	
	/**
	 * sets the primary key
	 * @param codice
	 */
	public void setCodice(Long codice) {
		this.codice = codice;
	}
	
	
	/**
	 * returns the valuation
	 * @return voto
	 */
	public int getVoto() {
		return voto;
	}
	
	
	/**
	 * sets the valuation
	 * @param voto
	 */
	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	
	/**
	 * 
	 * @return commento
	 */
	public String getCommento() {
		return commento;
	}
	
	/**
	 * sets the comment
	 * @param commento
	 */
	public void setCommento(String commento) {
		this.commento = commento;
	}
	
	/**
	 * gets the valued service
	 * @return servizio
	 */
	public int getServizio() {
		return servizio;
	}
	
	/**
	 * set the valued service
	 * @param servizio
	 */
	public void setServizio(int servizio) {
		this.servizio = servizio;
	}

	/**
	 * gets the user who wrote it
	 * @return utente
	 */
	public int getUtente() {
		return utente;
	}

	/**
	 * sets the user
	 * @param utente
	 */
	public void setUtente(int utente) {
		this.utente = utente;
	}
	
	
	
}
