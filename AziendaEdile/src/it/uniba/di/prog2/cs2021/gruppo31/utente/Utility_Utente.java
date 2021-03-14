package it.uniba.di.prog2.cs2021.gruppo31.utente;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import it.uniba.di.prog2.cs2021.gruppo31.database.LogIn_SignIn;
import it.uniba.di.prog2.cs2021.gruppo31.database.ProxyDB;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;

public class Utility_Utente {
	
	public static void checkUtente(String username, String hashPassword) throws SQLException,AziendaException {
		LogIn_SignIn login = ProxyDB.getIstance();
		login.checkUtente(username, hashPassword);
	}
	
	/**
	 * Username:
	 * - Min leng = 5
	 * - Max leng = 20
	 * - Can contains only a-z, A-Z, 0-9, and the chars {._-}
	 * - Must start with a-z, A-Z
	 * Password:
	 * - Min leng = 8
	 * - Max leng = 50
	 * - Can contains only a-z, A-Z, 0-9, and the chars {.,;:_+/*^=?!()\\[\\]{}@%#$-} 
	 * @param username 
	 * @param password
	 * @return
	 * 	1: Username length not valid
	 * 	2: Username format not valid
	 *  3: Password length not valid
	 *  4: Password format not valid
	 *  0: Credentials valid
	 */
	public static int checkCorrettezzaCredenziali(String username, String password) {
		if(username == null || username.length() > 20 || username.length() < 5)	return 1;
		if(Pattern.matches("[a-zA-z][a-zA-Z0-9._-]*", username) == false)	return 2;
		if(password == null || password.length() > 50 || password.length() < 8)	return 3;
		if(Pattern.matches("[a-zA-Z0-9.,;:_+/*^=?!()\\[\\]{}@%#$-]+", password) == false)	return 4;
		return 0;
	}
	
	public static int checkImpiegato(Impiegato impiegato) {
		if(checkNome(impiegato.getNome()) == false)	return 1;
		if(checkNome(impiegato.getCognome()) == false)	return 2;
		if(checkDataNascita(impiegato.getDataNascita()) == false)	return 3;
		if(checkDataEntrata(impiegato.getDataEntrata()) == false)	return 4;
		if(impiegato.getStipendioMensile() < 0)	return 5;
		if(impiegato.getMaxVenditeAnno() < 0) return 6;
		return 0; //Valido
	}
	
	public static String hashPwd(String password) {
		if(password == null)	return null;
		int hash = password.hashCode();
		return Integer.toString(hash);
	}
	
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
	
	private static boolean checkDataNascita(Date dataNascita) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR,-18); //Possono lavorare solo maggiorenni
		Date temp = c.getTime();
		if(dataNascita.compareTo(temp) > 0)	return false;
		return true;
	}
	
	private static boolean checkDataEntrata(Date dataEntrata) {
		Calendar c = Calendar.getInstance();
		Date temp = c.getTime();
		if(dataEntrata.compareTo(temp) > 0)	return false;
		return true;
	}
}
