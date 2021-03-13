package it.uniba.di.prog2.cs2021.gruppo31.database;
import java.sql.SQLException;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Utente;

public interface LogIn_SignIn {
	public int checkUtente(String username, String hashPassword) throws SQLException;
	public boolean addUtente(Utente utente) throws SQLException;
}
