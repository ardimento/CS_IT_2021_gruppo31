package it.uniba.di.prog2.cs2021.gruppo31;
import java.util.Date;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Dado;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Utente;

/**
 * Classe che si occupa di gestire le vendite.<br>
 * Ogni vendita fa riferimento ad un tipo di dado e all'utente che effettua la vendita.
 * @author matteo
 * @version 1.1
 */
public class Vendita {
	
	private Utente utente; // Utente che effettua la vendita
	private Dado dado; // Tipo di dado venduto
	private Date data; // Data di vendita
 	private int numPezzi; // Numero di pezzi venduti
	
	/**
	 * Costruttore parametrico.<br>
	 * Inizializza tutti i campi di un oggetto Vendita.
	 * @param utente Utente che effettua la vendita.
	 * @param dado Tipo di dado venduto.
	 * @param data Data di vendita.
	 * @param numPezzi Numero di pezzi venduti.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.dado.Dado
	 * @see it.uniba.di.prog2.cs2021.gruppo31.utente.Utente
	 */
	public Vendita(Utente utente, Dado dado, Date data, int numPezzi) {
		this.utente = utente;
		this.dado = dado;
		this.data = data;
		this.numPezzi = numPezzi;
	}

	/**
	 * Restituisce l'utente che ha effettuato la vendita.
	 * @return utente Utente che ha effettuato la vendita.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.utente.Utente
	 */
	public Utente getUtente() {
		return utente;
	}
	
	/**
	 * Restituisce il tipo di dado venduto.
	 * @return Tipo di dado venduto.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.dado.Dado
	 */
	public Dado getDado() {
		return dado;
	}
	
	/**
	 * Restituisce la data di vendita.
	 * @return Data di vendita.
	 * @see Date
	 */
	public Date getData() {
		return data;
	}
	
	/**
	 * Restituisce il numero di pezzi venduti.
	 * @return Numero di pezzi venduti.
	 */
	public int getNumPezzi() {
		return numPezzi;
	}
}
