package it.uniba.di.prog2.cs2021.gruppo31.database;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import it.uniba.di.prog2.cs2021.gruppo31.Vendita;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Dado;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Impiegato;

/**
 * WQuesta è un interfaccia query utente
 * @author andrea
 * @version 1.1
 *
 */
public interface UserQuery {
	/**
	 * @param vendita 
	 * @throws SQLException
	 * @throws AziendaException
	 * @throws ParseException
	 */
	public void addVendita(Vendita vendita) throws SQLException,AziendaException,ParseException;
	/**
	 * @param username
	 * @return
	 * @throws SQLException
	 * @throws AziendaException
	 * @throws ParseException
	 */
	public Impiegato getInfoImpiegato(String username) throws SQLException,AziendaException,ParseException;
	/**
	 * @param username
	 * @return
	 * @throws SQLException
	 * @throws AziendaException
	 * @throws ParseException
	 */
	public ArrayList<Vendita> getVenditeImpiegato(String username) throws SQLException,AziendaException,ParseException;
	/**
	 * @return
	 * @throws SQLException
	 * @throws AziendaException
	 * @throws ParseException
	 */
	public ArrayList<Dado> getCatalogoDadi() throws SQLException,AziendaException,ParseException;
	/**
	 * @param hashDado
	 * @return
	 * @throws SQLException
	 * @throws AziendaException
	 * @throws ParseException
	 */
	public Dado getDado(String hashDado) throws SQLException,AziendaException,ParseException;
}
