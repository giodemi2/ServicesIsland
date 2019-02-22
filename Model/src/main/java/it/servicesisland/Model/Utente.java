package it.servicesisland.Model;


/**
 * User simple class
 * @author tiziana
 */
public class Utente {
	
	private Long codice;
	private String nome;
	private String cognome;
	private String sesso;
	private String email;
	private String password;
	private boolean professionista;
	private Long telefono;
	private String codice_fiscale;
	private String partita_iva;
	private String professione;
	private String settore;
	private String sede_fiscale;
	private String sede_legale;
	
	
	/**
	 * Constructor without parameters
	 */
	public Utente() {
		this.codice = null;
		this.nome = null;
		this.cognome = null;
		this.sesso = null;
		this.email = null;
		this.password =null;
		this.professionista = false;
		this.telefono = null;
		this.codice_fiscale=null;
		this.partita_iva=null;
		this.sede_fiscale=null;
		this.sede_legale=null;
		this.professione=null;
		this.settore=null;
	}
	
	/**
	 * Constructor with parameters of a simple user
	 
	 * @param nome of Utente
	 * @param cognome of Utente
	 * @param sesso of Utente
	 * @param email of Utente
	 * @param password of Utente
	 * @param professionista of Utente
	 * @param telefono of Utente
	 */
	public Utente(String nome, String cognome, String sesso, String email, String password,
			 Long telefono) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.email = email;
		this.password = password;
		this.professionista = false;
		this.telefono = telefono;
	}
	
	
	/**
	 * Constructor for professionista
	 * 
	 * @param codice
	 * @param nome
	 * @param cognome
	 * @param sesso
	 * @param email
	 * @param password
	 * @param telefono
	 * @param codice_fiscale
	 * @param partita_iva
	 * @param professione
	 * @param settore
	 * @param sede_fiscale
	 * @param sede_legale
	 */
	public Utente(String nome, String cognome, String sesso, String email, String password, Long telefono,
			String codice_fiscale, String partita_iva, String professione, String settore, String sede_fiscale,
			String sede_legale) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.codice_fiscale = codice_fiscale;
		this.partita_iva = partita_iva;
		this.professione = professione;
		this.settore = settore;
		this.sede_fiscale = sede_fiscale;
		this.sede_legale = sede_legale;
		this.professionista=true;
	}

	/**
	 * @return the codice
	 */
	public Long getCodice() {
		return codice;
	}

	/**
	 * @param codice the codice to be set
	 */
	public void setCodice(Long codice) {
		this.codice = codice;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return the sesso
	 */
	public String getSesso() {
		return sesso;
	}

	/**
	 * @param sesso the sesso to set
	 */
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the professionista
	 */
	public boolean isProfessionista() {
		return professionista;
	}

	/**
	 * @param professionista the professionista to set
	 */
	public void setProfessionista(boolean professionista) {
		this.professionista = professionista;
	}

	/**
	 * @return the telefono
	 */
	public Long getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	/**
	 * return codice fiscale
	 * @return codice_fiscale
	 */
	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	/**
	 * sets the codice fiscale
	 * @param codice_fiscale
	 */
	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	/**
	 * returns the partita iva
	 * @return partita_iva
	 */
	public String getPartita_iva() {
		return partita_iva;
	}

	/**
	 * sets partita iva
	 * @param partita_iva
	 */
	public void setPartita_iva(String partita_iva) {
		this.partita_iva = partita_iva;
	}

	/**
	 * returns professione
	 * @return professione
	 */
	public String getProfessione() {
		return professione;
	}

	/**
	 * sets professione
	 * @param professione
	 */
	public void setProfessione(String professione) {
		this.professione = professione;
	}

	public String getSettore() {
		return settore;
	}

	public void setSettore(String settore) {
		this.settore = settore;
	}

	public String getSede_fiscale() {
		return sede_fiscale;
	}

	public void setSede_fiscale(String sede_fiscale) {
		this.sede_fiscale = sede_fiscale;
	}

	public String getSede_legale() {
		return sede_legale;
	}

	public void setSede_legale(String sede_legale) {
		this.sede_legale = sede_legale;
	}
	
	
	
}
