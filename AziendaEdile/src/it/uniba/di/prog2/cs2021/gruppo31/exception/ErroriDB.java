package it.uniba.di.prog2.cs2021.gruppo31.exception;

/**
 * Classe contenente i messaggi di errore relativi al database.<br>
 * Queste stringhe vengono utilizzate come messaggi di errore per
 * lanciare le eccezioni custom della classe AziendaException, le
 * quali avranno come parametro il messaggio di errore relativo al tipo di eccezione.
 * Queste eccezioni potranno essere lanciate dalla classe ProxyDB durante le operazioni
 * di accesso al database, mentre verranno gestite nella classe HomePage o nella classe Client.
 * @author matteo
 * @version 1.1
 */
public class ErroriDB {
	public static final String USERNAME_NOT_FOUND = "ERROR: Username non trovato!";
	public static final String INCORRECT_PASSWORD = "ERROR: Password non corretta!";
	public static final String FILETTATURA_NOT_FOUND = "ERROR: Metrica non trovata!";
	public static final String EMPTY_LIST = "ERROR: Tabella vuota!";
	public static final String DADO_NOT_FOUND = "ERROR: Dado non trovato!";
	public static final String DADO_ALREADY_EXISTS = "ERROR: Dado gia' esistente!";
	public static final String USERNAME_ALREADY_EXISTS = "ERROR: Username gia' esistente!";
	public static final String USERNAME_NOT_ADMIN = "ERROR: Permessi di amministratore richiesti!";
	public static final String IMPIEGATO_ALREADY_EXISTS = "ERROR: Impiegato gia' esistente!";
}