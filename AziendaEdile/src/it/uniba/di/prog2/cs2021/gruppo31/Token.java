package it.uniba.di.prog2.cs2021.gruppo31;

/**
 * Classe che si occupa di controllare gli accessi al sistema.<br>
 * La classe viene utilizzata dal metodo {@link it.uniba.di.prog2.cs2021.gruppo31.utente.Utility_Utente#checkUtente(String, String)}
 * per permettere ad un utente di effettuare il login impostando l'hash della sua password con il metodo {@link Token#setHashPassword(String)}.
 * Una volta impostato l'hash password con quello dell'utente che vuole loggarsi nel sistema, la classe {@link it.uniba.di.prog2.cs2021.gruppo31.HomePage}
 * controlla che l'utente che richiede l'homepage sia effettivamente loggato, andando a controllare che il suo hash password corrisponda con quello
 * presente nella classe Token, utilizzando il metodo {@link Token#getHashPassword()}.<br>
 * Inoltre la classe è stata modellata come classe singoletto, per poter permettere alla classe HomePage
 * di accedere allo stesso hash password impostato dall'utente che si è loggato.
 * @author matteo
 * @version 1.1
 */
public class Token {
	
	private String hashPassword;
	private static Token istance = new Token(); // Unica istanza Token
	
	/**
	 * Costruttore privato.<br>
	 * L'oggetto può essere istanziato solo all'interno della classe stessa.
	 */
	private Token() {}
	
	/**
	 * Restituisce l'hash password dell'utente loggato nel sistema.
	 * @return Hash password dell'utente loggato.
	 */
	public String getHashPassword() {
		return hashPassword;
	}
	
	/**
	 * Imposta l'hash password dell'utente che si vuole loggare nel sistema.
	 * @param hashPassword Hash password dell'utente da loggare.
	 */
	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}
	
	/**
	 * Restituisce l'unica istanza di Token.<br>
	 * Il metodo è statico, quindi può essere invocato senza istanziare la classe.
	 * Sull'istanza poi si possono invocare i due metodi {@link Token#getHashPassword()} e {@link Token#setHashPassword(String)}.
	 * @return Istanza di Token.
	 */
	public static Token getIstance() {
		return istance;
	}
}
