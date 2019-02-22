package it.servicesisland.Model;


import java.sql.Date;
import java.sql.Time;

/**
 * Service simple class
 * @author tiziana
 */
public class Servizio {
	
	private Long codice;
	private double prezzo;
	private Time orario_inizio;
	private Date data_inizio;
	private Time orario_fine;
	private Date data_fine;
	private String descrizione;
	private String nome;
	private Time tempo_medio;
	private boolean approvato;
	private int professionista;
	private String altri_dettagli;
	
	/**
	 * Constructor without parameters
	 */
	public Servizio() {
		super();
		this.codice = 0L;
		this.prezzo = 0.0;
		this.orario_inizio = null;
		this.data_inizio = null;
		this.orario_fine = null;
		this.data_fine = null;
		this.descrizione = null;
		this.nome = null;
		this.tempo_medio = null;
		this.approvato = false;
		this.professionista = 0;
		this.altri_dettagli = null;
	}
	
	

	
	/**
	 * Constructor with parameters
	 * @param codice
	 * @param prezzo
	 * @param orario_inizio
	 * @param data_inizio
	 * @param orario_fine
	 * @param data_fine
	 * @param descrizione
	 * @param nome
	 * @param tempo_medio
	 * @param approvato
	 * @param professionista
	 * @param altri_dettagli
	 */
	public Servizio(Long codice, double prezzo, Time orario_inizio, Date data_inizio, Time orario_fine, Date data_fine,
			String descrizione, String nome, Time tempo_medio, boolean approvato, int professionista,
			String altri_dettagli) {
		super();
		this.codice = codice;
		this.prezzo = prezzo;
		this.orario_inizio = orario_inizio;
		this.data_inizio = data_inizio;
		this.orario_fine = orario_fine;
		this.data_fine = data_fine;
		this.descrizione = descrizione;
		this.nome = nome;
		this.tempo_medio = tempo_medio;
		this.approvato = approvato;
		this.professionista = professionista;
		this.altri_dettagli = altri_dettagli;
	}



	/**
	 * @return the codice
	 */
	public Long getCodice() {
		return codice;
	}
	/**
	 * @param codice the codice to set
	 */
	public void setCodice(Long codice) {
		this.codice = codice;
	}
	/**
	 * @return the prezzo
	 */
	public double getPrezzo() {
		return prezzo;
	}
	/**
	 * @param prezzo the prezzo to set
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}
	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	/**
	 * @return the approvato
	 */
	public boolean isApprovato() {
		return approvato;
	}
	/**
	 * @param approvato the approvato to set
	 */
	public void setApprovato(boolean approvato) {
		this.approvato = approvato;
	}
	/**
	 * @return the professionista
	 */
	public int getProfessionista() {
		return professionista;
	}
	/**
	 * @param professionista the professionista to set
	 */
	public void setProfessionista(int professionista) {
		this.professionista = professionista;
	}


	public Time getOrario_inizio() {
		return orario_inizio;
	}


	public void setOrario_inizio(Time orario_inizio) {
		this.orario_inizio = orario_inizio;
	}


	public Date getData_inizio() {
		return data_inizio;
	}


	public void setData_inizio(Date data_inizio) {
		this.data_inizio = data_inizio;
	}


	public Time getOrario_fine() {
		return orario_fine;
	}


	public void setOrario_fine(Time orario_fine) {
		this.orario_fine = orario_fine;
	}


	public Date getData_fine() {
		return data_fine;
	}


	public void setData_fine(Date data_fine) {
		this.data_fine = data_fine;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Time getTempo_medio() {
		return tempo_medio;
	}


	public void setTempo_medio(Time tempo_medio) {
		this.tempo_medio = tempo_medio;
	}


	public String getAltri_dettagli() {
		return altri_dettagli;
	}


	public void setAltri_dettagli(String altri_dettagli) {
		this.altri_dettagli = altri_dettagli;
	}
	
	
	
	

}
