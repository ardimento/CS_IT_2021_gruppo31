package it.uniba.di.prog2.cs2021.gruppo31.database;
import java.sql.SQLException;
import java.text.ParseException;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Dado;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;

public interface AdminQuery {
	public Dado getDado(String hashDado) throws SQLException,AziendaException,ParseException;
	public void addDado(String username, Dado dado) throws SQLException,AziendaException;
	public void deleteDado(String username, int hashDado) throws SQLException,AziendaException,ParseException;
	public void updatePezziDado(String username, int hashDado, int numPezzi) throws SQLException,AziendaException;
	public void updatePrezzoDado(String username, int hashDado, double prezzo) throws SQLException,AziendaException;
}
