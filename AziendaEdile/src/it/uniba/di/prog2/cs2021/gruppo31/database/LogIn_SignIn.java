package it.uniba.di.prog2.cs2021.gruppo31.database;
import java.sql.SQLException;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Utente;

public interface LogIn_SignIn {
	public void checkUtente(String username, String hashPassword) throws SQLException,AziendaException;
	public void addUtente(Utente utente) throws SQLException,AziendaException;
}
