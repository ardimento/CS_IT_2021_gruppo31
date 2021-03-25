package it.uniba.di.prog2.cs2021.gruppo31.utente;
import java.sql.SQLException;
import it.uniba.di.prog2.cs2021.gruppo31.database.*;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;


/**
 * Classe che gestisce la creazione di un utente 
 * @author andrea
 * @version 1.1
 */
public class Utente {
	
	private Impiegato impiegato;
	private String username;
	private String password;
	private boolean adminFlag = false;
	
	/**
	 * @param impiegato Impiegato dell'azienda 
	 * @param username  Nickname per definire l'utente
	 * @param password  Password utente
	 * @param adminFlag  stato dell'amministratore
	 */
	public Utente(Impiegato impiegato, String username, String password, boolean adminFlag) {
		this.impiegato = impiegato;
		this.username = username;
		this.password = password;
		this.adminFlag = adminFlag;
	}

	/**
	 * @return Impiegato dell'azienda con tutti i suoi attributi
	 */
	public Impiegato getImpiegato() {
		return impiegato;
	}
	/**
	 * @return username Nickname per definire l'utente
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @return password per accedere al sito 
	 */
	public String getHashPassword() {
		return Utility_Utente.hashPwd(password);
	}
	/**
	 * @return adminFlag lo stato dell'amministratore
	 */
	public boolean isAdmin() {
		return adminFlag;
	}
	
	/**
	 * @throws SQLException
	 * @throws AziendaException
	 */
	public void addUtente() throws SQLException,AziendaException {
		LogIn_SignIn login = ProxyDB.getIstance();
		login.addUtente(this);
	}
}
