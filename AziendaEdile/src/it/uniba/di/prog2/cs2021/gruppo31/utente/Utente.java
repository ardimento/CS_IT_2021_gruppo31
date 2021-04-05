package it.uniba.di.prog2.cs2021.gruppo31.utente;
import java.sql.SQLException;
import it.uniba.di.prog2.cs2021.gruppo31.database.*;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;

/**
 * Classe che occupa di gestire un generico utente.<br>
 * Ogni utente all'interno del sistema corrisponde ad un impiegato dell'azienda.
 * @author matteo
 * @version 1.1
 */
public class Utente {
	
	/** Impiegato relativo all'utente */
	private Impiegato impiegato;
	
	/** Username utente */
	private String username;
	
	/** Hash password utente */
	private String hashPassword;
	
	/** Se l'utente è un amministratore, allora adminFlag=TRUE. Altrimenti adminFlag=FALSE. */
	private boolean adminFlag = false;
	
	/**
	 * Costruttore parametrico.<br>
	 * Inizializza tutti i campi relativi all'utente.
	 * @param impiegato Impiegato relativo all'utente.
	 * @param username Username utente.
	 * @param hashPassword Hash password utente.
	 * @param adminFlag Flag che indica se l'utente è un amministratore o meno.
	 * @see Utility_Utente#hashPwd(String)
	 */
	public Utente(Impiegato impiegato, String username, String hashPassword, boolean adminFlag) {
		this.impiegato = impiegato;
		this.username = username;
		this.adminFlag = adminFlag;
		this.hashPassword = hashPassword;
	}

	/**
	 * Restituisce l'impiegato dell'azienda relativo all'utente.
	 * @return Impiegato relativo all'utente.
	 * @see Impiegato
	 */
	public Impiegato getImpiegato() {
		return impiegato;
	}
	
	/**
	 * Restituisce lo username dell'utente.
	 * @return username Username dell'utente.
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Restituisce l'hash della password dell'utente.
	 * @return Hash della password dell'utente.
	 */
	public String getHashPassword() {
		return hashPassword;
	}
	/**
	 * Restituisce un valore booleano che indica se l'utente è un amministratore o meno.
	 * @return Se l'utente è un amministratore, ritorna TRUE. Altrimenti FALSE.
	 */
	public boolean isAdmin() {
		return adminFlag;
	}
	
	/**
	 * Aggiunge l'utente nella base dati.<br>
	 * Il metodo utilizza l'interfaccia {@link it.uniba.di.prog2.cs2021.gruppo31.database.LogIn_SignIn} del package
	 * {@link it.uniba.di.prog2.cs2021.gruppo31.database} per accedere al metodo 
	 * {@link it.uniba.di.prog2.cs2021.gruppo31.database.ProxyDB#addUtente(Utente)} e aggiungere l'utente al DB.
	 * @throws SQLException
	 * @throws AziendaException Possibili eccezioni:<br>
	 * 		IMPIEGATO_ALREADY_EXISTS, USERNAME_ALREADY_EXISTS.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.database.LogIn_SignIn
	 * @see it.uniba.di.prog2.cs2021.gruppo31.database.ProxyDB#addUtente(Utente)
	 */
	public void addUtente() throws SQLException,AziendaException {
		LogIn_SignIn login = ProxyDB.getIstance();
		login.addUtente(this);
	}
}
