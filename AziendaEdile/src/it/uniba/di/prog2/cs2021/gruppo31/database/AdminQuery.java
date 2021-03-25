package it.uniba.di.prog2.cs2021.gruppo31.database;
import java.sql.SQLException;
import java.text.ParseException;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Dado;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;

/**
 * Interfaccia amministratore 
 * @author andrea
 * @version 1.1
 */
public interface AdminQuery {
	
	/**
	 * @param hashDado 
	 * @return
	 * @throws SQLException
	 * @throws AziendaException
	 * @throws ParseException
	 */
	public Dado getDado(String hashDado) throws SQLException,AziendaException,ParseException;
	
	/**
	 * @param username Nickname utente 
	 * @param dado
	 * @throws SQLException
	 * @throws AziendaException
	 */
	public void addDado(String username, Dado dado) throws SQLException,AziendaException;
	
	/**
	 * @param username Nickname utente 
	 * @param hashDado 
	 * @throws SQLException
	 * @throws AziendaException
	 * @throws ParseException
	 */
	public void deleteDado(String username, int hashDado) throws SQLException,AziendaException,ParseException;
	
	/**
	 * Metodo che aggiorna i pezzi dei dadi
	 * @param username Nickname utente
	 * @param hashDado 
	 * @param numPezzi Numero pezzi dadi 
	 * @throws SQLException
	 * @throws AziendaException
	 */
	public void updatePezziDado(String username, int hashDado, int numPezzi) throws SQLException,AziendaException;
	
	/**
	 * Metodo che aggiorna il prezzo del dado
	 * @param username Nickname utente 
	 * @param hashDado
	 * @param prezzo prezzo del dado
	 * @throws SQLException
	 * @throws AziendaException
	 */
	public void updatePrezzoDado(String username, int hashDado, double prezzo) throws SQLException,AziendaException;
}
