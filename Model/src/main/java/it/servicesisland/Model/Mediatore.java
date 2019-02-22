package it.servicesisland.Model;

/**
 * 
 * @author Tiziana
 *
 */

public class Mediatore {
	
	private Long codice;
	private String chiave;
	
	
	public Mediatore() {
		super();
	}
	
	
	/**
	 * 
	 * @return codice
	 */
	public Long getCodice() {
		return codice;
	}
	
	/**
	 * 
	 * @param codice
	 */
	public void setCodice(Long codice) {
		this.codice = codice;
	}


	public String getChiave() {
		return chiave;
	}


	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	
	
}
