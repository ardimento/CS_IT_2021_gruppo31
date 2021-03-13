package it.uniba.di.prog2.cs2021.gruppo31.database;
import java.sql.SQLException;
import java.text.ParseException;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Dado;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;

public interface AdminQuery {
	public boolean addDado(String username, Dado dado) throws SQLException,AziendaException;
	public boolean deleteDado(String username, int hashDado) throws SQLException,AziendaException,ParseException;
	public boolean updatePezziDado(String username, int hashDado, int numPezzi) throws SQLException,AziendaException;
	public boolean updatePrezzoDado(String username, int hashDado, double prezzo) throws SQLException,AziendaException;
}
