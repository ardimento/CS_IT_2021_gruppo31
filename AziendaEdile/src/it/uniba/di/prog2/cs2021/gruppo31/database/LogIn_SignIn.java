package it.uniba.di.prog2.cs2021.gruppo31.database;
import java.sql.SQLException;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Utente;

/**
 * Interfaccia utilizzata dal package utente per LogIn e SignIn.
 * @author matteo
 * @version 1.1
 */
public interface LogIn_SignIn {
	
	/**
	 * Ricerca un utente all'interno del database.<br>
	 * Questo metodo viene utilizzato anche per effettuare il LogIn
	 * all'interno del sistema, in quanto viene controllato se username
	 * e password sono presenti del database.
	 * @param username Username utente da controllare.
	 * @param hashPassword Hash della password dell'utente da controllare.
	 * @throws SQLException
	 * @throws AziendaException Possibili eccezioni:<br>
	 * 		USERNAME_NOT_FOUND, INCORRECT_PASSWORD.
	 * @see Utente
	 * @see ConnectorDB
	 */
	public void checkUtente(String username, String hashPassword) throws SQLException,AziendaException;
	
	/**
	 * Aggiunge un utente nel database.<br>
	 * Questo metodo viene utilizzato anche per effettuare il SignIn,
	 * ossia la registrazione dell'utente nel database. Nel metodo
	 * viene prima effettuato un controllo sull'impiegato relativo
	 * all'utente che si vuole registrare, e successivamente ai parametri
	 * forniti per l'utente.
	 * @param utente Utente da aggiungere al database.
	 * @throws SQLException
	 * @throws AziendaException Possibili eccezioni:<br>
	 * 		IMPIEGATO_ALREADY_EXISTS, USERNAME_ALREADY_EXISTS.
	 * @see Utente
	 * @see Impiegato
	 * @see ConnectorDB
	 */
	public void addUtente(Utente utente) throws SQLException,AziendaException;
}
