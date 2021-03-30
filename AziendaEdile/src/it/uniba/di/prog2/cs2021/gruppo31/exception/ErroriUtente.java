package it.uniba.di.prog2.cs2021.gruppo31.exception;

/**
 * Classe contenente i messaggi di errore relativi agli utenti.<br>
 * Queste stringhe vengono utilizzate come messaggi di errore per
 * lanciare le eccezioni custom della classe AziendaException, le
 * quali avranno come parametro il messaggio di errore relativo al tipo di eccezione.
 * Queste eccezioni potranno essere lanciate dalla classe ProxyDB oppure dalla classe
 * HomePage nel caso in cui un utente inserisca dei dati non validi oppure prova ad eseguire
 * delle operazioni senza avere il permesso. Verranno gestite infine dalla classe Client.
 * @author matteo
 * @version 1.1
 */
public class ErroriUtente {
	public static final String MAX_VENDITE_GIORNO = "ERROR: Limite massimo di vendite giornaliere raggiunto!";
	public static final String MAX_VENDITE_ANNO = "ERROR: Limite massimo di vendite annue raggiunto!";
	public static final String NUMPEZZI_NOT_VALID = "ERROR: Numero pezzi non valido!";
	public static final String DATA_NOT_VALID = "ERROR: Data non valida!";
	public static final String PREZZO_NOT_VALID = "ERROR: Prezzo non valido!";
	public static final String USERNAME_NOT_LOGGED = "ERROR: Utente non loggato!";
}