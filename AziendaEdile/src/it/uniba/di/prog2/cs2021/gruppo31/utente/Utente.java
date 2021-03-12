package it.uniba.di.prog2.cs2021.gruppo31.utente;
import java.sql.SQLException;
import it.uniba.di.prog2.cs2021.gruppo31.database.ProxyDB;


public class Utente {
	
	private Impiegato impiegato;
	private String username;
	private String password;
	private boolean adminFlag = false;
	
	public Utente(Impiegato impiegato, String username, String password, boolean adminFlag) {
		this.impiegato = impiegato;
		this.username = username;
		this.password = password;
		this.adminFlag = adminFlag;
	}

	public Impiegato getImpiegato() {
		return impiegato;
	}

	public String getUsername() {
		return username;
	}

	public String getHashPassword() {
		return Utility_Utente.hashPwd(password);
	}

	public boolean isAdmin() {
		return adminFlag;
	}
	
	public boolean addUtente() throws SQLException {
		return ProxyDB.getIstance().addUtente(this);
	}
}
