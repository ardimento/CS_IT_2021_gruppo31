package it.uniba.di.prog2.cs2021.gruppo31.utente;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe che si occupa di implementare un Impiegato 
 * @author andrea
 * @version 1.1
 */
public class Impiegato {
	
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String mansione;
	private Date dataEntrata;
	private int stipendioMensile;
	private int maxVenditeAnno;
	public static final int MAX_VENDITE_GIORNO = 300;
	
	/**
	 * Class constructor.
	 * @param nome Nome dell'impiegato
	 * @param cognome Cognome dell'impiegato
	 * @param dataNascita Data di nascita dell'impiegato
	 * @param mansione Lavoro che svolge l'impiegato
	 * @param dataEntrata Data che indica l'inizio del lavoro nell'azienda
	 * @param stipendioMensile Stipendio dell'impiegato
	 * @param maxVenditeAnno numero massimo di vendite annuo
	 */
	public Impiegato(String nome, String cognome, Date dataNascita, String mansione, Date dataEntrata, int stipendioMensile, int maxVenditeAnno) {
		this.stipendioMensile = stipendioMensile;
		this.maxVenditeAnno = maxVenditeAnno;
		this.dataEntrata = dataEntrata;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.mansione = mansione;
	}

	/**
	 * @return nome dell'impiegato
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome Nome dell'impiegato
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return cognome dell'impiegato
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param nome cognome dell'impiegato
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	/**
	 * @return Data di nascita dell'impiegato
	 */
	public Date getDataNascita() {
		return dataNascita;
	}
	
	/**
	 * @param dataNascita Data di nascita dell'impiegato
	 */
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	/**
	 * @return mansione Lavoro che svolge all'interno dell'azienda
	 */
	public String getMansione() {
		return mansione;
	}
	
	/**
	 * @param mansione Lavoro che svolge all'interno dell'azienda
	 */
	public void setMansione(String mansione) {
		this.mansione = mansione;
	}
	
	/**
	 * @return dataEntrata Data che indica l'inizio del lavoro nell'azienda
	 */
	public Date getDataEntrata() {
		return dataEntrata;
	}

	/**
	 * @param dataEntrata Data che indica l'inizio del lavoro nell'azienda
	 */
	public void setDataEntrata(Date dataEntrata) {
		this.dataEntrata = dataEntrata;
	}

	/**
	 * @return stipendioMensile Stipendio dell'impiegato
	 */
	public int getStipendioMensile() {
		return stipendioMensile;
	}

	/**
	 * @param stipendioMensile Stipendio dell'impiegato
	 */
	public void setStipendioMensile(int stipendioMensile) {
		this.stipendioMensile = stipendioMensile;
	}

	/**
	 * @return maxVenditeAnno Numero massimo di vendite annuo
	 */
	public int getMaxVenditeAnno() {
		return maxVenditeAnno;
	}

	/**
	 * @param maxVenditeAnno Numero massimo di vendite annuo
	 */
	public void setMaxVenditeAnno(int maxVenditeAnno) {
		this.maxVenditeAnno = maxVenditeAnno;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String s = "Nome: " + nome + "\nCognome: " + cognome + "\nData Nascita: " + formatter.format(dataNascita);
		s += "\nMansione: " + mansione + "\nData Entrata: " + formatter.format(dataEntrata) + "\nStipendio Mensile: ";
		s += + stipendioMensile + "\nLimite massimo vendite annue: " + maxVenditeAnno;
		return s;
	}
	
	
}
