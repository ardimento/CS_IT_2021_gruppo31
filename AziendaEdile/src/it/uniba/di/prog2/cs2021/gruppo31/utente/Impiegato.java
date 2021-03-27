package it.uniba.di.prog2.cs2021.gruppo31.utente;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe che si occupa di gestire un generico impiegato.
 * @author matteo
 * @version 1.1
 */
public class Impiegato {
	
	/** Nome dell'impiegato */
	private String nome;
	
	/** Cognome dell'impiegato */
	private String cognome;
	
	/** Data di nascita dell'impiegato */
	private Date dataNascita;
	
	/** Masione dell'impiegato all'interno dell'azienda */
	private String mansione;
	
	/** Data di entrata dell'impiegato all'interno dell'azienda */
	private Date dataEntrata;
	
	/** Stipendio mensile dell'impiegato */
	private int stipendioMensile;
	
	/** Numero massimo di vendite all'anno per l'impiegato */
	private int maxVenditeAnno;
	
	/** Numero massimo di vendite al giorni, valido per ogni impiegato */
	public static final int MAX_VENDITE_GIORNO = 300;
	
	/**
	 * Costruttore parametrico.<br>
	 * Inizializza tutti i parametri di un impiegato.
	 * @param nome Nome dell'impiegato.
	 * @param cognome Cognome dell'impiegato.
	 * @param dataNascita Data di nascita dell'impiegato.
	 * @param mansione Masione svolta dall'impiegato in azienda.
	 * @param dataEntrata Data di entrata dell'impiegato in azienda.
	 * @param stipendioMensile Stipendio mensile dell'impiegato.
	 * @param maxVenditeAnno Numero massimo di vendite all'anno per l'impiegato.
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
	 * Restituisce il nome dell'impiegato.
	 * @return Nome dell'impiegato.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Imposta il nome all'impiegato.
	 * @param nome Nome dell'impiegato.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Restituisce il cognome dell'impiegato.
	 * @return Cognome dell'impiegato.
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * Imposta il cognome dell'impiegato.
	 * @param cognome Cognome dell'impiegato.
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	/**
	 * Restituisce la data di nascita dell'impiegato.
	 * @return Data di nascita dell'impiegato.
	 * @see Date
	 */
	public Date getDataNascita() {
		return dataNascita;
	}
	
	/**
	 * Imposta la data di nascita dell'impiegato.
	 * @param dataNascita Data di nascita dell'impiegato.
	 * @see Date
	 */
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	/**
	 * Restituisce la mansione dell'impiegato.
	 * @return Mansione svolta dall'impiegato in azienda.
	 */
	public String getMansione() {
		return mansione;
	}
	
	/**
	 * Imposta la mansione dell'impiegato.
	 * @param mansione Mansione svolta dall'impiegato in azienda.
	 */
	public void setMansione(String mansione) {
		this.mansione = mansione;
	}
	
	/**
	 * Restituisce la data di entrata in azienda dell'impiegato.
	 * @return Data di entrata in azienda dell'impiegato.
	 * @see Date
	 */
	public Date getDataEntrata() {
		return dataEntrata;
	}

	/**
	 * Imposta la data di entrata in azienda dell'impiegato.
	 * @param dataEntrata Data di entrata in azienda dell'impiegato.
	 * @see Date
	 */
	public void setDataEntrata(Date dataEntrata) {
		this.dataEntrata = dataEntrata;
	}

	/**
	 * Restituisce lo stipendio mensile dell'impiegato.
	 * @return stipendioMensile Stipendio mensile dell'impiegato.
	 */
	public int getStipendioMensile() {
		return stipendioMensile;
	}

	/**
	 * Imposta lo stipendio mensile dell'impiegato.
	 * @param stipendioMensile Stipendio mensile dell'impiegato.
	 */
	public void setStipendioMensile(int stipendioMensile) {
		this.stipendioMensile = stipendioMensile;
	}

	/**
	 * Restituisce il numero massimo di vendite all'anno per l'impiegato.
	 * @return maxVenditeAnno Numero massimo di vendite all'anno per l'impiegato.
	 */
	public int getMaxVenditeAnno() {
		return maxVenditeAnno;
	}

	/**
	 * Imposta il numero massimo di vendite all'anno per l'impiegato.
	 * @param maxVenditeAnno Numero massimo di vendite all'anno per l'impiegato.
	 */
	public void setMaxVenditeAnno(int maxVenditeAnno) {
		this.maxVenditeAnno = maxVenditeAnno;
	}
	
	/**
	 * Restutisce l'impiegato in formato String.
	 * @return Elenco di tutte le informazioni relative all'impiegato.
	 * @see Date
	 * @see SimpleDateFormatter
	 */
	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String s = "Nome: " + nome + "\nCognome: " + cognome + "\nData Nascita: " + formatter.format(dataNascita);
		s += "\nMansione: " + mansione + "\nData Entrata: " + formatter.format(dataEntrata) + "\nStipendio Mensile: ";
		s += + stipendioMensile + "\nLimite massimo vendite annue: " + maxVenditeAnno;
		return s;
	}
}
