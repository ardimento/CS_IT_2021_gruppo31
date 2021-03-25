package it.uniba.di.prog2.cs2021.gruppo31.utente;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import it.uniba.di.prog2.cs2021.gruppo31.Token;
import it.uniba.di.prog2.cs2021.gruppo31.database.LogIn_SignIn;
import it.uniba.di.prog2.cs2021.gruppo31.database.ProxyDB;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;

/**
 * Classe contenete alcune funzioni statiche per la gestione degli utenti
 * @author andrea
 * @version 1.1
 */
public class Utility_Utente {
	
	/**
	 * Metodo che si occupa di validare username e password inseriti, e permettere all'utente di loggarsi nel sistema
	 * @param username username che viene inserito dall'utente 
	 * @param hashPassword Password che viene inserita dall'utente 
	 * @throws SQLException 
	 * @throws AziendaException 
	 */
	public static void checkUtente(String username, String hashPassword) throws SQLException,AziendaException {
		LogIn_SignIn login = ProxyDB.getIstance();
		login.checkUtente(username,hashPassword);
		Token.getIstance().setHashPassword(hashPassword);
	}
	
	/**
	 * Username:
	 * - Minima lunghezza = 5
	 * - Massima lunghezza = 20
	 * - Può contenere solo a-z, A-Z, 0-9, and the chars {._-}
	 * - Deve iniziare con  a-z, A-Z
	 * Password:
	 * - Minima lunghezza = 8
	 * - Massima lunghezza = 50
	 * - Può contenere solo a-z, A-Z, 0-9, and the chars {.,;:_+/*^=?!()\\[\\]{}@%#$-} 
	 * @param username 
	 * @param password
	 * @return
	 * 	1: Username lunghezza non valida
	 * 	2: Username formato non valido
	 *  3: Password lunghezza non valida
	 *  4: Password formato non valido
	 *  0: Credenziali valide
	 */
	public static int checkCorrettezzaCredenziali(String username, String password) {
		if(username == null || username.length() > 20 || username.length() < 5)	return 1;
		if(Pattern.matches("[a-zA-z][a-zA-Z0-9._-]*", username) == false)	return 2;
		if(password == null || password.length() > 50 || password.length() < 8)	return 3;
		if(Pattern.matches("[a-zA-Z0-9.,;:_+/*^=?!()\\[\\]{}@%#$-]+", password) == false)	return 4;
		return 0;
	}
	
	/**
	 * Metodo  che gestisce il controllo dell'impiegato implementando metodi locali 
	 * @param impiegato Impiegato azienda
	 * @return
	 *  0 : Tutti i parametri sono corretti
	 * 	1 : Nome non corretto
	 * 	2 : Cognome non corretto
	 * 	3 : Data di nascita non corretta 
	 * 	4 : Data di inizio lavoro non corretta 
	 * 	5 : Stipendio dell'impiegato non corretto
	 *  6 : Vendita massima annua non corretta 
	 */
	public static int checkImpiegato(Impiegato impiegato) {
		if(checkNome(impiegato.getNome()) == false)	return 1;
		if(checkNome(impiegato.getCognome()) == false)	return 2;
		if(checkDataNascita(impiegato.getDataNascita()) == false)	return 3;
		if(checkDataEntrata(impiegato.getDataEntrata()) == false)	return 4;
		if(impiegato.getStipendioMensile() < 0)	return 5;
		if(impiegato.getMaxVenditeAnno() < 0) return 6;
		return 0; //Valido
	}
	
	/**
	 * @param password 
	 * @return String Stringa contente la password 
	 */
	public static String hashPwd(String password) {
		if(password == null)	return null;
		int hash = (password.hashCode() & 0xfffffff);
		return Integer.toString(hash);
	}
	
	/**
	 * Controllo sulla correttezza del nome 
	 * @param nome Nome impiegato 
	 * @return Il metodo ritorna false  se il Nome non è correttoe 
	 *         true se il  Nome corretto
	 */
	private static boolean checkNome(String nome) {
		if(nome == null)	return false;
		int leng = nome.length();
		if(leng > 30) return false;
		for(int i=0; i<leng; i++) {
			if(Character.isLetter(nome.charAt(i)) == false)
					return false;
		}
		return true;
	}
	
	/**
	 * Controllo sulla correttezza dela data di nascita dell'impiegato  
	 * @param dataNascita Data di nascita dell'impiegato
	 * @return false Data non corretta
	 *         true Data corretta
	 */
	private static boolean checkDataNascita(Date dataNascita) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR,-18); //Possono lavorare solo maggiorenni
		Date temp = c.getTime();
		if(dataNascita.compareTo(temp) > 0)	return false;
		return true;
	}
	
	/**
	 * Controllo sulla correttezza della data di inizio lavoro nell'Azienda 
	 * @param dataEntrata Data di inizio lavoro nell'Azienda 
	 * @return false Data non corretta
	 *         true Data corretta 
	 */
	private static boolean checkDataEntrata(Date dataEntrata) {
		Calendar c = Calendar.getInstance();
		Date temp = c.getTime();
		if(dataEntrata.compareTo(temp) > 0)	return false;
		return true;
	}
}
