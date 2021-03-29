package it.uniba.di.prog2.cs2021.gruppo31.database;
import java.sql.SQLException;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Utente;

/**
 * Interfaccia accesso utente, registrazione utente 
 * @author andrea
 * @version 1.1
 */
public interface LogIn_SignIn {
	/**
	 * Metodo per la ricerca di un utente nel database.
	 * @param username Nickname utente
	 * @param hashPassword password per accedere al profilo 
	 * @throws SQLException
	 * @throws AziendaException
	 */
	public void checkUtente(String username, String hashPassword) throws SQLException,AziendaException;
	/**
	 * Metodo per aggiungere un utente al database
	 * @param utente Utente
	 * @throws SQLException
	 * @throws AziendaException
	 */
	public void addUtente(Utente utente) throws SQLException,AziendaException;
}
