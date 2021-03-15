package it.uniba.di.prog2.cs2021.gruppo31;

public class Token {
	private String hashPassword;
	private static Token istance = new Token();
	
	private Token() {}
	
	public String getHashPassword() {
		return hashPassword;
	}
	
	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}
	
	public static Token getIstance() {
		return istance;
	}
}
