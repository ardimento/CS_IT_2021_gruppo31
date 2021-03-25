package it.uniba.di.prog2.cs2021.gruppo31;

/**
 * 
 * @author andrea
 * @version 1.1
 *
 */
public class Token {
	private String hashPassword;
	private static Token istance = new Token();
	
	private Token() {}
	
	/**
	 * 
	 * @return Password 
	 */
	public String getHashPassword() {
		return hashPassword;
	}
	
	/**
	 * 
	 * @param hashPassword password 
	 */
	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}
	
	/**
	 * 
	 * @return 
	 */
	public static Token getIstance() {
		return istance;
	}
}
