package it.uniba.di.prog2.cs2021.gruppo31;
import java.util.Date;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Dado;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Utente;
/**
 * Classe che gestisce le vendite di un tipo di Dado,in una specifica Data e uno specifico Utente
 * @author andrea
 * @version 1.1
 */
public class Vendita {
	
	private Utente utente;
	private Dado dado;
	private Date data;
	private int numPezzi;
	
	/**
	 * @param utente Utente che acquista 
	 * @param dado   interfaccia Dado
	 * @param data   data della vendita
	 * @param numPezzi quantita di dadi venduti
	 */
	public Vendita(Utente utente, Dado dado, Date data, int numPezzi) {
		this.utente = utente;
		this.dado = dado;
		this.data = data;
		this.numPezzi = numPezzi;
	}

	/**
	 * @return utente utente che ha effettuato la vendita 
	 */
	public Utente getUtente() {
		return utente;
	}
	/**
	 * @return dado Il tipo di dato 
	 */
	public Dado getDado() {
		return dado;
	}
	/**
	 * @return data Data vendita 
	 */
	public Date getData() {
		return data;
	}
	/**
	 * @return numPezzi Numero di Dadi che sono stati venduti
	 */
	public int getNumPezzi() {
		return numPezzi;
	}
}
