package it.servicesisland.Model;

public class Notifica {
	
	private Long codice;
	private Long utente;
	private String titolo;
	private String contenuto;
	
	/**
	 * construttore senza parametri
	 */
	public Notifica() {
		codice=0L;
		utente=0L;
		titolo=null;
		contenuto=null;
	}

	
	/**
	 * costruttore con parametri
	 * @param utente
	 * @param titolo
	 * @param contenuto
	 */
	public Notifica(Long utente, String titolo, String contenuto) {
		
		this.utente=utente;
		this.titolo=titolo;
		this.contenuto=contenuto;
	}


	// setters and getters
	
	public Long getCodice() {
		return codice;
	}


	public void setCodice(Long codice) {
		this.codice = codice;
	}


	public Long getUtente() {
		return utente;
	}


	public void setUtente(Long utente) {
		this.utente = utente;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public String getContenuto() {
		return contenuto;
	}


	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}
	
	
}
